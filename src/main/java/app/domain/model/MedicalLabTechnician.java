package app.domain.model;

import static app.domain.shared.Constants.ROLE_MED_LAB_TECH;

public class MedicalLabTechnician extends Employee implements RoleExtra{

    public MedicalLabTechnician(OrgRole role, String employeeId, String name, String address, long phoneNumber, String socCode){
        super(role, employeeId, name, address, phoneNumber, socCode);
    }

    public MedicalLabTechnician(Employee employee) {
        super (employee.getRole(), employee.getEmployeeId(), employee.getName(), employee.getAddress(), employee.getPhoneNumber(), employee.getSocCode());
    }

    @Override
    public String RegisteredUserRole() {
        return ROLE_MED_LAB_TECH;
    }
}
