package app.domain.model;

import auth.AuthFacade;
import auth.domain.model.Email;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class CreateClientStoreTest {
    AuthFacade authFacade= new AuthFacade();
    CreateClientStore p = new CreateClientStore(authFacade);
    @Test
    public void getClientList() {
        
    }
}