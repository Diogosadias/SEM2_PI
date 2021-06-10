package app.controller;

import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.model.TestStore;
import app.domain.shared.LinearRegression;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CovidNhsReportController {


    private Company company;
    private TestStore testStore;
    private LinearRegression linear;
    private String historic;
    private int histPoints;
    private Date initialDate;
    private Date finalDate;
    private String regression;
    private Date currentDay;
    private String report;
    private String varIndependent;
    private double [] xTests;
    private double [] xAge;
    private double [] y;
    private List<Test> testList;

    public CovidNhsReportController(){
        this.company = App.getInstance().getCompany();
        this.testStore = this.company.getTestStore();
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
    }

    public void Matcp(){
        List<Date> dateList = new ArrayList<>();
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        this.xAge = new double[this.histPoints];
        this.xTests = new double[this.histPoints];
        this.y = new double[this.histPoints];

            int countx = 0;
            int county = 0;

            int i=0;

            start.setTime(this.initialDate);
            end.setTime(this.finalDate);


            while( !start.after(end)){
                Date targetDay = start.getTime();
                int sumAge = 0;

                SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
                    List<Test> list = this.testStore.getValidatedTests();
                    for(Test t :  list){
                        if(fmt.format(t.getDateValidation()).equals(fmt.format(targetDay))){
                            countx++;
                            if(t.getTestParam().getResult().getMetric() > 1.4) {
                                county++;
                            }
                            sumAge += t.getClient().calculateAge();
                        }
                    }
                if(countx > 0 && county > 0) {
                    this.xAge[i] = (double)sumAge / (double)countx;
                    this.xTests[i] = countx;
                    this.y[i] = county;
                    dateList.add(targetDay);
                } else {
                    i--;
                }
                start.add(Calendar.DATE, 1);
                i++;
                countx = 0;
                county = 0;
            }
            if(this.varIndependent.equals("Registered Tests")) {
                this.linear = new LinearRegression(xTests,y,dateList);
            } else if(this.varIndependent.equals("Mean Age")) {
                this.linear = new LinearRegression(xAge,y,dateList);
            }
            System.out.println(linear);

        try (PrintStream out = new PrintStream(new FileOutputStream("CovidReport.txt"))) {
            out.print(linear);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }




    public String writeReport(){
        this.report = linear.toString();
        return this.report;
    }

}
