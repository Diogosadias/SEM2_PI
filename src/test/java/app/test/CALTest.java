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
            CAL cal = new CAL("11a","labName",12345678524L,"Adress",1234567891,true);
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
    public void testCheckaddressrules() {
        //arrange
        //testing

        try{
            CAL cal = new CAL("11asa","labName",12345678524L,"",1234567891,true);
            fail();
        }catch(IllegalArgumentException ex){
            assertEquals("Address cannot be blank.",ex.getMessage());
        }
        try{
            CAL cal = new CAL("11as1","labName",12345678524L,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. ",1234567891,true);
            fail();
        }catch(IllegalArgumentException ex){
            assertEquals("Address must have no more than 30 characters.",ex.getMessage());
        }

    }

    @Test
    public void testCheckphoneNumberrules() {
        //arrange
        //testing

        try{
            CAL cal = new CAL("11asa","labName",0,"asasa",1234567891,true);
            fail();
        }catch(IllegalArgumentException ex){
            assertEquals("Phone Number must have 11 chars.",ex.getMessage());
        }
        try{
            CAL cal = new CAL("11as1","labName",2345678524L,"asasa ",1234567891,true);
            fail();
        }catch(IllegalArgumentException ex){
            assertEquals("Phone Number must have 11 chars.",ex.getMessage());
        }
        try{
            CAL cal = new CAL("11as1","labName",234567238524L,"asasa ",1234567891,true);
            fail();
        }catch(IllegalArgumentException ex){
            assertEquals("Phone Number must have 11 chars.",ex.getMessage());
        }
    }

    @Test
    public void testCheckTINrules() {
        //arrange

        //testing

        try{
            CAL cal = new CAL("11as1","labName",23672318524L,"asasa ",123467891,true);
            fail();
        }catch(IllegalArgumentException ex){
            assertEquals("TIN must have 10 chars.",ex.getMessage());
        }
    }

    @Test
    public void testCheckNamerules() {
        //arrange
        //testing
        try{
            CAL cal = new CAL("11as1","",23672318524L,"asasa ",1231467891,true);
            fail();
        }catch(IllegalArgumentException ex){
            assertEquals("Laboratory Name cannot be blank.",ex.getMessage());
        }
        try{
            CAL cal = new CAL("11as1","Lorem Ipsum is simply dummy text of the printing and typesetting industry.",23672318524L,"asasa ",1231467891,true);
            fail();
        }catch(IllegalArgumentException ex){
            assertEquals("Laboratory Name must have no more than 20 characters.",ex.getMessage());
        }
    }

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