package app.domain.model;

import junit.framework.TestCase;
import org.junit.Test;


public class CompanyTest extends TestCase {

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
        assertNotNull(test.getCreateClientStore());
    }

    @Test
    public void testGetParameterCategoryStore() {
        assertNotNull(test.getParameterCategoryStore());
    }

    @Test
    public void testGetSpecifyNewTestStore() {
        assertNotNull(test.getSpecifyNewTestStore());
    }

    @Test
    public void testGetEmployeeStore() {
        assertNotNull(test.getEmployeeStore());
    }

    @Test
    public void testGetParameterStore() {
        assertNotNull(test.getParameterStore());
    }

}