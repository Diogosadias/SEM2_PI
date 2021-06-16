package app.controller;

import app.domain.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import java.util.*;

/**
 *  Controller for testing statistics
 *
 * @author Gil
 */
public class TestingStatsController {

    private final TestStore testStore;
    private final TestTypeStore testTypeStore;

    /**
     * Constructor
     */
    public TestingStatsController() {
        Company company = App.getInstance().getCompany();
        testStore = company.getTestStore();
        testTypeStore = company.getTestTypeStore();
    }


    /**
     * Method for creating a line chart for monthly registered tests
     */
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

    /**
     *  each position contains the number of tests for each month difference
     * @return int[12]
     */
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

    /**
     * Method for creating a line chart for monthly results' average   time
     */
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
    }

    /**
     *  Returns the Monthly Average Waiting Time For the Last 12 Months in an array.
     * @return int[]
     */
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
    }


    private int calculateDifferenceInDays(Date dateRegistered, Date dateValidation) {
        return (int)(dateValidation.getTime()-dateRegistered.getTime()) / (1000*60*60*24);
    }

    private int getMonthsDifference(Date date1, Date date2) {
        int m1 = date1.getYear() * 12 + date1.getMonth();
        int m2 = date2.getYear() * 12 + date2.getMonth();
        return m2 - m1 + 1;
    }

    /**
     * Creates a pie chart with the All Time Test Type Distribution Data.
     * @param pieChart
     */
    public void createPieChart(PieChart pieChart) {

        List<PieChart.Data> list = new ArrayList<>();
        for(TestType type : testTypeStore.getTestTypeList()){
            int cont = 0;

            for (Test t : testStore.getAllTests()){
                if (t.getTestType().getCode().equalsIgnoreCase(type.getCode())) cont++;
            }

            list.add(new PieChart.Data(type.getDescription(), cont));

        }
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(list);

        pieChart.setData(pieChartData);
        pieChart.setTitle("All Time Test Type Distribution");
        pieChart.setClockwise(true);
    }
}
