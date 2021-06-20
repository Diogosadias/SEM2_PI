package app.ui.gui;

import app.controller.TestingStatsController;
import app.ui.Main;
import app.utils.fx.FXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
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


    private Main main;
    private final TestingStatsController controller = new TestingStatsController();



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
            openStatsGUI2(1);

        } catch (Exception e) {
            FXUtils.openAlert("WARNING", "Warning",e.getMessage(), Alert.AlertType.WARNING);
        }
    }

    @FXML
    private void testsWaitingForDiagnosis(ActionEvent event) {
        try{
            openStatsGUI2(2);
        } catch (Exception e) {
            FXUtils.openAlert("WARNING", "Warning",e.getMessage(), Alert.AlertType.WARNING);
        }
    }


    @FXML
    private void validatedTestsGraphs(ActionEvent event) {
        try{
            openStatsGUI2(3);
        } catch (Exception e) {
            FXUtils.openAlert("WARNING", "Warning",e.getMessage(), Alert.AlertType.WARNING);
        }
    }

    public void openStatsGUI2(int num) throws Exception{
        TestingStatsGUI2 testingStatsGUI2 = (TestingStatsGUI2) main.replaceSceneContent("/fxml/TestingStatsGUI2.fxml");
        testingStatsGUI2.setInstance(main);
        controller.setChartOption(num);
        testingStatsGUI2.setController(controller);
    }
    public void errMessage(Exception e){
        FXUtils.openAlert("Error", "There was an error", e.getMessage(), Alert.AlertType.ERROR);
    }


    public void menuGoBack() {
        FXUtils.menuGoBack(main,"/fxml/LabCoordinatorGUI.fxml");
    }

    public void menuLogout() {
        FXUtils.menuLogout(main);
    }

    public void menuExit() {
        FXUtils.menuExit(main);
    }
}
