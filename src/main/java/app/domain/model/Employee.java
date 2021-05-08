package app.domain.model;

import java.util.Objects;


/**
 *
 * @author Tiago Rocha
 */
public class Employee {

    private String email;
    private String employeeId;
    private OrgRole role;
    private String name;
    private String address;
    private long phoneNumber;
    private String socCode;
    private static final String EMAILSUFIX = "@lei.isep.pt";

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

    private void checkNumDigits (long num) {
        String temp = String.valueOf(num);
        if ( temp.length() != 11)
            throw new IllegalArgumentException("Phone Number must have 11 chars.");
    }
    private void checkEmployedID(String employeeId){
        if (employeeId.length() == 0)
            throw new IllegalArgumentException("Employee Id cannot be blank.");

    }
    private void checkName(String name){
        if (name.length() == 0)
            throw new IllegalArgumentException("Name cannot be blank.");

    }
    private void checkAddress(String address){
        if (address.length() == 0)
            throw new IllegalArgumentException("Address cannot be blank.");

    }private void checkSOCode(String socCode){
        if (socCode.length() == 0)
            throw new IllegalArgumentException("SOC cannot be blank.");

    }

    public String generateEmail(String id) {
        if(id!=null) {
            return id + "" + EMAILSUFIX;
        }
        return null;
    }

    //get
    public String getEmployeeId() {
        return employeeId;
    }
    public OrgRole getRole() {
        return role;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }
    public String getSocCode() {
        return socCode;
    }
    public String getEmail() {
        return email;
    }

    //set
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public void setRole(OrgRole role) {
        this.role = role;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setSocCode(String socCode) {
        this.socCode = socCode;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if(o!=null){
            if (this == o) return true;
            if (!(o instanceof Employee)) return false;
            Employee employee = (Employee) o;
            return phoneNumber == employee.phoneNumber && Objects.equals(role, employee.role) && Objects.equals(name, employee.name) && Objects.equals(address, employee.address) && Objects.equals(socCode, employee.socCode);
        }
        throw new NullPointerException("Object is null");
    }

    @Override
    public int hashCode() {
        checkEmployedID(employeeId);
        checkName(name);
        checkAddress(address);
        checkSOCode(socCode);
        checkNumDigits(phoneNumber);

        return Objects.hash(role, name, address, phoneNumber, socCode);
    }

    @Override
    public String toString() {
        return
                "\n" + role.getDesignation() +
                        " - employeeId: " + employeeId +
                        ", email: " + email +
                        ", name: " + name +
                        ", address: " + address +
                        ", phoneNumber: " + phoneNumber +
                        ", socCode: " + socCode +
                        "";
    }
}

