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
import app.domain.model.EmployeeStore;
import auth.AuthFacade;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static app.domain.shared.Constants.ROLE_ADMIN;


/**
 * Controller for the US7 realization - Register a new Employee
 *
 * @author Tiago Rocha
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 */
public class RegisterEmployeeController {

    private Company company;
    private EmployeeStore estore;
    private AuthFacade auth;

    /**
     * Constructor for a given Company instance.
     */
    public RegisterEmployeeController() {
         if (!App.getInstance().getCurrentUserSession().isLoggedInWithRole(ROLE_ADMIN)) {
            throw new IllegalStateException("Utilizador nï¿½o Autorizado");
        }
        this.company = App.getInstance().getCompany();
        this.estore = company.getEmployeeStore();
        this.auth = company.getAuthFacade();
    }

    /**
     * Return List of Roles
     *
     * @return
     */
    public List<OrgRoleDto> getOrgRoles(){
        List<OrgRole> roles = this.estore.getRoleStore().getOrgRoles();
        RolesMapper mapper = new RolesMapper();
        return mapper.toDto(roles);
    }



    public boolean registerEmployee(EmployeeDto eDto) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return (this.estore.registerEmployee(eDto));
    }

    public void setDoctorIndexNumber(int doctorIndexNumber) {
        estore.setDoctorIndexNumber(doctorIndexNumber);
    }

    public boolean saveEmployee() {
        return this.estore.saveEmployee();
    }

    public Company getCompany() {
        return this.company;
    }



    public void confirmEmployee () {
        estore.confirmRegistration();
    }

    public void cancelEmployee() {
        estore.removeEmployee();
    }

    public EmployeeStore getEmployeeStore () {
        return this.estore;
    }

}
