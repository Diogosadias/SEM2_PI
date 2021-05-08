package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestTypeTest {

    @Test
    public void getCode() {

        //arrange
        TestType test = new TestType("codex","description","collectingMethod");
        //assert
        assertEquals("codex",test.getCode());
        assertEquals(false,test.getCode().equals("Codex"));

    }

    @Test
    public void setCode() {
        //arrange
        TestType test = new TestType("codex","description","collectingMethod");

        //calculations
        test.setCode("aaaaa");
        //assert
        assertEquals("aaaaa",test.getCode());
        assertTrue(test.getCode().equals("aaaaa"));
        assertFalse(test.getCode().equals("aaaab"));
    }

    @Test
    public void getDescription() {
        //arrange
        TestType test = new TestType("codex","description","collectingMethod");
        //assert
        assertEquals("description",test.getDescription());
        assertEquals(false,test.getDescription().equals("ddddd"));
    }

    @Test
    public void setDescription() {
        //arrange
        TestType test = new TestType("codex","description","collectingMethod");

        //calculations
        test.setDescription("newDescription");
        //assert
        assertEquals("newDescription",test.getDescription());
        assertEquals(false,test.getDescription().equals("description"));
    }

    @Test
    public void getCollectingMethod() {
        //arrange
        TestType test = new TestType("codex","description","collectingMethod");
        //assert
        assertEquals("collectingMethod",test.getCollectingMethod());
        assertEquals(false,test.getCollectingMethod().equals("aaaaa"));
    }

    @Test
    public void setCollectingMethod() {
        //arrange
        TestType test = new TestType("codex","description","collectingMethod");

        //calculations
        test.setCollectingMethod("newCollect");
        //assert
        assertEquals("newCollect",test.getCollectingMethod());
        assertEquals(false,test.getCollectingMethod().equals("collectingMethod"));
    }


    @Test
    public void testCheckCode(){

        try{
            TestType test = new TestType("code","description","collectingMethod");
            fail();
        }
        catch (IllegalArgumentException ex){
            assertEquals("Code doesn't exist or doesn't have 5 alphanumeric numbers",ex.getMessage());
        }

        try{
            TestType test = new TestType("codess","description","collectingMethod");
            fail();
        }
        catch (IllegalArgumentException ex){
            assertEquals("Code doesn't exist or doesn't have 5 alphanumeric numbers",ex.getMessage());
        }
    }

    @Test
    public void testCheckDescription(){
        try{
        TestType test = new TestType("codex","","collectingMethod");

        }catch (IllegalArgumentException ex){
            assertEquals("Description doesn't exist or surpasses the 15 characters rule!", ex.getMessage());
        }

    }

    @Test
    public void testCheckDescription2(){
        try{
            TestType test = new TestType("codex","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","collectingMethod");

        }catch (IllegalArgumentException ex){
            assertEquals("Description doesn't exist or surpasses the 15 characters rule!",ex.getMessage());
        }
    }

    @Test
    public void testCheckCollectingMethod(){
        try{
            TestType test = new TestType("codex","aaaaaa","");
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("Collecting Method doesn't exist or surpasses the 20 characters rule!",ex.getMessage());
        }
        try{
            TestType test = new TestType("codex","description","collectingMethodaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("Collecting Method doesn't exist or surpasses the 20 characters rule!",ex.getMessage());
        }


    }

    @Test
    public void testToString() {
        TestType test = new TestType("codex","description","collectingMethod");

        assertEquals(false,test.toString().equals(" "));

    }
}