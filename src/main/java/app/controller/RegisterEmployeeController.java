/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.domain.dto.EmployeeDto;
import app.domain.dto.OrgRoleDto;
import app.domain.dto.RolesMapper;
import app.domain.model.*;
import app.domain.shared.Constants;
import app.domain.model.EmployeeStore;
import app.domain.shared.GeneratePassword;
import auth.AuthFacade;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static app.domain.shared.Constants.ROLE_ADMIN;
import static app.domain.shared.Constants.ROLE_EMPLOYEE;


/**
 *
 * @author Tiago Rocha
 */
public class RegisterEmployeeController {

    private Company company;
    private EmployeeStore estore;
    private Employee employee;
    private AuthFacade auth;

    public RegisterEmployeeController() {
         if (!App.getInstance().getCurrentUserSession().isLoggedInWithRole(ROLE_ADMIN)) {
            throw new IllegalStateException("Utilizador nï¿½o Autorizado");
        }
        this.company = App.getInstance().getCompany();
        this.estore = company.getEmployeeStore();
        this.auth = company.getAuthFacade();
    }
    
    public List<OrgRoleDto> getOrgRoles(){
        List<OrgRole> roles = this.estore.getOrgRoles();
        RolesMapper mapper = new RolesMapper();
        return mapper.toDto(roles);
    }



    public boolean registerEmployee(EmployeeDto eDto) {
        this.employee = this.estore.registerEmployee(eDto);
        return !(employee == null);
    }
    
    public boolean saveEmployee() {
        //validates and saves employee
        if (!this.estore.validateEmployee(this.employee)) {return false;}
        this.estore.saveEmployee(this.employee);
        String testpass = GeneratePassword.makerandompass();
        sendPassEmail(testpass);
        return this.auth.addUserWithRole(employee.getName(), employee.getEmail(), employee.getEmployeeId(),ROLE_EMPLOYEE);
    }

    public Employee getEmployee() {
        return this.employee;
    }
    
    
    public String getEmployeeToString()
    {
        return ("[name: " + this.employee.getName() + "]\n" + "[adress: " + this.employee.getAddress()+ "]\n" +
                "[email: " + this.employee.getEmail()+ "]\n" + "[id: " + this.employee.getEmployeeId()+ "]\n" +
                "[phone number: " + this.employee.getPhoneNumber()+ "]\n" + "[soc code: " + this.employee.getSocCode()+ "]\n");
    }

    public Company getCompany() {
        return this.company;
    }

    private void sendPassEmail (String pass){
        try{
            FileWriter myWriter = new FileWriter(employee.getEmployeeId()+"Password.txt");
            myWriter.write("Hello "+employee.getName()+",\nhere is your new password:\n\n");
            myWriter.append("Email: " + employee.getEmail() + "\n");
            myWriter.append("Password: " + pass + "\n");
            myWriter.append("\nBest regards\n");
            myWriter.append("ManyLabs team.");
            System.out.println("Sending your new password to your email...");
            myWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
