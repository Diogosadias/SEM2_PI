package app.controller;

import app.domain.model.*;
import javafx.scene.chart.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *  Controller for testing statistics
 *
 * @author Gil
 */
public class TestingStatsController {

    private final TestStore testStore;
    private final TestTypeStore testTypeStore;
    private final ClientStore clientStore;

    private Date initDateGraph;
    private Date finalDateGraph;
    private int chart;

    private String[] datesString;
    private Date[] dates ;

    public String[] getDatesString() {
        return datesString;
    }

    public Date[] getDates() {
        return dates;
    }

    /**
     * Constructor
     */
    public TestingStatsController() {
        Company company = App.getInstance().getCompany();
        this.testStore = company.getTestStore();
        this.testTypeStore = company.getTestTypeStore();
        this.clientStore = company.getClientStore();
    }

    public void createLineChartForData(LineChart<String, Number> lineChart, CategoryAxis xAxis, NumberAxis yAxis,
                                       String xAxisLabel, String yAxisLabel, String chartTitle, String seriesName,
                                       String[] xValues, int[] yValues) throws Exception {
        xAxis.setLabel(xAxisLabel);
        yAxis.setLabel(yAxisLabel);

        if(xValues.length != yValues.length) throw new IllegalArgumentException("Data issues! Couldn't load statistics");
        if(xValues.length < 2) throw new Exception("");

        yAxis.setAutoRanging(true);

        lineChart.setTitle(chartTitle);
        XYChart.Series<String, Number> series = new LineChart.Series<>();
        series.setName(seriesName);

        for (int i = 1; i < xValues.length; i++) {
            XYChart.Data<String, Number> data = new LineChart.Data<>(xValues[i], yValues[i]);
            series.getData().add(data);
        }
        lineChart.getData().add(series);
    }

    public void getArraysForDates(int period){
        int dif;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        switch (period){
            case 1:
                dif = calculateDifferenceInDays(this.initDateGraph,this.finalDateGraph);
                if(dif==0){
                    datesString=null;
                    dates=null;
                    break;
                }
                dates = new Date[dif];
                datesString = new String[dif];
                dates[0] = this.initDateGraph;
                datesString[0]=dateFormat.format(dates[0]);
                for(int i = 1 ; i<dif ; i++){
                    dates[i] = addDaysToDate(dates[i-1],1);
                    datesString[i]=dateFormat.format(dates[i]);
                }

                break;
            case 7:
                dif = calculateDifferenceInWeeks(this.initDateGraph,this.finalDateGraph);
                if(dif==0){
                    datesString=null;
                    dates=null;
                    break;
                }
                dates = new Date[dif];
                datesString = new String[dif];
                dates[0] = this.initDateGraph;
                datesString[0]=dateFormat.format(dates[0]);
                for(int i = 1 ; i<dif ; i++){
                    dates[i] = addDaysToDate(dates[i-1],7);
                    datesString[i]=dateFormat.format(dates[i]);
                }
                break;
            case 31:
                dif = calculateDifferenceInMonths(this.initDateGraph,this.finalDateGraph);
                if(dif==0){
                    datesString=null;
                    dates=null;
                    break;
                }
                dates = new Date[dif];
                datesString = new String[dif];
                dates[0] = this.initDateGraph;
                datesString[0]=dateFormat.format(dates[0]);
                for(int i = 1 ; i<dif ; i++){
                    dates[i] = addDaysToDate(dates[i-1],31);
                    datesString[i]=dateFormat.format(dates[i]);
                }
                break;
            case 365:
                dif = calculateDifferenceInYears(this.initDateGraph,this.finalDateGraph);
                if(dif==0){
                    datesString=null;
                    dates=null;
                    break;
                }
                dates = new Date[dif];
                datesString = new String[dif];
                dates[0] = this.initDateGraph;
                datesString[0]=dateFormat.format(dates[0]);
                for(int i = 1 ; i<dif ; i++){
                    dates[i] = addDaysToDate(dates[i-1],365);
                    datesString[i]=dateFormat.format(dates[i]);
                }
                break;
        }
    }

