package app.domain.model;

import auth.domain.model.Email;
import junit.framework.TestCase;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientTest extends TestCase {

    @Test
    public void testCheckNHS() {

        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);
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
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);
        Client c2 = new Client(new Email("user2@gmail.com"), "Mari", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 1111111);

    }

    @Test
    public void testCheckSex() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);
        Client c2 = new Client(new Email("user2@gmail.com"), "Mari", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "Hello", 111111111111l);

    }
}