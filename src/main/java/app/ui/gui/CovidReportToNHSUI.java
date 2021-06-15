package app.ui.gui;

import app.controller.App;
import app.controller.CovidNhsReportController;
import app.domain.shared.Constants;
import app.ui.Main;
import app.ui.console.MenuItem;
import app.utils.fx.FXUtils;
import com.nhs.report.Report2NHS;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 */
public class CovidReportToNHSUI implements Initializable, GuiMethods {

    private Main mainInstance;

    private CovidNhsReportController controller;

    ObservableList<String> options1 = FXCollections.observableArrayList("Linear", "Multiple");
    ObservableList<String> options2 = FXCollections.observableArrayList("Mean Age", "Registered Tests");
    ObservableList<String> options3 = FXCollections.observableArrayList("Mean Age and Registered Tests");
    ObservableList<String> options4 = FXCollections.observableArrayList("Daily", "Weekly");

    @FXML
    private Label lblTitle;

    @FXML
    private TextField txtHistoricalPoints;

    @FXML
    private TextField txtStartDate;

    @FXML
    private TextField txtEndDate;

    @FXML
    private ComboBox<String> comboHistoric;

    @FXML
    private ComboBox<String> comboBoxRegressiontType;

    @FXML
    private ComboBox<String> comboBoxIndependentVariable;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSubmit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controller = new CovidNhsReportController();
        comboBoxRegressiontType.setItems(options1);
        comboBoxIndependentVariable.setItems(options2);
        comboHistoric.setItems(options4);
    }

    @FXML
    void chooseRegression(ActionEvent event) {
        if(comboBoxRegressiontType.getSelectionModel().getSelectedItem().equalsIgnoreCase("Multiple"))
            comboBoxIndependentVariable.setItems(options3);
        else
            comboBoxIndependentVariable.setItems(options2);
    }

    @FXML
    void handleCancel(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Are you sure you want to cancel?");
        alert.setHeaderText("Do you want to cancel the report?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.OK) {
                //trocar para janela anterior
                try {
                    app.ui.console.MenuItem item= new MenuItem("default", "/fxml/AdminGUI.fxml");
                    item.runGui(item.getGui(),mainInstance);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    void handleSubmit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm data");
        alert.setHeaderText("Do you confirm the report data?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.OK) {
                controller.startNewReport(Integer.valueOf(txtHistoricalPoints.getText()));
                SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date dateI = formatter1.parse(txtStartDate.getText());
                    Date dateF = formatter1.parse(txtEndDate.getText());
                    if (comboBoxRegressiontType.getSelectionModel().getSelectedItem().equalsIgnoreCase("Linear")) {

                        controller.doLinearRegression(dateI, dateF, comboBoxIndependentVariable.getSelectionModel().getSelectedItem(), comboHistoric.getSelectionModel().getSelectedItem());
                    } else {
                        controller.doLinearRegression(dateI, dateF, "Both", comboHistoric.getSelectionModel().getSelectedItem());
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                controller.sendNhsReport();
                //Report2NHS.writeUsingFileWriter(controller.writeReport());

                try {
                    app.ui.console.MenuItem item= new MenuItem("default", "/fxml/AdminGUI.fxml");
                    item.runGui(item.getGui(),mainInstance);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void setInstance(Main mainInstance) {
        this.mainInstance=mainInstance;
    }
}
