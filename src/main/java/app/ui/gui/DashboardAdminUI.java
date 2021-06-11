package app.ui.gui;

import app.controller.App;
import app.ui.Main;
import app.utils.fx.FXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 */
public class DashboardAdminUI implements Initializable{

    private Main mainInstance;

    @FXML
    private Button btnSendReport;

    public void setMainInstance(Main mainInstance) {
        this.mainInstance = mainInstance;
    }

    public DashboardAdminUI() {
    }

    public DashboardAdminUI(Main mainApp) {
        this.mainInstance = mainApp;
    }

    public Main getInstance(){
        return mainInstance;
    }

    @FXML
    void handleSendReport(ActionEvent event) throws Exception {
        try{
            CovidReportToNHSUI covidReportToNHSUI = (CovidReportToNHSUI) this.mainInstance.replaceSceneContent("/fxml/CovidReportToNHS.fxml");
            covidReportToNHSUI.setDashboardAdminUI(this);
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
