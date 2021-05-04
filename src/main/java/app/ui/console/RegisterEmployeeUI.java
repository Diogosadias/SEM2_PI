/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ui.console;

import app.controller.RegisterEmployeeController;

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
        
        for(String a : this.m_controller.getOrganizationRoles()){
            
        }
    
    }
}
