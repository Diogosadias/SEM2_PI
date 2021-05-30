package app.ui.console;

import app.controller.RecordTestResultController;
import app.domain.model.Test;

import java.util.List;
import java.util.Scanner;

public class ListChemicalAnalysedTestsUI implements Runnable {

    public ListChemicalAnalysedTestsUI () {

    }

    public void run() {
        RecordTestResultController controller = new RecordTestResultController();
        try {
            List<Test> list  = controller.getCompany().getTestStore().getSampleAnalysisTests();
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
