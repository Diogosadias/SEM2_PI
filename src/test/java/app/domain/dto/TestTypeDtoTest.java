/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.dto;

import java.util.ArrayList;
import java.util.List;
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
public class TestTypeDtoTest {
    
    TestTypeDto testTypeDto;
    
    public TestTypeDtoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        List<ParameterCategoryDto> listCategories = new ArrayList<>();
        testTypeDto = new TestTypeDto("12345", "teste", listCategories);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCode method, of class TestTypeDto.
     */
    @Test
    public void testGetCode() {
        System.out.println("getCode");
        TestTypeDto instance = testTypeDto;
        String expResult = "12345";
        String result = instance.getCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class TestTypeDto.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        TestTypeDto instance = testTypeDto;
        String expResult = "teste";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListCategories method, of class TestTypeDto.
     */
    @Test
    public void testGetListCategories() {
        System.out.println("getListCategories");
        TestTypeDto instance = testTypeDto;
        List<ParameterCategoryDto> expResult = new ArrayList<>();
        List<ParameterCategoryDto> result = instance.getListCategories();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class TestTypeDto.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        TestTypeDto instance = testTypeDto;
        String expResult = "[ " + testTypeDto.getDescription() + " ]\n";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCode method, of class TestTypeDto.
     */
    @Test
    public void testSetCode() {
        System.out.println("setCode");
        String code = "54321";
        TestTypeDto instance = testTypeDto;
        instance.setCode(code);
        assertEquals(code, instance.getCode());
    }

    /**
     * Test of setDescription method, of class TestTypeDto.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "teste2";
        TestTypeDto instance = testTypeDto;
        instance.setDescription(description);
        assertEquals(description, instance.getDescription());
    }

    /**
     * Test of setListParameters method, of class TestTypeDto.
     */
    @Test
    public void testSetListParameters() {
        System.out.println("setListParameters");
        List<ParameterCategoryDto> listCategories = new ArrayList<>();
        listCategories.add(new ParameterCategoryDto("1", "teste"));
        TestTypeDto instance = testTypeDto;
        instance.setListParameters(listCategories);
        assertEquals(listCategories, instance.getListCategories());
    }
    
}
