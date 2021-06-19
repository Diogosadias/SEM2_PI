package app.ui.gui;

import app.ui.Main;
import app.ui.console.*;
import app.utils.fx.FXUtils;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 *
 * @author Gil <1180838@isep.ipp.pt>
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class MedLabTechnicianGUI implements Initializable, GuiMethods {
    private Main mainInstance;

    @FXML
    private ListView<String> myListView;

    int option;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<MenuItem> options = new ArrayList<>();

        options.add(new MenuItem("Create Sample", new RecordSampleUI()));
        options.add(new MenuItem("List Test Sample(s)", new ListSampleCollectedUI()));


        for(int i=0; i<options.size();i++){
            myListView.getItems().add(options.get(i).toString());
        }

        myListView.getSelectionModel().selectedIndexProperty().addListener((observableValue, number, t1) -> {
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
        });


    }

    @FXML
    private void menuLogout(ActionEvent event) {
        FXUtils.menuLogout(mainInstance);
    }
    @FXML
    private void menuExit(ActionEvent event) {
        FXUtils.menuExit(mainInstance);
    }

    @Override
    public void setInstance(Main mainInstance) {
        this.mainInstance=mainInstance;
    }


}