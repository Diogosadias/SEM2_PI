package app.domain.model;

import java.util.Objects;

public class SpecialistDoctor extends Employee{


    private int doctorIndexNumber;

    public SpecialistDoctor(OrgRole role, String employeeId, String name, String address, String phoneNumber, String socCode,int doctorIndexNumber) {
        super (role, employeeId, name, address, phoneNumber, socCode);
        this.doctorIndexNumber = doctorIndexNumber;
    }

    public int getDoctorIndexNumber() {
        return doctorIndexNumber;
    }

    public void setDoctorIndexNumber(int doctorIndexNumber) {
        this.doctorIndexNumber = doctorIndexNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpecialistDoctor)) return false;
        if (!super.equals(o)) return false;
        SpecialistDoctor that = (SpecialistDoctor) o;
        return doctorIndexNumber == that.doctorIndexNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), doctorIndexNumber);
    }
}
