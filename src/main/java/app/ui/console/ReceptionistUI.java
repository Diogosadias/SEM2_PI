package app.ui.console;


import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Gil <1180838@isep.ipp.pt>
 */
public class ReceptionistUI implements Runnable {

    public ReceptionistUI() {
    }

    public void run() {

        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Create Client", new CreateClientUI()));
        options.add(new MenuItem("List Clients", new ListClientsUI()));
        //options.add(new MenuItem("Find Client"))    TO DO
        //options.add(new MenuItem("Remove Client", new DeleteClientUI()));
        //options.add(new MenuItem("Edit Client"))    TO DO
        options.add(new MenuItem("Register Test", new RegisterTestUI()));
        options.add(new MenuItem("List Registered Tests", new ListRegisteredTestsUI()));
        boolean success = false;
        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nReceptionist Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );

    }


}
