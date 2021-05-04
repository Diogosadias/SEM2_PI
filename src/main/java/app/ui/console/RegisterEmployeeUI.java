/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ui.console;

import app.controller.RegisterEmployeeController;
import app.domain.model.Employee;
import app.domain.model.OrganizationRole;
import app.ui.console.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Bruno Pereira
 */
public class RegisterEmployeeUI implements Runnable{
    
    private RegisterEmployeeController m_controller;
    
    public RegisterEmployeeUI()
    {
        m_controller = new RegisterEmployeeController();
    }


    public void run()
    {
        System.out.println("\nRegister client");
        Employee emp = new Employee();
        emp = registerData(emp);
        if(emp!=null)
        {
            presentsData(emp);

            if (Utils.confirm("Do you confirm the data? (Y/N)")) {
                if (m_controller.saveEmployee(emp)) {
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
    
    private Employee registerData(Employee emp) {        
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
//        String doctorIndexNumber = Utils.readLineFromConsole("Doctor Index Number: ");
        
        emp.setName(name);
        emp.setAddress(adress);
        emp.setPhoneNumber(phoneNumber);
        emp.setSocCode(socCode);
        //emp.setEmployeeId(doctorIndexNumber);
        
//        orgRole.setDoctorIndexNumber(Integer.getInteger(doctorIndexNumber));
        
        emp.setRole(orgRole);
        
        if(m_controller.registerEmployee(emp))
            return emp;
        else 
            return null;
    }
    
    private void presentsData(Employee emp) 
    {
        System.out.println("\nEmployee:\n" + m_controller.getEmployeeToString(emp));
    }
        
    
}
