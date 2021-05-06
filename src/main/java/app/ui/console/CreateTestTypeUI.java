package app.ui.console;

import app.controller.ParameterCategoryController;
import app.controller.SpecifyNewTestTypeController;
import app.domain.model.ParameterCategory;
import app.domain.model.ParameterCategoryStore;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateTestTypeUI implements Runnable {


    public void run() {
        SpecifyNewTestTypeController tc = new SpecifyNewTestTypeController();
        ParameterCategoryController pc = new ParameterCategoryController();

        String code;
        String description;
        String collectingMethod;
        Scanner read = new Scanner(System.in);

        System.out.println("Create New Type Test:");

        System.out.println("New code:");
        code = read.next();
        System.out.println("Description:");
        description = read.next();
        System.out.println("Collecting Method:");
        collectingMethod = read.next();

        pc.writeParameterCategories();
        tc.createTestType(code,description,collectingMethod);

        String codep = "";
        while( ! codep.equalsIgnoreCase("Finish")) {
            pc.writeParameterCategories();
            System.out.println("Type parameter's code(Type Finish to end:");
            codep = read.next();

            if(pc.getParameterCategory(codep) == null)
                System.out.println("Parameter doesn't exist!");
            else
                tc.addParameterToTest(pc.getParameterCategory(codep));

            tc.writeTestType();



    }
    }
}