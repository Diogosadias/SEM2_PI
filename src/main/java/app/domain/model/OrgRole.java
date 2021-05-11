package app.domain.model;

import app.domain.dto.EmployeeDto;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

import static app.domain.shared.Constants.SPECIALIST_DOCTOR;

/**
 * This domain class allows to build an instance of role.
 *
 * @author Tiago Rocha
 *  @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class OrgRole {

    /**
     * The id of role.
     */
    private String id;

    /**
     * The designation of role.
     */
    private String designation;

    /**
     * Constructor Role with id and designation.
     *
     * @param id role's id
     * @param designation role's designation
     */
    public OrgRole(String id,String designation) {
        if(id == null || designation == null) {
            throw new IllegalArgumentException("Error: at least one of the attributes of OrgRole is null.");
        }
        this.designation = designation;
        this.id = id;
    }

    /**
     * Return the role's designation
     *
     * @return role's designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Return the role's id.
     *
     * @return role's id
     */
    public String getId() {
        return id;
    }

    /**
     * Change the role's designation.
     *
     * @param designation role's designation
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * Change the role's id.
     *
     * @param id role's id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Creates a Employee instance and returns it.
     *
     * @param dto - Employee's dto
     *
     * @return Employee
     */
    public Employee createEmployee (EmployeeDto dto) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //Later changing to Reflection technique
        Object employee = getEmployeeObject(dto);
        return (Employee)employee;
    }

    private Object getEmployeeObject(EmployeeDto dto) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> c = Class.forName(this.designation);
        Employee temp = new Employee(this,dto);
        Constructor<?> constructor = c.getConstructor((Employee.class));
        return constructor.newInstance(temp);
    }

    /**
     * This method compares the equality of the current object
     * with the object of same type.
     *
     * @param o object
     *
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrgRole)) return false;
        OrgRole that = (OrgRole) o;
        return Objects.equals(id, that.id) && Objects.equals(designation, that.designation);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return Object.hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(designation, id);
    }

    /**
     * Return the textual description of the role.
     *
     * @return role's features
     */
    @Override
    public String toString() {
        return "OrgRole{" +
                "id='" + id + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }


}
