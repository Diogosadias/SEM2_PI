package app.domain.model;

import static app.domain.shared.Constants.ROLE_LAB_COORDINATOR;

public class LaboratoryCoordinator extends Employee{

    public LaboratoryCoordinator(OrgRole role, String employeeId, String name, String address, long phoneNumber, String socCode){
        super(role, employeeId, name, address, phoneNumber, socCode);
    }

    public LaboratoryCoordinator(Employee employee) {
        super (employee.getRole(), employee.getEmployeeId(), employee.getName(), employee.getAddress(), employee.getPhoneNumber(), employee.getSocCode());
    }

}
