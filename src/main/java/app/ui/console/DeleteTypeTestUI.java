package app.ui.console;

import app.controller.SpecifyNewTestTypeController;
import java.util.Scanner;
import static app.domain.shared.Constants.ANS_NO;
import static app.domain.shared.Constants.ANS_YES;

/**
 *
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */

public class DeleteTypeTestUI implements Runnable{
    @Override
    public void run() {
        Scanner read = new Scanner(System.in);
        SpecifyNewTestTypeController specifyNewTestTypeController = new SpecifyNewTestTypeController();
        String codedel;
        String verific;

        System.out.println("Choose the code of the test type you want to delete:\n");
        specifyNewTestTypeController.writeTestType();
        System.out.print("\n->");
        codedel= read.next();
        do {
            System.out.println("\n Are you sure you want to delete this type test?(Y/N)");
            verific = read.next().trim();
        }while(!verific.equalsIgnoreCase(ANS_YES) && !verific.equalsIgnoreCase(ANS_NO));
        System.out.println();
        if(verific.equalsIgnoreCase(ANS_YES)) {
            if (specifyNewTestTypeController.deleteTestType(codedel)) {
                System.out.println("Test Type deleted with success!");
            } else {
                System.out.println("Type Test not found!");
            }
        }
    }
}
