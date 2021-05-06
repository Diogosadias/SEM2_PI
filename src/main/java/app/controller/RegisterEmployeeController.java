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
    private Employee emp;

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

    public boolean registerEmployee(String orgRole, String name, String adress, String phoneNumber, String socCode, int doctorIndexNumber) {
        
        this.emp = this.estore.create(orgRole, name, adress, phoneNumber, socCode, doctorIndexNumber);        
        return this.estore.validateEmployee(this.emp);        
    }
    
    public boolean saveEmployee() {
        //validates and saves employee
        this.estore.saveEmployee(this.emp); 
        System.out.println("AQUIIIIIIIIIIIII");
        //saves employee user - password é o id????
        return this.company.getAuthFacade().addUserWithRole(emp.getName(), emp.getEmail(), emp.getEmployeeId(), emp.getRole().getDesignation());

    }

    public Employee getEmployee() {
        return this.emp;
    }
    
    
    public String getEmployeeToString()
    {
        return ("[name: " + this.emp.getName() + "]\n" + "[adress: " + this.emp.getAddress()+ "]\n" +
                "[email: " + this.emp.getEmail()+ "]\n" + "[id: " + this.emp.getEmployeeId()+ "]\n" +
                "[phone number: " + this.emp.getPhoneNumber()+ "]\n" + "[soc code: " + this.emp.getSocCode()+ "]\n" +
                "[doctor index code: " + getEmployeeDoctorIndexCode() + "]\n");
    }
    
    public int getEmployeeDoctorIndexCode(){
        return this.emp.getRole().getDoctorIndexNumber();
    }
}
