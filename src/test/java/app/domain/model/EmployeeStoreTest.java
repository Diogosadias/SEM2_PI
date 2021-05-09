package app.domain.model;

import app.domain.dto.EmployeeDto;
import static app.domain.shared.Constants.*;
import auth.AuthFacade;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.*;

/**
 *
 * @author Bruno Pereira
 */
public class EmployeeStoreTest  {
    Employee e1 = new Employee(new OrgRole("12345","safdxfasf"), "1111", "John", "Address", 12345678912L,"12345" );
    EmployeeDto dto = new EmployeeDto("teste", "teste", "teste", 12345678912L, "12335");
    EmployeeStore es = new EmployeeStore();  
    
    @Test
    public void testGetOrgRoles() {        
        System.out.println("GetOrgRoles");
        List<OrgRole> expResult = new ArrayList();
        expResult.add(new OrgRole("role_1",SPECIALIST_DOCTOR));
        expResult.add(new OrgRole("role_2",LABORATORY_COORDINATOR));
        expResult.add(new OrgRole("role_3",CHEMISTRY_TECHNOLOGIST));
        expResult.add(new OrgRole("role_4",MEDICAL_LAB_TECHNICIAN));
        expResult.add(new OrgRole("role_5",ROLE_RECEP));
        expResult.add(new OrgRole("role_6",ROLE_ADMIN));
        List<OrgRole> result = es.getOrgRoles();
        assertEquals(expResult, result);      


    }

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
        String expResult = es.generateEmployeeId(e1.getName());
        String result = "J00001";
        assertEquals(expResult, result);    
    }

    @Test
    public void testGetNumEmployees() {     
        System.out.println("GetNumEmployees");   
        int expResult = 0;
        int result = es.getNumEmployees();
        assertEquals(expResult, result);    
    }

    @Test
    public void testGetRoleById() {         
        System.out.println("GetRoleById");
        OrgRole expResult = new OrgRole("role_5",ROLE_RECEP);
        OrgRole result = es.getRoleById("role_5");        
        assertEquals(expResult , result);  
    }

    @Test
    public void testValidateEmployee() {                
        System.out.println("ValidateEmployee");
        boolean b = es.validateEmployee(e1);
        assertEquals(true,b);
        es.saveEmployee(e1);
        boolean b1 = es.validateEmployee(e1);
        assertEquals(false,b1);
        boolean b2 = es.validateEmployee(e1);
        assertFalse(b2);
    }

    @Test
    public void testSaveEmployee() {       
        System.out.println("SaveEmployee");    
        boolean b = es.saveEmployee(e1);
        assertEquals(true,b);
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