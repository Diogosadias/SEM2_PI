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
public class ParameterCategoryDtoTest {

    ParameterCategoryDto pc = new ParameterCategoryDto("12345", "abc");

    /**
     * Test of getCode method, of class ParameterCategoryDto.
     */
    @Test
    public void testGetCode() {
        System.out.println("getCode");
        ParameterCategoryDto instance = pc;
        String expResult = "12345";
        String result = instance.getCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCode method, of class ParameterCategoryDto.
     */
    @Test
    public void testSetCode() {
        System.out.println("setCode");
        String expResult = "54321";
        ParameterCategoryDto instance = pc;
        instance.setCode(expResult);
        assertEquals(expResult, pc.getCode());
    }

    /**
     * Test of getDescription method, of class ParameterCategoryDto.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        ParameterCategoryDto instance = pc;
        String expResult = "abc";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class ParameterCategoryDto.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String expResult = "bca";
        ParameterCategoryDto instance = pc;
        instance.setDescription(expResult);
        assertEquals(expResult, pc.getDescription());
    }

    /**
     * Test of toString method, of class ParameterCategoryDto.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ParameterCategoryDto instance = pc;
        String expResult = "[ abc ]\n";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
