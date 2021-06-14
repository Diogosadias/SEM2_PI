package app.ui.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import app.ui.Main;
import app.ui.console.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class AdminGUI implements Initializable, GuiMethods {
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
        options.add(new MenuItem("Create type of test", new SpecifyNewTestTypeUI()));
        options.add(new MenuItem("List types of test", new ListTypeTestUI()));
        options.add(new MenuItem("Search types of test", new SearchTestTypeUI()));
        options.add(new MenuItem("Delete type of test", new DeleteTypeTestUI()));
        options.add(new MenuItem("New Parameter", new SpecifyNewParameterUI()));
        options.add(new MenuItem("List Parameters", new ListParametersUI()));
        options.add(new MenuItem("Delete Parameter", new DeleteParameterUI()));
        options.add(new MenuItem("New Parameter Category", new CreateNewParameterCategoryUI()));
        options.add(new MenuItem("List Parameter Categories", new ListParameterCategoryUI()));
        options.add(new MenuItem("Register employee", new RegisterEmployeeUI()));
        options.add(new MenuItem("List Registered Employees", new ListEmployeesUI()));
        options.add(new MenuItem("Register new Clinical Analysis Laboratory", new RegisterNewCALUI()));
        options.add(new MenuItem("Send Covid report to Nhs", "/fxml/CovidReportToNHS.fxml"));


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
        try {
            MenuItem item= new MenuItem("default", "/fxml/LoginGUI.fxml");
            item.runGui(item.getGui(),mainInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void menu_exit(ActionEvent event) {
        mainInstance.getStage().close();
    }

    @Override
    public void setInstance(Main mainInstance) {
        this.mainInstance=mainInstance;
    }


}
