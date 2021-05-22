package app.domain.model;

import app.domain.dto.EmployeeDto;


import app.domain.shared.GenerateEmployeeId;
import app.domain.model.stores.EmployeeStore;
import app.domain.model.stores.OrgRoleStore;
import auth.AuthFacade;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static app.domain.shared.Constants.*;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

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

//    @Test
//    public void testRegisterEmployee() {        
//        System.out.println("RegisterEmployee");
//        Employee expResult = new Employee(new OrgRole("teste","teste"),new EmployeeDto("teste", "teste", "teste", 12345678900L, "12335"));
//        Employee result = es.registerEmployee(dto);
//        assertEquals(expResult, result); 
//    }

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

/*    @Test
    public void testGetRoleById() {
        System.out.println("GetRoleById");
        OrgRole expResult = new OrgRole("role_5",ROLE_RECEP);
        es.addOrgRole(new OrgRole("role_5",ROLE_RECEP));
        OrgRole result = es.getRoleById("role_5");
        assertEquals(expResult , result);
    }*/

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

//    @Test
//    public void testGetEmployees() {        
//        System.out.println("GetEmployees");              
//        Employee temp = es.registerEmployee(new EmployeeDto("teste2", "teste2", "teste2", 12345678900L, "72612"));
//        es.saveEmployee(temp);
//        List<Employee> result = new ArrayList<>();
//        result.add(temp);        
//        List<Employee> expResult = es.getEmployees();
//        assertEquals(expResult, result);
//    }
}