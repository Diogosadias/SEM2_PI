package app.ui.console;

import app.controller.CreateClientController;

/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class ListClientsUI implements Runnable {


    public void run() {
        CreateClientController ccr = new CreateClientController();
        ccr.writeClient();

    }


}
