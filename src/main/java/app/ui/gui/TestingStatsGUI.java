package app.ui.gui;

import app.controller.TestingStatsController;
import app.ui.Main;
import app.ui.console.MenuItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.net.URL;
import java.util.Optional;
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
