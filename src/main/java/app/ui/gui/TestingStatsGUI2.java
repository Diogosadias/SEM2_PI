package app.ui.gui;

import app.controller.TestingStatsController;
import app.domain.shared.Constants;
import app.ui.Main;
import app.ui.console.MenuItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class TestingStatsGUI2 implements Initializable, GuiMethods{
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

    private String[] dates1, dates2, dates3, dates4;

    @Override
    public void setInstance(Main mainInstance) {
        this.main = mainInstance;
    }
    public void setController(TestingStatsController controller) {
        this.controller = controller;
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] dates1 = controller.getDatesInArray(1);
        String[] dates2 = controller.getDatesInArray(7);
        String[] dates3 = controller.getDatesInArray(31);
        String[] dates4 = controller.getDatesInArray(365);
        switch (controller.getChartOption()){
            case 1:
                //NR Clients
                /*controller.createLineChartForData(this.dailyChart, xAxis1, yAxis1, "Date",
                        "Client Total","Daily Chart", "Clients Number",
                        controller.getDatesInArray(1), "");
                controller.createLineChartForData(this.weeklyChart, xAxis2, yAxis2, "Date",
                        "Client Total","Weekly Chart", "Clients Number",
                        controller.getDatesInArray(7), "");
                controller.createLineChartForData(this.monthlyChart, xAxis3, yAxis3, "Date",
                        "Client Total","Monthly Chart", "Clients Number",
                        controller.getDatesInArray(31), "");
                controller.createLineChartForData(this.yearlyChart, xAxis4, yAxis4, "Date",
                        "Client Total","Yearly Chart", "Clients Number",
                        controller.getDatesInArray(365), "");*/
                break;
            case 2:
                //Waiting Tests
                controller.createLineChartForData(this.dailyChart, xAxis1, yAxis1, "Date",
                        "Total tests","Daily Chart", "Waiting Tests",
                        dates1, controller.getNrTests(dates1, Constants.SAMPLE_ANALYSED));
                controller.createLineChartForData(this.weeklyChart, xAxis2, yAxis2, "Date",
                        "Total tests","Weekly Chart", "Waiting Tests",
                        dates2, controller.getNrTests(dates2, Constants.SAMPLE_ANALYSED));
                controller.createLineChartForData(this.monthlyChart, xAxis3, yAxis3, "Date",
                        "Total tests","Monthly Chart", "Waiting Tests",
                        dates3, controller.getNrTests(dates3, Constants.SAMPLE_ANALYSED));
                controller.createLineChartForData(this.yearlyChart, xAxis4, yAxis4, "Date",
                        "Total tests","Yearly Chart", "Waiting Tests",
                        dates4, controller.getNrTests(dates4, Constants.SAMPLE_ANALYSED));
                break;
            case 3:
                //Validated Tests
                controller.createLineChartForData(this.dailyChart, xAxis1, yAxis1, "Date",
                        "Total tests","Daily Chart", "Validated Tests",
                        dates1, controller.getNrTests(dates1, Constants.VALIDATED));
                controller.createLineChartForData(this.weeklyChart, xAxis2, yAxis2, "Date",
                        "Total tests","Weekly Chart", "Validated Tests",
                        dates2, controller.getNrTests(dates2, Constants.VALIDATED));
                controller.createLineChartForData(this.monthlyChart, xAxis3, yAxis3, "Date",
                        "Total tests","Monthly Chart", "Validated Tests",
                        dates3, controller.getNrTests(dates3, Constants.VALIDATED));
                controller.createLineChartForData(this.yearlyChart, xAxis4, yAxis4, "Date",
                        "Total tests","Yearly Chart", "Validated Tests",
                        dates4, controller.getNrTests(dates4, Constants.VALIDATED));
                break;
        }
    }

    @FXML
    private void menu_cancel(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Are you sure you want to cancel?");
        alert.setHeaderText("Do you want to go back?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.OK) {
                //trocar para janela anterior
                try {
                    MenuItem item= new MenuItem("default", "/fxml/LabCoordinatorGUI.fxml");
                    item.runGui(item.getGui(),main);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
