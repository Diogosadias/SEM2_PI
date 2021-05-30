package app.ui.console;

import app.controller.ParameterCategoryController;
import app.ui.console.utils.Utils;

/**
 *
 * @author Tiago Ferreira <1200601@isep.ipp.pt>
 */

public class CreateNewParameterCategoryUI implements Runnable{

    public void run(){

        String code;
        String description;
        String nhsId;

        ParameterCategoryController pc = new ParameterCategoryController();
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
