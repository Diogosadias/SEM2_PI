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

        assertEquals(admin.getAdress(),"adress");

        try {
            Administrator admin2 = new Administrator(new Email("aaa@aaa.aaa"), new Password("12345"), "Name", null, "11111", "aaaaa", "11111");
        }catch (IllegalArgumentException ex){
            assertEquals("Address cannot be null.",ex.getMessage());
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

        assertEquals("aaaaa",admin.getStandardOcuppationalCode());

        try {
            Administrator admin2 = new Administrator(new Email("aaa@aaa.aaa"), new Password("12345"), "Name", "adress", "11111", null, "11111");
        }catch (IllegalArgumentException ex){
            assertEquals("SOC cannot be null.",ex.getMessage());
        }
    }

    @Test
    public void testcheckEmployeeId() {

        try {

            Administrator admin = new Administrator(new Email("aaa@aaa.aaa"), new Password("12345"), "Name", "adress", "11111", "aaaaa", "");
        } catch (IllegalArgumentException ex) {
            assertEquals("Employee ID cannot be blank.", ex.getMessage());
        }
        try {

            Administrator admin = new Administrator(new Email("aaa@aaa.aaa"), new Password("12345"), "Name", "adress", "11111", "aaaaa", "1");
        } catch (IllegalArgumentException ex) {
            assertEquals("Employee ID must have 5 chars.", ex.getMessage());
        }
        try {

            Administrator admin = new Administrator(new Email("aaa@aaa.aaa"), new Password("12345"), "Name", "adress", "11111", "aaaaa", "111111111111111");
        } catch (IllegalArgumentException ex) {
            assertEquals("Employee ID must have 5 chars.", ex.getMessage());
        }

        assertEquals("11111",admin.getEmployeeId());

        try {
            Administrator admin2 = new Administrator(new Email("aaa@aaa.aaa"), new Password("12345"), "Name", "adress", "11111", "aaaaa", null);
        }catch (IllegalArgumentException ex){
            assertEquals("Employee ID cannot be null.",ex.getMessage());
        }
    }

        @Test
        public void testsetStandardOcuppationalCode(){
            admin.setStandardOcuppationalCode("fivex");
            assertEquals("fivex",admin.getStandardOcuppationalCode());
            assertEquals(false,admin.getStandardOcuppationalCode().equals("aaaaa"));

        }

        @Test
        public void testsetEmployeeId(){

        admin.setEmployeeId("22222");
        assertEquals("22222",admin.getEmployeeId());
        assertEquals(false,admin.getEmployeeId().equals("11111"));
        }

        @Test
        public void testSetAdress(){

        admin.setAdress("endereco");
        assertEquals("endereco",admin.getAdress());
        assertEquals(false,admin.getAdress().equals("adress"));
        }

        @Test
        public void testGetAdress(){
        assertEquals("adress",admin.getAdress());
        }

        @Test
        public void testEmployeeId(){
        assertEquals("11111",admin.getEmployeeId());
        }

        @Test
        public void testgetStandardOcuppationalCode(){
        assertEquals("aaaaa",admin.getStandardOcuppationalCode());
        }

        @Test
        public void testToString(){
        assertEquals(false,admin.toString().equals("false"));
        }

}