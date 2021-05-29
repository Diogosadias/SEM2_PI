/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.dto;

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
public class OrgRoleDtoTest {
    
    OrgRoleDto org1 = new OrgRoleDto("12345", "teste");
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class OrgRoleDto.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        OrgRoleDto instance = org1;
        String expResult = "12345";
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDesignation method, of class OrgRoleDto.
     */
    @Test
    public void testGetDesignation() {
        System.out.println("getDesignation");
        OrgRoleDto instance = org1;
        String expResult = "teste";
        String result = instance.getDesignation();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class OrgRoleDto.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "54321";
        OrgRoleDto instance = org1;
        instance.setId(id);
        assertEquals(id,instance.getId());
    }

    /**
     * Test of setDesignation method, of class OrgRoleDto.
     */
    @Test
    public void testSetDesignation() {
        System.out.println("setDesignation");
        String designation = "teste2";
        OrgRoleDto instance = org1;
        instance.setDesignation(designation);
        assertEquals(designation,instance.getDesignation());
    }

    /**
     * Test of toString method, of class OrgRoleDto.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        OrgRoleDto instance = org1;
        String expResult = "[ " + org1.getId() + " ]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
