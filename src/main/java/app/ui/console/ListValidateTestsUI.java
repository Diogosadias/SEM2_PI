package app.ui.console;

import app.controller.ValidateTestController;
import app.domain.model.Test;

import java.util.List;
import java.util.Scanner;

public class ListValidateTestsUI implements Runnable {

    public void run() {
        ValidateTestController controller = new ValidateTestController();
        try {
            List<Test> list  = controller.getCompany().getTestStore().getValidatedTests();
            for (Test t : list ) {
                System.out.println("\n" + t);
                System.out.println("\nPress Enter to continue:");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            }
            System.out.println("Reached end of registered Test list.\n");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}