package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestTypeTest {

    TestType test = new TestType("code","description","collectingMethod");
    @Test
    public void getCode() {


        //assert
        assertEquals("code",test.getCode());
        assertEquals(false,test.getCode().equals("Codex"));

    }

    @Test
    public void setCode() {
    }

    @Test
    public void getDescription() {


        //assert
        assertEquals("description",test.getDescription());
        assertEquals(false,test.getDescription().equals("ddddd"));
    }

    @Test
    public void setDescription() {
        //arrange


        //calculations
        test.setDescription("newDescription");
        //assert
        assertEquals("newDescription",test.getDescription());
        assertEquals(false,test.getDescription().equals("description"));
    }

    @Test
    public void getCollectingMethod() {
        //arrange

        //assert
        assertEquals("collectingMethod",test.getCollectingMethod());
        assertEquals(false,test.getCollectingMethod().equals("aaaaa"));
    }

    @Test
    public void setCollectingMethod() {
        //arrange

        //calculations
        test.setCollectingMethod("newCollect");
        //assert
        assertEquals("newCollect",test.getCollectingMethod());
        assertEquals(false,test.getCollectingMethod().equals("collectingMethod"));
    }


    @Test
    public void checkDescription(){



    }

    @Test
    public void checkCode(){}

    @Test
    public void checkCollectingMethods(){}

    @Test
    public void TesttoString(){

    }




    @Test
    public void testToString() {
    }
}