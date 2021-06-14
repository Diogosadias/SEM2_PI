package app.ui;

import app.controller.App;
import app.controller.FileController;
import app.domain.shared.Constants;
import app.ui.gui.MainMenuGUI;
import app.ui.gui.GuiMethods;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import static app.domain.shared.Constants.*;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 *
 */
public class Main extends Application {

    public Stage stage;

    public Stage getStage() {
        return stage;
    }
    public Main getinstance(){ return this;}



    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        /*
        MainMenuUI menu = new MainMenuUI();
        FileController fileController = new FileController();
        try
        {
            fileController.runFileInputStreams();
            menu.run();
            fileController.runFileOutputStreams();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
        */
        launch(args);
        FileController fileController = new FileController();
        fileController.runFileOutputStreams();
    }

    @Override
    public void start(Stage stage) throws Exception {
        //LANÇA UI LOGIN
        this.stage = stage;
        stage.setTitle("Many Labs");
        stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
        stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
        toLoginScene();
        this.stage.show();
    }

    //Opens Login UI
    public void toLoginScene() {
        try {
            /*MainUI mainUI = (MainUI) replaceSceneContent("/fxml/Main.fxml");
            mainUI.setMainApp(this);*/
            FileController fileController = new FileController();
            fileController.runFileInputStreams();
            //LoginGUI loginGUI = (LoginGUI) replaceSceneContent("/fxml/LoginGUI.fxml");

            //loginGUI.setMainInstance(this);
            MainMenuGUI mainMenuGUI = (MainMenuGUI) replaceSceneContent("/fxml/MainMenuGUI.fxml");
            mainMenuGUI.setMainInstance(this);




        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Initializable replaceSceneContent(String fxml) throws Exception {
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
        this.stage.setScene(scene);
        this.stage.sizeToScene();

        //interface que envia o Main para todos
        GuiMethods guiMethods = loader.getController();
        guiMethods.setInstance(this);

        return (Initializable) loader.getController();
    }

}

