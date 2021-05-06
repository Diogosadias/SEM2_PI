package app.ui.console;

import app.controller.ParameterCategoryController;
import app.ui.console.utils.Utils;

import java.util.Scanner;

public class CreateNewParameterCategoryUI implements Runnable{

    public void run(){

        String code;
        String description;
        String nhsId;

        ParameterCategoryController pc = new ParameterCategoryController();
        Scanner read = new Scanner(System.in);
        code = Utils.readLineFromConsole("New code: ");
        description = Utils.readLineFromConsole("Description: ");
        nhsId = Utils.readLineFromConsole("NHSID: ");

        boolean created = pc.createParameterCategory(code,description,nhsId);

        if(created ){
            System.out.println("Parameter Category Created!");

        }

        else
            System.out.println("Unsuccesfully created the Parameter Category");
    }
}
