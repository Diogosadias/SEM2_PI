package app.ui.gui;

import app.ui.Main;
import app.ui.console.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class SpecialistDoctorGUI implements Initializable, GuiMethods {
    private Main mainInstance;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> myListView;

    @FXML
    private Button loginButton;


    int option;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Diagnosis - Write Report", new WriteReportUI()));
        options.add(new MenuItem("List Diagnosed Tests", new ListDiagnosedTestUI()));

        for(int i=0; i<options.size();i++){
            myListView.getItems().add(options.get(i).toString());
        }

        myListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                option = myListView.getSelectionModel().getSelectedIndex();

                if(options.get(option).getGui()==null) {
                    options.get(option).run();
                }else{
                    try {
                        options.get(option).runGui(options.get(option).getGui(),mainInstance);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });


    }

    @FXML
    private void menu_logout(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setHeaderText("Are you sure you want to logout?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.OK) {

                try {
                    MenuItem item= new MenuItem("default", "/fxml/LoginGUI.fxml");
                    item.runGui(item.getGui(),mainInstance);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
    @FXML
    private void menu_exit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Confirmation");
        alert.setHeaderText("Are you sure you want to exit the program?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.OK) {

                mainInstance.getStage().close();
            }
        }
    }

    @Override
    public void setInstance(Main mainInstance) {
        this.mainInstance=mainInstance;
    }

}
