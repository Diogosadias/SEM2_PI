package app.ui.console;

import app.controller.RegisterEmployeeController;
import app.domain.dto.EmployeeDto;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */

public class ListEmployeesUI implements Runnable {

    public void run() {
        RegisterEmployeeController controller = new RegisterEmployeeController();
        List<EmployeeDto> list  = controller.getCompany().getEmployeeStore().getEmployeesToShow();
        if (list.isEmpty()) {
            System.out.println("List of Employees is empty.");
        } else {
            for (EmployeeDto e : list) {
                System.out.println("\n" + e);
                System.out.println("\nPress Enter to continue:");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            }
            System.out.println("Reached end of Employee list.\n");
        }
    }

}
