package app.domain.model;

import org.junit.Test;
import static org.junit.Assert.*;


public class EmployeeTest {
    Employee e1 = new Employee(new OrgRole("12345","safdxfasf"), "1111", "John", "Address", 12345678912L,"12345" );

    @Test
    public void testCheck() {

        try{
            Employee e = new Employee(new OrgRole("12345","safdxfasf"), "1111", "John", "Address", 1234567912L,"12345" );
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("Phone Number must have 11 chars.",ex.getMessage());
        }
        try{
            Employee e = new Employee(new OrgRole("12345","safdxfasf"), "1111", "John", "Address", 123456178912L,"12345" );
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("Phone Number must have 11 chars.",ex.getMessage());
        }
        for(int i = 0;i<1;i++) {
            Employee e = new Employee(new OrgRole("12345","safdxfasf"), "1111", "John", "Address", 12345678912L,"12345" );
            assertEquals(12345678912L, e.getPhoneNumber());
        }


        try{
            Employee e = new Employee(new OrgRole("12345","safdxfasf"), "", "John", "Address", 12345678912L,"12345" );
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("Employee Id cannot be blank.",ex.getMessage());
        }

        try{
            Employee e = new Employee(new OrgRole("12345","safdxfasf"), "1111", "", "Address", 12345678912L,"12345" );
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("Name cannot be blank.",ex.getMessage());
        }
        try{
            Employee e = new Employee(new OrgRole("12345","safdxfasf"), "1111", "John", "", 12345678912L,"12345" );
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("Address cannot be blank.",ex.getMessage());
        }
        try{
            Employee e = new Employee(new OrgRole("12345","safdxfasf"), "1111", "John", "Address", 12345678912L,"" );
            fail();
        }catch (IllegalArgumentException ex){
            assertEquals("SOC cannot be blank.",ex.getMessage());
        }
    }

    @Test
    public void testGenerateEmail() {
    }
    @Test
    public void testGetEmployeeId() {
    }
    @Test
    public void testGetRole() {
    }
    @Test
    public void testTestGetName() {
    }
    @Test
    public void testGetAddress() {
    }
    @Test
    public void testGetPhoneNumber() {
    }
    @Test
    public void testGetSocCode() {
    }
    @Test
    public void testGetEmail() {
    }
    @Test
    public void testSetEmployeeId() {
    }
    @Test
    public void testSetRole() {
    }
    @Test
    public void testTestSetName() {
    }
    @Test
    public void testSetAddress() {
    }
    @Test
    public void testSetPhoneNumber() {
    }
    @Test
    public void testSetSocCode() {
    }
    @Test
    public void testSetEmail() {
    }
    @Test
    public void testTestEquals() {
    }
    @Test
    public void testTestHashCode() {
    }
    @Test
    public void testTestToString() {

        //assert
        assertEquals(false,e1.toString().equals(" "));
    }
}