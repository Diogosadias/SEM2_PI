package app.domain.model;

import auth.AuthFacade;
import auth.domain.model.Email;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ParameterStoreTest {
    ParameterStore storetest = new ParameterStore();
    Parameter p1 = new Parameter("1111t", "test", "this is a test", "11111");
    Parameter p2 = storetest.createParameter("1111t","test","this is a test", "11111");
    @Test
    public void testCreateParameter() {


        //assert
        assertEquals(p1.getCode(),p2.getCode());
        assertEquals(p1.getName(),p2.getName());
        assertEquals(p1.getDescription(),p2.getDescription());
        assertEquals(p1.getCategory(),p2.getCategory());


    }


    @Test
    public void testValidateParameter1() {
        //calculations
        boolean b = storetest.validateParameter(p1);
        assertEquals(true,b);

        storetest.saveParameter(p1);
        boolean b1 = storetest.validateParameter(p1);
        assertEquals(false,b1);

    }


    @Test
    public void testSaveParameter() {
        boolean b = storetest.saveParameter(p1);
        assertEquals(true,b);

        boolean b1 = storetest.saveParameter(p1);
        assertEquals(false,b1);
    }

    @Test
    public void testGetParameterList() {
        storetest.saveParameter(p1);
        storetest.saveParameter(p2);
        List<Parameter> storetest2 = storetest.getParameterList();
        assertEquals(storetest2,storetest.getParameterList());
    }

    @Test
    public void testTestToString() {
        storetest.saveParameter(p1);
        storetest.saveParameter(p2);
        String check = "ParameterCategory{code='1111t', name='test', description='this is a test', category='11111'}\nParameterCategory{code='1111t', name='test', description='this is a test', category='11111'}\n";
        assertEquals(check,storetest.toString());
    }
}