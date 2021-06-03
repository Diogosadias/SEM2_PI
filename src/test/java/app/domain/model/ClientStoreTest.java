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
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */

public class ClientStoreTest {
    AuthFacade auth = new AuthFacade();

    Client c1 = new Client(new Email("usedafr1@gmail.com"), "John", 1111111111L, 1111111111111111L, 1111111111L, new Date("2001/12/22"), "M", 11111111111L);
    ClientStore store = new ClientStore(auth);

    @Test
    public void testCreateClient() {
        ClientStore store = new ClientStore(auth);
        //calculations
        Client c2 = store.createClient("usxedar1@gmail.com", "John", 1111111111L, 1111111111111111L, 1111111111L, "2001/12/22", "M", 11111111111L);

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

        Client c2 = new Client(new Email("usrd6f3@gmail.com"), "John", 1111111111L, 1111111111111111L, 1111111111L, new Date("2001/12/22"), "M", 11111111111L);

        Client c3 = new Client(new Email("usrda31@gmail.com"), "John", 1111511111L, 1113111111111111L, 1111111111L, new Date("2001/12/22"), "M", 11111111111L);
        Client c4 = new Client(new Email("usrd3fr1@gmail.com"), "John", 1111111151L, 1111116111111111L, 1111111111L, new Date("2001/12/22"), "M", 11113111111L);
        Client c5 = new Client(new Email("us5fr1@gmail.com"), "John", 1111111111L, 1111111111171111L, 1111711111L, new Date("2001/12/22"), "M", 11113111111L);
        store.saveClients(c2,"aaaa");
        store.saveClients(c3,"aaaa");
        store.saveClients(c4,"aaaa");
        store.saveClients(c5,"aaaa");
        assertFalse(store.validateClient(c2));
        assertFalse(store.validateClient(c3));
        assertFalse(store.validateClient(c4));
        assertFalse(store.validateClient(c5));
    }

    @Test
    public void testSaveClients() {
        //testing
        Client c2 = store.createClient("usxeeedar1@gmail.com", "Johnn", 1111111110L, 1111101111111111L, 1011111111L, "2001/12/22", "M", 11011111111L);
        boolean test1 = store.saveClients(c1,"aaaa");
        assertTrue(test1);
    }

    @Test
    public void setClientList() {
    }

    @Test
    public void testGetClientList() {
        ClientStore ccs = new ClientStore(null);
        Client c1 = new Client(new Email("usewdar1@gmail.com"), "John", 1111111111L, 1111111111111111L, 1111111111L, new Date("2001/12/22"), "M", 11111111111L);
        List<Client> testList = new ArrayList<>();
        //calculations
        ccs.setClientList(c1);
        testList.add(c1);
        //assemble
        assertEquals(testList,ccs.getClientList());
    }

    @Test
    public void getClientByCC() {
        ClientStore ccs = new ClientStore(null);
        Client c1 = new Client(new Email("usewdar1@gmail.com"), "John", 1111111111L, 1111111111111111L, 1111111111L, new Date("2001/12/22"), "M", 11111111111L);
        List<Client> testList = new ArrayList<>();
        //calculations
        ccs.setClientList(c1);
        testList.add(c1);
        //assemble
        assertEquals(testList.get(0),ccs.getClientByCC(1111111111111111L));
        assertEquals(null,ccs.getClientByCC(1111111111311111L));
    }

    @Test
    public void getClientByTIN() {
    }
}