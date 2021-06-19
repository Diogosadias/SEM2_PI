package app.ui.console;


import app.controller.RecordSampleController;
import app.domain.dto.TestDto;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */

public class ListSampleCollectedUI implements Runnable {

    public void run() {
        RecordSampleController controller = new RecordSampleController();
        try {
            List<TestDto> list = controller.listTestSamples();
            for (TestDto t : list) {
                System.out.println("\n" + t.SamplesToString());
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


