package app.domain.model;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 */
public class ChemistryTechnologist extends Employee{

    public ChemistryTechnologist(OrgRole role, String employeeId, String name, String address, long phoneNumber, String socCode){
        super(role, employeeId, name, address, phoneNumber, socCode);
    }

    public ChemistryTechnologist(Employee employee) {
        super (employee.getRole(), employee.getEmployeeId(), employee.getName(), employee.getAddress(), employee.getPhoneNumber(), employee.getSocCode());
    }

}
