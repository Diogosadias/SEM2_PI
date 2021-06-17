package app.controller;

import app.domain.model.*;
import app.domain.shared.Constants;
import app.ui.gui.TestingStatsGUI2;
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

    private Date initDateGraph;
    private Date finalDateGraph;
    private int chart;




    /**
     * Constructor
     */
    public TestingStatsController() {
        Company company = App.getInstance().getCompany();
        testStore = company.getTestStore();
        testTypeStore = company.getTestTypeStore();
    }

    public void createLineChartForData(LineChart<String, Number> lineChart, CategoryAxis xAxis, NumberAxis yAxis,
                                       String xAxisLabel, String yAxisLabel, String chartTitle, String seriesName,
                                       String[] xValues, int[] yValues){

        if(xValues.length != yValues.length) throw new IllegalArgumentException("Data issues! Couldn't load statistics");

        xAxis.setLabel(xAxisLabel);

        yAxis.setLabel(yAxisLabel);
        yAxis.setAutoRanging(true);
        yAxis.setTickUnit(1);

        lineChart.setTitle(chartTitle);
        XYChart.Series<String, Number> series = new LineChart.Series<>();
        series.setName(seriesName);

        for (int i = 1; i < xValues.length; i++) {
            XYChart.Data<String, Number> data = new LineChart.Data<>(xValues[i], yValues[i]);
            series.getData().add(data);
        }
        lineChart.getData().add(series);
    }

    public String[] getDatesInArray(int period){
        int dif;

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String[] dates;

        switch (period){
            case 1:
                dif = calculateDifferenceInDays(this.initDateGraph,this.finalDateGraph);
                dates = new String[dif];
                dates[0] = dateFormat.format(this.initDateGraph);
                for(int i = 1; i < dif; i++){
                    dates[i] = dateFormat.format(addDaysToDate(new Date(dates[i-1]), 1));
                }
                return dates;
            case 7:
                dif = calculateDifferenceInWeeks(this.initDateGraph,this.finalDateGraph);
                dates = new String[dif];
                dates[0] = dateFormat.format(this.initDateGraph);
                for(int i = 1; i < dif; i++){
                    dates[i] = dateFormat.format(addDaysToDate(new Date(dates[i-1]), 7));
                }
                return dates;
            case 31:
                dif = calculateDifferenceInMonths(this.initDateGraph,this.finalDateGraph);
                dates = new String[dif];
                dates[0] = dateFormat.format(this.initDateGraph);
                for(int i = 1; i < dif; i++){
                    dates[i] = dateFormat.format(addDaysToDate(new Date(dates[i-1]), 31));
                }
                return dates;
            case 365:
                dif = calculateDifferenceInYears(this.initDateGraph,this.finalDateGraph);
                dates = new String[dif];
                dates[0] = dateFormat.format(this.initDateGraph);
                for(int i = 1; i < dif; i++){
                    dates[i] = dateFormat.format(addDaysToDate(new Date(dates[i-1]), 365));
                }
                return dates;
        }
        return null;
    }

    public int[] getNrTests(String[] dates, String state){
        int[] res = new int[dates.length];
        for(int i = 0; i < dates.length; i++){
            for(Test t : this.testStore.getAllTests()){
                if (t.hasCondition(state) && t.getDateRegistered().after(new Date(dates[i])) && t.getDateRegistered().before(new Date(dates[i+1]))){
                    res[i]++;
                }
            }
        }
        return res;
    }


    public Date addDaysToDate(Date date, int days) {
        Date newDate = new Date(date.getTime());
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(newDate);
        calendar.add(Calendar.DATE, days);
        newDate.setTime(calendar.getTime().getTime());
        return newDate;
    }

    /**
     * Method for creating a line chart for monthly registered tests
     *//*
    public void createLineChart1(LineChart<Number, Number> lineChart, NumberAxis xAxis, NumberAxis yAxis){
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(1);
        xAxis.setUpperBound(12);
        xAxis.setTickUnit(1);
        xAxis.setLabel("Number of months past");

        yAxis.setLabel("Number of tests");
        yAxis.setAutoRanging(true);
        yAxis.setTickUnit(1);

        lineChart.setTitle("Last 12 months registered tests number");
        XYChart.Series<Number, Number> series = new LineChart.Series<>();
        series.setName("Registered tests");

        int[] yValues = getRegisteredTestsNrForLast12Months();

        for (int i = 1; i < 13; i++) {
            XYChart.Data<Number, Number> data = new LineChart.Data<>(13-i, yValues[yValues.length-i]);
            series.getData().add(data);
        }
        lineChart.getData().add(series);
    }
*/
    /*
    private int[] getRegisteredTestsNrForLast12Months(){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -1);
        Date yrAgo = c.getTime();
        int[] yValues = new int[12];
        int dif;
        for(Test i : testStore.getAllTests()) {
            dif = getMonthsDifference(yrAgo, i.getDateRegistered());
            if (dif < 13) {
                yValues[dif - 1]++;
            }

        }
        return yValues;
    }

    *//*
    public void createLineChart2(LineChart<Number, Number> lineChart, NumberAxis xAxis, NumberAxis yAxis){
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(1);
        xAxis.setUpperBound(12);
        xAxis.setTickUnit(1);
        xAxis.setLabel("Number of months past");

        yAxis.setAutoRanging(true);
        yAxis.setLabel("Days");

        lineChart.setTitle("Last 12 months results' average waiting time");

        XYChart.Series<Number, Number> series = new LineChart.Series<>();
        series.setName("Waiting time");

        int[] yValues = getMonthlyAverageWaitingTimeForLast12Months();

        for (int i = 1; i < 13; i++) {
            XYChart.Data<Number, Number> data = new LineChart.Data<>(13-i, yValues[yValues.length-i]);
            series.getData().add(data);
        }
        lineChart.getData().add(series);
    }*//*

    *//**
     *  Returns the Monthly Average Waiting Time For the Last 12 Months in an array.
     * @return int[]
     *//*
    private int[] getMonthlyAverageWaitingTimeForLast12Months() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -1);
        Date yrAgo = c.getTime();

        int[] yValues = new int[12];
        int[] nTestsInMonth = new int[12];

        int dif;
        for(Test i : testStore.getAllTests()) {
            dif = getMonthsDifference(yrAgo, i.getDateRegistered());
            if (dif < 13) {
                yValues[dif - 1] = calculateDifferenceInDays(i.getDateRegistered(), i.getDateValidation());
                nTestsInMonth[dif - 1]++;
            }
        }
        for(dif=0; dif < 12; dif++){
            yValues[dif] = (nTestsInMonth[dif] == 0) ? 0 : (yValues[dif]/nTestsInMonth[dif]);
        }
        return yValues;
    }*/


    private int calculateDifferenceInDays(Date date1, Date date2) {
        return (int)(date1.getTime()-date2.getTime()) / (1000*60*60*24);
    }

    private int calculateDifferenceInMonths(Date date1, Date date2) {
        int m1 = date1.getYear() * 12 + date1.getMonth();
        int m2 = date2.getYear() * 12 + date2.getMonth();
        return m2 - m1 + 1;
    }

    private int calculateDifferenceInWeeks(Date date1, Date date2){
        return (int) (date1.getTime()-date2.getTime())/(7*24 * 60 * 60 * 1000);
    }

    private int calculateDifferenceInYears(Date date1, Date date2){
        return (int) (date1.getTime()-date2.getTime())/(1000*60*60*24*365);
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

}
