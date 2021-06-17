package app.ui.gui;

import app.controller.App;
import app.controller.TestingStatsController;
import app.ui.Main;
import app.ui.console.MenuItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import static app.domain.shared.Constants.SCENE_HEIGHT;
import static app.domain.shared.Constants.SCENE_WIDTH;

public class TestingStatsGUI1 implements Initializable, GuiMethods {
    @FXML
    public DatePicker initDate;
    @FXML
    public DatePicker finalDate;

    @FXML
    public Label lblTotalClient;
    @FXML
    public Label lblTotalValidatedTests;
    @FXML
    public Button btnTestsWaiting;
    @FXML
    public Button btnNumberOfClients;
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
        this.lblTotalClient.setText("");//controller.getTotalClientsNumber()
        this.lblTotalValidatedTests.setText("");//controller.getTotalValidatedTests()
    }
    @FXML
    void selectDate1(ActionEvent event) {
        controller.setInitDateGraph(java.sql.Date.valueOf(initDate.getValue()));
    }

    @FXML
    void selectDate2(ActionEvent event) {
        controller.setInitDateGraph(java.sql.Date.valueOf(finalDate.getValue()));
    }


    @FXML
    private void nrClientsGraphs(ActionEvent event) {
        try{
            controller.setInitDateGraph(java.sql.Date.valueOf(this.initDate.getValue()));
            controller.setFinalDateGraph(java.sql.Date.valueOf(this.finalDate.getValue()));
            controller.setChartOption(1);
            TestingStatsGUI2 testingStatsGUI2 = (TestingStatsGUI2) main.replaceSceneContent("/fxml/TestingStatsGUI2.fxml");
            testingStatsGUI2.setInstance(main);
            testingStatsGUI2.setController(controller);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void waitingTestsGraphs(ActionEvent event) {
        try{
            controller.setInitDateGraph(java.sql.Date.valueOf(this.initDate.getValue()));
            controller.setFinalDateGraph(java.sql.Date.valueOf(this.finalDate.getValue()));
            controller.setChartOption(2);
            TestingStatsGUI2 testingStatsGUI2 = (TestingStatsGUI2) main.replaceSceneContent("/fxml/TestingStatsGUI2.fxml");
            testingStatsGUI2.setInstance(main);
            testingStatsGUI2.setController(controller);
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println(e.getMessage());
        }
    }

    @FXML
    private void validatedTestsGraphs(ActionEvent event) {
        try{
            /*
            System.out.println(this.initDateNumberClients.getValue());
            System.out.println(this.finalDateNumberClients.getValue());*/
            controller.setInitDateGraph(java.sql.Date.valueOf(this.initDate.getValue()));
            controller.setFinalDateGraph(java.sql.Date.valueOf(this.finalDate.getValue()));
            controller.setChartOption(3);
            //TestingStatsGUI2 testingStatsGUI2 = (TestingStatsGUI2) main.replaceStatsSceneContent("/fxml/TestingStatsGUI2.fxml", this.controller);
            TestingStatsGUI2 testingStatsGUI2 = (TestingStatsGUI2) main.replaceSceneContent("/fxml/TestingStatsGUI2.fxml");
            testingStatsGUI2.setInstance(main);
            testingStatsGUI2.setController(controller);
            //replaceScene();
        } catch (Exception e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
            //System.out.println(e.getMessage());
        }
    }

    /*private Initializable replaceScene() throws Exception {
        String fxml="/fxml/TestingStatsGUI2.fxml";

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
        TestingStatsGUI2 testingStatsGUI2 = loader.getController();
        testingStatsGUI2.setInstance(main);
        testingStatsGUI2.setController(controller);

        Scene scene = new Scene(page, SCENE_WIDTH, SCENE_HEIGHT);
        scene.getStylesheets().add("/styles/Styles.css");
        main.stage.setScene(scene);
        main.stage.sizeToScene();

        //interface que envia o Main para todos
        GuiMethods guiMethods = loader.getController();
        guiMethods.setInstance(main);



        return (Initializable) loader.getController();
    }*/

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
                    app.ui.console.MenuItem item= new MenuItem("default", "/fxml/LabCoordinatorGUI.fxml");
                    item.runGui(item.getGui(),main);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
