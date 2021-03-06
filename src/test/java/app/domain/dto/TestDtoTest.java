package app.domain.dto;

import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import app.domain.model.Sample;
import app.domain.model.TestParameter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import app.domain.shared.Constants;
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
    TestDto testDto2 = new TestDto("23456","sample","type",12345678901L, categories, parameters);
    List<Sample> sampleList = new ArrayList<>();
    TestDto testDto3 = new TestDto("34567","teste3", sampleList);
    List<TestParameter> listTP = new ArrayList<>();
    TestDto testDto4 = new TestDto("45678",Long.valueOf("45678"),listTP);
    Date now = new Date();
    TestDto testDto5 = new TestDto(now);
    TestDto testDto6 = new TestDto("11111", now, now, now);
    TestDto testDto7 = new TestDto("22222", now, now, now, now);
    TestDto testDto8 = new TestDto();


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
        List<Sample> expResult = new ArrayList<>();
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
        Date expResult = new Date(2021, 10, 10);
        Date result = instance.getDateDiagnosis();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateValidation method, of class TestDto.
     */
    @Test
    public void testGetDateValidation() {
        System.out.println("getDateValidation");
        TestDto instance = testDto1;
        Date expResult = new Date(2021, 10, 10);
        Date result = instance.getDateValidation();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of toString method, of class TestDto.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        TestDto instance = testDto1;
        String expResult = "\nTest: "+ testDto1.getCode() + " | Nhs: " + testDto1.getNhsCode() + " | Client n: " + testDto1.getClientCC() + " | Collection Method: " + testDto1.getDescription();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of Parameters_toString method, of class TestDto.
     */
    @Test
    public void testParametersToString() {
        System.out.println("ParametersToString");
        TestDto instance = testDto2;
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
        String result = instance.parametersToString();
        assertEquals(expResult, result);
    }

    /**
     * Test of Samples_toString method, of class TestDto.
     */
    @Test
    public void testSamplesToString() {
        System.out.println("SamplesToString");
        TestDto instance = testDto1;
        String expResult = "\nTest n: " + instance.getCode() +
                "\nList of Sample(s): \n";
        for (Sample sample : testDto1.getSampleList()) {
            expResult += "\n - " + sample.getSampleBarcode();
        }
        String result = instance.samplesToString();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTin method, of class TestDto.
     */
    @Test
    public void testSetTin() {
        System.out.println("setTin");
        long tin = 1L;
        TestDto instance = testDto1;
        instance.setTin(tin);
        assertEquals(tin, instance.getTin());
        
    }

    /**
     * Test of setNhsCode method, of class TestDto.
     */
    @Test
    public void testSetNhsCode() {
        System.out.println("setNhsCode");
        String nhsCode = "54321";
        TestDto instance = testDto1;
        instance.setNhsCode(nhsCode);
        assertEquals(nhsCode, instance.getNhsCode());
    }

    /**
     * Test of setParameters method, of class TestDto.
     */
    @Test
    public void testSetParameters() {
        System.out.println("setParameters");
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter("1", "teste", "teste", "teste"));        
        TestDto instance = testDto1;
        instance.setParameters(parameters);
        assertEquals(parameters, instance.parameters);
    }

    /**
     * Test of setListTP method, of class TestDto.
     */
    @Test
    public void testSetListTP() {
        System.out.println("setListTP");
        List<TestParameter> listTP = new ArrayList<>();
        listTP.add(new TestParameter(new Parameter("2", "teste", "teste", "teste")));
        TestDto instance = testDto1;
        instance.setListTP(listTP);
        assertEquals(listTP, instance.listTP);
    }

    /**
     * Test of setDateRegistered method, of class TestDto.
     */
    @Test
    public void testSetDateRegistered() {
        System.out.println("setDateRegistered");
        Date expResult = this.now;
        TestDto instance = testDto5;
        instance.setDateRegistered(expResult);
        Date result = instance.getDateRegistered();
        assertEquals(expResult, result);

    }

    /**
     * Test of setDateChemicalAnalysis method, of class TestDto.
     */
    @Test
    public void testSetDateChemicalAnalysis() {
        System.out.println("setDateChemicalAnalysis");
        Date expResult = this.now;
        TestDto instance = testDto5;
        instance.setDateChemicalAnalysis(expResult);
        Date result = instance.getDateChemicalAnalysis();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDateDiagnosis method, of class TestDto.
     */
    @Test
    public void testSetDateDiagnosis() {
        System.out.println("setDateDiagnosis");
        Date expResult = this.now;
        TestDto instance = testDto5;
        instance.setDateDiagnosis(expResult);
        Date result = instance.getDateDiagnosis();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDateValidation method, of class TestDto.
     */
    @Test
    public void testSetDateValidation() {
        System.out.println("setDateValidation");
        Date expResult = this.now;
        TestDto instance = testDto5;
        instance.setDateValidation(expResult);
        Date result = instance.getDateValidation();
        assertEquals(expResult, result);
    }

    /**
     * Test of validatedDates_toString method, of class TestDto.
     */
    @Test
    public void testValidatedDatesToString() {
        System.out.println("validatedDatesToString");
        TestDto instance = testDto7;
        String expResult = "\n" +
                "Test n: 22222\n" +
                "Date Registration: " + Constants.FORMATTER.format(this.now) + "\n" +
                "Date Chemical Analysis: " + Constants.FORMATTER.format(this.now) + "\n" +
                "Date Diagnosis: " + Constants.FORMATTER.format(this.now) + "";
        String result = instance.validatedDatesToString();
        assertEquals(expResult, result);
    }
    
}