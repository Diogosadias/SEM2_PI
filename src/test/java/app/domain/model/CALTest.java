package app.domain.model;

import junit.framework.TestCase;
import org.junit.Test;

public class CALTest extends TestCase {

    @Test
    public void testGetAddress() {
        CAL cal = new CAL("111","hello",1111,"adress",1000,true);

        assertEquals("adress",cal.getAddress());
    }
}