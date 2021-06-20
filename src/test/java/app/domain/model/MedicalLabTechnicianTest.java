package app.domain.model;

import org.junit.Test;

public class MedicalLabTechnicianTest {
    OrgRole testRole = new OrgRole("testOrgRole_1", "TEST SUBJECT");

    @Test
    public void testMedicalLabTechnician() {
        Employee test = new Employee(testRole, "1111", "John", "Address", 12345678912L,"12345" );
        MedicalLabTechnician mlt1 = new MedicalLabTechnician(test);
        MedicalLabTechnician mlt2 = new MedicalLabTechnician(testRole, "1111", "John", "Address", 12345678912L,"12345" );
    }

}