package app.test;

import app.domain.model.CAL;
import app.domain.model.CALStore;
import app.domain.model.Client;
import auth.domain.model.Email;
import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.*;

public class CALStoreTest {


    @Test
    public void testRegisterNewCAL() {
        CAL cal1 = new CAL("11asd","labNams",12345678524L,"Adress",1234567891,true);
        CALStore calList = new CALStore();

        CAL cal2 = calList.registerNewCAL("11a85","labNams",12345678523L,"Adress",1214567891,true);

        assertEquals(false,cal2.getTinNumber()== cal1.getTinNumber());
        assertEquals(true,cal2.getAddress().equals(cal1.getAddress()));
        //assertEquals(false,cal2.getLaboratoryId().equals(cal1.getLaboratoryId()));

    }

    @Test
    public void testValidateCAL() {
        //preparations
        CAL cal1 = new CAL("11asd","labNams",12345678524L,"Adress",1234567891,true);
        CAL cal2 = new CAL("11a85","labNams",12345678523L,"Adress",1234567891,true);

        CALStore calList = new CALStore();


        boolean b = calList.validateCAL(cal1);

        //testing
        assertEquals(true,b);
        calList.saveCAL(cal1);
        assertEquals(false,calList.validateCAL(cal2));

    }

    @Test
    public void testSaveCAL() {
        CAL cal1 = new CAL("11asd","labNams",12345678524L,"Adress",1234567891L,true);
        CAL cal2 = new CAL("11a85","labNams",12345678523L,"Adress",1234567891L,true);
        CAL cal3 = new CAL("11aqw","labNams",12345688523L,"Route X",2234567891L,false);

        CALStore calList = new CALStore();


        boolean b = calList.saveCAL(cal1);

        //testing
        assertEquals(false,calList.validateCAL(cal1));
        assertEquals(false,calList.validateCAL(cal2));
        assertEquals(true,calList.validateCAL(cal3));
    }
}