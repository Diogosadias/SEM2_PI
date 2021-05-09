package app.domain.model;

import app.domain.model.Client;
import app.domain.model.CreateClientStore;
import auth.AuthFacade;
import auth.domain.model.Email;
import junit.framework.TestCase;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
/**
 *
 *  @author Márcio Ramos <1201682@isep.ipp.pt>
 */

public class CreateClientStoreTest extends TestCase {
    AuthFacade auth = new AuthFacade();
    Client c1 = new Client(new Email("usaer1@gmail.com"), "John", 1111111111l, 1111111111111111l, 111111111111l, new Date("2001/12/22"), "M", 11111111111l);
    CreateClientStore tccs = new CreateClientStore(auth);


    @Test
    public void testCreateClient() {
        //arrange


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("2021-12-12");



        //calculations
        Client c2 = tccs.createClient("user1@gmail.com", "John", 1111111111l, 1111111111111111l, 111111111111l, "12/12/2021", "M", 11111111111l);

        //assert
        assertEquals(c1.getPNumber(),c2.getPNumber());
        assertEquals(c1.getCitizenCard(),c2.getCitizenCard());
        assertEquals(c1.getNhs(),c2.getNhs());
        assertEquals(c1.getTin(),c2.getTin());
        assertEquals(c1.getSex(),c2.getSex());
    }

    @Test
    public void testValidateClient() {

        //testing
        boolean b = tccs.validateClient(c1);
        assertEquals(true,b);
        tccs.saveClient(c1,"asdf");
        boolean b1 = tccs.validateClient(c1);
        assertEquals(false,b1);
        boolean b2 = tccs.validateClient(null);
        assertFalse(b2);
    }


    @Test
    public void testSaveClient() {
        //testing

        boolean b = tccs.saveClient(c1,"asdf");
        assertEquals(true,b);

        boolean b1 = tccs.saveClient(c1,"asdf");
        assertEquals(false,b1);
    }

    @Test
    public void testGetClientList() {
        AuthFacade auth = null;
        CreateClientStore ccs = new CreateClientStore(auth);
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111l, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 11111111111l);
        List<Client> testList = new ArrayList<>();

        //calculations
        ccs.setClientList(c1);
        testList.add(c1);
        //assemble
        assertEquals(testList,ccs.getClientList());
    }
}