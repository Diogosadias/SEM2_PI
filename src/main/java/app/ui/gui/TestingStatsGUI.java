package app.ui.gui;

import app.controller.TestingStatsController;
import app.ui.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.util.ResourceBundle;

public class TestingStatsGUI implements Initializable, GuiMethods {

    @FXML
    private LineChart<Number, Number> lnChart1;
    @FXML
    private NumberAxis xAxis1;
    @FXML
    private NumberAxis yAxis1;


    @FXML
    private LineChart<Number, Number> lnChart2;
    @FXML
    private NumberAxis xAxis2;
    @FXML
    private NumberAxis yAxis2;


    @FXML
    private PieChart pieChart;

    private Main main;
    private TestingStatsController controller = new TestingStatsController();

    @Override
    public void setInstance(Main mainInstance) {
        this.main = mainInstance;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controller.createLineChart1(lnChart1, xAxis1, yAxis1);
        controller.createLineChart2(lnChart2, xAxis2, yAxis2);
        controller.createPieChart(pieChart);
    }
}
