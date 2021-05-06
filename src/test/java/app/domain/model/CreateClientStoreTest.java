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
        Client c = new Client(new Email("aaa@user.com"),"John",1111111111,123123123123123l,123123123123l,new Date("12/12/2012"),"M",123123123123l);
        Client c2 = null;


        assertEquals(true,cr.validateClient(c));

    }
}