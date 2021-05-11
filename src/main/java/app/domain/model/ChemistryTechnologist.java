package app.domain.model;

import static app.domain.shared.Constants.ROLE_CHEM_TECH;

public class ChemistryTechnologist extends Employee implements RoleExtra{

    public ChemistryTechnologist(OrgRole role, String employeeId, String name, String address, long phoneNumber, String socCode){
        super(role, employeeId, name, address, phoneNumber, socCode);
    }

    public ChemistryTechnologist(Employee employee) {
        super (employee.getRole(), employee.getEmployeeId(), employee.getName(), employee.getAddress(), employee.getPhoneNumber(), employee.getSocCode());
    }

    @Override
    public String RegisteredUserRole() {
        return ROLE_CHEM_TECH;
    }

}
