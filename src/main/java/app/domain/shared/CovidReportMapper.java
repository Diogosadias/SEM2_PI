package app.domain.shared;

import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.model.TestStore;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CovidReportMapper {

    private final TestStore testStore;
    private LinearRegression linear;
    private final SimpleDateFormat fmt;
    private List<Test> testList;
    public static final String VARTESTS = "Registered Tests";
    public static final String VARAGE = "Mean Age";
    public static final String MULTIPLE = "Multiple";
    private List<Date> historicDateList;
    private Date initialDate;
    private Date finalDate;
    private int histPoints;
    private double alpha;
    private String reportData;

    public CovidReportMapper(Company company) {
        this.testStore = company.getTestStore();
        testList = new ArrayList<>();
        fmt = new SimpleDateFormat("yyyyMMdd");
        historicDateList = new ArrayList<>();
    }

    public boolean startNewReport(Date initialDate,Date finalDate,int histPoints, double alpha) {
        try {
            this.testList = getValidatedCovidTestList();
            this.initialDate = initialDate;
            this.finalDate = finalDate;
            this.histPoints = histPoints;
            this.alpha = alpha;
            return true;
        } catch (NullPointerException n) {
            System.out.println("Problem sending daily Nhs Report.");
            return false;
        }
    }

    public String getData (){
        String data = "";
        String historic = "Daily";
        String variable = "Registered Tests";
        this.doLinearRegression(variable,historic);
        data += " === Linear Regression - " + historic + " - " + variable + " === \n" + reportData + "\n\n\n";
         historic = "Daily";
         variable = "Mean Age";
        this.doLinearRegression(variable,historic);
        data += " === Linear Regression - " + historic + " - " + variable + " === \n" + reportData + "\n\n\n";
        historic = "Daily";
        variable = "Multiple";
        this.doLinearRegression(variable,historic);
        data += " === Linear Regression - " + historic + " - " + variable + " === \n" + reportData + "\n\n\n";
        historic = "Weekly";
        variable = "Registered Tests";
        this.doLinearRegression(variable,historic);
        data += " === Linear Regression - " + historic + " - " + variable + " === \n" + reportData + "\n\n\n";
        historic = "Weekly";
        variable = "Mean Age";
        this.doLinearRegression(variable,historic);
        data += " === Linear Regression - " + historic + " - " + variable + " === \n" + reportData + "\n\n\n";
        historic = "Weekly";
        variable = "Multiple";
        this.doLinearRegression(variable,historic);
        data += " === Linear Regression - " + historic + " - " + variable + " === \n" + reportData + "\n\n\n";
        return data;
    }

    public void doLinearRegression(String varIndependent, String historic) {
        int historicDays = 1;
        if (historic.equals("Weekly")) {
            historicDays = 7;
        }
        int n = setN(initialDate,finalDate);
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.setTime(initialDate);
        end.setTime(finalDate);
        double[][] intervalValues = getIntervalValues(start,end, n);
        double[] xAgeInterval = intervalValues[0];
        double[] xTestsInterval = intervalValues[1];
        double[] yInterval = intervalValues[2];
        double[][] values = getHistoricValues(histPoints,historicDays);
        double[] xAge = values[0];
        double[] xTests = values[1];
        double[] y = values[2];
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.reportData = "";
        switch (varIndependent){
            case VARTESTS:
                this.linear = new LinearRegression(xTestsInterval,yInterval,alpha);
                reportData += this.linear + this.boardSimpleLRString(xTests, y,historicDays, dateFormat);
                break;
            case VARAGE:
                this.linear = new LinearRegression(xAgeInterval,yInterval,alpha);
                reportData += this.linear + this.boardSimpleLRString(xAge,y, historicDays, dateFormat);
                break;
            case MULTIPLE:
                NumberFormat formatter = new DecimalFormat("#0.0000");
                MultipleRegression multiple = new MultipleRegression(yInterval, xTestsInterval, xAgeInterval, alpha);
                reportData += multiple + "\n\nPrediction values\n\n" + "Date\t\t\tNumber of OBSERVED positive cases\t\tNumber of ESTIMATED/EXPECTED positive cases\t\t\t\t\t95% intervals";
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
                        reportData += "\t\t\t\t\t" + (int) y[i] + "\t\t\t\t\t\t\t\t\t\t\t\t" + formatter.format(multiple.predict(xTests[i], xAge[i])) + "\t\t\t\t\t\t\t\t\t[" + formatter.format(multiple.mininterval(xTests[i], xAge[i])) + "," + formatter.format(multiple.maxinterval(xTests[i], xAge[i])) + "]" + "\t\t\t\t\t\t";
                    }
                }
                break;
            default:
                reportData += "Error!";


        }
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

    public double [][] getHistoricValues(int histPoints,int historicDays){
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

    private List getValidatedCovidTestList() {
        List<Test> covidTests = new ArrayList<>();
        for(Test t :  testStore.getValidatedTests()){
            if(t.getTestType().getCode().equalsIgnoreCase("Covid")){
                covidTests.add(t);
            }
        }
        if(covidTests.isEmpty()) {
            return null;
        }
        return covidTests;
    }

    public int setN(Date initialDate, Date finalDate) {
        return (int) TimeUnit.DAYS.convert((finalDate.getTime() - initialDate.getTime()), TimeUnit.MILLISECONDS) - 1;
    }

    private String boardSimpleLRString (double[] x, double[] y, int historicDays, SimpleDateFormat dateFormat) {
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


}