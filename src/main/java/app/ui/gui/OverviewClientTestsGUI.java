package app.ui.gui;

import app.controller.OverviewAnalyzeTestsController;
import app.domain.dto.ClientDTO;
import app.domain.dto.TestDto;
import app.domain.model.Test;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */

public class OverviewClientTestsGUI implements Initializable {

    public Stage stage;
    public void setStage(Stage stage){
        this.stage=stage;
    }

    private final OverviewAnalyzeTestsController oc = new OverviewAnalyzeTestsController();
    private List<Test> tl;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> myListView;

    @FXML
    private Label lbl_client;

    @FXML
    private TextArea myTextArea;

    @FXML
    public void setClientDTO(ClientDTO clientdto){
        ClientDTO client;
        client=clientdto;
        lbl_client.setText(client.getName()+" - tin: "+client.getTin());
        tl = oc.listClientTest(client);
        for(Test t: tl){
            TestDto dto = new TestDto(t.getCode(),t.getDateRegistered(),t.getDateChemicalAnalysis(),t.getDateDiagnosis());
            myListView.getItems().add(dto.datesForGUIToString());
        }
    }

    @FXML
    private void menuClose(ActionEvent event) {
        stage.close();
    }

    private int option;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        myListView.getSelectionModel().selectedIndexProperty().addListener((observableValue, number, t1) -> {
            option = myListView.getSelectionModel().getSelectedIndex();
            myTextArea.setText(tl.get(option).toString());
        });
    }



}
