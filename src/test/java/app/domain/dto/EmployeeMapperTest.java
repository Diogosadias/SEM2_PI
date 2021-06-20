/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.dto;

import app.domain.model.Client;
import app.domain.model.Employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import app.domain.model.OrgRole;
import auth.domain.model.Email;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruno Pereira
 */
public class EmployeeMapperTest {

    EmployeeMapper mapper = new EmployeeMapper();
    EmployeeDto eDto = new EmployeeDto("123", "teste", "teste", 11111111111L, "123");
    Employee e = new Employee(new OrgRole("123", "teste"), "123",  "teste", "teste", 11111111111L, "123");
    List<Employee> employees = new ArrayList<>();

    /**
     * Test of toDto method, of class EmployeeMapper.
     */
    @Test
    public void testToDto() {System.out.println("toDto");
        List<EmployeeDto> expResult = new ArrayList<>();
        eDto.setId("123");
        expResult.add(eDto);
        employees.add(e);
        EmployeeMapper instance = mapper;
        List<EmployeeDto> result = instance.toDto(employees);
        assertEquals(expResult.get(0).getEmployeeId(), result.get(0).getEmployeeId());
    }
    
}
