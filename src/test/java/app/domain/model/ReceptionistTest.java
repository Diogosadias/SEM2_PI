package app.domain.model;

import auth.AuthFacade;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReceptionistTest {

    Receptionist rec = new Receptionist("aaa@aaa.com","111","John","1111","1111","1111");


    @Test
    public void getClientStore() {
        CreateClientStore res;
        res = rec.getClientStore();
        assertEquals(res, rec.getClientStore());
    }
}