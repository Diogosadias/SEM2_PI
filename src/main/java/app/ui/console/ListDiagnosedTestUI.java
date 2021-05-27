package app.ui.console;

import app.controller.WriteReportController;
import app.domain.dto.TestDto;
import app.domain.model.Test;

import java.util.List;
import java.util.Scanner;

public class ListDiagnosedTestUI implements Runnable {

    public ListDiagnosedTestUI() {

    }

    public void run() {
        WriteReportController controller = new WriteReportController();
        try {
            List<TestDto> list = controller.getDiagnosedTests();
            for (TestDto t : list) {
                System.out.println("\n" + controller.showDiagnosis(t));
                System.out.println("\nPress Enter to continue:");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            }
            System.out.println("Reached end of registered Test list.\n");
        } catch (IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        }

    }

}