    public Date addDaysToDate(Date date, int days) {
        Date newDate = date;
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(newDate);
        calendar.add(Calendar.DATE, days);
        newDate=calendar.getTime();
        //newDate.setTime(calendar.getTime().getTime());
        return newDate;
    }

    private int calculateDifferenceInDays(Date date1, Date date2) {
        if(date1.getTime()>date2.getTime()){
            long d = (date1.getTime()-date2.getTime())/(1000*60*60*24);
            d= Math.abs(d);
            return Integer.parseInt(String.valueOf(d));
        }
        long d = (date2.getTime()-date1.getTime())/(1000*60*60*24);
        d= Math.abs(d);
        return Integer.parseInt(String.valueOf(d));
        //return (int)(date2.getTime()-date1.getTime()) / (1000*60*60*24);
    }

    private int calculateDifferenceInMonths(Date date1, Date date2) {
        int m1 = date1.getYear() * 12 + date1.getMonth();
        int m2 = date2.getYear() * 12 + date2.getMonth();
        return m2 - m1 + 1;
    }

    private int calculateDifferenceInWeeks(Date date1, Date date2){
        if(date1.getTime()>date2.getTime()){
            long d = (date1.getTime()-date2.getTime())/(7*24 * 60 * 60 * 1000);
            d= Math.abs(d);
            return Integer.parseInt(String.valueOf(d));
        }
        long d = (date2.getTime()-date1.getTime())/(7*24 * 60 * 60 * 1000);
        d= Math.abs(d);
        return Integer.parseInt(String.valueOf(d));
    }

    private int calculateDifferenceInYears(Date date1, Date date2){
        if(date1.getTime()>date2.getTime()){
            long d = (date1.getTime()-date2.getTime())/(1000L *60*60*24*365);
            d= Math.abs(d);
            return Integer.parseInt(String.valueOf(d));
        }
        long d = (date2.getTime()-date1.getTime())/(1000L *60*60*24*365);
        d= Math.abs(d);
        return Integer.parseInt(String.valueOf(d));
    }

    public void setChartOption(int chart) {
        this.chart = chart;
    }
    public int getChartOption() {
        return chart;
    }
    public void setInitDateGraph(Date initDateGraph) {
        this.initDateGraph = initDateGraph;
    }
    public void setFinalDateGraph(Date finalDateGraph) {
        this.finalDateGraph = finalDateGraph;
    }

    public int[] getNrTests(Date[] dates, String state){
        int[] res = new int[dates.length];
        for(int i = 0; i < dates.length; i++){
            for(Test t : this.testStore.getAllTests()){
                if (t.hasCondition(state) && t.getDateRegistered().after(dates[i]) && t.getDateRegistered().before(addDaysToDate(dates[i],1))){
                    res[i]++;
                }
            }
        }
        return res;
    }
    public int[] getNrClients(int datesLength) {
        int[] res = new int[datesLength];
        for(int i = 0; i < datesLength; i++){
            Date minDate = new Date();
            for(Client c : this.clientStore.getClientList()){

                if(!Objects.isNull(c) && !Objects.isNull(c.getId())){

                    for(Test t : this.testStore.getAllTests()){
                        System.out.println(c);
                        if(t.getClient().getId().equals(c.getId())){
                            if(t.getDateRegistered().getDay() < minDate.getDay() &&
                                    t.getDateRegistered().getMonth() <= minDate.getMonth() &&
                                    t.getDateRegistered().getYear() <= minDate.getYear()){
                                minDate = t.getDateRegistered();
                            }
                        }
                    }

                }

            }

            if (minDate.getDay() == dates[i].getDay() &&
                    dates[i].getMonth() == minDate.getMonth() &&
                    dates[i].getYear() == minDate.getYear()){
                res[i]++;
            }

        }
        return res;
    }
}
