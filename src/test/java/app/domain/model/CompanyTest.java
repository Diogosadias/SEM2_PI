package app.domain.model;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class CompanyTest extends TestCase {

    Company test = new Company("TESTE");

    @Test
    public void testCompanyConstructor(){
        Company test1 = new Company("TESTE");
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
    public void testGetTestTypeStore() {
        SpecifyNewTestStore testStore1 = test.getSpecifyNewTestStore();
        assertNotNull(testStore1);
    }

    public void testSetTestTypeStore() {
    }

    public void testGetDesignation() {
    }

    public void testGetAuthFacade() {
    }

    public void testGetCalStore() {
    }

    public void testSetCalStore() {
    }

    public void testGetCreateClientStore() {
    }

    public void testSetCreateClientStore() {
    }

    public void testGetParameterCategoryStore() {
    }

    public void testSetParameterCategoryStore() {
    }

    public void testGetSpecifyNewTestStore() {
    }

    public void testSetSpecifyNewTestStore() {
    }

    public void testGetEmployeeStore() {
    }

    public void testSetEmployeeStore() {
    }

    public void testGetParameterStore() {
    }

    public void testSetParameterStore() {
    }
}