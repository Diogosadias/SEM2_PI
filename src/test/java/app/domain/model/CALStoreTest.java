package app.domain.model;

import org.junit.Test;


import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

public class CALStoreTest {
    CAL cal1 = new CAL("11asd", "labNams", 12345678524L, "Adress", 1234567891, true);
    CALStore calList = new CALStore();

    @Test
    public void testRegisterNewCAL() {
        CAL cal2 = calList.registerNewCAL("11asd", "labNams", 12345678524L, "Adress", 1234567891, true);
        assertEquals(cal1.getLaboratoryId(), cal2.getLaboratoryId());
        assertEquals(cal1.getLabName(), cal2.getLabName());
        assertEquals(cal1.getPhoneNumber(), cal2.getPhoneNumber());
        assertEquals(cal1.getAddress(), cal2.getAddress());
        assertEquals(cal1.getTinNumber(), cal2.getTinNumber());

        //testing
        assertNull(calList.registerNewCAL(null, null, 1234567891L, null, 12345678912L, true));
        assertNull(calList.registerNewCAL("11a85", null, 12345678524L, null, 1234567891, true));
        assertNull(calList.registerNewCAL("11a85", null, 12345678524L, "Adress", 1234567891, true));
        assertNull(calList.registerNewCAL("11a85", "labNams", 12345678524L, null, 1234567891, true));
        assertNull(calList.registerNewCAL(null, null, 12345678524L, "Adress", 1234567891, true));
        assertNull(calList.registerNewCAL(null, "labNams", 12345678524L, "Adress", 1234567891, true));
        assertNull(calList.registerNewCAL(null, "labNams", 12345678524L, null, 1234567891, true));


    }
    @Test
    public void testValidateCAL () {
        //testing
        boolean b = calList.validateCAL(cal1);
        assertEquals(true,b);
        calList.saveCAL(cal1);
        boolean b1 = calList.validateCAL(cal1);
        assertEquals(false,b1);
        assertFalse(calList.validateCAL(null));


    }

    @Test
    public void testSaveCAL () {
        //testing

        boolean b = calList.saveCAL(cal1);
        assertEquals(true,b);

        boolean b1 = calList.saveCAL(cal1);
        assertEquals(false,b1);
    }
}
