package app.utils.fx;

import javafx.scene.control.Alert;

/**
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 */
public class FXUtils {

    public FXUtils() {
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

}