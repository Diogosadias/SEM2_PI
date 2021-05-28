package app.domain.model;

import app.domain.shared.Constants;
import app.domain.shared.ExternalModule;
import auth.domain.model.Email;

import java.util.Date;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestTest {


    TestType testtype = new TestType("codex","description","collectingMethod");
    Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M", 11111111111L);

    app.domain.model.Test test = new app.domain.model.Test(testtype,"description",c1);


    @Test
    public void checkValidation() {
        try {
            app.domain.model.Test test1 = new app.domain.model.Test(null, "description", c1);
            assertNull(test1);
        } catch (IllegalArgumentException ex) {
            assertEquals("Creating Test Error: Test type is null.", ex.getMessage());
        }
        try {
            app.domain.model.Test test1 = new app.domain.model.Test(testtype, "", c1);
            assertNull(test1);
        } catch (IllegalArgumentException ex) {
            assertEquals("Creating Test Error: Description is empty.", ex.getMessage());
        }
        try {
            app.domain.model.Test test1 = new app.domain.model.Test(testtype, "description", null);
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
        }catch (IllegalArgumentException ex){
            assertEquals("Adding NhsCode to Test Error: NhsCode needs 12 alphanumeric characters.",ex.getMessage());
        }
        try{
            test.setNhsCode(nhs2);
        }catch (IllegalArgumentException ex){
            assertEquals("Adding NhsCode to Test Error: NhsCode needs 12 alphanumeric characters.",ex.getMessage());
        }
        test.setNhsCode("123456789012");
        assertEquals(test.getNhsCode(), "123456789012");
    }


    @Test
    public void setCode(){
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
    }

    @Test
    public void checkGetParameterByCode(){
        Parameter parameter = new Parameter("code","parameter","description","category");
        test.addParameter(parameter);

        try{

            Parameter result1 = test.getParameterByCode("code");
            assertEquals(parameter, result1);

        }catch (IllegalArgumentException ex){
            assertNotEquals("Test: No Parameter with that Code.",ex.getMessage());
        }
    }

    @Test
    public void checkAddTestResult(){
        Parameter parameter = new Parameter("code","parameter","description","category");
        test.addParameter(parameter);
        ExternalModule em = this.test.getTestType().getExternalModule();

        TestParameter tp = new TestParameter(parameter);
        tp.addResult("12", 12, em.getReferenceValue(parameter));

        test.addTestResult("code", "12", 12);
        assertEquals(test.getCurrentTestParameter().toString(), tp.toString());
        assertTrue(test.hasCondition(Constants.SAMPLE_ANALYSED));
    }


        @Test
        public void getListParametersTest(){
        try{
            test.getListParameters();
        }catch (IllegalArgumentException ex){
            assertEquals("Test: List Parameter is empty.",ex.getMessage());
        }
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



