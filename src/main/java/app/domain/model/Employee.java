package app.domain.model;

import java.util.Objects;

public class Employee {

    private String email;
    private String employeeId;
    private OrganizationRole role;
    private String name;
    private String address;
    private String phoneNumber;
    private String socCode;

    public Employee(String email, String employeeId, String role, String name, String address, String phoneNumber, String socCode, int doctorIndexNumber) {
        this.email = email;
        this.employeeId = employeeId;
        this.role = new OrganizationRole(role,doctorIndexNumber);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.socCode = socCode;

    }

    public Employee() {
    }

        //get
    public String getEmployeeId() {
        return employeeId;
    }
    public OrganizationRole getRole() {
        return role;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPhoneNumber() {
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
    public void setRole(OrganizationRole role) {
        this.role = role;
    }    
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhoneNumber(String phoneNumber) {
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
        return phoneNumber == employee.phoneNumber || employeeId.equals(employee.employeeId) || email.equals(employee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, phoneNumber, email);
    }
}
