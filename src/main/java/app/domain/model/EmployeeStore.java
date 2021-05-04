package app.domain.model;

import app.domain.shared.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class EmployeeStore {

//    private Set<String> lor;
    private Set<Employee> store;
    private int numEmployees=0;
    public final String SPECIALIST_DOCTOR = "Specialist Doctor";
    public final String LABORATORY_COORDINATOR = "Laboratory Coordinator";
    public final String CHEMISTRY_TECHNOLOGIST = "Chemistry Technologist";
    public final String MEDICAL_LAB_TECHNICIAN = "Medical Lab Technicians";

    public EmployeeStore () {
//        this.lor = addOrganizationRoles();
        this.store = new HashSet<Employee>();
    }

//    public Set<String> addOrganizationRoles () {
//        Set<String> roles = new HashSet<>();
//        roles.add(SPECIALIST_DOCTOR);
//        roles.add(LABORATORY_COORDINATOR);
//        roles.add(CHEMISTRY_TECHNOLOGIST);
//        roles.add(MEDICAL_LAB_TECHNICIAN);
//        return roles;
//    }

    public Employee create(String role, String name, String address, String phoneNumber, String socCode, int doctorIndexNumber) {
        String employeeId = generateEmployeeId(name.trim());
        String email = employeeId + "" ;
        return new Employee(email, employeeId, role, name.trim(), address, phoneNumber, socCode, doctorIndexNumber);
    }

    public boolean validateEmployee(Employee employee) {
        boolean flag = true;
        
        if (this.store != null) {
            for (Employee e : this.store) {
                if (e.getEmployeeId().equalsIgnoreCase(employee.getEmployeeId())) {
                    flag = false;
                }
            }

        }
        
        return flag;
        
    }
    
    public List<String> getOrganizationRoles() {
            List<String> temp = new ArrayList();
            
            temp.add(SPECIALIST_DOCTOR);
            temp.add(LABORATORY_COORDINATOR);
            temp.add(CHEMISTRY_TECHNOLOGIST);
            temp.add(MEDICAL_LAB_TECHNICIAN);
            
            return temp;
        }
    
    public String generateEmail(String id){
        return id.concat("@manylabs.pt");        
    }
    
    public String generateEmployeeId(String name) {
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

    public int  newEmployeeNumber() {
        return numEmployees++;
    }
    
    public boolean registerEmployee(Employee emp) {
        return this.store.add(emp);
    }
    
    //save esta a fazer o mesmo que register??
    public boolean saveEmployee(Employee emp){
//        if (validateEmployee(emp)) {
            return this.store.add(emp);
//        } else {
//            System.out.println("Employee " + emp.toString() + " already exists");
//            return false;
//        }
        
    }
        
    
}
