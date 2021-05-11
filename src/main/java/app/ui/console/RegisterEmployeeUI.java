/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ui.console;

import app.controller.App;
import app.controller.RegisterEmployeeController;
import app.domain.dto.EmployeeDto;
import app.domain.dto.OrgRoleDto;
import app.domain.model.Employee;
import app.ui.console.utils.Utils;
import auth.AuthFacade;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static app.domain.shared.Constants.SPECIALIST_DOCTOR;

/**
 *
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 * @author Tiago Rocha
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

        try {
            if(registerData())
            {
                presentsData();

                if (Utils.confirm("Do you confirm the data? (Y/N)")) {
                        System.out.println("Employee registered successfully!");
                } else
                {
                    System.out.println("Operation cancelled.");
                }
            }
            else
            {
                System.out.println("Error. Operation cancelled.");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
    
    private boolean registerData() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        List<OrgRoleDto> set = m_controller.getOrgRoles();
        OrgRoleDto temp = (OrgRoleDto)Utils.showAndSelectOne(set, "\nList of Organization Role\nNumber/id of role: \n");
        if (temp != null) {
            // Request data: name, address, phoneNumber,socCode, doctorIndexNumber
            String name = Utils.readLineFromConsole("Name: ");
            String address = Utils.readLineFromConsole("Address: ");
            double phoneNumber = Utils.readDoubleFromConsole("Phone number: ");
            String socCode = Utils.readLineFromConsole("Soc Code: ");
            EmployeeDto eDto = new EmployeeDto(temp.getId(), name, address, (long)phoneNumber, socCode);
            if (temp.getId().equals(SPECIALIST_DOCTOR)) {
                int doctorIndexNumber = Utils.readIntegerFromConsole("Doctor Index Number: ");
                eDto.setDoctorIndexNumber(doctorIndexNumber);
            }
            if (this.m_controller.registerEmployee(eDto)) {
                return this.m_controller.saveEmployee();
            } else {
                System.out.println("Invalid Data was introduced! Returning to the menu.");
                return false;
            }
        }
        return false;
    }
    
    private void presentsData() 
    {
        System.out.println("\nEmployee:\n" + m_controller.getEmployeeToString());
    }
        
    
}
