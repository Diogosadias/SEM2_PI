package app.ui.gui;

import app.controller.TestingStatsController;
import app.ui.Main;
import app.ui.console.MenuItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * @author Gil <1180838@isep.ipp.pt>
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class TestingStatsGUI1 implements Initializable, GuiMethods {

    @FXML
    public Label lblTotalClient;
    @FXML
    public Label lblTotalValidatedTests;
    @FXML
    public Button btnTestsWaitingForResult;
    @FXML
    public Button btnTestsWaitingForDiagnosis;
    @FXML
    public Button btnTestsValidated;

    private Main main;
    private TestingStatsController controller = new TestingStatsController();



    @Override
    public void setInstance(Main mainInstance) {
        this.main=mainInstance;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.lblTotalClient.setText(String.valueOf(controller.getTotalClients()));
        this.lblTotalValidatedTests.setText(String.valueOf(controller.getTotalValidatedTests()));//
    }


    @FXML
    private void testsWaitingForResult(ActionEvent event) {
        try{
            TestingStatsGUI2 testingStatsGUI2 = (TestingStatsGUI2) main.replaceSceneContent("/fxml/TestingStatsGUI2.fxml");
            testingStatsGUI2.setInstance(main);
            controller.setChartOption(1);
            testingStatsGUI2.setController(controller);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void testsWaitingForDiagnosis(ActionEvent event) {
        try{

            TestingStatsGUI2 testingStatsGUI2 = (TestingStatsGUI2) main.replaceSceneContent("/fxml/TestingStatsGUI2.fxml");
            testingStatsGUI2.setInstance(main);
            controller.setChartOption(2);
            testingStatsGUI2.setController(controller);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void validatedTestsGraphs(ActionEvent event) {
        try{
            TestingStatsGUI2 testingStatsGUI2 = (TestingStatsGUI2) main.replaceSceneContent("/fxml/TestingStatsGUI2.fxml");
            testingStatsGUI2.setInstance(main);
            controller.setChartOption(3);
            testingStatsGUI2.setController(controller);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void menu_cancel(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Are you sure you want to cancel?");
        alert.setHeaderText("Do you want to go back?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.OK) {
                //trocar para janela anterior
                try {
                    app.ui.console.MenuItem item= new MenuItem("default", "/fxml/LabCoordinator.fxml");
                    item.runGui(item.getGui(),main);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
