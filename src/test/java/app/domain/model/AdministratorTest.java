package app.domain.model;

import auth.domain.model.Email;
import auth.domain.model.Password;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdministratorTest {

    Administrator admin = new Administrator(new Email("aaa@aaa.aaa"), new Password("12345"),"Name","adress","11111","aaaaa","11111");

    @Test
    public void testCheckAdressrules(){

        try {
            Administrator admin1 = new Administrator(new Email("aaa@aaa.aaa"), new Password("12345"), "Name", "", "11111", "aaaaa", "11111");
            }catch (IllegalArgumentException ex){
            assertEquals("Address cannot be blank.",ex.getMessage());
        }

        try {
            Administrator admin2 = new Administrator(new Email("aaa@aaa.aaa"), new Password("12345"), "Name", "adressssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss", "11111", "aaaaa", "11111");
        }catch (IllegalArgumentException ex){
            assertEquals("Address must have no more than 30 characters.",ex.getMessage());
        }

    }

    @Test
    public void testcheckStandardOcuppationalCoderules(){

        try{
            Administrator admin = new Administrator(new Email("aaa@aaa.aaa"), new Password("12345"),"Name","adress","11111","","11111");
        }catch (IllegalArgumentException ex){
            assertEquals("SOC cannot be blank.", ex.getMessage());
        }
        try{
            Administrator admin = new Administrator(new Email("aaa@aaa.aaa"), new Password("12345"),"Name","adress","11111","11","11111");
        }catch (IllegalArgumentException ex){
            assertEquals("SOC must have 5 chars.",ex.getMessage());
        }
        try {
            Administrator admin = new Administrator(new Email("aaa@aaa.aaa"), new Password("12345"),"Name","adress","11111","11111111111","11111");
        }catch (IllegalArgumentException ex){
            assertEquals("SOC must have 5 chars.",ex.getMessage());
        }
    }

    @Test
    public void testcheckEmployeeId(){

        try{

            Administrator admin = new Administrator(new Email("aaa@aaa.aaa"), new Password("12345"),"Name","adress","11111","aaaaa","");
        }catch (IllegalArgumentException ex){
            assertEquals("Employee ID cannot be blank.", ex.getMessage());
        }
        try {

            Administrator admin = new Administrator(new Email("aaa@aaa.aaa"), new Password("12345"),"Name","adress","11111","aaaaa","1");
        }catch (IllegalArgumentException ex){
            assertEquals("Employee ID must have 5 chars.",ex.getMessage());
        }
        try{

            Administrator admin = new Administrator(new Email("aaa@aaa.aaa"), new Password("12345"),"Name","adress","11111","aaaaa","111111111111111");
        }catch (IllegalArgumentException ex){
            assertEquals("Employee ID must have 5 chars.",ex.getMessage());
        }
    }

}