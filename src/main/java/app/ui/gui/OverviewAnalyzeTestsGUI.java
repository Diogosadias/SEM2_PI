package app.ui.gui;

import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import app.controller.App;
import app.controller.CreateClientController;
import app.controller.OverviewAnalyzeTestsController;
import app.domain.dto.ClientDTO;
import app.domain.shared.SortAlgorithm;
import app.ui.Main;
import app.utils.fx.FXUtils;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import static app.domain.shared.Constants.*;

/**
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */

public class OverviewAnalyzeTestsGUI implements Initializable, GuiMethods {

    private Main mainInstance;
    private OverviewAnalyzeTestsController oc = new OverviewAnalyzeTestsController();
    private CreateClientController controllerClient = new CreateClientController();
    int option;

    @FXML
    private RadioButton rbt_tin;

    @FXML
    private RadioButton rbt_name;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> myListView;

    @FXML
    private void menuGoBack(ActionEvent event) {
        FXUtils.menuGoBack(mainInstance,"/fxml/ClinicalChemicalTechnologistGUI.fxml");
    }

    @FXML
    private void menuLogout(ActionEvent event) {
        FXUtils.menuLogout(mainInstance);
    }

    @FXML
    private void menuExit(ActionEvent event) {
        FXUtils.menuExit(mainInstance);
    }

    private List<ClientDTO> clientsDTOs = oc.getClient();

    @FXML
    public void radio_ListBy(ActionEvent event){

        if(rbt_name.isSelected()){
            Collections.sort(clientsDTOs, new SortAlgorithm.ClientCompareByName());
            rbt_tin.setSelected(false);

        }
        if(rbt_tin.isSelected()){
            Collections.sort(clientsDTOs, new SortAlgorithm.ClientCompareByTIN());
            rbt_name.setSelected(false);
        }

       // myListView.getItems().removeAll(myListView.getItems());
        for(int i=0; i<clientsDTOs.size();i++){
            myListView.getItems().set(i,clientsDTOs.get(i).toStringNameAndTIN());
        }
    }


    ClientDTO client;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(int i=0; i<clientsDTOs.size();i++){
            myListView.getItems().add(clientsDTOs.get(i).toStringNameAndTIN());
        }

        myListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                option = myListView.getSelectionModel().getSelectedIndex();
                client = clientsDTOs.get(option);
                try {
                    openClientInfo();
                } catch (Exception e) {
                    FXUtils.openAlert("No Tests", "Validated tests list empty","This client doesn't have validated tests", Alert.AlertType.INFORMATION);
                }

            }
        });



    }


    @Override
    public void setInstance(Main mainInstance) {
        this.mainInstance=mainInstance;
    }

    public Stage stage;

    public Initializable openClientInfo() throws Exception {
        this.stage = new Stage();
        stage.setTitle("Many Labs");
        stage.setMinWidth(MINIMUM_WINDOW_WIDTH-40);
        stage.setMinHeight(MINIMUM_WINDOW_HEIGHT-90);

        String fxml = "/fxml/OverviewClientTestsGUI.fxml";
        FXMLLoader loader = new FXMLLoader();

        InputStream in = Main.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(App.class.getResource(fxml));

        Pane page;
        try {

            page = (Pane) loader.load(in);
        } finally {
            in.close();
        }


        Scene scene = new Scene(page, SCENE_WIDTH-40, SCENE_HEIGHT-90);
        scene.getStylesheets().add("/styles/Styles.css");
        OverviewClientTestsGUI ct = loader.getController();
        ct.setClientDTO(client);
        ct.setStage(stage);
        this.stage.setScene(scene);
        this.stage.sizeToScene();

        this.stage.show();


        return (Initializable) loader.getController();
    }

}

