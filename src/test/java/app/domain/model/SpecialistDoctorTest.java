package app.domain.model;

import junit.framework.TestCase;
import org.junit.Test;

import static app.domain.shared.Constants.RECEPTIONIST;

/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class SpecialistDoctorTest extends TestCase {

    OrgRole testRole = new OrgRole("testOrgRole_1", "TEST SUBJECT");
    Receptionist employee1 = new Receptionist(testRole, "R00001", "Receptionist1","R1-address",12900000001L,"R1-soc");

    SpecialistDoctor testDoc = new SpecialistDoctor(testRole, "TT000001", "name", "address",
            12345678900L, "1234567890", 1234567890);
    SpecialistDoctor t = new SpecialistDoctor(employee1);
    @Test
    public void testGetDoctorIndexNumber() {
        assertEquals(1234567890, testDoc.getDoctorIndexNumber());
    }
    @Test
    public void testGetDoctorIndexNumberIsNotNull() {
        assertNotNull(testDoc.getDoctorIndexNumber());
    }

    @Test
    public void testSetDoctorIndexNumber() {
        testDoc.setDoctorIndexNumber(1234567891);
    }

    @Test
    public void testEquals() {
        SpecialistDoctor testDoc2 = new SpecialistDoctor(testRole, "TT000001", "name", "address",
                12345678900L, "1234567890", 1234567890);
        assertTrue(testDoc.equals(testDoc2));
        assertTrue(testDoc.equals(testDoc));

    }
    @Test
    public void testEqualsForDifferent() {
        SpecialistDoctor testDoc2 = new SpecialistDoctor(testRole, "TT005001", "tiago tocha", "address",
                12345678900L, "1234567890", 1234567890);
        assertFalse(testDoc.equals(testDoc2));
    }
    @Test
    public void testEqualsForDifferentInstances() {
        String test = new String();
        assertFalse(testDoc.equals(test));
    }
    @Test
    public void testTestEqualsForSuperClass() {
        Employee test = new Employee(new OrgRole("12345","safdxfasf"), "1111", "John", "Address", 12345678912L,"12345" );
        assertFalse(testDoc.equals(test));
    }
    /*@Test
    public void testTestEqualsForDoctorIndexNumber() {
        Employee test = new Employee(testRole, "1111", "John", "Address", 12345678912L,"12345" );
        SpecialistDoctor test2 = new SpecialistDoctor(test);

        testDoc.setDoctorIndexNumber(test2.getDoctorIndexNumber());
        assertEquals(true,testDoc.equals(test2));
    }*/
}