/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruno Pereira
 */
public class EmployeeTest {
    
    private final Employee emp;
    
    public EmployeeTest() {
        this.emp = new Employee("email@lei.pt", "12345", "abc", "ze", "aqui", "12345", "12345", 12345);
    }
    
    /**
     * Test of getEmployeeId method, of class Employee.
     */
    @Test
    public void testGetEmployeeId() {
        System.out.println("getEmployeeId");
        String expResult = "12345";
        String result = emp.getEmployeeId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRole method, of class Employee.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        OrganizationRole expResult = new OrganizationRole("abc", 12345);;
        OrganizationRole result = emp.getRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Employee.
     */
    @Test
    public void testGetName() {        
        System.out.println("getName");
        String expResult = "ze";
        String result = emp.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAddress method, of class Employee.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        String expResult = "aqui";
        String result = emp.getAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPhoneNumber method, of class Employee.
     */
    @Test
    public void testGetPhoneNumber() {
        System.out.println("getPhoneNumber");
        String expResult = "12345";
        String result = emp.getPhoneNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSocCode method, of class Employee.
     */
    @Test
    public void testGetSocCode() {
        System.out.println("getSocCode");
        String expResult = "12345";
        String result = emp.getSocCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class Employee.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        String expResult = "email@lei.pt";
        String result = emp.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmployeeId method, of class Employee.
     */
    @Test
    public void testSetEmployeeId() {
        System.out.println("setEmployeeId");
        String employeeId = "54321";
        emp.setEmployeeId(employeeId);
        assertEquals(emp.getEmployeeId(), employeeId);
    }

    /**
     * Test of setRole method, of class Employee.
     */
    @Test
    public void testSetRole() {
        System.out.println("setRole");
        OrganizationRole role = new OrganizationRole("asd", 12345);
        emp.setRole(role);
        assertEquals(emp.getRole(), role);
    }

    /**
     * Test of setName method, of class Employee.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "manel";
        emp.setName(name);
        assertEquals(emp.getName(), name);
    }

    /**
     * Test of setAddress method, of class Employee.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "ali";
        emp.setAddress(address);
        assertEquals(emp.getAddress(), address);
    }

    /**
     * Test of setPhoneNumber method, of class Employee.
     */
    @Test
    public void testSetPhoneNumber() {
        System.out.println("setPhoneNumber");
        String phoneNumber = "54321";
        emp.setPhoneNumber(phoneNumber);
        assertEquals(emp.getPhoneNumber(), phoneNumber);
    }

    /**
     * Test of setSocCode method, of class Employee.
     */
    @Test
    public void testSetSocCode() {
        System.out.println("setSocCode");
        String socCode = "54321";
        emp.setSocCode(socCode);
        assertEquals(emp.getSocCode(), socCode);
    }

    /**
     * Test of setEmail method, of class Employee.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "email2@lei.pt";
        emp.setEmail(email);
        assertEquals(emp.getEmail(), email);
    }

    /**
     * Test of equals method, of class Employee.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        boolean expResult = false;
        boolean result = emp.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Employee.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        int expResult = 1739969989;
        int result = emp.hashCode();
        assertEquals(expResult, result);
    }
    
}
