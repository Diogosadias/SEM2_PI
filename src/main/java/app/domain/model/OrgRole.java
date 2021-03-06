package app.domain.model;

import app.domain.dto.EmployeeDto;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/**
 * This domain class allows to build an instance of role.
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */

public class OrgRole implements Serializable {

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
        return initiateEmployeeClass(dto);
    }

    /**
     * Initiate Employee Class
     *
     * @param dto EmployeeDto' dto
     *
     * @return Constructor new instance
     *
     * @throws ClassNotFoundException Class not found
     * @throws IllegalAccessException Illegal access
     * @throws InstantiationException Instantiation
     * @throws NoSuchMethodException No such method
     * @throws InvocationTargetException Invocation target
     */

    private Employee initiateEmployeeClass(EmployeeDto dto) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> c = Class.forName(this.designation);
        Employee temp = new Employee(this,dto);
        Constructor<?> constructor = c.getConstructor((Employee.class));
        return (Employee)constructor.newInstance(temp);
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
