package app.ui.console;

import app.controller.CreateTestTypeController;
import app.controller.ParameterCategoryController;
import app.domain.model.ParameterCategory;
import app.domain.model.ParameterCategoryStore;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateTestTypeUI implements Runnable {


    public void run() {
        CreateTestTypeController tc = new CreateTestTypeController();
        ParameterCategoryController pc = new ParameterCategoryController();
        ParameterCategoryStore pcs = new ParameterCategoryStore();

        String code;
        String description;
        String collectingMethod;
        ArrayList<ParameterCategory> ParameterList = new ArrayList<>();
        Scanner read = new Scanner(System.in);



        if(pcs.getParameterCategoryList().size() == 0)
            System.out.println("Can't create TestType without categories!");
        else{
        System.out.println("New code:");
        code = read.next();
        System.out.println("Description:");
        description = read.next();
        System.out.println("Collecting Method:");
        collectingMethod = read.next();

        tc.createTestType(code,description,collectingMethod);

        String codep = "";
        while( ! codep.equals("Finish")) {
            pc.writeParameters();
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
}