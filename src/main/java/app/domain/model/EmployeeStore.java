package app.domain.model;

import app.domain.dto.EmployeeDto;
import app.domain.model.Employee;
import app.domain.model.OrgRole;

import java.util.ArrayList;
import java.util.List;

import static app.domain.shared.Constants.*;

/**
 *
 * @author Tiago Rocha
 */
public class EmployeeStore {

    private List<OrgRole> lor;
    private List<Employee> le;
    private int numEmployees=0;
    private final int MAX_NUM_EMPLOYEES = 99999;


    public EmployeeStore () {
        this.lor = new ArrayList<>();
        addOrgRoles();
        this.le = new ArrayList<>();
    }

    public void addOrgRoles () {
        lor.add(new OrgRole("role_1",SPECIALIST_DOCTOR));
        lor.add(new OrgRole("role_2",LABORATORY_COORDINATOR));
        lor.add(new OrgRole("role_3",CHEMISTRY_TECHNOLOGIST));
        lor.add(new OrgRole("role_4",MEDICAL_LAB_TECHNICIAN));
        lor.add(new OrgRole("role_5",RECEPTIONIST));
        lor.add(new OrgRole("role_6",ADMINISTRATOR));
    }

    public List<OrgRole> getOrgRoles () {
        if(lor.isEmpty()) { throw new IllegalArgumentException("Organization Roles list is empty.");}
        return lor;
    }

    public Employee registerEmployee(EmployeeDto eDto) {
        String roleId = eDto.getRoleId();
        OrgRole role = this.getRoleById(roleId);
        eDto.setId(generateEmployeeId(eDto.getName()));
        return role.createEmployee(eDto);
    }

    public String generateEmployeeId(String name) {
        int nEmp = getNumEmployees();
        if (nEmp == MAX_NUM_EMPLOYEES) { throw new IllegalArgumentException("Maximum Employees reached."); };
        // acrescentar +1 ao numero de employees
        int id = nEmp + 1;
        // gerar as inicias do nome
        String initials = "";
        String[] temp = name.split(" ");
        for (int i=0;i< temp.length;i++) {
            initials += temp[i].toUpperCase().charAt(0);
        }
        // acrescentar zeros entre as letras e o numero
        String fillZeros = "";
        for (int i=0;i< 5;i++) {

            if (id % 10 == 0) {
                fillZeros += "0";
            }
            id = id / 10;
        }
        return initials + fillZeros + "" + (nEmp + 1);
    }

    public int  getNumEmployees() {
        return numEmployees;
    }

    public OrgRole getRoleById(String id) {
        for (OrgRole role : this.lor) {
            if(role.getId().equals(id)) return role;
        }
        throw new IllegalArgumentException("There is no Organization Role with that Id.");
    }

    public boolean validateEmployee(Employee employee) {
        if (!this.le.isEmpty()) {
            for (Employee e : le) {
                if (e.getPhoneNumber() == employee.getPhoneNumber()) {
                    System.out.println("Employee already exists.");
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean saveEmployee(Employee employee){
        this.numEmployees++;
        return this.le.add(employee);
    }

    public List<Employee> getEmployees () {
        if(le.isEmpty()) { throw new IllegalArgumentException("Employee list is empty.");}
        return this.le;
    }
        
    
}
