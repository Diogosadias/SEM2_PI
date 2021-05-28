package app.domain.model;

import app.domain.shared.Constants;
import app.domain.shared.ExternalModule;
import auth.domain.model.Email;

import java.util.Date;

import static org.junit.Assert.*;
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
        Parameter parameter = new Parameter("code","parameter","description","category");
        this.test.addParameter(parameter);
        ExternalModule em = this.test.getTestType().getExternalModule();

        TestParameter tp = new TestParameter(parameter);
        tp.addResult("12", 12, em.getEMRefValue(this.test.getDescription(), parameter));

        test.addTestResult("code", "12", 12);
        assertEquals(this.test.getCurrentTestParameter().toString(), tp.toString());
        assertTrue(this.test.hasCondition(Constants.SAMPLE_ANALYSED));
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
            this.test.getListParameters().isEmpty();
        }catch (IllegalArgumentException ex){
            assertEquals("Test: List Parameter is empty.",ex.getMessage());
        }

        Parameter parameter = new Parameter("code","parameter","description","category");
        this.test.addParameter(parameter);

        assertNotNull(this.test.getListParameters());
        assertEquals(this.test.getParameterByCode("code").toString(), parameter.toString());
    }

    @Test
    public void getListCategories(){
        try{
            test.getListCategories();
        }catch (IllegalArgumentException ex){
            assertEquals("Test: List ParameterCategory is empty.",ex.getMessage());
        }

    }

    @Test
    public void addParameterTest(){
        Parameter parameter = new Parameter("code","parameter","description","category");

        try {
            test.addParameter(parameter);
            test.addParameter(parameter);
        }catch (IllegalArgumentException ex){
            assertEquals("Test: Parameter already exists.",ex.getMessage());
        }
    }
}



