/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.domain.model.*;
import app.domain.shared.Constants;
import auth.AuthFacade;
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
            throw new IllegalStateException("Utilizador n�o Autorizado");
        }
        this.company = App.getInstance().getCompany();
        this.estore = company.getEmployeeStore();
        
    }
    
    public Set<String> getOrganizationRoles(){
        return this.estore.getRoles();
    }
    
    public EmployeeStore getEmployees() {
        return this.estore;
    }

    public boolean registerEmployee(Employee employee) {
        return this.company.getEmployeeStore().addEmployee(employee);
    }
}
