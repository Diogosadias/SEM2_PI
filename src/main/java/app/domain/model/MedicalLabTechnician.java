package app.domain.model;

import java.io.Serializable;

/**
 * MedicalLabTechnician - Domain class representing a Medical Lab Technician
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 */
public class MedicalLabTechnician extends Employee implements Serializable {

    /**
     * Constructor Medical Lab Technician with the role, employeeId, name, address, phone number, socCode.
     *
     * @param role MedicalLabTechnician's role
     * @param employeeId MedicalLabTechnician's employeeId
     * @param name MedicalLabTechnician's name
     * @param address MedicalLabTechnician's address
     * @param phoneNumber MedicalLabTechnician's phone number
     * @param socCode MedicalLabTechnician's socCode
     */

    public MedicalLabTechnician(OrgRole role, String employeeId, String name, String address, long phoneNumber, String socCode){
        super(role, employeeId, name, address, phoneNumber, socCode);
    }

    /**
     * Constructor Medical Lab Technician with the employee.
     *
     * @param employee MedicalLabTechnician's employee
     */

    public MedicalLabTechnician(Employee employee) {
        super (employee.getRole(), employee.getEmployeeId(), employee.getName(), employee.getAddress(), employee.getPhoneNumber(), employee.getSocCode());
    }

}
