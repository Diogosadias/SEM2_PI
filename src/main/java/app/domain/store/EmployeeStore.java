package app.domain.store;

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
        int id = nEmp++;
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
        return initials + fillZeros + "" + nEmp++;
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
            for (Employee e : this.le) {
                if (e.equals(employee)) {
                    throw new IllegalArgumentException("Employee already exists.");
                }
            }

        }
        
        return true;
        
    }
    
    public boolean saveEmployee(Employee employee){
        if (employee == null) {
            throw new IllegalArgumentException("Error: Employee is null.");
        }
        this.numEmployees++;
        return this.le.add(employee);
    }
        
    
}
