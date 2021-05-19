package app.ui.console;

import app.controller.RegisterEmployeeController;
import app.domain.model.Employee;

import java.util.List;
import java.util.Scanner;

public class ListEmployeesUI implements Runnable {

    public ListEmployeesUI () {

    }

    public void run() {
        RegisterEmployeeController rec = new RegisterEmployeeController();
        List<Employee> list  = rec.getCompany().getEmployeeStore().getEmployees();
        if (list.isEmpty()) {
            System.out.println("List of Employees is empty.");
        } else {
            for (Employee e : list) {
                System.out.println("\n" + e);
                System.out.println("\nPress Enter to continue:");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            }
            System.out.println("Reached end of Employee list.\n");
        }
    }

}
