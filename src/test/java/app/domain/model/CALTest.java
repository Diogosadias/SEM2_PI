package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CALTest {

    @Test
    public void getLabName() {
        //arrange
        CAL cal = new CAL("11","labName",1111,"Adress",1111,true);
        //asssert
        assertEquals("labName",cal.getLabName());
    }

    @Test
    public void getAddress() {
        //arrange
        CAL cal = new CAL("11","labName",1111,"Adress",1111,true);
        //assert
        assertEquals("Adress",cal.getAddress());
    }

    @Test
    public void getPhoneNumber() {
        //arrange
        CAL cal = new CAL("11","labName",1111,"Adress",1111,true);
        //assert
        assertEquals(1111,cal.getPhoneNumber());
    }

    @Test
    public void getTinNumber() {
        //arrange
        CAL cal = new CAL("11","labName",1111,"Adress",1111,true);
        //assert
        assertEquals(1111,cal.getTinNumber());
    }

    @Test
    public void getPerformsCovidTest() {
        //arrange
        CAL cal = new CAL("11","labName",1111,"Adress",1111,true);
        //assert
        assertEquals(true,cal.getPerformsCovidTest());
    }

    @Test
    public void getLaboratoryId() {
        //arrange
        CAL cal = new CAL("11","labName",1111,"Adress",1111,true);
        //assert
        assertEquals(11,cal.getLaboratoryId());
    }

    @Test
    public void setLabName() {
        //arrange
        CAL cal = new CAL("11","labName",1111,"Adress",1111,true);
        //Calculations
        cal.setLabName("newLab");
        //assert
        assertEquals("newLab",cal.getLabName());
    }

    @Test
    public void setAddress() {
        //arrange
        CAL cal = new CAL("11","labName",1111,"Adress",1111,true);
        //Calculations
        cal.setAddress("newAdress");
        //assert
        assertEquals("newAdress",cal.getAddress());
    }

    @Test
    public void setPhoneNumber() {
        //arrange
        CAL cal = new CAL("11","labName",1111,"Adress",1111,true);
        //Calculations
        cal.setPhoneNumber(1112);
        //assert
        assertEquals(1112,cal.getPhoneNumber());
    }

    @Test
    public void setTinNumber() {
        //arrange
        CAL cal = new CAL("11","labName",1111,"Adress",1111,true);
        //Calculations
        cal.setTinNumber(2222);
        //assert
        assertEquals(2222,cal.getTinNumber());
    }

    @Test
    public void setPerformsCovidTest() {
        //arrange
        CAL cal = new CAL("11","labName",1111,"Adress",1111,true);
        //Calculations
        cal.setPerformsCovidTest(false);
        //assert
        assertEquals(false,cal.getPerformsCovidTest());
    }

    @Test
    public void setLaboratoryId() {
        //arrange
        CAL cal = new CAL("11","labName",1111,"Adress",1111,true);
        //Calculations
        cal.setLaboratoryId("22");
        //assert
        assertEquals("22",cal.getLaboratoryId());
    }
}