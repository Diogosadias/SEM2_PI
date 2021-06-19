package app.domain.model;

import com.example2.EMRefValue;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class TestParameterResultTest {
    TestParameterResult test = new TestParameterResult("xxx",1.23,new EMRefValue("1111","2",2.1,4.1,new Date(12/12/2021)));

    @Test
    public void testGetResult() {
        assertEquals("xxx",test.getResult());
        //assertNull();
    }

    @Test
    public void testSetResult() {
        try{
            test.setResult(null);
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("Result is Null!",ex.getMessage());
        }
        test.setResult("123");
        assertEquals("123",test.getResult());

    }

    @Test
    public void testGetMetric() {
        double x = 1.23;
        boolean b = false;
        if(x==test.getMetric()) b=true;
        assertTrue(b);

    }

    @Test
    public void testSetMetric() {
        test.setMetric(2.34);
        boolean b = false;
        if(test.getMetric()==2.34) b=true;
        assertTrue(b);
    }

    @Test
    public void testGetRefValue() {
        EMRefValue x = new EMRefValue("1111","2",2.1,4.1,new Date(12/12/2021));
        assertEquals(x,test.getRefValue());

    }

    @Test
    public void testSetRefValue() {
        try{
            test.setRefValue(null);
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("Reference Value is Null!",ex.getMessage());
        }
        test.setRefValue(new EMRefValue("1211","1",2.0,4.1,new Date(12/12/2021)));
        EMRefValue x = new EMRefValue("1211","1",2.0,4.1,new Date(12/12/2021));
        assertEquals(x,test.getRefValue());
    }
}