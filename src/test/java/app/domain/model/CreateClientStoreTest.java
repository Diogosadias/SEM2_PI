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

public class CreateClientStoreTest extends TestCase {
    AuthFacade auth = new AuthFacade();
    Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M", 111111111111L);
    CreateClientStore tccs = new CreateClientStore(auth);


    @Test
    public void testCreateClient() {
        //arrange


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("2021-12-12");



        //calculations
        Client c2 = tccs.createClient("user1@gmail.com", "John", 1111111111L, 1111111111111111L, 111111111111L, "12/12/2021", "M", 111111111111L);

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

        //arrange
        AuthFacade auth = new AuthFacade();
        CreateClientStore ccs = new CreateClientStore(auth);
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M", 111111111111L);

        //calculations
        boolean b = ccs.saveClient(c1,"pwd");

        //assert
        assertEquals(true,b);
    }

    @Test
    public void testGetClientList() {
        AuthFacade auth = null;
        CreateClientStore ccs = new CreateClientStore(auth);
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M", 111111111111L);
        List<Client> testList = new ArrayList<>();

        //calculations
        ccs.setClientList(c1);
        testList.add(c1);
        //assemble
        assertEquals(testList,ccs.getClientList());
    }
}