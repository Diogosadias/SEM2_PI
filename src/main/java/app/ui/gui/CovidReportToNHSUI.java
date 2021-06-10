package app.ui.gui;

import app.controller.CovidNhsReportController;
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

public class CovidReportToNHSUI implements Initializable {

    private CovidNhsReportController controller;
    private Scanner read;

    ObservableList<String> options1 = FXCollections.observableArrayList("Simple", "Multiple");
    ObservableList<String> options2 = FXCollections.observableArrayList("Mean Age", "Positive Tests");
    ObservableList<String> options3 = FXCollections.observableArrayList("Mean Age and Positive Tests");

    @FXML
    private Label lblTitle;

    @FXML
    private TextField txtHistoricalPoints;

    @FXML
    private TextField txtStartDate;

    @FXML
    private TextField txtEndDate;

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
        read = new Scanner(System.in);
        controller = new CovidNhsReportController();
        comboBoxRegressiontType.setItems(options1);
        comboBoxIndependentVariable.setItems(options2);
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
                /*switchSmallWindow("/fxml/LoginUI.fxml", "Login");*/
            }
        }
    }

    @FXML
    void handleSubmit(ActionEvent event) {
        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dateI = formatter1.parse(txtStartDate.getText());
            Date dateF = formatter1.parse(txtEndDate.getText());
            if (comboBoxRegressiontType.getSelectionModel().getSelectedItem().equalsIgnoreCase("Linear")) {

                controller.doSimpleLinearRegression(dateI,dateF,"Linear",comboBoxIndependentVariable.getSelectionModel().getSelectedItem());
            } else {
                controller.doMultipleLinearRegression(dateI,dateF,"Multiple");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Report2NHS.writeUsingFileWriter(controller.writeReport());
    }

}
