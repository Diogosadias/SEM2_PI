package app.utils.fx;

import app.ui.Main;
import app.ui.console.MenuItem;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;

/**
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 */
public class FXUtils {

    public FXUtils() {
        //no need for code here
    }

    /**
     * Method that opens an alert window
     *
     * @param title: title of the alert window
     * @param headerText: header text of the alert window
     * @param contentText: content of the alert window
     * @param alertType: alertType of the alert window
     */
    public static void openAlert(String title, String headerText, String contentText, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    public static void menuExit(Main mainInstance){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Confirmation");
        alert.setHeaderText("Are you sure you want to exit the program?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.OK) {

                mainInstance.getStage().close();
            }
        }
    }
    public static void menuLogout(Main mainInstance){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setHeaderText("Are you sure you want to logout?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.OK) {

                try {
                    MenuItem item= new MenuItem("default", "/fxml/LoginGUI.fxml");
                    item.runGui(item.getGui(),mainInstance);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void menuGoBack(Main mainInstance, String fxml){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Back Confirmation");
        alert.setHeaderText("Are you sure you want to go back?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.OK) {

                try {
                    MenuItem item= new MenuItem("default", fxml);
                    item.runGui(item.getGui(),mainInstance);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

}