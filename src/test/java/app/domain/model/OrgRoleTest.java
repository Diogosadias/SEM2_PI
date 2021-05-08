package app.domain.model;

import app.domain.dto.EmployeeDto;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 *
 *  @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class OrgRoleTest {
    OrgRole or = new OrgRole("123","aaaaa");
    @Test
    public void testOrgRole(){
        try{
            OrgRole or2 = new OrgRole(null,null);
            fail();
        }catch(IllegalArgumentException ex){
            assertEquals("Error: at least one of the attributes of OrgRole is null.", ex.getMessage());
        }
        try{
            OrgRole or2 = new OrgRole(null,"aaaaa");
            fail();
        }catch(IllegalArgumentException ex){
            assertEquals("Error: at least one of the attributes of OrgRole is null.", ex.getMessage());
        }
        try{
            OrgRole or2 = new OrgRole("123",null);
            fail();
        }catch(IllegalArgumentException ex){
            assertEquals("Error: at least one of the attributes of OrgRole is null.", ex.getMessage());
        }
    }
    @Test
    public void getDesignation() {
        assertEquals("aaaaa", or.getDesignation());
    }

    @Test
    public void getId() {
        assertEquals("123",or.getId());
    }

    @Test
    public void setDesignation() {
        or.setDesignation("bbbbb");
        assertEquals("bbbbb",or.getDesignation());
    }

    @Test
    public void setId() {
        or.setId("321");
        assertEquals("321",or.getId());
    }
    @Test
    public void createEmployee() {
        OrgRole awd = new OrgRole("1","SpecialistDoctor");
        EmployeeDto daw = new EmployeeDto("1","aowd","ajwdiajd",12313123123l,"ajwdi");
        daw.setId("A00001");
        Employee awdawd = awd.createEmployee(daw);
        boolean a = awdawd.getRole().getId().equals(daw.getRoleId());
        assertTrue(a);

        EmployeeDto daw2 = new EmployeeDto("2","aowd","ajwdiajd",12313123123l,"ajwdi");
        daw2.setId("A00001");
        Employee awdawd2 = awd.createEmployee(daw2);
        boolean a2 = awdawd2.getRole().getId().equals(daw2.getRoleId());
        assertFalse(a2);

        OrgRole awd3 = new OrgRole("3","awd");
        EmployeeDto daw3 = new EmployeeDto("3","aowd","ajwdiajd",12313123123l,"ajwdi");
        daw3.setId("A00001");
        Employee awdawd3 = awd3.createEmployee(daw3);
        boolean a3 = awdawd3.getRole().getId().equals(daw3.getRoleId());
        assertTrue(a3);

    }
    @Test
    public void testEquals() {
        OrgRole or2 = new OrgRole("133","aaaba");
        OrgRole or3 = new OrgRole("123","aaaaa");
        OrgRole or4 = new OrgRole("123","aaaba");
        OrgRole or5 = new OrgRole("113","aaaaa");

        boolean b1 = or.equals(or2);
        boolean b2 = or.equals(or3);
        boolean b3 = or.equals(or);
        boolean b4 = or.equals(or4);
        boolean b5 = or.equals(or5);

        assertFalse(b1);
        assertTrue(b2);
        assertTrue(b3);
        assertFalse(b4);
        assertFalse(b5);
    }
    @Test
    public void testEqualsObject() {
        ParameterCategory pc = new ParameterCategory("aaaaa","aaaaaaaa","aaaaa");

        boolean check = or.equals(pc);
        assertFalse(check);

    }
/*
    @Test
    public void testHashCode() {
    }
*/
    @Test
    public void testToString() {
        assertEquals("OrgRole{id='123', designation='aaaaa'}",or.toString());
    }
}