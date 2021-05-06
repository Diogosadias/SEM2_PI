package app.domain.model;

import app.domain.dto.EmployeeDto;

import java.util.Objects;

/**
 *
 * @author Tiago Rocha
 */
public class OrgRole {

    private String id;
    private String designation;
    private String initClass;

    public OrgRole(String id,String designation) {
        this.designation = designation;
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public String getId() {
        return id;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employee createEmployee (EmployeeDto dto) {
        //Later changing to Reflection technique
        Employee employee = new Employee(this, dto.getEmployeeId(), dto.getName(), dto.getAddress(), dto.getPhoneNumber(), dto.getSocCode());
        if(this.getDesignation() == "SpecialistDoctor") {
           return new SpecialistDoctor(this, dto.getEmployeeId(), dto.getName(), dto.getAddress(), dto.getPhoneNumber(), dto.getSocCode(), dto.getDoctorIndexNumber());
        }
        return employee;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrgRole)) return false;
        OrgRole that = (OrgRole) o;
        return Objects.equals(id, that.id) || Objects.equals(designation, that.designation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(designation, id);
    }

    @Override
    public String toString() {
        return "OrgRole{" +
                "id='" + id + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}
