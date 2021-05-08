package app.domain.model;

import auth.domain.model.Email;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

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
        assertEquals("1111@lei.isep.pt",e1.getEmail());
        assertNull(e1.generateEmail(null) );
    }
    @Test
    public void testGetEmployeeId() {
        //testing
        Assert.assertEquals("1111", e1.getEmployeeId());
    }
    @Test
    public void testGetRole() {
        //testing
        Assert.assertEquals(new OrgRole("12345","safdxfasf"), e1.getRole());
    }
    @Test
    public void testTestGetName() {
        //testing
        Assert.assertEquals("John", e1.getName());
    }
    @Test
    public void testGetAddress() {
        //testing
        Assert.assertEquals("Address", e1.getAddress());
    }
    @Test
    public void testGetPhoneNumber() {
        //testing
        Assert.assertEquals(12345678912L, e1.getPhoneNumber());
    }
    @Test
    public void testGetSocCode() {
        //testing
        Assert.assertEquals("12345", e1.getSocCode());
    }
    @Test
    public void testGetEmail() {
        //testing
        assertEquals("1111@lei.isep.pt",e1.getEmail());
    }
    @Test
    public void testSetEmployeeId() {
        e1.setEmployeeId("123456789");
        Assert.assertEquals("123456789", e1.getEmployeeId());
    }
    @Test
    public void testSetRole() {
        e1.setRole(new OrgRole("1111","qwertyuiop"));
        Assert.assertEquals(new OrgRole("1111","qwertyuiop"), e1.getRole());
    }
    @Test
    public void testTestSetName() {
        e1.setName("Diogo");
        Assert.assertEquals("Diogo", e1.getName());
    }
    @Test
    public void testSetAddress() {
        e1.setAddress("Route 66");
        Assert.assertEquals("Route 66", e1.getAddress());
    }
    @Test
    public void testSetPhoneNumber() {
        e1.setPhoneNumber(11345678912L);
        Assert.assertEquals(11345678912L, e1.getPhoneNumber());
    }
    @Test
    public void testSetSocCode() {
        e1.setSocCode("123");
        Assert.assertEquals("123", e1.getSocCode());
    }
    @Test
    public void testSetEmail() {
        e1.setEmail("123@lei.isep.pt");
        Assert.assertEquals("123@lei.isep.pt", e1.getEmail());
    }
    @Test
    public void testTestEquals() {
        assertNull("Object is null",null);
        assertTrue(e1.equals(e1));
    }
    @Test
    public void testTestHashCode() {
        assertEquals(318588947,e1.hashCode());
    }
    @Test
    public void testTestToString() {

        //assert
        assertEquals(false,e1.toString().equals(" "));
    }
}