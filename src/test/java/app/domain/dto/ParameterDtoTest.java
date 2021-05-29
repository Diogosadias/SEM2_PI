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
public class ParameterDtoTest {
    
    ParameterDto parameter1 = new ParameterDto("12345", "teste");
        
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
     * Test of getCode method, of class ParameterDto.
     */
    @Test
    public void testGetCode() {
        System.out.println("getCode");
        ParameterDto instance = parameter1;
        String expResult = "12345";
        String result = instance.getCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCode method, of class ParameterDto.
     */
    @Test
    public void testSetCode() {
        System.out.println("setCode");
        String code = "54321";
        ParameterDto instance = parameter1;
        instance.setCode(code);
        assertEquals(code,instance.getCode());
    }

    /**
     * Test of getName method, of class ParameterDto.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        ParameterDto instance = parameter1;
        String expResult = "teste";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class ParameterDto.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "teste2";
        ParameterDto instance = parameter1;
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of toString method, of class ParameterDto.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ParameterDto instance = parameter1;
        String expResult = "[ " + instance.getName() + " ]\n";;
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }
    
}
