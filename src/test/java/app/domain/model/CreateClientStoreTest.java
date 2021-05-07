package app.domain.model;

import auth.AuthFacade;
import auth.domain.model.Email;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class CreateClientStoreTest {
    AuthFacade auth = new AuthFacade();
    CreateClientStore cr = new CreateClientStore(auth);


    @Test
    public void validateClient() {
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 111111111L, 1111111111111111L, 111111111111L, new Date("12/12/2021"), "M", 111111111111L);
        Client c2 = null;


        assertEquals(true,cr.validateClient(c1));

    }
}