package app.ui.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import app.controller.App;
import app.ui.Main;
import app.ui.console.*;
import app.utils.fx.FXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class MainMenuGUI implements Initializable, GuiMethods {
    public Stage stage;
    public void setStage(Stage stage){
        this.stage=stage;
    }

    public Main mainInstance;
    public void setMainInstance(Main mainInstance) {
        this.mainInstance = mainInstance;
    }

    public Main getMainInstance(){
        return mainInstance;
    }


    @FXML
    private ListView<String> myListView;


    private int option;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        App.getInstance().getCompany().generateDailyTasks();
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Do Login","/fxml/LoginGUI.fxml"));
        options.add(new MenuItem("Know the Development Team",new DevTeamUI()));



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
    private void menuExit(ActionEvent event) {
        FXUtils.menuExit(mainInstance);
    }

    @Override
    public void setInstance(Main mainInstance) {
        this.mainInstance=mainInstance;
    }
}
