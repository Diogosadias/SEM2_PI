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
    private final String EMAIL_SUFIX = "@lei.isep.pt";

    public Employee(OrgRole role, String employeeId,  String name, String address, long phoneNumber, String socCode) {
        if(role == null || employeeId == null || name == null || address == null || socCode == null ) {
            throw new IllegalArgumentException("Error: At least one Employee attribute is null.");
        }
        if(!checkNumDigits(phoneNumber)) {
            throw new IllegalArgumentException("Phone Number doesnt have 11 digits.");
        }
        this.employeeId = employeeId;
        this.role = role;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.socCode = socCode;
        this.email = generateEmail(employeeId);
    }

    public boolean checkNumDigits (long num) {
        return (Math.floor(Math.log10(Math.abs((double)num))) + 1) == 11;
    }

    public String generateEmail(String id) {
        return id + "" + EMAIL_SUFIX;
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
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return phoneNumber == employee.phoneNumber && Objects.equals(role, employee.role) && Objects.equals(name, employee.name) && Objects.equals(address, employee.address) && Objects.equals(socCode, employee.socCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, name, address, phoneNumber, socCode);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "email: " + email +
                ", employeeId: " + employeeId +
                ", role: " + role.getDesignation() +
                ", name: " + name +
                ", address: " + address +
                ", phoneNumber: " + phoneNumber +
                ", socCode: " + socCode +
                '}';
    }
}
