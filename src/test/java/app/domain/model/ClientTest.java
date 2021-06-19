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

/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */

public class ClientTest {
    //preparations
    Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 1111111111L, new Date("12/12/2021"), "M", 11111111111L);
    Client c2 = new Client(1111111111111111L);
    /*Client c2 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M");

        public void testClient(){
            Email a = new Email("user1@gmail.com");
            String b = "John";
            long c = 1111111111L;
            long d = 1111111111111111L;
            Date e = new Date("12/12/2021");
            String f = "M";
            assertEquals(a,c2.getId());
            assertEquals(b,c2.getName());
            assertEquals(c,c2.getNhs());
            assertEquals(d,c2.getCitizenCard());
            assertEquals(e,c2.getBirthDate());
            assertEquals(f,c2.getSex());
        }
*/

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
        String check = String.valueOf(c1.getCitizenCard());


        //testing
        Assert.assertEquals(1111111111, c1.getNhs());
    }

    @Test
    public void testGetCitizenCard() {
        //testing
        Assert.assertEquals(1111111111111111L, c1.getCitizenCard());
    }

    @Test
    public void testGetTin() {

        //testing
        Assert.assertEquals(1111111111L, c1.getTin());
    }

    @Test
    public void testGetBirthDate() {
        //testing
        Assert.assertEquals(new Date("12/12/2021"), c1.getBirthDate());
    }

    @Test
    public void testGetSex() {
        //testing
        Assert.assertEquals("M", c1.getSex());
    }

    @Test
    public void testGetPNumber() {
        //testing
        Assert.assertEquals(11111111111L, c1.getPNumber());
    }

    @Test
    public void testTestGetName() {
        //testing
        Assert.assertEquals("John", c1.getName());
    }

    @Test
    public void testSetId() {
        c1.setId(new Email("antonio@gmail.com"));
        Assert.assertEquals(new Email("antonio@gmail.com"), c1.getId());

    }

    @Test
    public void testSetNhs() {

        //calculations
        c1.setNhs(1111111112L);

        //assert
        Assert.assertEquals(1111111112L, c1.getNhs());
    }

    @Test
    public void testSetCitizenCard() {

        //calculations
        c1.setCitizenCard(1111111111111112L);

        //assert
        Assert.assertEquals(1111111111111112L, c1.getCitizenCard());
    }

    @Test
    public void testSetBirthDate() {

        //calculations
        c1.setBirthDate(new Date ("20/08/1997"));
        //assert
        Assert.assertEquals(new Date("20/08/1997"), c1.getBirthDate());


    }



    @Test
    public void testSetTin() {

        //calculations
        c1.setTin(1111111112L);
        //assert
        Assert.assertEquals(1111111112L, c1.getTin());


    }


    @Test
    public void testSetSex() {


        //testing
        c1.setSex("Masculine");
        Assert.assertEquals("Masculine", c1.getSex());
    }

    @Test
    public void testSetPNumber() {

        //testing
        c1.setPNumber(11111111112L);

        Assert.assertEquals(11111111112L, c1.getPNumber());

    }
    @Test
    public void testSetName(){
        c1.setName("Josef");
        Assert.assertEquals("Josef", c1.getName());
    }

    @Test
    public void checkNHS(){
        try{
            Client c1 = new Client(new Email("user1@gmail.com"), "John", 111111121121L, 1111111111111111L, 1111111111L, new Date("12/12/2021"), "M", 11111111111L);
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("NHS code must have 10 chars.",ex.getMessage());
        }
        try{
            Client c1 = new Client(new Email("user1@gmail.com"), "John", 111111111221L, 1111111111111111L, 1111111111L, new Date("12/12/2021"), "M", 11111111111L);
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("NHS code must have 10 chars.",ex.getMessage());
        }



    }

    @Test
    public void checkCitizenNumber(){
        try{
            Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 111111111111121111L, 1111111111L, new Date("12/12/2021"), "M", 11111111111L);
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("Citizen Card code must have 16 chars.",ex.getMessage());
        }
        try{
            Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 111111111211121111L, 1111111111L, new Date("12/12/2021"), "M", 11111111111L);
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("Citizen Card code must have 16 chars.",ex.getMessage());
        }
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111211L, 1111111111L, new Date("12/12/2021"), "M", 11111111111L);

    }

    @Test
    public void checkSex(){
        try{
            Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 1111111111L, new Date("12/12/2021"), "Y", 11111111111L);
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("You must define your sex as 'M' or 'F'.",ex.getMessage());
        }
        try{
            Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 1111111111L, new Date("12/12/2021"), "I", 11111111111L);
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("You must define your sex as 'M' or 'F'.",ex.getMessage());
        }
        try{
            Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 1111111111L, new Date("12/12/2021"), "M", 11111111111L);
        }catch (IllegalArgumentException ex){
            assertEquals("You must define your sex as 'M' or 'F'.",ex.getMessage());
        }
        try{
            Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 1111111111L, new Date("12/12/2021"), null, 11111111111L);
        }catch (IllegalArgumentException ex){
            assertEquals("Cannot be Null",ex.getMessage());
        }

    }

    @Test
    public void checkTIN(){
        try{
            Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111112L, new Date("12/12/2021"), "M", 11111111111L);

        }catch (IllegalArgumentException ex){
            assertEquals("TIN code must have 10 chars.",ex.getMessage());
        }
        try{
            Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111112L, 1111111111111112L, 1111111111112L, new Date("12/12/2021"), "M", 11111111111L);

        }catch (IllegalArgumentException ex){
            assertEquals("TIN code must have 10 chars.",ex.getMessage());
        }
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111112L, 1111111111111112L, 1111111112L, new Date("12/12/2021"), "M", 11111111111L);

    }

    @Test
    public void checkPNumber(){
        try{
            Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 1111111111L, new Date("12/12/2021"), "M", 1111111111L);
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("Phone Number must have 11 chars.",ex.getMessage());
        }

        try{
            Client c1 = new Client(new Email("user2@gmail.com"), "John", 1111111112L, 1111111111111141L, 1111116111L, new Date("12/12/2021"), "M", 111111111111111111L);
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("Phone Number must have 11 chars.",ex.getMessage());
        }
        Client c1 = new Client(new Email("user2@gmail.com"), "John", 1111111112L, 1111111111111141L, 1111116111L, new Date("12/12/2021"), "M", 12345678901L);


    }

    @Test
    public void testToString() {

        //assert
        assertEquals(false,c1.toString().equals(" "));

    }
}