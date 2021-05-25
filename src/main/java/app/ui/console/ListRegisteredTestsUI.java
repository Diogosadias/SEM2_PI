package app.ui.console;

import app.controller.RegisterTestController;
import app.domain.dto.TestDto;
import app.domain.model.Test;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 */
public class ListRegisteredTestsUI implements Runnable {

    public ListRegisteredTestsUI () {

    }

    public void run() {
        RegisterTestController controller = new RegisterTestController();
        try {
            List<Test> list  = controller.getCompany().getTestStore().getRegisteredTests();
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
