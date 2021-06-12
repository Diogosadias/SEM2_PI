package app.controller;

import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.model.TestStore;
import app.domain.shared.LinearRegression;
import app.domain.shared.MultipleRegression;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
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
    private String historic;
    private int histPoints;
    private Date initialDate;
    private Date finalDate;
    private String regression;
    private Date currentDay;
    private String report;
    private String varIndependent;
    private double [] xTests;
    private double [] xTestsInterval;
    private double [] xAge;
    private double [] xAgeInterval;
    private double [] yInterval;
    private double [] y;
    private List<Test> testList;
    private List<Date> historicDateList = new ArrayList<>();
    private SimpleDateFormat fmt;
    List<Test> list;

    public CovidNhsReportController(){
        this.company = App.getInstance().getCompany();
        this.testStore = this.company.getTestStore();
        fmt = new SimpleDateFormat("yyyyMMdd");
        list = this.testStore.getValidatedTests();
    }

    public void startNewReport(String historic, int histPoints) {
        this.currentDay = new Date(System.currentTimeMillis());
        this.historic = historic;
        this.histPoints = histPoints;
        this.testList = getValidatedCovidTestList();
        if (testList == null) {
            throw new IllegalArgumentException("Validated/Covid Test list is empty.");
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

    public void doSimpleLinearRegression(Date initialDate, Date finalDate, String regression, String varIndependent) {
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.regression = regression;
        this.varIndependent = varIndependent;
        this.Matcp();
    }

    public void doMultipleLinearRegression(Date initialDate, Date finalDate, String regression) {
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.regression = regression;
        this.varIndependent = "Both";
        this.Matcp();
    }

    public void Matcp(){
        List<Date> intervalDateList = getIntervalDates();
        Calendar date = Calendar.getInstance();
        this.xAge = new double[this.histPoints];
        this.xTests = new double[this.histPoints];
        this.y = new double[this.histPoints];

            int countx = 0;
            int county = 0;

            int i=0;

            date.setTime(new Date(System.currentTimeMillis()));
            int countDays = 1;
            while( countDays <= histPoints ) {
                Date targetDay = date.getTime();
                int sumAge = 0;

                SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
                List<Test> list = this.testStore.getValidatedTests();

                    for (Test t : list) {

                        if (fmt.format(t.getDateRegistered()).equals(fmt.format(targetDay))) {
                            countx++;
                            if (t.getTestParam().getResult().getMetric() > 1.4) {
                                county++;
                            }
                            sumAge += t.getClient().calculateAge();
                        }

                    }

                if(countx > 0 ) {
                    this.xAge[i] = (double)sumAge / (double)countx;
                    this.xTests[i] = countx;
                    this.y[i] = county;
                    historicDateList.add(targetDay);
                    countDays++;
                } else {
                    i--;
                }
                date.add(Calendar.DATE, -1);
                i++;
                countx = 0;
                county = 0;
            }

            if(this.varIndependent.equals("Registered Tests")) {
                this.linear = new LinearRegression(this.xTestsInterval,this.yInterval);
            } else if(this.varIndependent.equals("Mean Age")) {
                this.linear = new LinearRegression(this.xAgeInterval,this.yInterval);
            } else if(this.varIndependent.equals("Both")){
                this.multiple = new MultipleRegression(this.yInterval,this.xTestsInterval,this.xAgeInterval);
            }



        try (PrintStream out = new PrintStream(new FileOutputStream("CovidReport.txt"))) {
            switch (regression){
                case "Linear":
                    out.print(linear);
                    break;
                case "Multiple":
                    out.print(multiple);
                    break;
                default:
                    out.print("Error!");

            }
            out.print(boardToFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List getIntervalDates() {
        List<Date> temp = new ArrayList<>();
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.setTime(this.initialDate);
        end.setTime(this.finalDate);
        int n = (int) TimeUnit.DAYS.convert((this.finalDate.getTime() - this.initialDate.getTime()), TimeUnit.MILLISECONDS) - 1;
        this.xAgeInterval = new double[n];
        this.xTestsInterval = new double[n];
        this.yInterval = new double[n];
        int i =0;
        while (!start.after(end)) {
            int countx = 0;
            int county = 0;
            int sumAge = 0;
            for (Test t : list) {
                if (fmt.format(t.getDateRegistered()).equals(fmt.format(start.getTime()))) {
                    countx++;
                    if (t.getTestParam().getResult().getMetric() > 1.4) {
                        county++;
                    }
                    sumAge += t.getClient().calculateAge();
                }

            }
            if(countx > 0) {
                this.xAgeInterval[i] = (double)sumAge / (double)countx;
                this.xTestsInterval[i] = countx;
                this.yInterval[i] = county;
                temp.add(start.getTime());
                i++;
            }
            start.add(Calendar.DATE, 1);
        }
        return temp;
    }


    public String writeReport(){
        if(linear!=null)
            this.report = linear.toString();
        else if(multiple!=null)
                this.report = multiple.toString();
        return this.report;
    }

    private String boardToFile() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String board;
        switch (varIndependent){
            case "Registered Tests":
                board = "\n\nPrediction values\n\n" + "Date\t\t\tNumber of OBSERVED positive cases\t\tNumber of ESTIMATED/EXPECTED positive cases\t\t\t\t\t\t95% intervals\t\t\t\t\t\t\tNumber Tests Registed";
                for(int i = 0; i < this.historicDateList.size(); i ++){
                    if(y[i] != 0) {
                        double predict = this.linear.predict(xTests[i]);
                        double delta = this.linear.delta(xTests[i]);
                        board += "\n" + dateFormat.format(historicDateList.get(i)) + "\t\t\t\t\t" + (int)y[i] + "\t\t\t\t\t\t\t\t\t\t\t\t" + predict +"\t\t\t\t\t\t\t\t\t["+(predict - delta)+","+(predict + delta)+"]" + "\t\t\t\t\t\t" + (int)xTests[i] + "\t\t\t\t\t\t" + roundAvoid(xAge[i],2);
                    }
                }
                break;
            case "Mean Age":
                board = "Por implementar";
                break;
            case "Both":
                board = "\n\nPrediction values\n\n" + "Date\t\t\tNumber of OBSERVED positive cases\t\tNumber of ESTIMATED/EXPECTED positive cases\t\t\t\t\t\t95% intervals\t\t\t\t\t\t\tNumber Tests Registed";
                for(int i = 0; i < this.historicDateList.size(); i ++){
                    board += "\n" + dateFormat.format(historicDateList.get(i)) + "\t\t\t\t\t" + (int)y[i] + "\t\t\t\t\t\t\t\t\t\t\t\t" + this.multiple.predict(xTestsInterval[i],xAgeInterval[i]) +"\t\t\t\t\t\t\t\t\t["+this.multiple.mininterval(xTestsInterval[i],xAgeInterval[i])+","+this.multiple.maxinterval(xTestsInterval[i],xAgeInterval[i])+"]"+ "\t\t\t\t\t\t" + (int)xTests[i];
                }
                break;
            default:
                board = "Error!";


        }
        return board;

    }

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

}
