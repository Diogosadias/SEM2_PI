package app.domain.model;

import java.io.Serializable;

/**
 * LaboratoryCoordinator - Domain class representing a Laboratory Coordinator
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 */

public class LaboratoryCoordinator extends Employee implements Serializable {

    /**
     * Constructor Laboratory Coordinator with the role, employeeId, name, address, phone number, socCode.
     *
     * @param role LaboratoryCoordinator's role
     * @param employeeId LaboratoryCoordinator's employeeId
     * @param name LaboratoryCoordinator's name
     * @param address LaboratoryCoordinator's address
     * @param phoneNumber LaboratoryCoordinator's phone number
     * @param socCode LaboratoryCoordinator's socCode
     */

    public LaboratoryCoordinator(OrgRole role, String employeeId, String name, String address, long phoneNumber, String socCode){
        super(role, employeeId, name, address, phoneNumber, socCode);
    }

    /**
     * Constructor Laboratory Coordinator with the employee.
     *
     * @param employee LaboratoryCoordinator's employee
     */

    public LaboratoryCoordinator(Employee employee) {
        super (employee.getRole(), employee.getEmployeeId(), employee.getName(), employee.getAddress(), employee.getPhoneNumber(), employee.getSocCode());
    }
}
