package app.domain.model;

import junit.framework.TestCase;

public class ParameterTest extends TestCase {

    public void testGetCode() {

        //arrange
        Parameter parameter = new Parameter("code","parameter","description","category");

        //assert
        assertEquals("code",parameter.getCode());

    }

    public void testTestGetName() {
        //arrange
        Parameter parameter = new Parameter("code","parameter","description","category");
        //assert
        assertEquals("parameter",parameter.getName());
    }

    public void testGetDescription() {
        //arrange
        Parameter parameter = new Parameter("code","parameter","description","category");

        //assert
        assertEquals("description",parameter.getDescription());
    }

    public void testGetCategory() {
        //arrange
        Parameter parameter = new Parameter("code","parameter","description","category");

        //assert
        assertEquals("category",parameter.getCategory());
    }

    public void testSetCode() {
        //arrange
        Parameter parameter = new Parameter("code","parameter","description","category");

        //calculations
        parameter.setCode("codenew");
        //assert
        assertEquals("codenew",parameter.getCode());
        assertEquals(false,parameter.getCode().equals("code"));
    }

    public void testTestSetName() {
        //arrange
        Parameter parameter = new Parameter("code","parameter","description","category");

        //coding
        parameter.setName("newName");

        //assert
        assertEquals("newName",parameter.getName());
        assertEquals(false,parameter.getName().equals("parameter"));

    }

    public void testSetDescription() {
        //arrange
        Parameter parameter = new Parameter("code","parameter","description","category");

        //coding
        parameter.setDescription("newDescription");

        //assert
        assertEquals("newDescription",parameter.getDescription());
        assertEquals(false,parameter.getDescription().equals("description"));
    }

    public void testSetCategory() {
        //arrange
        Parameter parameter = new Parameter("code","parameter","description","category");

        //coding
        parameter.setCategory("newCategory");

        //assert
        assertEquals("newCategory",parameter.getCategory());
        assertEquals(false,parameter.getCategory().equals("category"));
    }

    public void testTestToString() {
        //arrange
        Parameter parameter = new Parameter("code","parameter","description","category");

        //assert
        assertEquals(false,parameter.toString().equals(" "));

    }
}