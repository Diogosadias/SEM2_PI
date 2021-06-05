package app.domain.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 */
public class SpecialistDoctor extends Employee implements Serializable {

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
        this.setDoctorIndexNumber(doctorIndexNumber);
    }

    /**
     * Constructor Specialist Doctor with the employee.
     *
     * @param employee SpecialistDoctor's employee
     */

    public SpecialistDoctor(Employee employee) {
        super (employee.getRole(), employee.getEmployeeId(), employee.getName(), employee.getAddress(), employee.getPhoneNumber(), employee.getSocCode());
        this.setDoctorIndexNumber(doctorIndexNumber);
    }

    /**
     * Method for getting the doctor's Index number.
     *
     * @return doctorIndexNumber
     */
    public int getDoctorIndexNumber() {
        return this.doctorIndexNumber;
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

}
