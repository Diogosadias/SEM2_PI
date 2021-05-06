package app.domain.model;

import auth.AuthFacade;
import auth.domain.model.Email;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class ParameterStoreTest {
    ParameterStore storetest = new ParameterStore();
    Parameter p1 = new Parameter("1111t", "test", "this is a test", "11111");
    @Test
    public void testCreateParameter() {
        //arrange

        Parameter p2 = storetest.createParameter("1111t","test","this is a test", "11111");



        //assert
        assertEquals(p1.getCode(),p2.getCode());
        assertEquals(p1.getName(),p2.getName());
        assertEquals(p1.getDescription(),p2.getDescription());
        assertEquals(p1.getCategory(),p2.getCategory());


    }


    @Test
    public void testGetParameterByCode1() {

    }
    @Test
    public void testGetParameterByCode2() {

    }

    @Test
    public void testValidateParameter1() {
        //calculations
        boolean b = storetest.validateParameter(p1);
        assertEquals(true,b);

    }
    @Test
    public void testValidateParameter2(){
        //calculations
        storetest.saveParameter(p1);
        boolean b = storetest.validateParameter(p1);
        assertEquals(false,b);
    }


    @Test
    public void testSaveParameter() {
    }

    @Test
    public void testGetParameterList() {
    }

    @Test
    public void testTestToString() {
    }
}