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


    Company company;
    TestStore testStore;
    List<Test> testList = new ArrayList<>();
    LinearRegression linear;

    public CovidNhsReportController(){
        this.company = App.getInstance().getCompany();
        this.testStore = company.getTestStore();
    }

    public void Matcp(Date inid , Date finald){



        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();


        int countx = 0;
        int county = 0;

        int i;

        start.setTime(inid);
        end.setTime(finald);

        long dif = Math.abs(inid.getTime() - finald.getTime());
        double dayDifference = TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);



        double [] x = new double[(int)dayDifference];   //nr de testes positivos
        double [] y = new double[(int) dayDifference]; //nr de testes

        while( !start.after(end)){
            Date targetDay = start.getTime();

            i = 0;

            for(Test t : testStore.getValidatedTests() ){

                if(t.getDateValidation() == targetDay || t.getTestType().getCode().equalsIgnoreCase("Covid")){
                    county++;
                    if(t.getTestParam().getResult().getMetric() > 1.4)
                        countx++;
                }


            }



            start.add(Calendar.DATE, 1);

            x[i] = countx; //nr de testes positivos
            y[i] = county; //nr de testes
            i++;
            countx = 0;
            county = 0;
        }

        linear = new LinearRegression(x,y);
        System.out.println(linear);

    }




}
