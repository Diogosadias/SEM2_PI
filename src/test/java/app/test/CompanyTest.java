package app.test;

import app.domain.model.CAL;
import app.domain.model.CALStore;
import app.domain.model.Company;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompanyTest {

    @Test
    public void testGetCalStore() {
        //preparations
        CAL cal1 = new CAL("11asd","labNams",12345678524L,"Adress",1234567891,true);
        CAL cal2 = new CAL("11asd","labNams",12345678524L,"Adress",1234567891,true);
        CALStore calList = new CALStore();
        Company comp1 = new Company("asd");
        Company comp2 = new Company("qwe");
        calList.saveCAL(cal1);
        comp1.setCalStore(calList);
        comp2.setCalStore(calList);
        CALStore calList2 = calList;

        //testing
        assertEquals(comp1.getCalStore(),comp2.getCalStore());
        calList2.saveCAL(cal2);
        comp2.setCalStore(calList2);
        assertEquals(comp1.getCalStore(),comp2.getCalStore());
        calList.saveCAL(cal2);
        assertEquals(comp1.getCalStore(),(comp2.getCalStore()));



    }

    @Test
    public void testSetCalStore() {
        //preparations
        CAL cal1 = new CAL("11asd","labNams",12345678524L,"Adress",1234567891,true);
        CAL cal2 = new CAL("11asd","labNams",12345678524L,"Adress",1234567891,true);
        CAL cal3 = new CAL("11asw","labNams",12345671524L,"Adreqs",1234567391,false);
        CALStore calList1 = new CALStore();
        calList1.saveCAL(cal1);
        calList1.saveCAL(cal2);
        Company comp = new Company("designation");
        comp.setCalStore(calList1);
        CALStore calList2 = calList1;
        calList2.saveCAL(cal3);
        Company comp1 = new Company("as");
        comp1.setCalStore(calList2);


        //testing
        assertEquals(calList1,comp.getCalStore());
        assertEquals(false,comp1.equals(comp));
        comp1.setCalStore(calList1);
        assertEquals(calList1,comp1.getCalStore());

    }
}