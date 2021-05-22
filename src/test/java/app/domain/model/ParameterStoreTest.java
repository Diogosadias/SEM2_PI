package app.domain.model;

import app.domain.model.stores.ParameterStore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class ParameterStoreTest {
    ParameterStore storeTest = new ParameterStore();
    Parameter p1 = new Parameter("1111t", "test", "this is a test", "11111");

    @Test
    public void testCreateParameter() {
        Parameter p2 = storeTest.createParameter("1111t","test","this is a test", "11111");
        //assert
        assertEquals(p1.getCode(),p2.getCode());
        assertEquals(p1.getName(),p2.getName());
        assertEquals(p1.getDescription(),p2.getDescription());
        assertEquals(p1.getCategory(),p2.getCategory());
    }

    @Test
    public void testCreateParameterWithNullValues(){
        assertNull(storeTest.createParameter(null, null, null, null));
    }

    @Test
    public void testDeleteParameter(){
        Parameter p2 = storeTest.createParameter("1111t","test","this is a test", "11111");
        storeTest.saveParameter(p2);
        boolean delete = storeTest.deleteParameter(p2.getCode());
        boolean contains = storeTest.getParameterList().contains(p2);
        assertTrue(delete && !contains);
    }

    @Test
    public void testDeleteNullParameter(){
        assertFalse(storeTest.deleteParameter(null));
    }

    @Test
    public void testDeleteNonExistentParameter(){
        assertFalse(storeTest.deleteParameter("DOESNT EXIST"));
    }


    @Test
    public void testGetParameterByCode(){
        Parameter p2 = storeTest.createParameter("1111t","test","this is a test", "11111");
        storeTest.saveParameter(p2);
        assertEquals(p2 , storeTest.getParameterByCode(p2.getCode()));
    }

    @Test
    public void testGetParameterByCodeIsNotNull(){
        Parameter p2 = storeTest.createParameter("1111t","test","this is a test", "11111");
        storeTest.saveParameter(p2);
        assertNotNull(storeTest.getParameterByCode(p2.getCode()));
    }

    @Test
    public void testGetParameterByNullCode() {
        assertNull(storeTest.getParameterByCode(null));
    }
    @Test
    public void testGetParameterByNonExistantCode(){
        assertNull(storeTest.getParameterByCode("DOESNT EXIST"));
    }

    @Test
    public void testValidateParameter() {
        //calculations
        boolean b = storeTest.validateParameter(p1);
        assertEquals(true,b);
    }
    @Test
    public void testValidateExistentParameter() {
        storeTest.saveParameter(p1);
        boolean b1 = storeTest.validateParameter(p1);
        assertEquals(false,b1);
    }
    @Test
    public void testValidateNullParameter() {
        boolean b2 = storeTest.validateParameter(null);
        assertFalse(b2);
    }


    @Test
    public void testSaveParameter() {
        boolean b = storeTest.saveParameter(p1);
        assertEquals(true,b);

        boolean b1 = storeTest.saveParameter(p1);
        assertEquals(false,b1);
    }

    @Test
    public void testGetParameterList() {
        Parameter p2 = storeTest.createParameter("111at","teast","thias is a test", "11111");
        storeTest.saveParameter(p1);
        storeTest.saveParameter(p2);
        List<Parameter> storeTestList = new ArrayList<>();
        storeTestList.add(p1);
        storeTestList.add(p2);

        assertEquals(storeTestList, storeTest.getParameterList());
    }

    @Test
    public void testGetNotNullParameterList() {
        ParameterStore storetest2 = new ParameterStore();
        assertNotNull(storetest2.getParameterList());
    }

    @Test
    public void testTestToString() {
        Parameter p2 = storeTest.createParameter("1131t","tast","tdhis is a test", "11111");

        storeTest.saveParameter(p1);
        storeTest.saveParameter(p2);
        String check = "Parameter{code='1111t', name='test', description='this is a test', category='11111'}\nParameter{code='1131t', name='tast', description='tdhis is a test', category='11111'}\n";
        assertEquals(check, storeTest.toString());
    }
}