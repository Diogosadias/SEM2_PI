package app.ui.gui;


import app.domain.shared.CSVFileConverter;
import app.ui.Main;
import app.utils.fx.FXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */

public class ImportClinicalTestsGUI implements Initializable, GuiMethods {


    private Main mainInstance;

    @FXML
    private Button btnImport;

    @FXML
    private Label lblFilePath;

    @FXML
    private void menuCancel(ActionEvent event) {
        FXUtils.menuGoBack(mainInstance, "/fxml/LabCoordinatorGUI.fxml");
    }
    @FXML
    private void menuLogout(ActionEvent event) {
        FXUtils.menuLogout(mainInstance);
    }
    @FXML
    private void menuExit(ActionEvent event) {
        FXUtils.menuExit(mainInstance);
    }

    private File selectedFile;

    @FXML
    public void buttonFindFile(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        selectedFile = fc.showOpenDialog(null);

        if(selectedFile!=null){
            lblFilePath.setText(selectedFile.getName());
            btnImport.disableProperty().set(false);
        }else{
            lblFilePath.setText("There is no file selected");
            btnImport.disableProperty().set(true);
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
            FXUtils.openAlert("File Not Found","File Not Found", "The file was not found", Alert.AlertType.ERROR);
        }catch(Exception e){
            FXUtils.openAlert("Error","File Error", e.getMessage(), Alert.AlertType.INFORMATION);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //no need for code here
    }

    @Override
    public void setInstance(Main mainInstance) {
        this.mainInstance=mainInstance;
    }
}

