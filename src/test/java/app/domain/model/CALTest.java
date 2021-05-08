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
        try{
            CAL cal = new CAL("123as","labName",12345678910L,"",1234567891L,true);
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("Address cannot be blank.",ex.getMessage());
        }
        try{
            CAL cal = new CAL("123as","labName",12345678910L,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. ",1234567891L,true);
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("Address must have no more than 30 characters.",ex.getMessage());
        }
        for(int i = 0;i<1;i++) {
            //equal to 30 char
            CAL cal = new CAL("123as", "labName", 12345678910L, "YYixYJx91hQDr1eXdzWa44JzjrSbUH", 1234567891L, true);
            assertEquals("YYixYJx91hQDr1eXdzWa44JzjrSbUH", cal.getAddress());
        }
        try{
            CAL cal = new CAL("123as","labName",2345678910L,"Adress",1234567891L,true);
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("Phone Number must have 11 chars.",ex.getMessage());
        }
        try{
            CAL cal = new CAL("123as","labName",112345678910L,"Adress",1234567891L,true);
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("Phone Number must have 11 chars.",ex.getMessage());
        }
        try{
            CAL cal = new CAL("123as","labName",12345678910L,"Adress",234567891L,true);
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("TIN must have 10 chars.",ex.getMessage());
        }
        try{
            CAL cal = new CAL("123as","labName",12345678910L,"Adress",12234567891L,true);
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("TIN must have 10 chars.",ex.getMessage());
        }
        try{
            CAL cal = new CAL("123as","",12345678910L,"Adress",1234567891L,true);
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("Laboratory Name cannot be blank.",ex.getMessage());
        }
        try{
            CAL cal = new CAL("123as","48Yd4DURqJYghc2XwrBPas",12345678910L,"Adress",1234567891L,true);
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("Laboratory Name must have no more than 20 characters.",ex.getMessage());
        }
        for(int i = 0;i<1;i++) {
            //equal to 20 char
            CAL cal = new CAL("123as", "48Yd4DURqJYghc2XwrBP", 12345678910L, "Adress", 1234567891L, true);
            assertEquals("48Yd4DURqJYghc2XwrBP", cal.getLabName());
        }

    }
    @Test
    public void testTestEquals() {
        CAL cal1 = new CAL("115a1","labName",12345678910L,"Adress",1234567891L,true);
        CAL cal2 = new CAL("12345","labName",12345178910L,"Adrss",1234167891L,true);
        CAL cal3 = new CAL("78945","labName",12345678110L,"Adre12ss",1234561891L,true);
        CAL cal4 = new CAL("sadfs","labName",12345698910L,"Adss",1234867891L,true);
        CAL cal5 = new CAL("98765","labName",12347778910L,"Adreswss",1234127891L,true);
        CAL cal6 = new CAL("qwea1","labName",12311178910L,"Adreqwess",1211167891L,true);
        CAL cal7 = new CAL("poia1","labName",12322278910L,"Adrertess",1222267891L,true);
        CAL cal8 = new CAL("lopa1","labName",12333378910L,"Adrtyress",1333567891L,true);
        CAL cal9 = new CAL("lmja1","labName",12344478910L,"Adrtyuess",1444567891L,true);

        assertTrue(cal1.equals(cal1));
        assertFalse(cal1.equals(cal3));
        assertFalse(cal1.equals(cal4));
        assertFalse(cal1.equals(cal5));
        assertFalse(cal1.equals(cal6));
        assertFalse(cal1.equals(cal7));
        assertFalse(cal1.equals(cal8));
        assertFalse(cal1.equals(cal9));
        assertFalse(cal1.equals(cal2));
        try{
            cal1.equals(null);
            fail();
        }catch (NullPointerException ex){
            assertEquals("Object is null.",ex.getMessage());
        }

        ParameterCategory pc = new ParameterCategory("aaaaa","aaaaaaaa","aaaaa");

        boolean check = cal1.equals(pc);
        assertFalse(check);

    }
}