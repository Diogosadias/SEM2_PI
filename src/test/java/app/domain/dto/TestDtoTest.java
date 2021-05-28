package app.domain.dto;

import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import app.domain.model.Sample;
import app.domain.model.TestParameter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

public class TestDtoTest {    

    TestDto testDto1 = new TestDto("12345","teste1", Long.valueOf("12345"));
    List<ParameterCategory> categories = new ArrayList<>();
    List<Parameter> parameters = new ArrayList<>();
    TestDto testDto2 = new TestDto("23456", categories, parameters);
    List<Sample> sampleList = new ArrayList<>();
    TestDto testDto3 = new TestDto("34567","teste3", sampleList);
    List<TestParameter> listTP = new ArrayList<>();
    TestDto testDto4 = new TestDto("45678",Long.valueOf("45678"),listTP);    


    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        testDto1.setNhsCode("12345");
        testDto1.setTin(Long.valueOf("123"));
        testDto1.setDateChemicalAnalysis(new Date(2021, 10, 10));
        testDto1.setDateDiagnosis(new Date(2021, 10, 10));
        testDto1.setDateRegistered(new Date(2021, 10, 10));        
        testDto1.setDateValidation(new Date(2021, 10, 10));
    }

    @After
    public void tearDown() throws Exception {
    }
    
    /**
     * Test of getSampleList method, of class TestDto.
     */
    @Test
    public void testGetSampleList() {
        System.out.println("getSampleList");
        TestDto instance = testDto3;
        List<Sample> expResult = null;
        List<Sample> result = instance.getSampleList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCode method, of class TestDto.
     */
    @Test
    public void testGetCode() {
        System.out.println("getCode");
        TestDto instance = testDto1;
        String expResult = "12345";
        String result = instance.getCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class TestDto.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        TestDto instance = testDto1;
        String expResult = "teste1";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClientCC method, of class TestDto.
     */
    @Test
    public void testGetClientCC() {
        System.out.println("getClientCC");
        TestDto instance = testDto1;
        long expResult = Long.valueOf("12345");
        long result = instance.getClientCC();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNhsCode method, of class TestDto.
     */
    @Test
    public void testGetNhsCode() {
        System.out.println("getNhsCode");
        TestDto instance = testDto1;
        String expResult = "12345";
        String result = instance.getNhsCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getParameters method, of class TestDto.
     */
    @Test
    public void testGetParameters() {
        System.out.println("getParameters");
        TestDto instance = testDto2;
        List<Parameter> expResult = new ArrayList<>();
        List<Parameter> result = instance.getParameters();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTin method, of class TestDto.
     */
    @Test
    public void testGetTin() {
        System.out.println("getTin");
        TestDto instance = testDto1;
        long expResult = Long.valueOf("123");
        long result = instance.getTin();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getListTestParameter method, of class TestDto.
     */
    @Test
    public void testGetListTestParameter() {
        System.out.println("getListTestParameter");
        TestDto instance = testDto4;
        List<TestParameter> expResult = new ArrayList<>();
        List<TestParameter> result = instance.getListTestParameter();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateRegistered method, of class TestDto.
     */
    @Test
    public void testGetDateRegistered() {
        System.out.println("getDateRegistered");
        TestDto instance = testDto1;
        Date expResult = new Date(2021, 10, 10);
        Date result = instance.getDateRegistered();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateChemicalAnalysis method, of class TestDto.
     */
    @Test
    public void testGetDateChemicalAnalysis() {
        System.out.println("getDateChemicalAnalysis");
        TestDto instance = testDto1;
        Date expResult = new Date(2021, 10, 10);
        Date result = instance.getDateChemicalAnalysis();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateDiagnosis method, of class TestDto.
     */
    @Test
    public void testGetDateDiagnosis() {
        System.out.println("getDateDiagnosis");
        TestDto instance = testDto1;
        Date expResult = new Date(2021, 10, 10);;
        Date result = instance.getDateDiagnosis();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateValidation method, of class TestDto.
     */
    @Test
    public void testGetDateValidation() {
        System.out.println("getDateValidation");
        TestDto instance = new TestDto();
        Date expResult = null;
        Date result = instance.getDateValidation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of toString method, of class TestDto.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        TestDto instance = testDto1;
        String expResult = "\nCode: "+ testDto1.getCode() + "\nCollection Method: " + testDto1.getDescription();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of Parameters_toString method, of class TestDto.
     */
    @Test
    public void testParameters_toString() {
        System.out.println("Parameters_toString");
        TestDto instance = testDto1;
        String expResult = "\n\nList of Parameter(s) for each Category to be analysed: ";
        for (ParameterCategory category : instance.categories) {
            expResult = expResult + "\n\n - " + category.getDescription();
            for (Parameter parameter : instance.parameters) {
                if (parameter.getCategory().equals(category.getCode()))
                {
                    expResult += "\n" + parameter.getName();
                }
            }
        }
        String result = instance.Parameters_toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of Samples_toString method, of class TestDto.
     */
    @Test
    public void testSamples_toString() {
        System.out.println("Samples_toString");
        TestDto instance = testDto1;
        String expResult = "\nTest n: " + instance.getCode() +
                "\nList of Sample(s): \n";
        for (Sample sample : testDto1.getSampleList()) {
            expResult += "\n - " + sample.getSampleBarcode();
        }
        String result = instance.Samples_toString();
        assertEquals(expResult, result);
    }
    
}