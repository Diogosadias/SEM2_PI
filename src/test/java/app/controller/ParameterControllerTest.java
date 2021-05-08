package app.controller;

import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParameterControllerTest {
    ParameterController controller = new ParameterController();
    Parameter p1 = new Parameter("1111t", "test", "this is a test", "11111");
    @Test
    public void createParameter() {
        boolean test = controller.createParameter("1111e", "test", "this is a test", "11111");
        //assert
        assertEquals(true,test);
    }

    @Test
    public void deleteParameter() {
        boolean test = controller.deleteParameter(p1.getCode());
        assertEquals(false,test);
    }

    @Test
    public void getParameter() {
        Parameter test = controller.getParameter(p1.getCode());
        assertEquals(null,test);


    }
    @Test
    public void getParameter2(){
        controller.createParameter("1111t", "test", "this is a test", "11111");

        Parameter test = controller.getParameter("1111t");
        assertEquals(p1.toString(),test.toString());
    }

    @Test
    public void saveParameter() {
        boolean test = controller.saveParameter();
        assertEquals(false,test);

    }
}