package app.domain.model;

import auth.AuthFacade;
import auth.domain.model.Email;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */

public class ClientStoreTest {
    AuthFacade auth = new AuthFacade();

    Client c1 = new Client(new Email("usedafr1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("2001/12/22"), "M", 11111111111L);
    ClientStore store = new ClientStore(auth);

    @Test
    public void testCreateClient() {
        ClientStore store = new ClientStore(auth);
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
        assertTrue(b);
        store.saveClients(c1,"aaaa");
        boolean b1 = store.validateClient(c1);
        assertFalse(b1);
        boolean b2 = store.validateClient(null);
        assertFalse(b2);
    }

    @Test
    public void testSaveClients() {
        //testing
        Client c2 = store.createClient("usxeeedar1@gmail.com", "Johnn", 1111111110L, 1111101111111111L, 101111111111L, "2001/12/22", "M", 11011111111L);
        boolean test1 = store.saveClients(c1,"aaaa");
        assertTrue(test1);
    }

    @Test
    public void setClientList() {
    }

    @Test
    public void testGetClientList() {
        ClientStore ccs = new ClientStore(null);
        Client c1 = new Client(new Email("usewdar1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("2001/12/22"), "M", 11111111111L);
        List<Client> testList = new ArrayList<>();
        //calculations
        ccs.setClientList(c1);
        testList.add(c1);
        //assemble
        assertEquals(testList,ccs.getClientList());
    }

    @Test
    public void getClientByCC() {
    }

    @Test
    public void getClientByTIN() {
    }
}