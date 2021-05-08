package app.domain.model;

import junit.framework.TestCase;
import org.junit.Test;

public class SpecialistDoctorTest extends TestCase {

    OrgRole testRole = new OrgRole("testOrgRole_1", "TEST SUBJECT");
    SpecialistDoctor testDoc = new SpecialistDoctor(testRole, "TT000001", "name", "address",
            12345678900L, "1234567890", 1234567890);

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
    public void testTestEquals() {
        SpecialistDoctor testDoc2 = new SpecialistDoctor(testRole, "TT000001", "name", "address",
                12345678900L, "1234567890", 1234567890);
        assertTrue(testDoc.equals(testDoc2));
        testDoc2.setDoctorIndexNumber(1234567888);
    }
}