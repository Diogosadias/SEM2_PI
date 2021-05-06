/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ui.console;

import app.controller.App;
import app.controller.RegisterEmployeeController;
import app.domain.model.Employee;
import app.domain.model.OrganizationRole;
import app.ui.console.utils.Utils;
import auth.AuthFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Bruno Pereira
 */
public class RegisterEmployeeUI implements Runnable{
    
    private RegisterEmployeeController m_controller;
    private AuthFacade authFacade;
    
    public RegisterEmployeeUI()
    {
        this.m_controller = new RegisterEmployeeController();
        this.authFacade = App.getInstance().getCompany().getAuthFacade();
    }


    public void run()
    {
        System.out.println("\nRegister employee");
        
        if(registerData())
        {
            presentsData();

            if (Utils.confirm("Do you confirm the data? (Y/N)")) {
                if (this.m_controller.saveEmployee()) {
                    System.out.println("Successful regist.");
                } else {
                    System.out.println("Not able to regist employee");
                }
            }
        }
        else
        {
            System.out.println("Error. Operation cancelled.");
        }
          
    }
    
    private boolean registerData() {        
        List<String> set = m_controller.getOrganizationRoles();
        OrganizationRole orgRole = new OrganizationRole();
        
        String temp = (String)Utils.showAndSelectOne(set, "Select an organization role:\n");
        if (temp != null)
            orgRole.setDesignation(temp);
        
        
        // Request data: name, address, phoneNumber,socCode, doctorIndexNumber        
        String name = Utils.readLineFromConsole("Name: ");
        String adress = Utils.readLineFromConsole("Adress: ");
        String phoneNumber = Utils.readLineFromConsole("Phone number: ");
        String socCode = Utils.readLineFromConsole("Soc Code: ");
        int doctorIndexNumber = Utils.readIntegerFromConsole("Doctor Index Number: ");
                
        if(this.m_controller.registerEmployee(orgRole.getDesignation(), name, adress, phoneNumber, socCode, doctorIndexNumber)){
                System.out.println("Employee registered successfully!");
                return this.m_controller.getEmployees().validateEmployee(this.m_controller.getEmployee());
            }else{
                System.out.println("Invalid Data was introduced! Returning to the menu.");
                return false;
            }
        
    }
    
    private void presentsData() 
    {
        System.out.println("\nEmployee:\n" + m_controller.getEmployeeToString());
    }
        
    
}
