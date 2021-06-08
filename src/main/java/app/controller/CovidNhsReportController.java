package app.controller;

import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.model.TestStore;
import app.domain.shared.LinearRegression;

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

    public CovidNhsReportController(){
        this.company = App.getInstance().getCompany();
        this.testStore = this.company.getTestStore();
    }

    public void startNewReport(String historic, int histPoints) {
        this.currentDay = new Date(System.currentTimeMillis());
        this.historic = historic;
        this.histPoints = histPoints;
    }

    public void setAdditionalData(Date initialDate, Date finalDate, String regression) {
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.regression = regression;
    }

    public void Matcp(Date inid , Date finald, String varIndependent){
        List<Test> testList = this.testStore.getValidatedTests();
        if (testList != null) {
            Calendar start = Calendar.getInstance();
            Calendar end = Calendar.getInstance();


            int countx = 0;
            int county = 0;

            int i;

            start.setTime(inid);
            end.setTime(finald);

            long dif = Math.abs(inid.getTime() - finald.getTime());
            double dayDifference = TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);

            double [] x = new double[testList.size()];   //nr de testes positivos
            double [] y = new double[testList.size()]; //nr de testes

            while( !start.after(end)){
                Date targetDay = start.getTime();

                i = 0;


                for(Test t :  testList){

                    if(t.getDateValidation() == targetDay || t.getTestType().getCode().equalsIgnoreCase("Covid")){
                        county++;
                        if(t.getTestParam().getResult().getMetric() > 1.4)
                            countx++;
                    }


                }

                start.add(Calendar.DATE, 1);

                x[i] = countx; //nr de testes positivos - erro aqui
                y[i] = county; //nr de testes*/
                i++;
                countx = 0;
                county = 0;
            }
            this.linear = new LinearRegression(x,y,varIndependent);
            System.out.println(linear);

            }
        else {
            double[]a = {7,9,6,14,8,12,10,4,2,11,1,8};
            double[]b = {26,20,28,16,23,18,24,26,38,22,32,25};

            this.linear = new LinearRegression(a,b,varIndependent);
            System.out.println(linear);
        }

    }

    public String writeReport(){
        this.report = linear.toString();
        return this.report;
    }

}
