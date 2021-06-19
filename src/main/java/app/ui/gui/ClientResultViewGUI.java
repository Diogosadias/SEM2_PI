package app.ui.gui;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import app.controller.App;
import app.controller.ClientResultViewController;
import app.domain.dto.TestDto;
import app.domain.model.*;
import app.domain.shared.SortAlgorithm;
import app.ui.Main;
import app.utils.fx.FXUtils;
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

    private int option;

    @FXML
    private ListView<String> myListView;

    @FXML
    private TextArea myTextArea;

    @FXML
    private void menuGoBack(ActionEvent event) {
        FXUtils.menuGoBack(mainInstance,"/fxml/ClientGUI.fxml");
    }
    @FXML
    private void menuLogout(ActionEvent event) {
        FXUtils.menuLogout(mainInstance);
    }
    @FXML
    private void menuExit(ActionEvent event) {
        FXUtils.menuExit(mainInstance);
    }

    private List<TestDto> tlDTO;

    private final ClientResultViewController crvController = new ClientResultViewController();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TestStore ts = App.getInstance().getCompany().getTestStore();
        List<Test> tl;
        Client client = crvController.getClient();
        try {
            tl = crvController.listClientTest(client);
        tlDTO= crvController.toDTO(tl);

        Collections.sort(tlDTO, new SortAlgorithm.TestCompareByValidationTest());

            for(TestDto t: tlDTO){
                myListView.getItems().add(t.datesForGUIToString());
            }
        }catch(NullPointerException ex){
            FXUtils.openAlert("Warning", "No validated tests","This client doesn't have validated tests!", Alert.AlertType.WARNING);
        }

        myListView.getSelectionModel().selectedIndexProperty().addListener((observableValue, number, t1) -> {

            option = myListView.getSelectionModel().getSelectedIndex();
            Test t = ts.getTestByCode(tlDTO.get(option).getCode());
            myTextArea.setText(t.toString());//replaces the text
        });

    }

    @Override
    public void setInstance(Main mainInstance) {
        this.mainInstance=mainInstance;
    }
}
