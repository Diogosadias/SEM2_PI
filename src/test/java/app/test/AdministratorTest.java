package app.test;

import app.domain.model.Administrator;
import app.domain.model.CAL;
import app.domain.model.Client;
import auth.domain.model.Email;
import auth.domain.model.Password;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class AdministratorTest {
    Administrator admin = new Administrator(new Email("user@gmail.com"),new Password("aaaa"),"John", "Adress","111111111111","Admin","1111");

    @Test
    public void getAdress() {
        //assert
        assertEquals("Adress",admin.getAdress());
    }

    @Test
    public void setAdress() {
        //arrange
        Administrator admin = new Administrator(new Email("user@gmail.com"),new Password("aaaa"),"John", "Adress","111111111111","Admin","1111");

        //calculations
        admin.setAdress("newAdress");
        //assert
        assertEquals("newAdress",admin.getAdress());
    }

    @Test
    public void getStandardOcuppationalCode() {
        //testing
        Assert.assertEquals("Admin", admin.getStandardOcuppationalCode());

    }

    @Test
    public void setStandardOcuppationalCode() {

        //arrange
        Administrator admin = new Administrator(new Email("user@gmail.com"),new Password("aaaa"),"John", "Adress","111111111111","Admin","1111");

        //calculations
        admin.setStandardOcuppationalCode("newOcup");
        //assert
        assertEquals("newOcup",admin.getStandardOcuppationalCode());
    }

    @Test
    public void getEmployeeId() {

        //testing
        Assert.assertEquals("1111", admin.getEmployeeId());

    }

    @Test
    public void setEmployeeId() {
        //arrange
        Administrator admin = new Administrator(new Email("user@gmail.com"),new Password("aaaa"),"John", "Adress","111111111111","Admin","1111");
        //Calculations
        admin.setEmployeeId("2222");
        //assert
        assertEquals("2222",admin.getEmployeeId());
    }

    @Test
    public void testToString() {

        //assert
        assertEquals(false,admin.toString().equals(" "));

    }

}