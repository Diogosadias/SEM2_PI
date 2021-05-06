package app.domain.model;

import auth.domain.model.Email;
import org.junit.Test;


import java.util.Date;

import static org.junit.Assert.*;

public class ClientTest {

    Client c1 = new Client(new Email("aaa@user.com"),"John",1111111111,123123123123123l,123123123123l,new Date("12/12/2012"),"M",123123123123l);
    Client c2 = new Client(new Email("user2@gmail.com"), "Mari", 111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);


    @Test
    public void getNhs() {
        assertEquals(1111111111,c1.getNhs());
    }

    @Test
    public void getCitizenCard() {
        assertEquals(123123123123123l,c1.getCitizenCard());
    }

    @Test
    public void getTin() {
        assertEquals(123123123123l,c1.getTin());
    }

    @Test
    public void getBirthDate() {
        assertEquals(new Date("12/12/2012"),c1.getBirthDate());
    }

    @Test
    public void getSex() {
        assertEquals("M",c1.getSex());
    }

    @Test
    public void getPNumber() {
        assertEquals(123123123123l,c1.getPNumber());
    }

    @Test
    public void getName() {
        assertEquals("John",c1.getName());
    }

    @Test
    public void setName() {
        //calculations
        c1.setName("James");
        //asserts
        assertEquals("James",c1.getName());
        assertEquals(false,c1.getName().equals("John"));
    }

    @Test
    public void getId() {
        assertEquals(new Email("aaa@user.com"),c1.getId());
    }

    @Test
    public void setId() {

        //calculations
        c1.setId(new Email("user@user.com"));
        //assert
        assertEquals(new Email("user@user.com"),c1.getId());
    }

    @Test
    public void setNhs() {
        //calculations
        c1.setNhs(1111111113l);
        //assert
        assertEquals(1111111113l,c1.getNhs());
        assertEquals(false,c1.getNhs() == 1111111111l);
    }

    @Test
    public void setCitizenCard() {
        //calculations
        c1.setCitizenCard(123123123123124l);
        //assert
        assertEquals(123123123123124l,c1.getCitizenCard());
        assertEquals(false, c1.getCitizenCard() ==123123123123123l );
    }

    @Test
    public void setBirthDate() {
        //calculations
        c1.setBirthDate(new Date("13/13/2013"));
        //assert
        assertEquals(new Date("13/13/2013"),c1.getBirthDate());
        assertEquals(false,c1.getBirthDate() == new Date("12/12/2012"));
    }

    @Test
    public void setTin() {
        //calculations
        c1.setTin(123123123124l);
        //asserts
        assertEquals(123123123124l,c1.getTin());
        assertEquals(false,c1.getTin() == 123123123123l);
    }

    @Test
    public void setSex() {
        //calculations
        c1.setSex("Masculine");
        //asserts
        assertEquals("Masculine",c1.getSex());
        assertEquals(false,c1.getSex().equals("M"));
    }

    @Test
    public void setPNumber() {
        //calculations
        c1.setPNumber(123123123133l);

        //asserts
        assertEquals(123123123133l,c1.getPNumber());
        assertEquals(false,c1.getPNumber() ==123123123123l);
    }

    @Test
    public void checkNHS() {
        //calculations
        c1.checkNHS(c1.getNhs());

        try{
            c2.checkNHS(c2.getNhs());

        }catch (IllegalArgumentException ex){
            //asserts
            assertEquals("NHS number must have 10 chars",ex.getMessage());}

    }

    @Test
    public void checkCitizenNumber() {


        try{
            c1.checkCitizenNumber(c1.getCitizenCard());
            c2.checkCitizenNumber(c2.getCitizenCard());

        }catch (IllegalArgumentException ex){
            assertEquals("Citizen number must have 16 chars",ex.getMessage());
        }

    }

    @Test
    public void checkTIN() {
        c1.checkTIN(c1.getTin());

        try{
            c2.checkTIN(c2.getTin());

        }catch (IllegalArgumentException ex)
        {
            assertEquals("TIN must have 12 chars",ex.getMessage());
        }
    }

    @Test
    public void checkPNumber() {
        try{
            c2.checkPNumber(c2.getPNumber());

        }catch (IllegalArgumentException ex){
            assertEquals("Phone Number must have 12 chars", ex.getMessage());
        }

        try{
            c1.checkPNumber(c1.getPNumber());

        }catch(IllegalArgumentException ex){
            assertEquals("Phone Number must have 12 chars", ex.getMessage());
        }

    }

    @Test
    public void checkSex() {
        c1.checkSex(c1.getSex());

        try{
            c2.checkSex(c2.getSex());

        }catch(IllegalArgumentException ex){
            assertEquals("This gender does not exist!",ex.getMessage());
        }
    }

    @Test
    public void testToString() {
        String a = "Client{" +
                "nhs=" + c1.getNhs() +
                ", citizenCard=" + c1.getCitizenCard() +
                ", tin=" + c1.getTin() +
                ", birthDate='" + c1.getBirthDate() + '\'' +
                ", sex='" + c1.getSex() + '\'' +
                ", pNumber=" + c1.getPNumber() +
                '}';
        assertEquals(a,c1.toString());
    }

}