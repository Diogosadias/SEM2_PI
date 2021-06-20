package app.domain.model;

import app.domain.dto.EmployeeDto;


import app.domain.dto.EmployeeMapper;
import app.domain.shared.GenerateEmployeeId;
import auth.AuthFacade;
import junit.framework.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static app.domain.shared.Constants.*;
import static junit.framework.TestCase.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Bruno Pereira
 */
public class EmployeeStoreTest  {

    OrgRole role = new OrgRole(RECEPTIONIST, MODEL_CLASS_PATH+ ROLE_RECEP);
    AuthFacade authFacade = new AuthFacade();
    EmployeeDto dto = new EmployeeDto(role.getId(),"name","address",12312312312L,"soc");
    Employee e1;
    OrgRoleStore ors = new OrgRoleStore();
    EmployeeStore es = new EmployeeStore(ors, new AuthFacade());


    public EmployeeStoreTest() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException{
        authFacade.addUserRole(RECEPTIONIST,RECEPTIONIST);
        dto.setId("J00001");
        e1 = new Employee(role, dto);
        ors.addOrgRole(role);
        es.registerEmployee(dto);
    }


/*    @Test
    public void testGetOrgRoles() {
        System.out.println("GetOrgRoles");
        List<OrgRole> expResult = new ArrayList();
        expResult.add(new OrgRole("role_1",SPECIALIST_DOCTOR));
        expResult.add(new OrgRole("role_2",LABORATORY_COORDINATOR));
        expResult.add(new OrgRole("role_3",CHEMISTRY_TECHNOLOGIST));
        expResult.add(new OrgRole("role_4",MEDICAL_LAB_TECHNICIAN));
        expResult.add(new OrgRole("role_5",ROLE_RECEP));
        expResult.add(new OrgRole("role_6",ROLE_ADMIN));

        es.addOrgRole(new OrgRole("role_1",SPECIALIST_DOCTOR));
        es.addOrgRole(new OrgRole("role_2",LABORATORY_COORDINATOR));
        es.addOrgRole(new OrgRole("role_3",CHEMISTRY_TECHNOLOGIST));
        es.addOrgRole(new OrgRole("role_4",MEDICAL_LAB_TECHNICIAN));
        es.addOrgRole(new OrgRole("role_5",ROLE_RECEP));
        es.addOrgRole(new OrgRole("role_6",ROLE_ADMIN));
        assertEquals(expResult, es.getOrgRoles());




    }*/

    @Test
    public void testRegisterEmployee() {
        System.out.println("RegisterEmployee");
        boolean expResult = true;
        boolean result = false;
        try {
            result = es.registerEmployee(dto);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        assertEquals(expResult, result);
    }

    @Test
    public void testGenerateEmployeeId() {
        System.out.println("GenerateEmployeeId");
        String expResult = new GenerateEmployeeId(e1.getName(),es.getNumEmployees()).getId();
        String result = "N00001";
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNumEmployees() {
        System.out.println("GetNumEmployees");
        int expResult = 0;
        int result = es.getNumEmployees();
        assertEquals(expResult, result);
    }

 /*  @Test
    public void testGetRoleById() {
        System.out.println("GetRoleById");
        OrgRole expResult = new OrgRole("role_5",ROLE_RECEP);
        e1 =
        OrgRole result = es.getRoleById("role_5");
        assertEquals(expResult , result);
    }
*/
    @Test
    public void testValidateEmployee() {
        System.out.println("ValidateEmployee");
        boolean b = es.validateEmployee(e1);
        assertEquals(true,b);
        es.saveEmployee();
        boolean b1 = es.validateEmployee(e1);
        assertEquals(false,b1);
        boolean b2 = es.validateEmployee(e1);
        assertFalse(b2);
    }

    @Test
    public void testSaveEmployee() {
        System.out.println("SaveEmployee");
        boolean b = es.saveEmployee();
        assertEquals(false,b);
        //Correct Later
    }


    @Test
    public void registerEmployee() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        EmployeeDto edto = null;
        assertEquals(es.registerEmployee(dto), true);
    }

    /**
     * Test of confirmRegistration method, of class EmployeeStore.
     */
    @Test
    public void testConfirmRegistration() {
        System.out.println("confirmRegistration");
        EmployeeStore instance = es;
        int expResult = es.getNumEmployees();
        instance.confirmRegistration();
        int result = es.getNumEmployees();
        assertNotSame(expResult, result);
    }

    /**
     * Test of addEmployee method, of class EmployeeStore.
     */
    @Test
    public void testAddEmployee() {
        System.out.println("addEmployee");
        Employee employee = e1;
        EmployeeStore instance = es;
        boolean expResult = true;
        boolean result = instance.addEmployee(employee);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeEmployee method, of class EmployeeStore.
     */
    @Test
    public void testRemoveEmployee() {
        System.out.println("removeEmployee");
        EmployeeStore instance = es;
        int expResult = instance.getNumEmployees();
        instance.removeEmployee();
        int result = instance.getNumEmployees();
        assertNotSame(expResult, result);
    }

    @Test
    public void testGetEmployee() {
        System.out.println("getEmployee");
        EmployeeStore instance = es;
        Employee expResult = e1;
        Employee result = instance.getEmployee();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmployeeToString method, of class EmployeeStore.
     */
    @Test
    public void testGetEmployeeToString() {
        System.out.println("getEmployeeToString");
        EmployeeStore instance = es;
        String expResult = "[Name: NAME]\n" +
                "[Adress: ADDRESS]\n" +
                "[Email: N00001@lei.pt]\n" +
                "[id: N00001]\n" +
                "[Phone Number: 12312312312]\n" +
                "[Soc code: soc]\n";
        if(instance.getEmployee().getRole().getId().equals(SPECIALIST_DOCTOR)) {
            SpecialistDoctor temp = (SpecialistDoctor)instance.getEmployee();
            expResult = expResult + "[Doctor Index Number: " + temp.getDoctorIndexNumber() + "]\n" + "";
        }
        String result = instance.getEmployeeToString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmployeesToShow method, of class EmployeeStore.
     */
    @Test
    public void testGetEmployeesToShow() {
        System.out.println("getEmployeesToShow");
        EmployeeStore instance = es;
        List expResult = new ArrayList<>();
        List result = instance.getEmployeesToShow();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetFileName() {
        System.out.println("GetFileName");
        EmployeeStore instance = es;
        String expResult = "ser/employee.txt";
        String result = instance.getFileName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRoleStore method, of class EmployeeStore.
     */
    @Test
    public void testGetListObjects() {
        System.out.println("GetListObjects");
        EmployeeStore instance = es;
        OrgRoleStore expResult = ors;
        OrgRoleStore result = instance.getRoleStore();
        assertEquals(expResult, result);
    }
}