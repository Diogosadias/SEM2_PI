package app.test;

import app.domain.model.Client;
import auth.domain.model.Email;
import junit.framework.TestCase;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ClientTest extends TestCase {

    @Test
    public void testCheckNHS() {

        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111L, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);
        Client c2 = new Client(new Email("user2@gmail.com"), "Mari", 111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);

        //testing
        c1.checkNHS(c1.getNhs());

        try{
           c2.checkNHS(c2.getNhs());
           fail();
        }catch (IllegalArgumentException ex){
        assertEquals("NHS number must have 10 chars",ex.getMessage());}

    }

    @Test
    public void testCheckCitizenNumber() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);
        Client c2 = new Client(new Email("user2@gmail.com"), "Mari", 1111111111, 11111, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);

        //testing
        c1.checkCitizenNumber(c1.getCitizenCard());

        try{
            c2.checkCitizenNumber(c2.getCitizenCard());
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("Citizen number must have 16 chars",ex.getMessage());
        }

    }

    @Test
    public void testCheckTIN() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);
        Client c2 = new Client(new Email("user2@gmail.com"), "Mari", 1111111111, 1111111111111111l, 111111, new Date("12/12/2021"), "M", 111111111111l);

        //testing
        c1.checkTIN(c1.getTin());

        try{
            c2.checkTIN(c2.getTin());
            fail();
        }catch (IllegalArgumentException ex)
        {
            assertEquals("TIN must have 12 chars",ex.getMessage());
        }
    }

    @Test
    public void testCheckPNumber() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 1111111111111111111l);
        Client c2 = new Client(new Email("user2@gmail.com"), "Mari", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 1111111);

        //testing

        try{
            c2.checkPNumber(c2.getPNumber());
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("Phone Number must have 12 chars", ex.getMessage());
        }

        Client c3 = new Client(new Email("user2@gmail.com"), "Mari", 111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 11111111111l);
        try{
            c3.checkPNumber(c3.getPNumber());

        }catch(IllegalArgumentException ex){
            assertEquals("Phone Number must have 12 chars", ex.getMessage());
        }

    }

    @Test
    public void testCheckSex() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);
        Client c2 = new Client(new Email("user2@gmail.com"), "Mari", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "Hello", 111111111111l);

        //testing
        c1.checkSex(c1.getSex());

        try{
            c2.checkSex(c2.getSex());
            fail();
        }catch(IllegalArgumentException ex){
            assertEquals("This gender does not exist!",ex.getMessage());
        }
    }

    @Test
    public void testGetNhs() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);
        //testing
        assertEquals(1111111111, c1.getNhs());
    }

    @Test
    public void testGetCitizenCard() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);
        //testing
        assertEquals(1111111111111111l,c1.getCitizenCard());
    }

    @Test
    public void testGetTin() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);
        //testing
        assertEquals(111111111111l,c1.getTin());
    }

    @Test
    public void testGetBirthDate() {
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);
        //testing
        assertEquals(new Date("12/12/2021"), c1.getBirthDate());
    }

    @Test
    public void testGetSex() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);
        //testing
        assertEquals("M",c1.getSex());
    }

    @Test
    public void testGetPNumber() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);
        //testing
        assertEquals(111111111111l,c1.getPNumber());
    }

    @Test
    public void testTestGetName() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);
        //testing
        assertEquals("John", c1.getName());
    }

    @Test
    public void testSetId() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);

    }

    @Test
    public void testSetNhs() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);

        //calculations
        c1.setNhs(1234567891);

        //assert
        assertEquals(1234567891, c1.getNhs());
    }

    @Test
    public void testSetCitizenCard() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);

        //calculations
        c1.setCitizenCard(1231231231231231l);

        //aserts
        assertEquals(1231231231231231l, c1.getCitizenCard());
    }

    @Test
    public void testSetBirthDate() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);

        //calculations
        c1.setBirthDate(new Date ("20/08/1997"));
        //assert
        assertEquals(new Date("20/08/1997"),c1.getBirthDate());


    }



    @Test
    public void testSetTin() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);

        //calculations
        c1.setTin(222222222222l);
        //assert
        assertEquals(222222222222l,c1.getTin());


    }


    @Test
    public void testSetSex() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);

        //testing
        c1.setSex("Masculine");
        assertEquals("Masculine",c1.getSex());
    }

    @Test
    public void testSetPNumber() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);

        //testing
        c1.setPNumber(222222222222l);

        assertEquals(222222222222l,c1.getPNumber());

    }
}