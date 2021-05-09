package app.controller;

import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class ParameterControllerTest {
    ParameterController controller = new ParameterController();
    Parameter p1 = new Parameter("1111e", "test", "this is a test", "11111");
    Parameter p2 = new Parameter("1111t", "test", "this is a test", "11111");

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

        Parameter test = controller.getParameter(p2.getCode());
        assertEquals(null,test);

        controller.createParameter("1111e", "test", "this is a test", "11111");

        Parameter test2 = controller.getParameter("1111e");
        assertEquals(p1.toString(),test2.toString());

    }

    @Test
    public void saveParameter() {
        boolean test = controller.saveParameter();
        assertEquals(false,test);

    }
}