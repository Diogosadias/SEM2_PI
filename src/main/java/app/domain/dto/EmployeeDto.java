package app.domain.dto;

/**
 *
 * @author Tiago Rocha
 */
public class EmployeeDto {
    private String roleId;
    private String name;
    private String address;
    private String phoneNumber;
    private String socCode;
    private int doctorIndexNumber;
    private String employeeId;

    public EmployeeDto(String role, String name, String address, String phoneNumber, String socCode) {
        this.roleId = role;
        this.name = name;
        this.address = address;
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

    public String getPhoneNumber() {
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
