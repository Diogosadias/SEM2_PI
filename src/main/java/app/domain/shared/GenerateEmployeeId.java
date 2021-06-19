package app.domain.shared;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */

public class GenerateEmployeeId {

    /**
     * Declare a constant with maximum number of employers .
     */
    private static final int MAXNUMEMPLOYEES = 99999;

    private final String id;

    public GenerateEmployeeId(String name, int numEmployees) {
        this.id = generateEmployeeId(name,numEmployees);
    }

    private String generateEmployeeId(String name, int numEmployees) {
        int nEmp = numEmployees;
        if (nEmp == MAXNUMEMPLOYEES) { throw new IllegalArgumentException("Maximum Employees reached."); }
        // acrescentar +1 ao numero de employees
        int ids = nEmp + 1;
        // gerar as inicias do nome
        String initials = "";
        String[] temp = name.split(" ");
        for (int i=0;i< temp.length;i++) {
            initials += temp[i].toUpperCase().charAt(0);
        }
        // acrescentar zeros entre as letras e o numero
        String fillZeros = "";
        for (int i=0;i< 5;i++) {

            if (ids % 10 == 0) {
                fillZeros += "0";
            }
            ids = ids / 10;
        }
        return initials + fillZeros + "" + (nEmp + 1);
    }

    public String getId() {
        return this.id;
    }
}
