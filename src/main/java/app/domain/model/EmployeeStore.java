package app.domain.model;

import app.domain.dto.EmployeeDto;
import app.domain.model.Employee;
import app.domain.model.OrgRole;

import java.util.ArrayList;
import java.util.List;

import static app.domain.shared.Constants.*;

/**
 * EmployeeStore - Class responsible for managing Employers.
 *
 * @author Tiago Rocha
 */
public class EmployeeStore {

    /**
     * Initialize a list of roles.
     */
    private  List<OrgRole> lor;

    /**
     * Initialize a list of employers.
     */
    private List<Employee> le;

    /**
     * Initialize number of employers.
     */
    private int numEmployees=0;

    /**
     * Declare a constant with maximum number of employers .
     */
    private final int MAX_NUM_EMPLOYEES = 99999;

    /**
     * Create Store instance with empties arrays.
     */
    public EmployeeStore () {
        this.lor = new ArrayList<>();
        this.le = new ArrayList<>();
    }

    /**
     * Add a role in the organisation.
     *
     * @param role EmployeeStore's role
     */
    public void addOrgRole (OrgRole role) {
        this.lor.add(role);
    }

    /**
     * Return a list of roles.
     *
     * @return Role's list
     */
    public List<OrgRole> getOrgRoles () {
        if(lor!=null) {
            if (lor.isEmpty()) {
                throw new IllegalArgumentException("Organization Roles list is empty.");
            }
            return lor;
        }
        return null;
    }

    /**
     * Creates a Employee instance and returns it.
     *
     * @param eDto - Employee's dto
     *
     * @return Employee
     */
    public Employee registerEmployee(EmployeeDto eDto) {
        String roleId = eDto.getRoleId();
        OrgRole role = this.getRoleById(roleId);
        eDto.setId(generateEmployeeId(eDto.getName()));
        return role.createEmployee(eDto);
    }

    /**
     * Generate the id of the employee.
     *
     * @param name employee's name
     *
     * @return employee's id
     */
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

    /**
     * Return the employee's number.
     *
     * @return employee's number
     */
    public int  getNumEmployees() {
        return numEmployees;
    }

    /**
     * Return the Role's by id.
     *
     * @return role's id
     */
    public OrgRole getRoleById(String id) {
        for (OrgRole role : this.lor) {
            if(role.getId().equals(id)) return role;
        }
        throw new IllegalArgumentException("There is no Organization Role with that Id.");
    }

    /**
     * Validates Employee attributes for business model rules.
     *
     * @param employee - Employee
     *
     * @return boolean
     */
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

    /**
     * Saves the new Employee.
     *
     * @param employee - Employee
     *
     * @return boolean
     */
    public boolean saveEmployee(Employee employee){
        this.numEmployees++;
        return this.le.add(employee);
    }

    /**
     * Return the employee's list.
     *
     * @return employee's list
     */
    public List<Employee> getEmployees () {
        if(le.isEmpty()) { throw new IllegalArgumentException("Employee list is empty.");}
        return this.le;
    }

    /**
     * Change the Role's list.
     * .
     * @param lor Role's list
     */
    public void setLor(List<OrgRole> lor){
        this.lor=lor;
    }
}
