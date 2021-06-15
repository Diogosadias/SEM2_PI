package app.ui.gui;

import app.controller.AuthController;
import app.domain.shared.Constants;
import app.ui.Main;
import app.ui.console.*;
import app.ui.console.MenuItem;
import auth.mappers.dto.UserRoleDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.*;

/**
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Gil <1180838@isep.ipp.pt>
 */
public class LoginGUI implements Initializable, GuiMethods {

    @FXML
    private TextField emailTxtField;

    @FXML
    private Button loginButton;

    @FXML
    private Label emailLabel;

    @FXML
    private Label pwdLabel;

    @FXML
    private PasswordField pwdTxtField;

    public AuthController controller;

    private Main mainInstance;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.controller = new AuthController();
    }

    public TextField getEmailTxtField(){
        return this.emailTxtField;
    }

    public PasswordField getPwdTxtField(){
        return this.pwdTxtField;
    }



    /**
     * Method that authenticates a User into the App
     *
     * @param event Action Event
     *//*
    @FXML
    private void onLogin(ActionEvent event)  {
        String strEmail = getEmailTxtField().getText();
        String strPwd = getPwdTxtField().getText();
        if (this.oController.onLogin(strEmail, strPwd)) {
            if (this.oController.getApp().getRole() == null || this.oController.getApp().getRole().isEmpty()) {
                FxUtils.switchRole();
            } else {
                FxUtils.switchDashboard(event, this.oController.getApp().getRole(), strEmail);
            }
        }
    }*/
    @FXML
    public void menu_goBack(ActionEvent event) {

        try {
            MenuItem item= new MenuItem("default", "/fxml/MainMenuGUI.fxml");
            item.runGui(item.getGui(),mainInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void menu_exit(ActionEvent event) {
        mainInstance.getStage().close();
    }


    @FXML
    private void btn_Login(ActionEvent event) throws Exception {

        boolean success = this.controller.doLogin(getEmailTxtField().getText(), getPwdTxtField().getText());

        if (success)
        {

            List<UserRoleDTO> roles = this.controller.getUserRoles();
            if ( (roles == null) || (roles.isEmpty()) )
            {
                openAlert("Error", "Can´t login!", "No roles are assigned.", Alert.AlertType.WARNING);
            }
            else
            {

                UserRoleDTO role = selectsRole(roles);
                if (!Objects.isNull(role))
                {
                    List<MenuItem> rolesUI = getMenuItemForRoles();

                    /*try {
                        //DashboardAdminUI dashboardAdminUI = (DashboardAdminUI) this.mainInstance.replaceSceneContent("/fxml/DashboardAdmin.fxml");
                        //dashboardAdminUI.setMainInstance(this.mainInstance);

                        //AdminGUI adminGui= (AdminGUI) this.mainInstance.replaceSceneContent("/fxml/AdminGUI.fxml");

                    } catch (Exception ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
                    //mainInstance.stage.close();
                    this.redirectToRoleUI(rolesUI,role);

                }
            }
        }else{
            openAlert("Login Error", "Login was not successful", "Check your email/password", Alert.AlertType.ERROR);
        }
        this.logout();

    }

    private UserRoleDTO selectsRole(List<UserRoleDTO> roles){ return roles.get(0); }

    private List<MenuItem> getMenuItemForRoles()
    {
        List<MenuItem> rolesUI = new ArrayList<>();
        rolesUI.add(new MenuItem(Constants.ROLE_ADMIN, "/fxml/AdminGUI.fxml"));
        rolesUI.add(new MenuItem(Constants.ROLE_RECEP, "/fxml/ReceptionistGUI.fxml"));
        rolesUI.add(new MenuItem(Constants.SPECIALIST_DOCTOR, "/fxml/SpecialistDoctorGUI.fxml"));
        rolesUI.add(new MenuItem(Constants.CHEMISTRY_TECHNOLOGIST, "/fxml/ClinicalChemicalTechnologistGUI.fxml"));
        rolesUI.add(new MenuItem(Constants.MEDICAL_LAB_TECHNICIAN, "/fxml/MedLabTechnicianGUI.fxml"));
        rolesUI.add(new MenuItem(Constants.LABORATORY_COORDINATOR, "/fxml/LabCoordinatorGUI.fxml"));
        rolesUI.add(new MenuItem(Constants.ROLE_CLIENT, "/fxml/ClientGUI.fxml"));

        // To complete with other user roles and related RoleUI

        //
        return rolesUI;
    }

    private void redirectToRoleUI(List<MenuItem> rolesUI, UserRoleDTO role)
    {
        boolean found = false;
        Iterator<MenuItem> it = rolesUI.iterator();
        while (it.hasNext() && !found)
        {
            MenuItem item = it.next();
            found = item.hasDescription(role.getDescription());
            if (found)
                if(item.getGui()==null) {
                    item.run();
                }else{
                    try {
                        //item.Instance(mainInstance);

                        item.runGui(item.getGui(),mainInstance);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                //item.run();
        }
        if (!found)
            System.out.println("There is no UI for users with role '" + role.getDescription() + "'");
        /*this.mainInstance*/

    }

    private void logout()
    {
        controller.doLogout();
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

    @Override
    public void setInstance(Main mainInstance) {
        this.mainInstance=mainInstance;
    }
}



