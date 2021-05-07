package app.ui.console;

import app.controller.ParameterController;
import app.controller.SpecifyNewTestTypeController;

import java.util.Scanner;
import static app.domain.shared.Constants.ANS_NO;
import static app.domain.shared.Constants.ANS_YES;

public class DeleteTypeTestUI implements Runnable{
    public DeleteTypeTestUI () {

    }

    public void run() {
        Scanner read = new Scanner(System.in);
        SpecifyNewTestTypeController testTypeController = new SpecifyNewTestTypeController();
        String codedel;
        String verific;

        System.out.println("Choose the code of the parameter you want to delete:\n");
        testTypeController.writeTestType();
        System.out.print("\n->");
        codedel= read.next();
        do {
            System.out.println("\n Are you sure you want to delete this test type?(Y/N)");
            verific = read.next().trim();
        }while(!verific.equalsIgnoreCase(ANS_YES) && !verific.equalsIgnoreCase(ANS_NO));
        System.out.println();
        if(verific.equalsIgnoreCase(ANS_YES)) {
            if (testTypeController.deleteTestType(codedel)) {
                System.out.println("Test Type deleted with success!");
            } else {
                System.out.println("Test Type not found!");
            }
        }

    }
}
