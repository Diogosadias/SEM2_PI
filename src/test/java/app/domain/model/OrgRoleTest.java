package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrgRoleTest {
    OrgRole or = new OrgRole("123","aaaaa");
    @Test
    public void testOrgRole(){
        try{
            OrgRole or2 = new OrgRole(null,null);
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
/*
    @Test
    public void createEmployee() {

    }
*/
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