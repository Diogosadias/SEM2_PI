package app.domain.model;

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
        } catch (IllegalArgumentException ex) {
            assertEquals("Creating Test Error: Test type is null.", ex.getMessage());
        }
        try {
            app.domain.model.Test test1 = new app.domain.model.Test(testtype, "", c1);
        } catch (IllegalArgumentException ex) {
            assertEquals("Creating Test Error: Description is empty.", ex.getMessage());
        }
        try {
            app.domain.model.Test test1 = new app.domain.model.Test(testtype, "description", null);
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
        }

        @Test
        public void setCode(){
        String code = null;
        try{
            test.setCode(code);
        }catch (IllegalArgumentException ex){
            assertEquals("Error: Code is null.",ex.getMessage());
        }
        }


    }



