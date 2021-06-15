package app.ui.console;

import app.controller.ParameterCategoryController;
import app.controller.SpecifyNewTestTypeController;
import app.domain.model.ParameterCategory;

import java.util.Scanner;

/**
 *  Controller for the US9 realization - Register a new Test Type
 *
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 * @author Márcio Ramos <1181835@isep.ipp.pt>
 */
public class SpecifyNewTestTypeUI implements Runnable {


    public void run() {
        SpecifyNewTestTypeController tc = new SpecifyNewTestTypeController();
        ParameterCategoryController pc = new ParameterCategoryController();

        String code;
        String description;
        String collectingMethod;
        Scanner read = new Scanner(System.in);

        System.out.println("Create New Type Test:");

        System.out.println("New code(5 alphanumeric characters):");
        code = read.next();
        read.nextLine();
        System.out.println("Description(max. 15 characters):");
        description = read.nextLine();
        System.out.println("Collecting Method(max. 20 characters):");
        collectingMethod = read.nextLine();
        System.out.print("\n");


        tc.createTestType(code,description,collectingMethod);

         String codep;
        do {
            tc.writeTestType();
            System.out.println("\nParameter Categories: ");
            pc.writeParameterCategories();
            System.out.println("Type parameter's code: (Type Finish to end)");
            codep = read.nextLine();
            ParameterCategory codeparameter  = pc.getParameterCategory(codep);
            if (codeparameter == null) {
                System.out.println("Parameter Category doesn't exist!");
            } else
                tc.addParameterToTest(pc.getParameterCategory(codep));
            System.out.print("\n");

        } while( ! codep.equalsIgnoreCase("Finish"));
        System.out.println("Test Type Created!");
    }
}