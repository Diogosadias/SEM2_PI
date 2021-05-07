package app.test;

import app.domain.model.Administrator;
import auth.domain.model.Email;
import auth.domain.model.Password;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdministratorTest {

    @Test
    public void getAdress() {
        //arrange
        Administrator admin = new Administrator(new Email("user@gmail.com"),new Password("aaaa"),"John", "Adress","111111111111","Admin","1111");

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
        //arrange
        Administrator admin = new Administrator(new Email("user@gmail.com"),new Password("aaaa"),"John", "Adress","111111111111","Admin","1111");

        //assert
        assertEquals("Admin",admin.getStandardOcuppationalCode());

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
        //arrange
        Administrator admin = new Administrator(new Email("user@gmail.com"),new Password("aaaa"),"John", "Adress","111111111111","Admin","1111");

        //assert
        assertEquals("1111",admin.getEmployeeId());

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

}