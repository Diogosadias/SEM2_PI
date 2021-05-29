package app.domain.model;

import auth.AuthFacade;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class ChemistryTechnologistTest {
    OrgRole testRole = new OrgRole("testOrgRole_1", "TEST SUBJECT");

    @Test
    public void testChemistryTechnologist(){
        Employee test = new Employee(testRole, "1111", "John", "Address", 12345678912L,"12345" );
        ChemistryTechnologist ct1 = new ChemistryTechnologist(test);
        ChemistryTechnologist ct2 = new ChemistryTechnologist(testRole, "1111", "John", "Address", 12345678912L,"12345" );
    }
}