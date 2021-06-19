package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Tiago Ferreira <1200601@isep.ipp.pt>
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */
/*
public class ClientUI implements Runnable{


    public void run() {

        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("NothingCreate Client", new ShowTextUI("Hello")));
        options.add(new MenuItem("List Clients", new ShowTextUI("Hello")));
        //options.add(new MenuItem("Find Client"))    TO DO
        //options.add(new MenuItem("Remove Client"))  TO DO
        //options.add(new MenuItem("Edit Client"))    TO DO

        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nClient Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );

    }

}*/
