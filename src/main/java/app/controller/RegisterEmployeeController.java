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
import app.domain.store.EmployeeStore;
import auth.AuthFacade;
import java.util.List;

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
         if (!App.getInstance().getCurrentUserSession().isLoggedInWithRole(Constants.ROLE_ADMIN)) {
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
        System.out.println(employee);
        return !(employee == null);
    }
    
    public boolean saveEmployee() {
        //validates and saves employee
        this.estore.validateEmployee(this.employee);
        this.estore.saveEmployee(this.employee);
        return this.auth.addUserWithRole(employee.getName(), employee.getEmail(), employee.getEmployeeId(),employee.getRole().getDesignation());
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

}
