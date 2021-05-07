package app.ui.console;

import app.controller.SpecifyNewTestTypeController;
import app.domain.model.TestType;

import java.util.Scanner;

public class SearchTestTypeUI implements Runnable{
    public SearchTestTypeUI() {
    }


    @Override
    public void run() {
        Scanner read = new Scanner(System.in);
        SpecifyNewTestTypeController testTypeController = new SpecifyNewTestTypeController();
        TestType testType = new TestType();
        String searchcode;

        System.out.println("Insert the code of the test type you want to search:");
        System.out.print("-> ");
        searchcode = read.next();
        if (testTypeController.searchTestType(searchcode)) {
            System.out.println("Test Type found successfully!");
            testTypeController.writeTestTypeByCode(searchcode);
        } else {
            System.out.println("Test Type not found!");
        }
    }
}
