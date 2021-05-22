package app.domain.model;

import auth.AuthFacade;
import auth.domain.model.Email;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class CreateClientStoreTest {
    AuthFacade auth = new AuthFacade();

    Client c1 = new Client(new Email("usedafr1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("2001/12/22"), "M", 11111111111L);
    CreateClientStore store = new CreateClientStore(auth);


    @Test
    public void testCreateClient() {

        //calculations
        Client c2 = store.createClient("usxedar1@gmail.com", "John", 1111111111L, 1111111111111111L, 111111111111L, "2001/12/22", "M", 11111111111L);

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
        boolean b = store.validateClient(c1);
        assertEquals(true,b);
        store.saveClient(c1);
        boolean b1 = store.validateClient(c1);
        assertEquals(false,b1);
        boolean b2 = store.validateClient(null);
        assertFalse(b2);
    }

    @Test
    public void testSaveClient() {
        //testing
        assertTrue(store.saveClient(c1));

        Client c2 = new Client(new Email("usedafr1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("2001/12/22"), "M", 11111111111L);
        assertFalse(store.saveClient(c2));
    }

    @Test
    public void testGetClientList() {
        AuthFacade auth = null;
        CreateClientStore ccs = new CreateClientStore(auth);
        Client c1 = new Client(new Email("usewdar1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("2001/12/22"), "M", 11111111111L);
        List<Client> testList = new ArrayList<>();
        //calculations
        ccs.setClientList(c1);
        testList.add(c1);
        //assemble
        assertEquals(testList,ccs.getClientList());
    }
}