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
    }

    @Test
    public void testGetRefValue() {
        EMRefValue x = new EMRefValue("1111","2",2.1,4.1,new Date(12/12/2021));
        assertEquals(x,test.getRefValue());

    }

    @Test
    public void testSetRefValue() {
    }
}