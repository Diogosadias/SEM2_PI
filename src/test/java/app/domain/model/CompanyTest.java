package app.domain.model;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 */

public class CompanyTest{

    Company test = new Company("TEST");

    @Test
    public void testCompanyConstructor(){
        Company test1 = new Company("TEST");
        assertNotNull(test1);
        assertEquals(test1.getDesignation(), test.getDesignation());
    }
    @Test
    public void testCompanyConstructorBlankDesignation(){
        try{
            Company test1 = new Company("");
            fail("No Illegal Argument Exception!");
        }catch(IllegalArgumentException ex){
            assertEquals("Designation cannot be blank.", ex.getMessage());
        }
    }

    @Test
    public void testGetAuthFacade(){
        assertNotNull(test.getAuthFacade());
    }

    @Test
    public void testGetTestTypeStore() {
        assertNotNull(test.getTestTypeStore());
    }

    @Test
    public void testGetDesignation() {
        String designation = test.getDesignation();
        assertEquals(designation, "TEST");
    }

    @Test
    public void testGetCalStore() {
        assertNotNull(test.getCalStore());
    }

    @Test
    public void testGetCreateClientStore() {
        assertNotNull(test.getClientStore());
    }

    @Test
    public void testGetParameterCategoryStore() {
        assertNotNull(test.getParameterCategoryStore());
    }

    @Test
    public void testGetEmployeeStore() {
        assertNotNull(test.getEmployeeStore());
    }

    @Test
    public void testGetParameterStore() {
        assertNotNull(test.getParameterStore());
    }

    @Test
    public void testGetReportStore() {
        assertNotNull(test.getReportStore());
    }

    @Test
    public void testGetSampleStore() {
        assertNotNull(test.getSampleStore());
    }

    /**
     * Test of setCalStore method, of class Company.
     */
    @Test
    public void testSetCalStore() {
        System.out.println("setCalStore");
        CALStore calStore = new CALStore();
        Company instance = test;
        instance.setCalStore(calStore);
        assertNotNull(test.getCalStore());
    }

    /**
     * Test of getClientStore method, of class Company.
     */
    @Test
    public void testGetClientStore() {
        System.out.println("getClientStore");
        assertNotNull(test.getClientStore());
    }

    /**
     * Test of setClientStore method, of class Company.
     */
    @Test
    public void testSetClientStore() {
        System.out.println("setClientStore");
        ClientStore clientStore = new ClientStore(test.getAuthFacade());
        Company instance = test;
        instance.setClientStore(clientStore);
        assertNotNull(test.getClientStore());
    }

    /**
     * Test of setParameterCategoryStore method, of class Company.
     */
    @Test
    public void testSetParameterCategoryStore() {
        System.out.println("setParameterCategoryStore");
        ParameterCategoryStore parameterCategoryStore = new ParameterCategoryStore();
        Company instance = test;
        instance.setParameterCategoryStore(parameterCategoryStore);
        assertNotNull(test.getClientStore());
    }

    /**
     * Test of setTestTypeStore method, of class Company.
     */
    @Test
    public void testSetTestTypeStore() {
        System.out.println("setTestTypeStore");
        TestTypeStore testTypeStore = new TestTypeStore();
        Company instance = test;
        instance.setTestTypeStore(testTypeStore);
        assertNotNull(test.getTestTypeStore());
    }

    /**
     * Test of setEmployeeStore method, of class Company.
     */
    @Test
    public void testSetEmployeeStore() {
        System.out.println("setEmployeeStore");
        EmployeeStore employeeStore = new EmployeeStore(test.getOrgRoleStore(), test.getAuthFacade());
        Company instance = test;
        instance.setEmployeeStore(employeeStore);
        assertNotNull(test.getEmployeeStore());
    }

    /**
     * Test of setParameterStore method, of class Company.
     */
    @Test
    public void testSetParameterStore() {
        System.out.println("setParameterStore");
        ParameterStore parameterStore = new ParameterStore();
        Company instance = test;
        instance.setParameterStore(parameterStore);
        assertNotNull(test.getParameterStore());
    }

    /**
     * Test of getOrgRoleStore method, of class Company.
     */
    @Test
    public void testGetOrgRoleStore() {
        System.out.println("getOrgRoleStore");
        assertNotNull(test.getOrgRoleStore());
    }

    /**
     * Test of getTestStore method, of class Company.
     */
    @Test
    public void testGetTestStore() {
        System.out.println("getTestStore");
        assertNotNull(test.getTestStore());
    }

    /**
     * Test of setSampleStore method, of class Company.
     */
    @Test
    public void testSetSampleStore() {
        System.out.println("setSampleStore");
        SampleStore sampleStore = new SampleStore();
        Company instance = test;
        instance.setSampleStore(sampleStore);
        assertNotNull(test.getSampleStore());
    }
}