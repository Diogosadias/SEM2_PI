package app.ui.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import app.ui.Main;
import app.ui.console.*;
import app.ui.gui.GuiMethods;
import app.utils.fx.FXUtils;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;

/**
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class ClientResultViewGUI implements Initializable, GuiMethods {
    private Main mainInstance;

    int option;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> myListView;



    @FXML
    private void menu_goBack(ActionEvent event) {
        FXUtils.menuGoBack(mainInstance,"/fxml/ClientGUI.fxml");
    }
    @FXML
    private void menu_logout(ActionEvent event) {
        FXUtils.menuLogout(mainInstance);
    }
    @FXML
    private void menu_exit(ActionEvent event) {
        FXUtils.menuExit(mainInstance);
    }






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("View Results Tests", "/fxml/ClientGUI.fxml"));

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

    @Override
    public void setInstance(Main mainInstance) {
        this.mainInstance=mainInstance;
    }
}
