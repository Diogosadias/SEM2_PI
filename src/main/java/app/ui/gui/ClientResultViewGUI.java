package app.ui.gui;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import app.controller.ClientResultViewController;
import app.domain.dto.ClientDTO;
import app.domain.dto.TestDto;
import app.domain.model.*;
import app.domain.shared.SortAlgorithm;
import app.ui.Main;
import app.utils.fx.FXUtils;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

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
    private TextArea myTextArea;

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
    private List<Test> tl;
    private List<TestDto> tlDTO;

    private ClientDTO clientdto ;

    private Client client;

    private ClientStore cs;

    private Company company;

    private TestStore ts;

    ClientResultViewController crvController = new ClientResultViewController();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        client = crvController.getClient();

        tl = crvController.listClientTest(client);
        tlDTO= crvController.toDTO(tl);
        //Collections.sort(tlDTO, new SortAlgorithm.TestCompareByValidationTest());
        try {
            for(TestDto t: tlDTO){
                //TestDto dto = new TestDto(t.getCode(),t.getDateRegistered(),t.getDateChemicalAnalysis(),t.getDateDiagnosis());
                myListView.getItems().add(t.datesForGUI_toString());
            }
        }catch(NullPointerException ex){
            FXUtils.openAlert("Warning", "No validated tests","This client doesn't have validated tests!", Alert.AlertType.WARNING);
        }

        myListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

                option = myListView.getSelectionModel().getSelectedIndex();
                myTextArea.setText(tl.get(option).toString());//replaces the text
            }
        });

    }


   /* public List<Test> listClientTest(Client cl){
        Client c = cs.getClientByTIN(cl.getTin());
        List<Test> tl = new ArrayList<>();
        for(Test t : ts.getValidatedTests()){

            if(t.getClient().getName().equalsIgnoreCase(c.getName())){
                tl.add(t);
            }
        }

        return tl;
    }*/

    @Override
    public void setInstance(Main mainInstance) {
        this.mainInstance=mainInstance;
    }
}
