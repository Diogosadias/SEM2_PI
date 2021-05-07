package app.domain.model;

import app.domain.model.CAL;
import app.domain.model.Client;
import auth.domain.model.Email;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ClientTest {



/*
    @Test
    public void testCheckValidation(){

        try{
            Client c1 = new Client(new Email("user1@gmail.com"), "John", 11, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);
        }
        catch (IllegalArgumentException ex){
            assertEquals("NHS number must have 10 chars", ex.getMessage());
        }

        try{
            Client c1 = new Client(new Email("user1@gmail.com"), "John", 1231231231, 11111, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);
        }
        catch (IllegalArgumentException ex){
            assertEquals("Citizen number must have 16 chars", ex.getMessage());
        }
        try{
            Client c1 = new Client(new Email("user1@gmail.com"), "John", 1231231231,1111111111111111l , 11111, new Date("12/12/2021"), "M", 111111111111l);
        }
        catch (IllegalArgumentException ex){
            assertEquals("TIN must have 12 chars",ex.getMessage());
        }


        try{
            Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M", 11111111111L);
            fail();
        }
        catch (IllegalArgumentException ex){
            assertEquals("Phone Number must have 12 chars",ex.getMessage());
        }
        try{
            Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M", 1111111111111L);
            fail();
        }
        catch (IllegalArgumentException ex){
            assertEquals("Phone Number must have 12 chars",ex.getMessage());
        }



        try{
            Client c1 = new Client(new Email("user1@gmail.com"), "John", 1231231231, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "Ah", 111111111111l);
        }
        catch (IllegalArgumentException ex){
            assertEquals("This gender does not exist!",ex.getMessage());
        }


    }
*/
    @Test
    public void testGetNhs() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M", 111111111111L);
        String check = String.valueOf(c1.getCitizenCard());


        //testing
        Assert.assertEquals(1111111111, c1.getNhs());
    }

    @Test
    public void testGetCitizenCard() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M", 111111111111L);
        //testing
        Assert.assertEquals(1111111111111111L, c1.getCitizenCard());
    }

    @Test
    public void testGetTin() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M", 111111111111L);
        //testing
        Assert.assertEquals(111111111111L, c1.getTin());
    }

    @Test
    public void testGetBirthDate() {
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M", 111111111111L);
        //testing
        Assert.assertEquals(new Date("12/12/2021"), c1.getBirthDate());
    }

    @Test
    public void testGetSex() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M", 111111111111L);
        //testing
        Assert.assertEquals("M", c1.getSex());
    }

    @Test
    public void testGetPNumber() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M", 111111111111L);
        //testing
        Assert.assertEquals(111111111111L, c1.getPNumber());
    }

    @Test
    public void testTestGetName() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M", 111111111111L);
        //testing
        Assert.assertEquals("John", c1.getName());
    }

    @Test
    public void testSetId() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M", 111111111111L);

    }

    @Test
    public void testSetNhs() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M", 111111111111L);

        //calculations
        c1.setNhs(1111111112L);

        //assert
        Assert.assertEquals(1111111112L, c1.getNhs());
    }

    @Test
    public void testSetCitizenCard() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M", 111111111111L);

        //calculations
        c1.setCitizenCard(1111111111111112L);

        //aserts
        Assert.assertEquals(1111111111111112L, c1.getCitizenCard());
    }

    @Test
    public void testSetBirthDate() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M", 111111111111L);

        //calculations
        c1.setBirthDate(new Date ("20/08/1997"));
        //assert
        Assert.assertEquals(new Date("20/08/1997"), c1.getBirthDate());


    }



    @Test
    public void testSetTin() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M", 111111111111L);

        //calculations
        c1.setTin(111111111112L);
        //assert
        Assert.assertEquals(111111111112L, c1.getTin());


    }


    @Test
    public void testSetSex() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M", 111111111111L);

        //testing
        c1.setSex("Masculine");
        Assert.assertEquals("Masculine", c1.getSex());
    }

    @Test
    public void testSetPNumber() {
        //preparations
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M", 111111111111L);

        //testing
        c1.setPNumber(111111111112L);

        Assert.assertEquals(111111111112L, c1.getPNumber());

    }

    @Test
    public void checkNHS(){
        try{
            Client c1 = new Client(new Email("user1@gmail.com"), "John", 111111121121L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M", 111111111111L);
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("NHS code must have 10 chars.",ex.getMessage());
        }
        try{
            Client c1 = new Client(new Email("user1@gmail.com"), "John", 111111111221L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M", 111111111111L);
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("NHS code must have 10 chars.",ex.getMessage());
        }
    }


    @Test
    public void checkCitizenNumber(){
    }


    @Test
    public void checkSex(){}

    @Test
    public void checkTIN(){}
    @Test
    public void checkPNumber(){}

    @Test
    public void testToString() {
        //arrange
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M", 111111111111L);

        //assert
        assertEquals(false,c1.toString().equals(" "));

    }
}