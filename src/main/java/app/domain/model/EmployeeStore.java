package app.domain.model;

import app.domain.dto.EmployeeDto;
import app.domain.dto.EmployeeMapper;
import app.domain.shared.EmailSender;
import app.domain.shared.GenerateEmployeeId;
import app.domain.shared.GeneratePassword;
import auth.AuthFacade;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static app.domain.shared.Constants.*;

/**
 * EmployeeStore - Class responsible for managing Employers.
 *
 * @author Tiago Rocha
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */

public class EmployeeStore extends Store{

    /**
     * The employee.
     */
    private Employee employee;

    /**
     * The Employee's password.
     */
    private String employeePwd;

    /**
     * Initialize a list of employers.
     */
    private final List<Employee> le;

    /**
     * Initialize number of employers.
     */
    private int numEmployees=0;

    /**
     * The store of OrgRole.
     */
    private final OrgRoleStore rStore;

    /**
     * The AuthFacade of EmployeeStore.
     */
    private final AuthFacade auth;

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

    /**
     * Saves the new Employee.
     *
     * @return boolean
     */

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

    /**
     * Method that confirms register of the employee.
     */

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

    /**
     * Change the doctor index number.
     *
     * @param doctorIndexNumber Employee's doctor index number
     */

    public void setDoctorIndexNumber(int doctorIndexNumber) {
        ((SpecialistDoctor) employee).setDoctorIndexNumber(doctorIndexNumber);
    }

    /**
     * Add a Employee.
     *
     * @param employee - Employee
     *
     * @return boolean
     */

    public boolean addEmployee(Employee employee){
        this.employee = employee;
        return this.le.add(employee);
    }

    /**
     * Method for remove an existing employee.
     */

    public void removeEmployee () {
        le.remove(this.employee);
        this.numEmployees--;
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
     * Return the OrgRole's store.
     *
     * @return OrgRole's store
     */

    public OrgRoleStore getRoleStore () {
        return this.rStore;
    }

    /**
     * Return the textual description of theemployee.
     *
     * @return Employee's features
     */

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

    /**
     * Method for getting the available employees.
     *
     * @return Employee Mapper
     */
    
    public List getEmployeesToShow () {
        EmployeeMapper mapper = new EmployeeMapper();
        return mapper.toDto(this.le);
    }

    @Override
    public List getListObjects() {
        //Change list of objects in Store to a List Object
        List<Object> list = new ArrayList<>();
        for(Employee e: le) {
            list.add(e);
        }
        return list;
    }

    @Override
    public String getFileName() {
        // Path - "Folder: ser" / "File Name: this store's object class" "Suffix: .txt"
        return "ser/employee.txt";
    }

    @Override
    public void importObject(Object o) {
        // Read Object from File and import as this store's object class
        this.employee = (Employee) o;
        try {
            Class<?> c = Class.forName(this.employee.getRole().getDesignation());
            Constructor<?> constructor = c.getConstructor((Employee.class));
            this.employee = (Employee) constructor.newInstance(employee);
            if(this.validateEmployee(employee)) {
                this.le.add(employee);
            }
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
