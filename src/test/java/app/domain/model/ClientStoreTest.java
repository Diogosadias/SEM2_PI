package app.domain.model;

import static org.junit.Assert.*;

import auth.AuthFacade;
import auth.domain.model.Email;
import org.junit.Test;

import java.util.Date;

public class ClientStoreTest {
    AuthFacade auth = new AuthFacade();

    Client c1 = new Client(new Email("usedafr1@gmail.com"), "John", 1111111111L, 1111111111111111L, 111111111111L, new Date("2001/12/22"), "M", 11111111111L);
    ClientStore store = new ClientStore(auth);


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

}