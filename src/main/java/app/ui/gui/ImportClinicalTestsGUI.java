package app.ui.gui;


import app.domain.shared.CSVFileConverter;
import app.ui.Main;
import app.utils.fx.FXUtils;
import com.sun.glass.ui.CommonDialogs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

import javax.swing.plaf.FileChooserUI;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import static app.domain.shared.Constants.MINIMUM_WINDOW_HEIGHT;
import static app.domain.shared.Constants.MINIMUM_WINDOW_WIDTH;

/**
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */

public class ImportClinicalTestsGUI implements Initializable, GuiMethods {


    private Main mainInstance;

    @FXML
    private Button btn_import;

    @FXML
    private Button btn_findFile;

    @FXML
    private Label lbl_filePath;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private void menu_cancel(ActionEvent event) {
        FXUtils.menuGoBack(mainInstance, "/fxml/LabCoordinatorGUI.fxml");
    }
    @FXML
    private void menu_logout(ActionEvent event) {
        FXUtils.menuLogout(mainInstance);
    }
    @FXML
    private void menu_exit(ActionEvent event) {
        FXUtils.menuExit(mainInstance);
    }

    private File selectedFile;

    @FXML
    public void buttonFindFile(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        selectedFile = fc.showOpenDialog(null);

        if(selectedFile!=null){
            lbl_filePath.setText(selectedFile.getName());
            btn_import.disableProperty().set(false);
        }else{
            lbl_filePath.setText("There is no file selected");
            btn_import.disableProperty().set(true);
            FXUtils.openAlert("Error","File Error", "The file was not selected or was invalid", Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void buttonImportFile(ActionEvent event) {
        try {
            CSVFileConverter converter = new CSVFileConverter();
            converter.convertToObject(selectedFile.getName());
            FXUtils.openAlert("Success","File imported successfully","The import was a success", Alert.AlertType.INFORMATION);
        }catch (FileNotFoundException e){
            FXUtils.openAlert("Error","File Not Found", "The file was not found", Alert.AlertType.ERROR);
        }catch(IllegalArgumentException e){
            FXUtils.openAlert("Error","File Error", e.getMessage(), Alert.AlertType.WARNING);
        }finally {
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void setInstance(Main mainInstance) {
        this.mainInstance=mainInstance;
    }
}

