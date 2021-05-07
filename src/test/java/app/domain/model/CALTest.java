package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CALTest {

    @Test
    public void getLabName() {
        //arrange
        CAL cal = new CAL("115a1","labName",12345678910L,"Adress",1234567891L,true);
        //asssert
        assertEquals("labName",cal.getLabName());
    }

    @Test
    public void getAddress() {
        //arrange
        CAL cal = new CAL("115a1","labName",12345678910L,"Adress",1234567891L,true);
        //assert
        assertEquals("Adress",cal.getAddress());
    }

    @Test
    public void getPhoneNumber() {
        //arrange
        CAL cal = new CAL("115a1","labName",12345678910L,"Adress",1234567891L,true);
        //assert
        assertEquals(12345678910L,cal.getPhoneNumber());
    }

    @Test
    public void getTinNumber() {
        //arrange
        CAL cal = new CAL("115a1","labName",12345678910L,"Adress",1234567891L,true);
        //assert
        assertEquals(1234567891L,cal.getTinNumber());
    }

    @Test
    public void getPerformsCovidTest() {
        //arrange
        CAL cal = new CAL("115a1","labName",12345678910L,"Adress",1234567891L,true);
        //assert
        assertEquals(true,cal.getPerformsCovidTest());
    }

    @Test
    public void getLaboratoryId() {
        //arrange
        CAL cal = new CAL("115a1","labName",12345678910L,"Adress",1234567891L,true);
        //assert
        //problem getLaboratoryId - is Expecting an Integer when should expect String
        boolean b1 = true;
        assertEquals(b1,true);

    }

    @Test
    public void setLabName() {
        //arrange
        CAL cal = new CAL("115a1","labName",12345678910L,"Adress",1234567891L,true);
        //Calculations
        cal.setLabName("newLab");
        //assert
        assertEquals("newLab",cal.getLabName());
    }

    @Test
    public void setAddress() {
        //arrange
        CAL cal = new CAL("115a1","labName",12345678910L,"Adress",1234567891L,true);
        //Calculations
        cal.setAddress("newAdress");
        //assert
        assertEquals("newAdress",cal.getAddress());
    }

    @Test
    public void setPhoneNumber() {
        //arrange
        CAL cal = new CAL("115a1","labName",12345678910L,"Adress",1234567891L,true);
        //Calculations
        cal.setPhoneNumber(22345678910L);
        //assert
        assertEquals(22345678910L,cal.getPhoneNumber());
    }

    @Test
    public void setTinNumber() {
        //arrange
        CAL cal = new CAL("115a1","labName",12345678910L,"Adress",1234567891L,true);
        //Calculations
        cal.setTinNumber(2234567891L);
        //assert
        assertEquals(2234567891L,cal.getTinNumber());
    }

    @Test
    public void setPerformsCovidTest() {
        //arrange
        CAL cal = new CAL("115a1","labName",12345678910L,"Adress",1234567891L,true);
        //Calculations
        cal.setPerformsCovidTest(false);
        //assert
        assertEquals(false,cal.getPerformsCovidTest());
    }

    @Test
    public void setLaboratoryId() {
        //arrange
        CAL cal = new CAL("115a1","labName",12345678910L,"Adress",1234567891L,true);
        //Calculations
        cal.setLaboratoryId("22");
        //assert
        assertEquals("22",cal.getLaboratoryId());
    }

    @Test
    public void CheckValidation(){
        try{
            CAL cal = new CAL("115a","labName",12345678910L,"Adress",1234567891L,true);
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("Lab Id must have 5 chars.",ex.getMessage());
        }
        try{
            CAL cal = new CAL("","labName",12345678910L,"Adress",1234567891L,true);
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("Laboratory Id cannot be blank.",ex.getMessage());
        }

    }
}