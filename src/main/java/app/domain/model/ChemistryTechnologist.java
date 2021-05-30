package app.domain.model;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 */

public class ChemistryTechnologist extends Employee{

    /**
     * Constructor Chemistry Technologist with the role, employeeId, name, address, phone number, socCode.
     *
     * @param role ChemistryTechnologist's role
     * @param employeeId ChemistryTechnologist's employeeId
     * @param name ChemistryTechnologist's name
     * @param address ChemistryTechnologist's address
     * @param phoneNumber ChemistryTechnologist's phone number
     * @param socCode ChemistryTechnologist's socCode
     */

    public ChemistryTechnologist(OrgRole role, String employeeId, String name, String address, long phoneNumber, String socCode){
        super(role, employeeId, name, address, phoneNumber, socCode);
    }

    /**
     * Constructor Chemistry Technologist with the employee.
     *
     * @param employee ChemistryTechnologist's employee
     */

    public ChemistryTechnologist(Employee employee) {
        super (employee.getRole(), employee.getEmployeeId(), employee.getName(), employee.getAddress(), employee.getPhoneNumber(), employee.getSocCode());
    }

}
