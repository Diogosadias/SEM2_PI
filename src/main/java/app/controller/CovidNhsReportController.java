package app.controller;

import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.model.TestStore;
import app.domain.shared.LinearRegression;
import app.domain.shared.MultipleRegression;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CovidNhsReportController {


    private Company company;
    private TestStore testStore;


    private LinearRegression linear;
    private MultipleRegression multiple;
    private SimpleDateFormat fmt;
    private List<Test> testList;
    public final String VAR_TESTS = "Registered Tests";
    public final String VAR_AGE = "Mean Age";
    public final String MULTIPLE = "Multiple";
    private List<Date> historicDateList;
    private String reportData = "";

    public CovidNhsReportController(){
        this.company = App.getInstance().getCompany();
        this.testStore = this.company.getTestStore();
        fmt = new SimpleDateFormat("yyyyMMdd");
    }

    public boolean startNewReport() {
        try {
            this.testList = getValidatedCovidTestList();
            return true;
        } catch (NullPointerException n) {
            System.out.println("Problem sending daily Nhs Report.");
            return false;
        }
    }

    private List getValidatedCovidTestList() {
        List<Test> covidTests = new ArrayList<>();
        for(Test t :  this.testStore.getValidatedTests()){
            if(t.getTestType().getCode().equalsIgnoreCase("Covid")){
                covidTests.add(t);
            }
        }
        if(covidTests.isEmpty()) {
            return null;
        }
        return covidTests;
    }


    public void doLinearRegression(Date initialDate, Date finalDate, String varIndependent, String historic,int histPoints,double alpha) {
        int historicDays = 1;
        if (historic.equals("Weekly")) {
            historicDays = 7;
        }
        int n = setN(initialDate,finalDate);
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.setTime(initialDate);
        end.setTime(finalDate);
        double[][] values = getIntervalValues(start,end, n);
        double[] xAgeInterval = values[0];
        double[] xTestsInterval = values[1];
        double[] yInterval = values[2];
        double[][] matcp = doMatcp(histPoints,historicDays);
        double[] xAge = matcp[0];
        double[] xTests = matcp[1];
        double[] y = matcp[2];
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.reportData = "";
        switch (varIndependent){
            case VAR_TESTS:
                this.linear = new LinearRegression(xTestsInterval,yInterval,alpha);
                reportData += this.linear + this.boardSimpleLRString(xTests, y,historicDays, dateFormat);
                break;
            case VAR_AGE:
                this.linear = new LinearRegression(xAgeInterval,yInterval,alpha);
                reportData += this.linear + this.boardSimpleLRString(xAge,y, historicDays, dateFormat);
                break;
            case MULTIPLE:
                NumberFormat formatter = new DecimalFormat("#0.0000");
                this.multiple = new MultipleRegression(yInterval,xTestsInterval,xAgeInterval,alpha);
                reportData += this.multiple + "\n\nPrediction values\n\n" + "Date\t\t\tNumber of OBSERVED positive cases\t\tNumber of ESTIMATED/EXPECTED positive cases\t\t\t\t\t95% intervals";
                for(int i = 0; i < this.historicDateList.size(); i ++){
                    if(y[i] != 0) {
                        Date date = historicDateList.get(i);
                        reportData += "\n" + dateFormat.format(date);
                        if(historicDays == 7) {
                            Calendar cal = Calendar.getInstance();
                            cal.setTime(date);
                            cal.add(Calendar.DATE,historicDays-1);
                            reportData += " - " + dateFormat.format(cal.getTime());
                        }
                        reportData += "\t\t\t\t\t" + (int) y[i] + "\t\t\t\t\t\t\t\t\t\t\t\t" + formatter.format(this.multiple.predict(xTests[i], xAge[i])) + "\t\t\t\t\t\t\t\t\t[" + formatter.format(this.multiple.mininterval(xTests[i], xAge[i])) + "," + formatter.format(this.multiple.maxinterval(xTests[i], xAge[i])) + "]" + "\t\t\t\t\t\t";
                    }
                }
                break;
            default:
                reportData += "Error!";


        }
    }

    private int setN (Date initialDate, Date finalDate) {
        return (int) TimeUnit.DAYS.convert((finalDate.getTime() - initialDate.getTime()), TimeUnit.MILLISECONDS) - 1;
    }

    private double[][] getIntervalValues (Calendar start,Calendar end, int n) {
        double [][] values = new double[3][n];
        int i =0;
        while (!start.after(end)) {
            int countx = 0;
            int county = 0;
            int sumAge = 0;
            for (Test t : testList) {
                if (fmt.format(t.getDateRegistered()).equals(fmt.format(start.getTime()))) {
                    countx++;
                    if (t.getTestParam().getResult().getMetric() > 1.4) {
                        county++;
                    }
                    sumAge += t.getClient().calculateAge();
                }

            }
            if(countx > 0 && county >0) {
                values[0][i] = (double)sumAge / (double)countx;
                values[1][i] = countx;
                values[2][i] = county;
                i++;
            }
            start.add(Calendar.DATE, 1);
        }
         return values;
    }

    public double [][] doMatcp(int histPoints,int historicDays){
            Calendar date = Calendar.getInstance();
            double [][] values = new double[3][histPoints];
            int countx = 0;
            int county = 0;

            int i=0;
            historicDateList = new ArrayList<>();
            date.setTime(new Date(System.currentTimeMillis()));
            date.setTime(new Date("2021/05/29"));
            int countDays = 1;
            int sumAge = 0;
            while( countDays <= (histPoints*historicDays) ) {
                Date targetDay = date.getTime();

                    for (Test t : testList) {

                        if (fmt.format(t.getDateRegistered()).equals(fmt.format(targetDay))) {
                            countx++;
                            if (t.getTestParam().getResult().getMetric() > 1.4) {
                                county++;
                            }
                            sumAge += t.getClient().calculateAge();
                        }

                    }

                if(countDays%historicDays == 0){
                    if(county > 0 && countx > 0) {
                        values[0][i] += (double)sumAge / (double)countx;
                        values[1][i] += countx;
                        values[2][i] += county;
                        historicDateList.add(targetDay);
                       }
                    if(values[2][i] > 0) {
                        i++;

                    }
                    countx = 0;
                    county = 0;
                    sumAge = 0;

                }
                countDays++;
                date.add(Calendar.DATE, -1);
            }
            return values;
    }

    public void sendNhsReport() {
        String fileName = "CovidReport.txt";
        try (PrintStream out = new PrintStream(new FileOutputStream(fileName))) {
            out.print(reportData);
            System.out.println("\nNhs data successfully delivered to " + fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String boardSimpleLRString (double[] x, double[] y, int historicDays, SimpleDateFormat dateFormat) {
        int histPoints = x.length;
        NumberFormat formatter = new DecimalFormat("#0.0000");
        String board = "\n\nPrediction values\n\n" + "Date\t\t\t\t\t\tNumber of OBSERVED positive cases\t\tNumber of ESTIMATED/EXPECTED positive cases\t\t\t\t\t95% intervals";
        for(int i = 0; i < this.historicDateList.size(); i ++){
            if(y[i] != 0) {
                double predict = this.linear.predict(x[i]);
                double delta = this.linear.delta(x[i]);
                Date date = historicDateList.get(i);
                board += "\n" + dateFormat.format(date);
                if(historicDays == 7) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(date);
                    cal.add(Calendar.DATE,historicDays-1);
                    board += " - " + dateFormat.format(cal.getTime());
                }
                board += "\t\t\t\t\t\t\t\t" + (int)y[i] + "\t\t\t\t\t\t\t\t" + formatter.format(predict) +"\t\t\t\t\t\t\t\t\t\t\t\t["+formatter.format((predict - delta))+","+formatter.format((predict + delta))+"]";
            }
        }
        return board + "\n\n\n\n";
    }

    public String getData() {
        return reportData;}

    public LinearRegression getLinearRegression() {
        return this.linear;}

    public MultipleRegression getMultipleRegression() {
        return this.multiple;}


}
