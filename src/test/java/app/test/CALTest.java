package app.test;

import app.domain.model.CAL;
import org.junit.Test;

import static org.junit.Assert.*;
public class CALTest {




    @Test
    public void testGetLabName() {
        //arrange
        CAL cal = new CAL("11asd","labName",12345678524L,"Adress",1234567891,true);
        //asssert
        assertEquals("labName",cal.getLabName());
    }

    @Test
    public void testGetAddress() {
        //arrange
        CAL cal = new CAL("11asd","labName",12345678524L,"Adress",1234567891,true);
        //assert
        assertEquals("Adress",cal.getAddress());
    }

    @Test
    public void testGetPhoneNumber() {
        //arrange
        CAL cal = new CAL("11asd","labName",12345678524L,"Adress",1234567891,true);
        //assert
        assertEquals(12345678524L,cal.getPhoneNumber());
    }

    @Test
    public void testGetTinNumber() {
        //arrange
        CAL cal = new CAL("11asd","labName",12345678524L,"Adress",1234567891,true);
        //assert
        assertEquals(1234567891,cal.getTinNumber());
    }

    @Test
    public void testGetPerformsCovidTest() {
        //arrange
        CAL cal = new CAL("11asd","labName",12345678524L,"Adress",1234567891,true);
        //assert
        assertEquals(true,cal.getPerformsCovidTest());
    }

    @Test
    public void testGetLaboratoryId() {
        //arrange
        CAL cal = new CAL("11asd","labName",12345678524L,"Adress",1234567891,true);
        //assert
        assertEquals("11asd",cal.getLaboratoryId());
    }

    @Test
    public void testSetLabName() {
        //arrange
        CAL cal = new CAL("11asd","labName",12345678524L,"Adress",1234567891,true);
        //Calculations
        cal.setLabName("newLab");
        //assert
        assertEquals("newLab",cal.getLabName());
    }

    @Test
    public void testSetAddress() {
        //arrange
        CAL cal = new CAL("11asd","labName",12345678524L,"Adress",1234567891,true);
        //Calculations
        cal.setAddress("newAdress");
        //assert
        assertEquals("newAdress",cal.getAddress());
    }

    @Test
    public void testSetPhoneNumber() {
        //arrange
        CAL cal = new CAL("11asd","labName",12345678524L,"Adress",1234567891,true);
        //Calculations
        cal.setPhoneNumber(1112);
        //assert
        assertEquals(1112,cal.getPhoneNumber());
    }

    @Test
    public void setTinNumber() {
        //arrange
        CAL cal = new CAL("11asd","labName",12345678524L,"Adress",1234567891,true);
        //Calculations
        cal.setTinNumber(2222);
        //assert
        assertEquals(2222,cal.getTinNumber());
    }

    @Test
    public void testSetPerformsCovidTest() {
        //arrange
        CAL cal = new CAL("11asd","labName",12345678524L,"Adress",1234567891,true);
        //Calculations
        cal.setPerformsCovidTest(false);
        //assert
        assertEquals(false,cal.getPerformsCovidTest());
    }

    @Test
    public void testSetLaboratoryId() {
        //arrange
        CAL cal = new CAL("11asd","labName",12345678524L,"Adress",1234567891,true);
        //Calculations
        cal.setLaboratoryId("22");
        //assert
        assertEquals("22",cal.getLaboratoryId());
    }

}