package app.domain.model;

import app.domain.dto.EmployeeDto;

import java.util.Objects;

import static app.domain.shared.Constants.EMAIL_SUFIX;


/**
 * This domain class allows to build an instance of employee.
 *
 * @author Tiago Rocha
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 */
public class Employee {

    /**
     * The email of employee.
     */
    private String email;

    /**
     * The id of employee.
     */
    private String employeeId;

    /**
     * The role of employee.
     */
    private OrgRole role;

    /**
     * The name of employee.
     */
    private String name;

    /**
     * The address of employee.
     */
    private String address;

    /**
     * The phone number of employee.
     */
    private long phoneNumber;

    /**
     * The standard occupational code of employee.
     */
    private String socCode;

    /**
     * Constructor Employee with the role, id, name, address, phone number
     * and standard occupational code.
     *
     * @param role employee's role
     * @param employeeId employee's id
     * @param name employee's name
     * @param address employee's address
     * @param phoneNumber employee's phone number
     * @param socCode employee's standard occupational code
     */

    public Employee(OrgRole role, String employeeId,  String name, String address, long phoneNumber, String socCode) {

        checkEmployedID(employeeId);
        checkName(name);
        checkAddress(address);
        checkSOCode(socCode);
        checkNumDigits(phoneNumber);

        this.employeeId = employeeId;
        this.role = role;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.socCode = socCode;
        this.email = generateEmail(employeeId);
    }

    /**
     * Constructor Employee with the role and dto.
     *
     * @param role employee's role
     * @param dto employee's dto
     */

    public Employee(OrgRole role, EmployeeDto dto) {

        this.employeeId = dto.getEmployeeId();
        checkEmployedID(employeeId);
        this.name = dto.getName();
        checkName(name);
        this.address = dto.getAddress();
        checkAddress(address);
        this.phoneNumber = dto.getPhoneNumber();
        checkNumDigits(phoneNumber);
        this.socCode = dto.getSocCode();
        checkSOCode(socCode);

        this.email = generateEmail(employeeId);
        this.role = role;
    }

    /**
     * Check if the phone number it's within the rules.
     *
     * @param num employee's phone number
     */
    private void checkNumDigits (long num) {
        String temp = String.valueOf(num);
        if ( temp.length() != 11)
            throw new IllegalArgumentException("Phone Number must have 11 chars.");
    }

    /**
     * Check if the id it's within the rules.
     * @param employeeId employee's id
     */
    private void checkEmployedID(String employeeId){
        if (employeeId.length() == 0)
            throw new IllegalArgumentException("Employee Id cannot be blank.");

    }

    /**
     * Check if the name it's within the rules.
     *
     * @param name employee's name
     */
    private void checkName(String name){
        if (name.length() == 0)
            throw new IllegalArgumentException("Name cannot be blank.");

    }

    /**
     * Check if the address it's within the rules.
     *
     * @param address employee's address
     */
    private void checkAddress(String address){
        if (address.length() == 0)
            throw new IllegalArgumentException("Address cannot be blank.");

    }

    /**
     * Check if the standard occupational code it's within the rules.
     *
     * @param socCode employee's standard occupational code
     */
    private void checkSOCode(String socCode){
        if (socCode.length() == 0)
            throw new IllegalArgumentException("SOC cannot be blank.");

    }

    /**
     * Generate the email of the employee.
     *
     * @param id employee's id
     *
     * @return email or null
     */
    public String generateEmail(String id) {
        if(id!=null) {
            return id + "" + EMAIL_SUFIX;
        }
        return null;
    }

    /**
     * Return the employee's id.
     *
     * @return employee's id
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Return the employee's role.
     *
     * @return employee's role
     */
    public OrgRole getRole() {
        return role;
    }

    /**
     * Return the employee's name.
     *
     * @return employee's name
     */
    public String getName() {
        return name;
    }

    /**
     * Return the employee's address.
     *
     * @return employee's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Return the employee's phone number.
     *
     * @return employee's phone number
     */
    public long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Return the employee's standard occupational code.
     *
     * @return employee's socCode
     */
    public String getSocCode() {
        return socCode;
    }

    /**
     * Return the employee's email.
     *
     * @return employee's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Change the employee's id.
     *
     * @param employeeId employee's id
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Change the employee's role.
     *
     * @param role employee's role
     */
    public void setRole(OrgRole role) {
        this.role = role;
    }

    /**
     * Change the employee's name.
     *
     * @param name employee's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Change the employee's address.
     *
     * @param address employee's address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Change the employee's phone number.
     *
     * @param phoneNumber employee's phone number
     */
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Change the employee's standard occupational code.
     *
     * @param socCode employee's standard occupational code
     */
    public void setSocCode(String socCode) {
        this.socCode = socCode;
    }

    /**
     * Change the employee's email.
     *
     * @param email employee's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method compares the equality of the current object
     * with the object of same type.
     *
     * @param o
     *
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if(o!=null){
            if (!(o instanceof Employee)) return false;
            Employee employee = (Employee) o;
            return phoneNumber == employee.phoneNumber && Objects.equals(role, employee.role) && Objects.equals(name, employee.name) && Objects.equals(address, employee.address) && Objects.equals(socCode, employee.socCode);
        }
        throw new NullPointerException("Object is null.");
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return Object.hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(role, name, address, phoneNumber, socCode);
    }

    /**
     * Return the textual description of the employee.
     *
     * @return employee's features
     */
    @Override
    public String toString() {
        return
                "\n" + role.getId() +
                        " - employeeId: " + employeeId +
                        ", email: " + email +
                        ", name: " + name +
                        ", address: " + address +
                        ", phoneNumber: " + phoneNumber +
                        ", socCode: " + socCode +
                        "";
    }
}

