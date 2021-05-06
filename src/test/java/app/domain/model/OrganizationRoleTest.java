package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrganizationRoleTest {

    @Test
    public void getDesignation() {

        //arrange
        OrganizationRole role = new OrganizationRole("designation",11);

        //asserts
        assertEquals("designation",role.getDesignation());
    }

    @Test
    public void getDoctorIndexNumber() {

        //arrange
        OrganizationRole role = new OrganizationRole("designation",11);

        //asserts
        assertEquals(11,role.getDoctorIndexNumber());
    }

    @Test
    public void setDesignation() {

        //arrange
        OrganizationRole role = new OrganizationRole("designation",11);

        //calculations
        role.setDesignation("newDesignation");
        //asserts
        assertEquals("newDesignation",role.getDesignation());
        assertEquals(false,role.getDesignation().equals("designation"));
    }

    @Test
    public void setDoctorIndexNumber() {

        //arrange
        OrganizationRole role = new OrganizationRole("designation",11);

        //calculations
        role.setDoctorIndexNumber(12);
        //asserts
        assertEquals(12,role.getDoctorIndexNumber());
        assertEquals(false,role.getDoctorIndexNumber() == 11);
    }

    @Test
    public void testEquals() {

        //arrange
        OrganizationRole role = new OrganizationRole("ADMINISTRATOR",11);
        OrganizationRole rolew = new OrganizationRole("Role",14);
        Parameter parameter = new Parameter("code","parameter","description","category");
        boolean b = role.equals(new OrganizationRole("ADMINISTRATOR",12));
        boolean b2 = rolew.equals(role);

        //asserts
        assertEquals(false,role.equals(rolew));
        assertEquals(false,b);
        assertEquals(false,b2);
        assertEquals(false,equals(parameter));
        assertEquals(true,role.equals(role));
        assertEquals(false,equals(role));
    }

    @Test
    public void testHashCode() {

        //arrange
        OrganizationRole role = new OrganizationRole("designation",11);
        OrganizationRole role2 = new OrganizationRole("designations",12);


        //calculations
        int i = role.hashCode();
        int j = role.hashCode();
        boolean f;
        //asserts
        if(i == j)
            f = true;
        else
            f = false;
        assertEquals(true, f);
        assertEquals(true,role.hashCode() != 0);



    }
}