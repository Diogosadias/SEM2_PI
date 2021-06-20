package app.domain.model;

import app.domain.shared.Constants;
import app.domain.shared.ExternalModule;
import auth.domain.model.Email;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestTest {


    TestType testType = new TestType("codex","description","collectingMethod");
    Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 1111111111L, new Date("12/12/2021"), "M", 11111111111L);

    app.domain.model.Test test = new app.domain.model.Test(testType,"description",c1);

    ParameterStore ps = new ParameterStore();
    Parameter p = new Parameter("1111t", "test", "this is a test", "11111");

    TestParameter tp = new TestParameter(p);
    ParameterCategory pc = new ParameterCategory("12345","abc","12345");
    Sample s = new Sample("123");

    public TestTest() throws BarcodeException, OutputException, IOException {
    }

    @Test
    public void checkValidation() {
        try {
            app.domain.model.Test test1 = new app.domain.model.Test(null, "description", c1);
            assertNull(test1);
        } catch (IllegalArgumentException ex) {
            assertEquals("Creating Test Error: Test type is null.", ex.getMessage());
        }
        try {
            app.domain.model.Test test1 = new app.domain.model.Test(testType, "", c1);
            assertNull(test1);
        } catch (IllegalArgumentException ex) {
            assertEquals("Creating Test Error: Description is empty.", ex.getMessage());
        }
        try {
            app.domain.model.Test test1 = new app.domain.model.Test(testType, "description", null);
            assertNull(test1);
        } catch (IllegalArgumentException ex) {
            assertEquals("Creating Test Error: Client is null.", ex.getMessage());
        }
    }

    @Test
    public void checkNhsCodeAtributeTest(){
        String nhs = "aaaaa";
        String nhs2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String nhs3 = "aaaaa  aaaaa";
        try{
            test.setNhsCode(nhs);
            assertNull(test.getNhsCode());
        }catch (IllegalArgumentException ex){
            assertEquals("Adding NhsCode to Test Error: NhsCode needs 12 alphanumeric characters.",ex.getMessage());
        }
        try{
            test.setNhsCode(nhs2);
            assertNull(test.getNhsCode());
        }catch (IllegalArgumentException ex){
            assertEquals("Adding NhsCode to Test Error: NhsCode needs 12 alphanumeric characters.",ex.getMessage());
        }
        try{
            test.setNhsCode(nhs3);
            assertNull(test.getNhsCode());
        }catch (IllegalArgumentException ex){
            assertEquals("Adding NhsCode to Test Error: NhsCode needs 12 alphanumeric characters.",ex.getMessage());
        }
        app.domain.model.Test test1 = new app.domain.model.Test(testType,"description",c1);
        test.setNhsCode("123456789012");
        assertEquals(test.getNhsCode(), "123456789012");
    }


    @Test
    public void checkSetCode(){
        String code = null;
        String code2 = "";
        try{
            test.setCode(code);
        }catch (IllegalArgumentException ex){
            assertEquals("Error: Test code is null.",ex.getMessage());
        }
        try{
            test.setCode(code2);
        }catch (IllegalArgumentException ex){
            assertEquals("Error: Test code is null.",ex.getMessage());
        }

        test.setCode("stdfgkhjbk");
        assertEquals("stdfgkhjbk", test.getCode());
    }

    @Test
    public void checkGetParameterByCode(){
        Parameter parameter = new Parameter("code","parameter","description","category");
        test.addParameter(parameter);

        Parameter result1 = test.getParameterByCode("code");
        assertEquals(parameter, result1);

        try{
            Parameter result2 = test.getParameterByCode("nope");
        }catch (IllegalArgumentException ex){
            assertEquals("Test: No Parameter with that Code.",ex.getMessage());
        }
    }

    @Test
    public void checkAddTestResult(){

    }

    @Test
    public void checkAddResultToList(){
        Parameter parameter = new Parameter("code","parameter","description","category");
        this.test.addParameter(parameter);
        test.addTestResult("code", "12", 12);
        assertTrue(test.addResultToList());
        /*test.addTestResult("code", "12", 12);*/
        assertFalse(test.addResultToList());
    }

    @Test
    public void getListTestParameters(){

        assertTrue(this.test.getListTestParameter().isEmpty());

        Parameter parameter = new Parameter("code","parameter","description","category");
        this.test.addParameter(parameter);
        test.addTestResult("code", "12", 12);

        ExternalModule em = this.test.getTestType().getExternalModule();

        TestParameter tp = new TestParameter(parameter);
        tp.addResult("12", 12, em.getEMRefValue(this.test.getDescription(), parameter));

        assertNotNull(this.test.getListTestParameter());
        assertEquals(this.test.getCurrentTestParameter().toString(), tp.toString());
    }

    @Test
    public void checkSetTestType(){
        TestType testType2 = new TestType("12345","description2","collectingMethod2");
        assertNotEquals(test.getTestType(), testType2);
        test.setTestType(testType2);
        assertEquals(testType2, test.getTestType());
    }

    @Test
    public void checkGetListParameters(){
        try{
            assertTrue(this.test.getListParameters().isEmpty());
        }catch (IllegalArgumentException ex){
            assertEquals("Test: List Parameter is empty.",ex.getMessage());
        }

        Parameter parameter = new Parameter("code","parameter","description","category");
        this.test.addParameter(parameter);

        assertNotNull(this.test.getListParameters());
        assertEquals(this.test.getParameterByCode("code").toString(), parameter.toString());
    }

    @Test
    public void checkGetListCategories(){
        ParameterCategory pCat = new ParameterCategory("12345", "weyrutiy", "123");
        try{
            assertTrue(test.getListCategories().isEmpty());
        }catch (IllegalArgumentException ex){
            assertEquals("Test: List ParameterCategory is empty.",ex.getMessage());
        }
        test.addCategory(pCat);
        assertTrue(test.getListCategories().contains(pCat));
    }

    @Test
    public void checkAddParameter(){
        Parameter parameter = new Parameter("code","parameter","description","category");
        assertTrue(test.addParameter(parameter));
        try {
            test.addParameter(parameter);
        }catch (IllegalArgumentException ex){
            assertEquals("Test: Parameter already exists.",ex.getMessage());
        }
    }

    @Test
    public void checkAddCategory(){
        ParameterCategory pCat = new ParameterCategory("12345", "weyrutiy", "123");
        try {
            if (test.addCategory(pCat)) {
                assertTrue(test.getListCategories().contains(pCat));
            }
        }catch (IllegalArgumentException ex){
            assertEquals("Test: ParameterCategory already exists.",ex.getMessage());
        }


    }

    @Test
    public void checkGetClient(){
        assertEquals(test.getClient(), c1);
    }

    @Test
    public void checkSetClient() {
        Client c2 = new Client(new Email("user2@gmail.com"), "Helium", 1112251111L, 1111123111111111L, 1167111111L, new Date("5/12/2021"), "M", 12110111111L);
        assertEquals(test.getClient(), c1);
        test.setClient(c2);
        assertEquals(test.getClient(), c2);
    }

    @Test
    public void checkSetDescription() {
        test.setDescription("qweetrthjr");
        assertEquals("qweetrthjr",test.getDescription());
    }

    @Test
    public void checkAddSample(){
        try{
            test.setCode("code");
            Sample s = new Sample(test.getCode());
            assertTrue(test.getListSamples().isEmpty());
            assertTrue(test.addSample(s));
            assertFalse(test.getListSamples().isEmpty());
            assertTrue(test.hasCondition(Constants.SAMPLE_COLLECTED));
        } catch (OutputException | BarcodeException | IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkGetListSamples(){
        try{
            assertTrue(test.getListSamples().isEmpty());
            test.setCode("code");
            Sample s = new Sample(test.getCode());
            test.addSample(s);
            assertEquals(1, test.getListSamples().size());
        } catch (OutputException | BarcodeException | IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkHasCondition(){

    }

    @Test
    public void checkTestDiagnosisIsCompleted(){
        assertTrue(test.testDiagnosisCompleted());
        assertNotNull(test.getDateDiagnosis());
        assertTrue(test.hasCondition(Constants.DIAGNOSIS_MADE));
    }

    @Test
    public void checkGetDateDiagnosis(){
        assertNull(test.getDateDiagnosis());
        test.testDiagnosisCompleted();
        assertNotNull(test.getDateDiagnosis());
    }

    @Test
    public void checkParametersToString(){
        ParameterCategory pCat = new ParameterCategory("12345", "ParamCategoryTest Description", "123");
        test.addCategory(pCat);
        Parameter parameter = new Parameter("code","parameter","param test description ","12345");
        test.addParameter(parameter);
        assertEquals("\n" +
                "\nList of Parameter(s) for each Category to be analysed: \n" +
                "\n" +
                " - ParamCategoryTest Description\n" +
                "parameter", test.parametersToString());
    }

    @Test
    public void checkToString(){
        assertEquals("\n" +
                " --- Many Labs Test --- \n" +
                "Test n: null\n" +
                "Client CC: 1111111111111111\n" +
                "Type of Test: description\n" +
                "Collection Method: description\n" +
                "Nhs Code: null\n" +
                "\n" +
                "List of Parameter(s) for each Category to be analysed: ", test.toString());
    }

    /**
     * Test of setNhsCode method, of class Test.
     */
    @Test
    public void testSetNhsCode() {
        System.out.println("setNhsCode");
        String expResult = "123456789012";
        app.domain.model.Test instance = test;
        instance.setNhsCode(expResult);
        assertEquals(expResult, instance.getNhsCode());
    }

    /**
     * Test of getParameterByCode method, of class Test.
     */
    @Test
    public void testGetParameterByCode() {
        System.out.println("getParameterByCode");
        app.domain.model.Test instance = test;
        instance.addParameter(p);
        Parameter expResult = p;
        Parameter result = instance.getParameterByCode(expResult.getCode());
        assertEquals(expResult, result);
    }

    /**
     * Test of addResultToList method, of class Test.
     */
    @Test
    public void testAddResultToList() {
        System.out.println("addResultToList");
        app.domain.model.Test instance = test;
        boolean expResult = true;
        boolean result = instance.addResultToList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListTestParameter method, of class Test.
     */
    @Test
    public void testGetListTestParameter() {
        System.out.println("getListTestParameter");
        app.domain.model.Test instance = test;
        instance.addParameter(p);
        List<TestParameter> expResult = new ArrayList<>();
        List<TestParameter> result = instance.getListTestParameter();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrentTestParameter method, of class Test.
     */
    @Test
    public void testGetCurrentTestParameter() {
        System.out.println("getCurrentTestParameter");
        app.domain.model.Test instance = test;
        TestParameter expResult = null;
        TestParameter result = instance.getCurrentTestParameter();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLabId method, of class Test.
     */
    @Test
    public void testSetLabId() {
        System.out.println("setLabId");
        String expResult = "123";
        app.domain.model.Test instance = test;
        instance.setLabId(expResult);
        String result = instance.getLabId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCode method, of class Test.
     */
    @Test
    public void testGetCode() {
        System.out.println("getCode");
        app.domain.model.Test instance = test;
        String expResult = "123";
        instance.setCode(expResult);
        String result = instance.getCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCode method, of class Test.
     */
    @Test
    public void testSetCode() {
        System.out.println("setCode");
        String expResult = "321";
        app.domain.model.Test instance = test;
        instance.setCode(expResult);
        String result = instance.getCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTestType method, of class Test.
     */
    @Test
    public void testSetTestType() {
        System.out.println("setTestType");
        TestType expResult = testType;
        app.domain.model.Test instance = test;
        instance.setTestType(expResult);
        TestType result = instance.getTestType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTestType method, of class Test.
     */
    @Test
    public void testGetTestType() {
        System.out.println("getTestType");
        app.domain.model.Test instance = test;
        TestType expResult = testType;
        TestType result = instance.getTestType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListParameters method, of class Test.
     */
    @Test
    public void testGetListParameters() {
        System.out.println("getListParameters");
        app.domain.model.Test instance = test;
        instance.addParameter(p);
        List<Parameter> expResult = new ArrayList<>();
        expResult.add(p);
        List<Parameter> result = instance.getListParameters();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListCategories method, of class Test.
     */
    @Test
    public void testGetListCategories() {
        System.out.println("getListCategories");
        app.domain.model.Test instance = test;
        List<ParameterCategory> expResult = new ArrayList<>();
        expResult.add(pc);
        test.addCategory(pc);
        List<ParameterCategory> result = instance.getListCategories();
        assertEquals(expResult, result);
    }

    /**
     * Test of addParameter method, of class Test.
     */
    @Test
    public void testAddParameter() {
        System.out.println("addParameter");
        app.domain.model.Test instance = test;
        boolean expResult = true;
        boolean result = instance.addParameter(p);
        assertEquals(expResult, result);
        assertEquals(p, instance.getParameterByCode(p.getCode()));
    }

    /**
     * Test of addCategory method, of class Test.
     */
    @Test
    public void testAddCategory() {
        System.out.println("addCategory");
        app.domain.model.Test instance = test;
        boolean expResult = true;
        boolean result = instance.addCategory(pc);
        assertEquals(expResult, result);
        assertEquals(pc, instance.getListCategories().get(0));
    }

    /**
     * Test of getLabId method, of class Test.
     */
    @Test
    public void testGetLabId() {
        System.out.println("getLabId");
        app.domain.model.Test instance = test;
        String expResult = "12345";
        instance.setLabId(expResult);
        String result = instance.getLabId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClient method, of class Test.
     */
    @Test
    public void testGetClient() {
        System.out.println("getClient");
        app.domain.model.Test instance = test;
        Client expResult = c1;
        Client result = instance.getClient();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class Test.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        app.domain.model.Test instance = test;
        String expResult = "description";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNhsCode method, of class Test.
     */
    @Test
    public void testGetNhsCode() {
        System.out.println("getNhsCode");
        app.domain.model.Test instance = test;
        String expResult = "123456789012";
        instance.setNhsCode(expResult);
        String result = instance.getNhsCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setClient method, of class Test.
     */
    @Test
    public void testSetClient() {
        System.out.println("setClient");
        Client expResult = c1;
        app.domain.model.Test instance = test;
        instance.setClient(expResult);
        Client result = instance.getClient();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class Test.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String expResult = "teste";
        app.domain.model.Test instance = test;
        instance.setDescription(expResult);
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of addSample method, of class Test.
     */
    @Test
    public void testAddSample() throws BarcodeException, OutputException, IOException {
        System.out.println("addSample");
        Sample sample = s;
        app.domain.model.Test instance = test;
        boolean expResult = true;
        boolean result = instance.addSample(sample);
        assertEquals(expResult, result);
    }

    /**
     * Test of getListSamples method, of class Test.
     */
    @Test
    public void testGetListSamples() throws BarcodeException, OutputException, IOException {
        System.out.println("getListSamples");
        app.domain.model.Test instance = test;
        List<Sample> expResult = new ArrayList<>();
        expResult.add(s);
        instance.addSample(s);
        List<Sample> result = instance.getListSamples();
        assertEquals(expResult, result);
    }

    /**
     * Test of testDiagnosisCompleted method, of class Test.
     */
    @Test
    public void testTestDiagnosisCompleted() {
        System.out.println("testDiagnosisCompleted");
        app.domain.model.Test instance = test;
        boolean expResult = true;
        boolean result = instance.testDiagnosisCompleted();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListDateSampleCollected method, of class Test.
     */
  /*  @Test
    public void testGetListDateSampleCollected() {
        System.out.println("getListDateSampleCollected");
        app.domain.model.Test instance = test;
        List<Date> expResult = new ArrayList<>();
        expResult.add(new Date());
        instance.addSample(s);
        List<Date> result = instance.getListDateSampleCollected();
        assertEquals(expResult, result);
    }
*/
    /**
     * Test of isValidated method, of class Test.
     */
    @Test
    public void testIsValidated() {
        System.out.println("isValidated");
        app.domain.model.Test instance = test;
        instance.isValidated();
        assertTrue(instance.hasCondition(Constants.VALIDATED));
    }

    /**
     * Test of getDateRegistered method, of class Test.
     */
    @Test
    public void testGetDateRegistered() {
        System.out.println("getDateRegistered");
        app.domain.model.Test instance = test;
        Date expResult = new Date();
        instance.setDateRegistered(expResult);
        Date result = instance.getDateRegistered();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateChemicalAnalysis method, of class Test.
     */
    @Test
    public void testGetDateChemicalAnalysis() {
        System.out.println("getDateChemicalAnalysis");
        app.domain.model.Test instance = test;
        Date expResult = new Date();
        instance.setDateRegistered(expResult);
        instance.setDateChemical(expResult);
        Date result = instance.getDateChemicalAnalysis();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateDiagnosis method, of class Test.
     */
    @Test
    public void testGetDateDiagnosis() {
        System.out.println("getDateDiagnosis");
        app.domain.model.Test instance = test;
        Date expResult = new Date();
        instance.setDateRegistered(expResult);
        instance.setDateChemical(expResult);
        instance.setDateDiagnosis(expResult);
        Date result = instance.getDateDiagnosis();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Test.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        app.domain.model.Test instance = test;
        String expResult = "\n" +
                " --- Many Labs Test --- \n" +
                "Test n: null\n" +
                "Client CC: 1111111111111111\n" +
                "Type of Test: description\n" +
                "Collection Method: description\n" +
                "Nhs Code: null\n" +
                "\n" +
                "List of Parameter(s) for each Category to be analysed: ";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDateRegistered method, of class Test.
     */
    @Test
    public void testSetDateRegistered() {
        System.out.println("setDateRegistered");
        Date expResult = new Date();
        app.domain.model.Test instance = test;
        instance.setDateRegistered(expResult);
        Date result = instance.getDateRegistered();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDateChemical method, of class Test.
     */
    @Test
    public void testSetDateChemical() {
        System.out.println("setDateChemical");
        app.domain.model.Test instance = test;
        Date expResult = new Date();
        instance.setDateRegistered(expResult);
        instance.setDateChemical(expResult);
        Date result = instance.getDateChemicalAnalysis();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDateDiagnosis method, of class Test.
     */
    @Test
    public void testSetDateDiagnosis() {
        System.out.println("setDateDiagnosis");
        app.domain.model.Test instance = test;
        Date expResult = new Date();
        instance.setDateRegistered(expResult);
        instance.setDateChemical(expResult);
        instance.setDateDiagnosis(expResult);
        Date result = instance.getDateDiagnosis();
        assertEquals(expResult, result);
    }

}








