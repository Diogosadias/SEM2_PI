package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestTypeTest {

    @Test
    public void getCode() {

        //arrange
        TestType test = new TestType("code","description","collectingMethod");
        //assert
        assertEquals("code",test.getCode());
        assertEquals(false,test.getCode().equals("Codex"));

    }

    @Test
    public void setCode() {
    }

    @Test
    public void getDescription() {
        //arrange
        TestType test = new TestType("code","description","collectingMethod");
        //assert
        assertEquals("description",test.getDescription());
        assertEquals(false,test.getDescription().equals("ddddd"));
    }

    @Test
    public void setDescription() {
        //arrange
        TestType test = new TestType("code","description","collectingMethod");

        //calculations
        test.setDescription("newDescription");
        //assert
        assertEquals("newDescription",test.getDescription());
        assertEquals(false,test.getDescription().equals("description"));
    }

    @Test
    public void getCollectingMethod() {
        //arrange
        TestType test = new TestType("code","description","collectingMethod");
        //assert
        assertEquals("collectingMethod",test.getCollectingMethod());
        assertEquals(false,test.getCollectingMethod().equals("aaaaa"));
    }

    @Test
    public void setCollectingMethod() {
        //arrange
        TestType test = new TestType("code","description","collectingMethod");

        //calculations
        test.setCollectingMethod("newCollect");
        //assert
        assertEquals("newCollect",test.getCollectingMethod());
        assertEquals(false,test.getCollectingMethod().equals("collectingMethod"));
    }

 

    @Test
    public void testToString() {
    }
}