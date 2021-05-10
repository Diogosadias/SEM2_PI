package app.domain.model;

import java.util.Objects;

import static app.domain.shared.Constants.ROLE_SPEC_DOCTOR;

public class SpecialistDoctor extends Employee implements RoleExtra{

    /**
     * Specialist Doctor's Index number
     */
    private int doctorIndexNumber;

    /**
     * Specialist Doctor Constructor, supers information to Employee except the Index number.
     *
     * @param role - Organization Role
     * @param employeeId - Employee ID
     * @param name - Employee Name
     * @param address - Employee Address
     * @param phoneNumber - Employee Phone Number
     * @param socCode - Employee SOC Code
     * @param doctorIndexNumber - Doctor Index Number
     */
    public SpecialistDoctor(OrgRole role, String employeeId, String name, String address, long phoneNumber, String socCode,int doctorIndexNumber) {
        super (role, employeeId, name, address, phoneNumber, socCode);
        this.doctorIndexNumber = doctorIndexNumber;
    }

    /**
     * Specialist Doctor's Constructor for an Employee.
     *
     * @param employee - Employee instance
     * @param doctorIndexNumber - Index number
     */
    public SpecialistDoctor(Employee employee, int doctorIndexNumber) {
        super (employee.getRole(), employee.getEmployeeId(), employee.getName(), employee.getAddress(), employee.getPhoneNumber(), employee.getSocCode());
        this.doctorIndexNumber = doctorIndexNumber;
    }

    /**
     * Method for getting the doctor's Index number.
     *
     * @return doctorIndexNumber
     */
    public int getDoctorIndexNumber() {
        return doctorIndexNumber;
    }

    /**
     * Method for setting the Doctor´s Index Number.
     *
     * @param doctorIndexNumber - Doctor´s Index Number
     */
    public void setDoctorIndexNumber(int doctorIndexNumber) {
        this.doctorIndexNumber = doctorIndexNumber;
    }

    /**
     * Equal method override for Specialist Doctor.
     *
     * @param o - Specialist Doctor
     * @return true/false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpecialistDoctor)) return false;
        if (!super.equals(o)) return false;
        SpecialistDoctor that = (SpecialistDoctor) o;
        return doctorIndexNumber == that.doctorIndexNumber;
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return Object.hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), doctorIndexNumber);
    }

    @Override
    public String RegisteredUserRole() {
        return ROLE_SPEC_DOCTOR;
    }
}
