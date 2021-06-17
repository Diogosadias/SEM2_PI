package app.controller;

import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.model.TestStore;
import app.domain.shared.CovidReport;
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
    private CovidReport report;
    private String reportData = "";

    public final String VAR_TESTS = "Registered Tests";
    public final String VAR_AGE = "Mean Age";
    public final String MULTIPLE = "Multiple";

    public CovidNhsReportController(){
        this.company = App.getInstance().getCompany();
        this.testStore = this.company.getTestStore();
    }

    public boolean startNewReport() {
        try {
            List<Test> list = getValidatedCovidTestList();
            this.report = new CovidReport();
            this.report.setTestList(list);
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
        int n = this.report.setN(initialDate,finalDate);
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.setTime(initialDate);
        end.setTime(finalDate);
        double[][] values = this.report.getIntervalValues(start,end, n);
        double[] xAgeInterval = values[0];
        double[] xTestsInterval = values[1];
        double[] yInterval = values[2];
        double[][] matcp = this.report.doMatcp(histPoints,historicDays);
        double[] xAge = matcp[0];
        double[] xTests = matcp[1];
        double[] y = matcp[2];
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.reportData = "";
        switch (varIndependent){
            case VAR_TESTS:
                this.report.setSimpleLinearRegression(new LinearRegression(xTestsInterval,yInterval,alpha));
                reportData += this.report.getSimpleLR() + this.report.boardSimpleLRString(xTests, y,historicDays, dateFormat);
                break;
            case VAR_AGE:
                this.report.setSimpleLinearRegression(new LinearRegression(xAgeInterval,yInterval,alpha));
                reportData += this.report.getSimpleLR() + this.report.boardSimpleLRString(xAge,y, historicDays, dateFormat);
                break;
            case MULTIPLE:
                NumberFormat formatter = new DecimalFormat("#0.0000");
                this.report.setMultipleLinearRegression(new MultipleRegression(yInterval,xTestsInterval,xAgeInterval,alpha));
                reportData += this.report.getMultipleLR() + "\n\nPrediction values\n\n" + "Date\t\t\tNumber of OBSERVED positive cases\t\tNumber of ESTIMATED/EXPECTED positive cases\t\t\t\t\t95% intervals";
                for(int i = 0; i < this.report.getHistoricDateList().size(); i ++){
                    if(y[i] != 0) {
                        Date date = this.report.getHistoricDateList().get(i);
                        reportData += "\n" + dateFormat.format(date);
                        if(historicDays == 7) {
                            Calendar cal = Calendar.getInstance();
                            cal.setTime(date);
                            cal.add(Calendar.DATE,historicDays-1);
                            reportData += " - " + dateFormat.format(cal.getTime());
                        }
                        reportData += "\t\t\t\t\t" + (int) y[i] + "\t\t\t\t\t\t\t\t\t\t\t\t" + formatter.format(this.report.getMultipleLR().predict(xTests[i], xAge[i])) + "\t\t\t\t\t\t\t\t\t[" + formatter.format(this.report.getMultipleLR().mininterval(xTests[i], xAge[i])) + "," + formatter.format(this.report.getMultipleLR().maxinterval(xTests[i], xAge[i])) + "]" + "\t\t\t\t\t\t";
                    }
                }
                break;
            default:
                reportData += "Error!";


        }
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

    public String getData() {
        return reportData;}



}
