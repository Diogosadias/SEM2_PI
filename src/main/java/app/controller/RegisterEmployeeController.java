/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.domain.model.*;
import app.domain.shared.Constants;
import auth.AuthFacade;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Bruno Pereira
 */
public class RegisterEmployeeController {

    private Company company;
    private EmployeeStore estore;

    public RegisterEmployeeController() {
         if (!App.getInstance().getCurrentUserSession().isLoggedInWithRole(Constants.ROLE_ADMIN)) {
            throw new IllegalStateException("Utilizador nï¿½o Autorizado");
        }
        this.company = App.getInstance().getCompany();
        this.estore = company.getEmployeeStore();
        
    }
    
    public List<String> getOrganizationRoles(){
        return this.estore.getOrganizationRoles();
    }
    
    public EmployeeStore getEmployees() {
        return this.estore;
    }

    public boolean registerEmployee(Employee employee) {
        //generate id
        employee.setEmployeeId(this.estore.generateEmployeeId(employee.getName()));
        
        //generate email
        employee.setEmail(this.estore.generateEmail(employee.getEmployeeId()));
        
        //register employee
        return this.estore.registerEmployee(employee);
    }
    
    public boolean saveEmployee(Employee emp) {
        //validates and saves employee
        this.estore.saveEmployee(emp); 
        //saves employee user - password é o id????
        return this.company.getAuthFacade().addUserWithRole(emp.getName(), emp.getEmail(), emp.getEmployeeId(), emp.getRole().getDesignation());

    }
    
    //not done
    public String getEmployeeToString(Employee emp)
    {
        return ("[name: " + emp.getName() + "]\n" + "[adress: " + emp.getAddress()+ "]\n" +
                "[email: " + emp.getEmail()+ "]\n" + "[id: " + emp.getEmployeeId()+ "]\n" +
                "[phone number: " + emp.getPhoneNumber()+ "]\n" + "[soc code: " + emp.getSocCode()+ "]\n" );
    }
}
