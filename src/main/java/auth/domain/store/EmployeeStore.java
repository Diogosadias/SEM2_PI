package auth.domain.store;

import app.domain.model.Employee;
import auth.domain.model.Email;
import auth.domain.model.Password;
import auth.domain.model.User;

import java.util.HashSet;
import java.util.Set;



public class EmployeeStore {

    private Set<String> lor;
    private Set<Employee> store = new HashSet<Employee>();
    private int numEmployees=0;
    public final String SPECIALIST_DOCTOR = "Specialist Doctor";
    public final String LABORATORY_COORDINATOR = "Laboratory Coordinator";
    public final String CHEMISTRY_TECHNOLOGIST = "Chemistry Technologist";
    public final String MEDICAL_LAB_TECHNICIAN = "Medical Lab Technicians";

    public EmployeeStore () {
        this.lor = addOrganizationRoles();
    }

    public Set<String> addOrganizationRoles () {
        Set<String> roles = new HashSet<>();
        roles.add(SPECIALIST_DOCTOR);
        roles.add(LABORATORY_COORDINATOR);
        roles.add(CHEMISTRY_TECHNOLOGIST);
        roles.add(MEDICAL_LAB_TECHNICIAN);
        return roles;
    }

    public Employee create(String role, String name, String address, int phoneNumber, String socCode, int doctorIndexNumber) {
        String employeeId = generateEmployeeId(name.trim());
        String email = employeeId + "" ;
        return new Employee(email, employeeId, role, name.trim(), address, phoneNumber, socCode, doctorIndexNumber);
    }

    public void validateEmployee(Employee employee) {

    }

    public boolean addEmployee(Employee employee) {
        return store.add(employee);
    }

    private String generateEmployeeId(String name) {
        // acrescentar +1 ao numero de employees
        int id = newEmployeeNumber();
        // gerar as inicias do nome
        String initials = "";
        String[] temp = name.split(" ");
        for (int i=0;i< temp.length;i++) {
            initials += temp[i].toUpperCase().charAt(0);
        }
        // acrescentar zeros entre as letras e o numero
        String fillZeros = "";
        for (int i=0;i< 5;i++) {

            if (id % 10 == 0) {
                fillZeros += "0";
            }
            id = id / 10;
        }
        return initials + fillZeros + "" + numEmployees;
    }

    private int  newEmployeeNumber() {
        return numEmployees++;
    }


}
