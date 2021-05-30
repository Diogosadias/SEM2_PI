package app.domain.model;

import app.domain.shared.Constants;
import app.domain.shared.ExternalModule;
import auth.domain.model.Email;

import java.io.IOException;
import java.util.Date;

import static org.junit.Assert.*;

import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.junit.Test;

public class TestTest {


    TestType testType = new TestType("codex","description","collectingMethod");
    Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M", 11111111111L);

    app.domain.model.Test test = new app.domain.model.Test(testType,"description",c1);


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
            assertEquals("Error: Code is null.",ex.getMessage());
        }
        try{
            test.setCode(code2);
        }catch (IllegalArgumentException ex){
            assertEquals("Error: Code is null.",ex.getMessage());
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
        test.addCategory(pCat);
        assertTrue(test.getListCategories().contains(pCat));
        try {
            test.addCategory(pCat);
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
        Client c2 = new Client(new Email("user2@gmail.com"), "Helium", 1112251111L, 1111123111111111L, 111167111111L, new Date("5/12/2021"), "M", 12110111111L);
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
}




