package app.domain.dto;

import java.util.Locale;

/**
 *
 * @author Tiago Rocha
 */
public class EmployeeDto {
    private String roleId;
    private String name;
    private String address;
    private long phoneNumber;
    private String socCode;
    private int doctorIndexNumber;
    private String employeeId;

    public EmployeeDto(String role, String name, String address, long phoneNumber, String socCode) {
        this.roleId = role;
        this.name = name.toUpperCase();
        this.address = address.toUpperCase();
        this.phoneNumber = phoneNumber;
        this.socCode = socCode;
    }

    public String getRoleId() {
        return roleId;
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

    public int getDoctorIndexNumber() {
        return doctorIndexNumber;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setId (String employeeId) {
        this.employeeId = employeeId;
    }

    public void setDoctorIndexNumber(int doctorIndexNumber) {
        this.doctorIndexNumber = doctorIndexNumber;
    }
}
