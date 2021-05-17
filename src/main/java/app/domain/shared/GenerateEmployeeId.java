package app.domain.shared;

import app.domain.model.Employee;
import app.domain.model.EmployeeStore;

public class GenerateEmployeeId {

    /**
     * Declare a constant with maximum number of employers .
     */
    private final int MAX_NUM_EMPLOYEES = 99999;

    private String id;

    public GenerateEmployeeId(String name, int numEmployees) {
        this.id = generateEmployeeId(name,numEmployees);
    }

    private String generateEmployeeId(String name, int numEmployees) {
        int nEmp = numEmployees;
        if (nEmp == MAX_NUM_EMPLOYEES) { throw new IllegalArgumentException("Maximum Employees reached."); };
        // acrescentar +1 ao numero de employees
        int id = nEmp + 1;
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
        return initials + fillZeros + "" + (nEmp + 1);
    }

    public String getId() {
        return this.id;
    }
}
