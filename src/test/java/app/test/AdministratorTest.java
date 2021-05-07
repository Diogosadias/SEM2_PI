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
    Administrator admin = new Administrator(new Email("user@gmail.com"),new Password("aaaa"),"John", "Adress","111111111111","Admin","12345");

    @Test
    public void getAdress() {
        //assert
        assertEquals("Adress",admin.getAdress());
    }

    @Test
    public void setAdress() {
        //arrange
        Administrator admin = new Administrator(new Email("user@gmail.com"),new Password("aaaa"),"John", "Adress","111111111111","Admin","12345");

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
        Administrator admin = new Administrator(new Email("user@gmail.com"),new Password("aaaa"),"John", "Adress","111111111111","Admin","12345");

        //calculations
        admin.setStandardOcuppationalCode("newOcup");
        //assert
        assertEquals("newOcup",admin.getStandardOcuppationalCode());
    }

    @Test
    public void getEmployeeId() {

        //testing
        Assert.assertEquals("12345", admin.getEmployeeId());

    }

    @Test
    public void setEmployeeId() {
        //arrange
        Administrator admin = new Administrator(new Email("user@gmail.com"),new Password("aaaa"),"John", "Adress","111111111111","Admin","12345");
        //Calculations
        admin.setEmployeeId("2222");
        //assert
        assertEquals("2222",admin.getEmployeeId());
    }

    @Test
    public void CheckValidation(){
        try{
            Administrator admin1 = new Administrator(new Email("user@gmail.com"),new Password("aaaa"),"John", "GWrna6FW1lAo1g6lDdNL6j2GxN7uvO4","111111111111","Admin","12345");
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("Address must have no more than 30 characters.",ex.getMessage());
        }
        for(int i = 0;i<1;i++) {
            Administrator admin1 = new Administrator(new Email("user@gmail.com"),new Password("aaaa"),"John", "GWrna6FW1lAo1g6lDdNL6j2GN7uvO4","111111111111","Admin","12345");
            assertEquals("GWrna6FW1lAo1g6lDdNL6j2GN7uvO4", admin1.getAdress());
        }
        try{
            Administrator admin1 = new Administrator(new Email("user@gmail.com"),new Password("aaaa"),"John", "","111111111111","Admin","12345");
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("Address cannot be blank.",ex.getMessage());
        }
        try{
            Administrator admin1 = new Administrator(new Email("user@gmail.com"),new Password("aaaa"),"John", "Adress","111111111111","Admina","12345");
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("SOC must have 5 chars.",ex.getMessage());
        }
        for(int i = 0;i<1;i++) {
            Administrator admin1 = new Administrator(new Email("user@gmail.com"),new Password("aaaa"),"John", "Adress","111111111111","Admin","12345");
            assertEquals("Admin", admin1.getStandardOcuppationalCode());
        }
        try{
            Administrator admin1 = new Administrator(new Email("user@gmail.com"),new Password("aaaa"),"John", "Adress","111111111111","","12345");
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("SOC cannot be blank.",ex.getMessage());
        }
        try{
            Administrator admin1 = new Administrator(new Email("user@gmail.com"),new Password("aaaa"),"John", "Adress","111111111111","Admin","123456");
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("Employee ID must have 5 chars.",ex.getMessage());
        }
        for(int i = 0;i<1;i++) {
            Administrator admin1 = new Administrator(new Email("user@gmail.com"),new Password("aaaa"),"John", "Adress","111111111111","Admin","12345");
            assertEquals("12345", admin1.getEmployeeId());
        }
        try{
            Administrator admin1 = new Administrator(new Email("user@gmail.com"),new Password("aaaa"),"John", "Adress","111111111111","Admin","");
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("Employee ID cannot be blank.",ex.getMessage());
        }


    }

    @Test
    public void testToString() {

        //assert
        assertEquals(false,admin.toString().equals(" "));

    }

}