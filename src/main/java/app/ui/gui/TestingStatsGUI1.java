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
    public DatePicker initDateTestsWaiting;
    @FXML
    public DatePicker finalDateTestsWaiting;
    @FXML
    public DatePicker initDateNumberClients;
    @FXML
    public DatePicker finalDateNumberClients;
    @FXML
    public DatePicker initDateTestsValidated;
    @FXML
    public DatePicker finalDateTestsValidated;
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
        System.out.println(initDateNumberClients.getValue());
        controller.setInitDateGraph(java.sql.Date.valueOf(initDateNumberClients.getValue()));
    }

    @FXML
    void selectDate2(ActionEvent event) {
        controller.setInitDateGraph(java.sql.Date.valueOf(finalDateNumberClients.getValue()));
    }


    @FXML
    private void nrClientsGraphs(ActionEvent event) {
        try{
            controller.setInitDateGraph(java.sql.Date.valueOf(this.initDateNumberClients.getValue()));
            controller.setFinalDateGraph(java.sql.Date.valueOf(this.finalDateNumberClients.getValue()));
            controller.setChartOption(1);
            replaceScene();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void waitingTestsGraphs(ActionEvent event) {
        try{
            controller.setInitDateGraph(java.sql.Date.valueOf(this.initDateNumberClients.getValue()));
            controller.setFinalDateGraph(java.sql.Date.valueOf(this.finalDateNumberClients.getValue()));
            controller.setChartOption(2);
            replaceScene();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void validatedTestsGraphs(ActionEvent event) {
        try{
            initDateNumberClients.setOnAction(e -> {
                // get the date picker value
                LocalDate i = initDateNumberClients.getValue();
                // get the selected date
                System.out.println(i);
            });
            /*
            System.out.println(this.initDateNumberClients.getValue());
            System.out.println(this.finalDateNumberClients.getValue());*/
            controller.setInitDateGraph(java.sql.Date.valueOf(this.initDateNumberClients.getValue()));
            controller.setFinalDateGraph(java.sql.Date.valueOf(this.finalDateNumberClients.getValue()));
            controller.setChartOption(3);
            replaceScene();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private Initializable replaceScene() throws IOException {
        String fxml="/fxml/TestingStatsGUI2.java";

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
        Scene scene = new Scene(page, SCENE_WIDTH, SCENE_HEIGHT);
        scene.getStylesheets().add("/styles/Styles.css");
        main.stage.setScene(scene);
        main.stage.sizeToScene();

        //interface que envia o Main para todos
        GuiMethods guiMethods = loader.getController();
        guiMethods.setInstance(main);
        TestingStatsGUI2 gui = loader.getController();
        gui.setController(this.controller);

        return (Initializable) loader.getController();
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
                    app.ui.console.MenuItem item= new MenuItem("default", "/fxml/LabCoordinatorGUI.fxml");
                    item.runGui(item.getGui(),main);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
