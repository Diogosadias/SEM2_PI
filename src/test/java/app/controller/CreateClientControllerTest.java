package app.controller;

import app.domain.model.Client;
import app.domain.model.CreateClientStore;
import auth.AuthFacade;
import auth.domain.model.Email;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Date;

public class CreateClientControllerTest extends TestCase {

    public void testCreateClient() {

        //arrange
        CreateClientController ccr = new CreateClientController();

        //calculating
        boolean b1 = ccr.createClient("user1@gmail.com", "John", 1111111111, 1111111111111111l, 111111111111l, "12/12/2021", "M", 111111111111l);

        //assert
        assertEquals(true,b1);

    }

    public void testSaveClient() {
        //arange
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);
        CreateClientController ccr = new CreateClientController();

        //calculation
        boolean b1 = ccr.saveClient(c1,"aaaa");

        //assert
        assertEquals(false,b1);
    }

    public void testWriteClient() {
        //arrange
        AuthFacade auth = new AuthFacade();
        CreateClientController ccr = new CreateClientController();
        CreateClientStore ccs = new CreateClientStore(auth);
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);


        //calculations
        ccs.setClientList(c1);

        ccr.writeClient();




    }
}