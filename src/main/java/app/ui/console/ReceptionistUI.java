package app.ui.console;


import app.controller.CreateClientController;
import app.domain.model.Client;
import app.domain.model.CreateClientStore;
import app.ui.console.utils.Utils;
import auth.domain.model.Email;
import auth.domain.model.Password;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
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
        //options.add(new MenuItem("Remove Client"))  TO DO
        //options.add(new MenuItem("Edit Client"))    TO DO
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






    public static class ListClientsUI implements Runnable {


        public void run() {
            CreateClientController ccr = new CreateClientController();
            ccr.writeClient();

        }



    }
}
