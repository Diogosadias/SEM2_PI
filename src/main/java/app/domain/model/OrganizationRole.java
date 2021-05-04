package app.domain.model;

import java.util.Objects;

public class OrganizationRole {

    private String designation;
    private int doctorIndexNumber;

    public OrganizationRole(String designation, int doctorIndexNumber) {
        this.designation = designation;
        this.doctorIndexNumber = doctorIndexNumber;
    }

    public OrganizationRole() {
        
    }

    public String getDesignation() {
        return designation;
    }

    public int getDoctorIndexNumber() {
        return doctorIndexNumber;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setDoctorIndexNumber(int doctorIndexNumber) {
        this.doctorIndexNumber = doctorIndexNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrganizationRole)) return false;
        OrganizationRole that = (OrganizationRole) o;
        return doctorIndexNumber == that.doctorIndexNumber && Objects.equals(designation, that.designation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(designation, doctorIndexNumber);
    }
}
