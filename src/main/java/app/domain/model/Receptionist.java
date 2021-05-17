package app.domain.model;

import static app.domain.shared.Constants.ROLE_RECEP;

public class Receptionist extends Employee{

    public Receptionist(OrgRole role, String employeeId, String name, String address, long phoneNumber, String socCode){
        super(role, employeeId, name, address, phoneNumber, socCode);
    }

    public Receptionist(Employee employee) {
        super (employee.getRole(), employee.getEmployeeId(), employee.getName(), employee.getAddress(), employee.getPhoneNumber(), employee.getSocCode());
  }

}
