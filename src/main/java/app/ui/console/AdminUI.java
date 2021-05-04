package app.ui.console;

import app.controller.ParameterCategoryController;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 * @author Tom�s Pinto <1181835@isep.ipp.pt>
 */

public class AdminUI implements Runnable{
    public AdminUI()
    {
    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Create type of test", new CreateTypeTestUI()));
        options.add(new MenuItem("Edit type test", new ShowTextUI("You have chosen Option B.")));
        options.add(new MenuItem("List types of test", new ShowTextUI("You have chosen Option C.")));
        options.add(new MenuItem("Search types of test", new ShowTextUI("You have chosen option D")));
        options.add(new MenuItem("Delete type of test", new ShowTextUI("You have chosen option E")));
        options.add(new MenuItem("New Parameter", new SpecifyNewParameterUI()));
        options.add(new MenuItem("New Parameter Category", new CreateNewParameterUI()));
        options.add(new MenuItem("Register employee", new RegisterEmployeeUI()));

        boolean success = false;

        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }

    public static class CreateTypeTestUI implements Runnable {


        public void run() {
            String code;
            String description;
            String collectingMethod;
            String [] parameterArray = new String[100];
            Scanner read = new Scanner(System.in);
            System.out.println("New code:");
            code = read.next();
            System.out.println("Description:");
            description = read.next();
            System.out.println("Collecting Method:");
            collectingMethod = read.next();

            String parameter = "";
            while( ! parameter.equals("Finish")) {
                int i = 0;
                System.out.println("Add new parameter to the test (Type Finish to end:");
                parameter = read.next();
                parameterArray[i++] = parameter;
            }





        }
    }

    public static class CreateNewParameterUI implements Runnable{

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
               pc.writeParameters();
           }

           else
               System.out.println("Unsuccesfully created the Parameter Category");
        }
    }
}
