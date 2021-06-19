package app.ui.gui;

import app.controller.TestingStatsController;
import app.ui.Main;
import app.ui.console.MenuItem;
import app.utils.fx.FXUtils;
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


    public void menu_goBack(ActionEvent actionEvent) {
        FXUtils.menuGoBack(main,"/fxml/LabCoordinatorGUI.fxml");
    }

    public void menu_logout(ActionEvent actionEvent) {
        FXUtils.menuLogout(main);
    }

    public void menu_exit(ActionEvent actionEvent) {
        FXUtils.menuExit(main);
    }
}
