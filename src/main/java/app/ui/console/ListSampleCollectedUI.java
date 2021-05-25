package app.ui.console;


import app.controller.RecordSampleController;
import app.domain.model.Test;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 */
public class ListSampleCollectedUI implements Runnable {

    public ListSampleCollectedUI () {

    }

    public void run() {
        RecordSampleController controller = new RecordSampleController();
        try {
            List<Test> list = controller.getCompany().getTestStore().getSampleCollectedTests();
            for (Test t : list) {
                System.out.println("\n" + t);
                System.out.println("\nPress Enter to continue:");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            }
            System.out.println("Reached end of collected Sample Test list.\n");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}


