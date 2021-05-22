package app.controller;

import app.domain.model.Client;
import app.domain.model.ClientStore;
import auth.AuthFacade;
import auth.domain.model.Email;
import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.*;
/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class CreateClientControllerTest{

    @Test
    public void testCreateClient() {

        //arrange
        CreateClientController ccr = new CreateClientController();

        //calculating
        boolean b1 = ccr.createClient("user2@gmail.com", "John", 1211111111, 1211111111111111l, 121111111111l, "12/12/2021", "M", 14411111111l);

        //assert
        assertEquals(true,b1);

    }

    @Test
    public void testSaveClient() {
        //arange
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("2021/12/22"), "M", 11111111111l);
        CreateClientController ccr = new CreateClientController();

        //calculation
        boolean b1 = ccr.saveClient(c1);

        //assert
        assertEquals(true,b1);
    }

    /*@Test
    public void testWriteClient() {
        //arrange
        AuthFacade auth = new AuthFacade();
        CreateClientController ccr = new CreateClientController();
        ClientStore ccs = new ClientStore(auth);
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 11111111111l);


        //calculations
        ccs.setClientList(c1);

        ccr.writeClient();




    }*/
}