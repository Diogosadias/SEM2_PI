package app.domain.model;

import app.domain.dto.EmployeeDto;
import app.domain.model.Employee;
import app.domain.model.OrgRole;
import app.domain.shared.Constants;
import app.domain.shared.GeneratePassword;
import auth.AuthFacade;

import java.io.FileWriter;
import java.io.IOException;
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

    private OrgRoleStore rStore;

    private AuthFacade auth;

    /**
     * Create Store instance with empties arrays.
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
        eDto.setId(generateEmployeeId(eDto.getName()));
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
        String pwd = GeneratePassword.makeRandomPass();
        boolean b = this.auth.addUserWithRole(name, email, pwd, role);
        sendEmail(email,pwd);
        return b;
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

    public void  setNumEmployees() {
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

    private void sendEmail (String email, String pass){
        try{
            FileWriter myWriter = new FileWriter(employee.getEmployeeId()+"Password.txt");
            myWriter.write("Hello,\nhere is your new password:\n\n");
            myWriter.append("Email: " + email + "\n");
            myWriter.append("Password: " + pass + "\n");
            myWriter.append("\nBest regards\n");
            myWriter.append("ManyLabs team.");
            System.out.println("Sending your new password to your email...");
            myWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
