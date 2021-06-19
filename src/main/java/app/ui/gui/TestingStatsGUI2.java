package app.ui.gui;

import app.controller.TestingStatsController;
import app.ui.Main;
import app.ui.console.MenuItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import static app.domain.shared.Constants.*;

/**
 * @author Gil <1180838@isep.ipp.pt>
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class TestingStatsGUI2 implements Initializable, GuiMethods{
    @FXML
    public DatePicker datePickerInit;
    @FXML
    public DatePicker datePickerFinal;
    @FXML
    public Button btnCharts;
    @FXML
    private LineChart<String, Number> dailyChart;
    @FXML
    private CategoryAxis xAxis1;
    @FXML
    private NumberAxis yAxis1;

    @FXML
    private LineChart<String, Number> weeklyChart;
    @FXML
    private CategoryAxis xAxis2;
    @FXML
    private NumberAxis yAxis2;

    @FXML
    private LineChart<String, Number> monthlyChart;
    @FXML
    private CategoryAxis xAxis3;
    @FXML
    private NumberAxis yAxis3;

    @FXML
    private LineChart<String, Number> yearlyChart;
    @FXML
    private CategoryAxis xAxis4;
    @FXML
    private NumberAxis yAxis4;

    Main main;
    private TestingStatsController controller;

    @Override
    public void setInstance(Main mainInstance) {
        this.main = mainInstance;
    }
    @FXML
    void selectDate1(ActionEvent event) {
        controller.setInitDateGraph(java.sql.Date.valueOf(datePickerInit.getValue()));
    }

    @FXML
    void selectDate2(ActionEvent event) {
        controller.setFinalDateGraph(java.sql.Date.valueOf(datePickerFinal.getValue()));
    }

    public void setController(TestingStatsController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //no need for code here
    }

    @FXML
    private void menuCancel(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Are you sure you want to cancel?");
        alert.setHeaderText("Do you want to go back?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.OK) {
                //trocar para janela anterior
                try {
                    MenuItem item= new MenuItem("default", "/fxml/TestingStatsGUI1.fxml");
                    item.runGui(item.getGui(),main);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    public void createChart(ActionEvent actionEvent) {
        this.dailyChart.getData().clear();
        this.weeklyChart.getData().clear();
        this.monthlyChart.getData().clear();
        this.yearlyChart.getData().clear();

        controller.getArraysForDates(1);
        Date[] dates1 = controller.getDates();
        String[] datesString1 = controller.getDatesString();

        controller.getArraysForDates(7);
        Date[] dates2 = controller.getDates();
        String[] datesString2 = controller.getDatesString();

        controller.getArraysForDates(31);
        Date[] dates3 = controller.getDates();
        String[] datesString3 = controller.getDatesString();

        controller.getArraysForDates(365);
        Date[] dates4 = controller.getDates();
        String[] datesString4 = controller.getDatesString();

        int chartOption = controller.getChartOption();

        switch (chartOption){
            case 1:
                //Tests Waiting for Results
                try{
                    controller.createLineChartForData(this.dailyChart, xAxis1, yAxis1, GRAPH_DATE,
                            RESULT_TESTS,DAILY_CHART, WAITING_TESTS,
                            datesString1, controller.getNrTestsWaitingForResult(dates1));
                    controller.createLineChartForData(this.weeklyChart, xAxis2, yAxis2, GRAPH_DATE,
                            RESULT_TESTS,WEEKLY_CHART, WAITING_TESTS,
                            datesString2, controller.getNrTestsWaitingForResult(dates2));
                    controller.createLineChartForData(this.monthlyChart, xAxis3, yAxis3, GRAPH_DATE,
                            RESULT_TESTS,MONTHLY_CHART, WAITING_TESTS,
                            datesString3, controller.getNrTestsWaitingForResult(dates3));
                    controller.createLineChartForData(this.yearlyChart, xAxis4, yAxis4, GRAPH_DATE,
                            RESULT_TESTS,YEARLY_CHART, WAITING_TESTS,
                            datesString4, controller.getNrTestsWaitingForResult(dates4));
                } catch (IllegalArgumentException exception){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText(exception.getMessage());
                    alert.showAndWait();
                } catch (Exception ignored) {
                }

               break;
            case 2:
                //Tests Waiting for Diagnosis
                try{
                    controller.createLineChartForData(this.dailyChart, xAxis1, yAxis1, GRAPH_DATE,
                            DIAGNOSIS_TESTS,DAILY_CHART, WAITING_TESTS,
                            datesString1, controller.getNrTestsWaitingForDiagnosis(dates1));
                    controller.createLineChartForData(this.weeklyChart, xAxis2, yAxis2, GRAPH_DATE,
                            DIAGNOSIS_TESTS,WEEKLY_CHART, WAITING_TESTS,
                            datesString2, controller.getNrTestsWaitingForDiagnosis(dates2));
                    controller.createLineChartForData(this.monthlyChart, xAxis3, yAxis3, GRAPH_DATE,
                            DIAGNOSIS_TESTS,MONTHLY_CHART, WAITING_TESTS,
                            datesString3, controller.getNrTestsWaitingForDiagnosis(dates3));
                    controller.createLineChartForData(this.yearlyChart, xAxis4, yAxis4, GRAPH_DATE,
                            DIAGNOSIS_TESTS,YEARLY_CHART, WAITING_TESTS,
                            datesString4, controller.getNrTestsWaitingForDiagnosis(dates4));
                } catch (IllegalArgumentException exception){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText(exception.getMessage());
                    alert.showAndWait();
                } catch (Exception ignored) {
                }
                break;

            case 3:
                //Tests Validated
                try {
                    controller.createLineChartForData(this.dailyChart, xAxis1, yAxis1, GRAPH_DATE,
                            TOTAL_TESTS,DAILY_CHART, null,
                            datesString1, controller.getNrTestsValidated(dates1));
                    controller.createLineChartForData(this.weeklyChart, xAxis2, yAxis2, GRAPH_DATE,
                            TOTAL_TESTS,WEEKLY_CHART, "",
                            datesString2, controller.getNrTestsValidated(dates2));
                    controller.createLineChartForData(this.monthlyChart, xAxis3, yAxis3, GRAPH_DATE,
                            TOTAL_TESTS,MONTHLY_CHART, "",
                            datesString3, controller.getNrTestsValidated(dates3));
                    controller.createLineChartForData(this.yearlyChart, xAxis4, yAxis4, GRAPH_DATE,
                            TOTAL_TESTS,YEARLY_CHART, "",
                            datesString4, controller.getNrTestsValidated(dates4));
                } catch (IllegalArgumentException exception){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText(exception.getMessage());
                    alert.showAndWait();
                } catch (Exception ignored) {
                }
                break;
        }
    }
}
