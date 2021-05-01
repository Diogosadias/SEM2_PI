package app.domain.model;

import app.ui.console.MenuItem;
import app.ui.console.ReceptionistUI;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ClientUI implements Runnable{


    public void run() {

        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("NothingCreate Client", new ReceptionistUI.CreateClientUI()));
        options.add(new MenuItem("List Clients", new ReceptionistUI.CreateClientUI()));
        //options.add(new MenuItem("Find Client"))    TO DO
        //options.add(new MenuItem("Remove Client"))  TO DO
        //options.add(new MenuItem("Edit Client"))    TO DO
        boolean success = false;
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

}
