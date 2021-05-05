package app.ui.console;

import app.controller.ParameterCategoryController;

import java.util.Scanner;

public class CreateNewParameterUI implements Runnable{

    public void run(){

        String code;
        String description;
        String nhsId;

        ParameterCategoryController pc = new ParameterCategoryController();
        Scanner read = new Scanner(System.in);
        System.out.println("New code:");
        code = read.next();
        System.out.println("Description:");
        description = read.next();
        System.out.println("NHSID:");
        nhsId= read.next();

        boolean created = pc.createParameterCategory(code,description,nhsId);

        if(created ){
            System.out.println("Parameter Category Created!");
        }

        else
            System.out.println("Unsuccesfully created the Parameter Category");
    }
}
