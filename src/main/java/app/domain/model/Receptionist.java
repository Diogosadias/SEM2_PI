package app.domain.model;

import java.io.Serializable;

/**
 * Receptionist - Domain class representing a Receptionist
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 */
public class Receptionist extends Employee implements Serializable {

    /**
     * Constructor Receptionist with the role, employeeId, name, address, phone number, socCode.
     *
     * @param role Receptionist's role
     * @param employeeId Receptionist's employeeId
     * @param name Receptionist's name
     * @param address Receptionist's address
     * @param phoneNumber Receptionist's phone number
     * @param socCode Receptionist's socCode
     */

    public Receptionist(OrgRole role, String employeeId, String name, String address, long phoneNumber, String socCode){
        super(role, employeeId, name, address, phoneNumber, socCode);
    }

    /**
     * Constructor Receptionist with the employee.
     *
     * @param employee Receptionist's employee
     */

    public Receptionist(Employee employee) {
        super (employee.getRole(), employee.getEmployeeId(), employee.getName(), employee.getAddress(), employee.getPhoneNumber(), employee.getSocCode());
  }

}
