package app.ui.console;

import app.controller.CreateClientController;

public class ListClientsUI implements Runnable {


    public void run() {
        CreateClientController ccr = new CreateClientController();
        ccr.writeClient();

    }


}
