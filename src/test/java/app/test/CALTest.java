package app.test;

import app.domain.model.CAL;
import org.junit.Test;

import static org.junit.Assert.*;
public class CALTest {

    @Test
    public void testCheckLabIDrules() {
        //arrange
        //testing

        try{
            CAL cal = new CAL("11as","labName",12345678524L,"Adress",1234567891,true);
            fail();
        }catch(IllegalArgumentException ex){
            assertEquals("Lab Id must have 5 chars.",ex.getMessage());
        }
        try{
            CAL cal = new CAL("11as12","labName",12345678524L,"Adress",1234567891,true);
            fail();
        }catch(IllegalArgumentException ex){
            assertEquals("Lab Id must have 5 chars.",ex.getMessage());
        }
        try{
            CAL cal = new CAL("","labName",12345678524L,"Adress",1234567891,true);
            fail();
        }catch(IllegalArgumentException ex){
            assertEquals("Laboratory Id cannot be blank.",ex.getMessage());
        }
    }

    @Test
    public void checkaddressrules() {
    }

    @Test
    public void checkphoneNumberrules() {
    }

    @Test
    public void checkTINrules() {
    }

    @Test
    public void checkNamerules() {
    }

    @Test
    public void getLabName() {
        //arrange
        CAL cal = new CAL("11asd","labName",12345678524L,"Adress",1234567891,true);
        //asssert
        assertEquals("labName",cal.getLabName());
    }

    @Test
    public void getAddress() {
        //arrange
        CAL cal = new CAL("11asd","labName",12345678524L,"Adress",1234567891,true);
        //assert
        assertEquals("Adress",cal.getAddress());
    }

    @Test
    public void getPhoneNumber() {
        //arrange
        CAL cal = new CAL("11asd","labName",12345678524L,"Adress",1234567891,true);
        //assert
        assertEquals(12345678524L,cal.getPhoneNumber());
    }

    @Test
    public void getTinNumber() {
        //arrange
        CAL cal = new CAL("11asd","labName",12345678524L,"Adress",1234567891,true);
        //assert
        assertEquals(1234567891,cal.getTinNumber());
    }

    @Test
    public void getPerformsCovidTest() {
        //arrange
        CAL cal = new CAL("11asd","labName",12345678524L,"Adress",1234567891,true);
        //assert
        assertEquals(true,cal.getPerformsCovidTest());
    }

    @Test
    public void getLaboratoryId() {
        //arrange
        CAL cal = new CAL("11asd","labName",12345678524L,"Adress",1234567891,true);
        //assert
        assertEquals("11asd",cal.getLaboratoryId());
    }

    @Test
    public void setLabName() {
        //arrange
        CAL cal = new CAL("11asd","labName",12345678524L,"Adress",1234567891,true);
        //Calculations
        cal.setLabName("newLab");
        //assert
        assertEquals("newLab",cal.getLabName());
    }

    @Test
    public void setAddress() {
        //arrange
        CAL cal = new CAL("11asd","labName",12345678524L,"Adress",1234567891,true);
        //Calculations
        cal.setAddress("newAdress");
        //assert
        assertEquals("newAdress",cal.getAddress());
    }

    @Test
    public void setPhoneNumber() {
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
    public void setPerformsCovidTest() {
        //arrange
        CAL cal = new CAL("11asd","labName",12345678524L,"Adress",1234567891,true);
        //Calculations
        cal.setPerformsCovidTest(false);
        //assert
        assertEquals(false,cal.getPerformsCovidTest());
    }

    @Test
    public void setLaboratoryId() {
        //arrange
        CAL cal = new CAL("11asd","labName",12345678524L,"Adress",1234567891,true);
        //Calculations
        cal.setLaboratoryId("22");
        //assert
        assertEquals("22",cal.getLaboratoryId());
    }
}