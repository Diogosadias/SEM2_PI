package app.domain.model;

import app.domain.dto.EmployeeDto;
import auth.domain.model.Email;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 *
 * @author Tiago Rocha
 *  @author Márcio Ramos <1201682@isep.ipp.pt>
**/
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
            Employee e = new Employee(new OrgRole("12345","safdxfasf"), "1111", "John", "Address", 1234561781231231912L,"12345" );
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
        assertEquals("1111@lei.pt",e1.getEmail());
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
        assertEquals("1111@lei.pt",e1.getEmail());
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

        Employee a = new Employee(new OrgRole("11111","safdxfasf"), "1111", "John", "Address", 12345678912L,"12345" );
        Employee b = new Employee(new OrgRole("12345","safwadawdxfasf"), "1111", "John", "Address", 12345678912L,"12345" );
        Employee c = new Employee(new OrgRole("12345","safdxfasf"), "1121", "John", "Address", 12345678912L,"12345" );
        Employee d = new Employee(new OrgRole("12345","safdxfasf"), "1111", "Johnw", "Address", 12345678912L,"12345" );
        Employee e = new Employee(new OrgRole("12345","safdxfasf"), "1111", "John", "Addressa", 12345678912L,"12345" );
        Employee f = new Employee(new OrgRole("12345","safdxfasf"), "1111", "John", "Address", 12345678942L,"12345" );
        Employee g = new Employee(new OrgRole("12345","safdxfasf"), "1111", "John", "Address", 12345678912L,"12245" );

        assertTrue(e1.equals(e1));
        assertFalse(e1.equals(a));
        assertFalse(e1.equals(b));
        assertTrue(e1.equals(c));
        assertFalse(e1.equals(d));
        assertFalse(e1.equals(e));
        assertFalse(e1.equals(f));
        assertFalse(e1.equals(g));
        try{
        e1.equals(null);
        fail();
        }catch (NullPointerException ex){
            assertEquals("Object is null.",ex.getMessage());
        }

        ParameterCategory pc = new ParameterCategory("aaaaa","aaaaaaaa","aaaaa");

        boolean check = e1.equals(pc);
        assertFalse(check);

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
