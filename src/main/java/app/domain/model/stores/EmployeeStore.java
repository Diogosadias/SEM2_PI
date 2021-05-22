package app.domain.model.stores;

import app.domain.dto.EmployeeDto;
import app.domain.dto.EmployeeMapper;
import app.domain.model.Employee;
import app.domain.model.OrgRole;
import app.domain.model.SpecialistDoctor;
import app.domain.shared.EmailSender;
import app.domain.shared.GenerateEmployeeId;
import app.domain.shared.GeneratePassword;
import auth.AuthFacade;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static app.domain.shared.Constants.*;

/**
 * EmployeeStore - Class responsible for managing Employers.
 *
 * @author Tiago Rocha
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 */
public class EmployeeStore {


    private Employee employee;

    private String employeePwd;

    /**
     * Initialize a list of employers.
     */
    private List<Employee> le;

    /**
     * Initialize number of employers.
     */
    private int numEmployees=0;

    private OrgRoleStore rStore;

    private AuthFacade auth;

    /**
     * Create Store instance with empties arrays.
     *
     * @author Tiago Rocha <1181445@isep.ipp.pt>
     */
    public EmployeeStore (OrgRoleStore rStore, AuthFacade auth) {
        this.rStore = rStore;
        this.auth = auth;
        this.le = new ArrayList<>();
    }

    /**
     * Creates a Employee instance and returns it.
     *
     * @param eDto - Employee's dto
     *
     * @return Employee
     */
    public boolean registerEmployee(EmployeeDto eDto) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        String roleId = eDto.getRoleId();
        OrgRole role = this.rStore.getRoleById(roleId);
        eDto.setId(new GenerateEmployeeId(eDto.getName(), this.getNumEmployees()).getId());
        this.employee = role.createEmployee(eDto);
        return (employee != null);
    }

    public boolean saveEmployee() {
        //validates and saves employee
        if (!this.validateEmployee(this.employee)) {
            return false;
        }
        String email = employee.getEmail();
        if (auth.existsUser(email)) {
            return false;
        }
        String name = employee.getName();
        String role = employee.getRole().getId();
        this.addEmployee(this.employee);
        this.employeePwd = new GeneratePassword().getPwd();
        return this.auth.addUserWithRole(name, email, this.employeePwd, role);
    }

    /**
     * Return the employee's number.
     *
     * @return employee's number
     */
    public int  getNumEmployees() {
        return numEmployees;
    }

    public void  confirmRegistration() {
        new EmailSender(this.employee.getEmail(),this.employeePwd);
        this.numEmployees++;
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

    public void setDoctorIndexNumber(int doctorIndexNumber) {
        ((SpecialistDoctor) employee).setDoctorIndexNumber(doctorIndexNumber);
    }

    public boolean addEmployee(Employee employee){
        return this.le.add(employee);
    }

    public void removeEmployee () {
        le.remove(this.employee);
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

    public OrgRoleStore getRoleStore () {
        return this.rStore;
    }

    public String getEmployeeToString()
    {
        String s = "[Name: " + this.employee.getName() + "]\n" + "[Adress: " + this.employee.getAddress()+ "]\n" +
                "[Email: " + this.employee.getEmail()+ "]\n" + "[id: " + this.employee.getEmployeeId()+ "]\n" +
                "[Phone Number: " + this.employee.getPhoneNumber()+ "]\n" + "[Soc code: " + this.employee.getSocCode() + "]\n" ;
        if(this.employee.getRole().getId().equals(SPECIALIST_DOCTOR)) {
            SpecialistDoctor temp = (SpecialistDoctor)employee;
            s = s + "[Doctor Index Number: " + temp.getDoctorIndexNumber() + "]\n" + "";
        }
        return s;
    }

    public List getEmployeesToShow () {
        EmployeeMapper mapper = new EmployeeMapper();
        return mapper.toDto(this.le);
    }

}
