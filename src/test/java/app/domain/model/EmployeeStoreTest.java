package app.domain.model;

import auth.domain.model.Email;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeStoreTest  {
    Employee e1 = new Employee(new OrgRole("12345","safdxfasf"), "1111", "John", "Address", 12345678912L,"12345" );
    EmployeeStore es = new EmployeeStore();

    @Test
    public void testAddOrgRoles() {
    }

    @Test
    public void testGetOrgRoles() {
        List<OrgRole> lor = new ArrayList<>();
        assertNull(null);
        try{
            es.setLor(lor);
        } catch (IllegalArgumentException ex) {
            assertEquals("Organization Roles list is empty.", ex.getMessage());
        }


    }

    @Test
    public void testRegisterEmployee() {
    }

    @Test
    public void testGenerateEmployeeId() {
    }

    @Test
    public void testGetNumEmployees() {
    }

    @Test
    public void testGetRoleById() {
    }

    @Test
    public void testValidateEmployee() {
    }

    @Test
    public void testSaveEmployee() {
    }

    @Test
    public void testGetEmployees() {
    }
}