package app.test;

import app.domain.model.Client;
import app.domain.store.CreateClientStore;
import auth.AuthFacade;
import auth.domain.model.Email;
import junit.framework.TestCase;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreateClientStoreTest extends TestCase {


    @Test
    public void testCreateClient() {
        //arrange
        AuthFacade auth = null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("2021-12-12");

        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);
        CreateClientStore tccs = new CreateClientStore(auth);


        //calculations
        Client c2 = tccs.createClient("user1@gmail.com", "John", 1111111111, 1111111111111111l, 111111111111l, "12/12/2021", "M", 111111111111l);

        //assert
        assertEquals(c1.getPNumber(),c2.getPNumber());
        assertEquals(c1.getCitizenCard(),c2.getCitizenCard());
        assertEquals(c1.getNhs(),c2.getNhs());
        assertEquals(c1.getTin(),c2.getTin());
        assertEquals(c1.getSex(),c2.getSex());
    }

    @Test
    public void testValidateClient() {

        //arrange
        AuthFacade auth = null;
        CreateClientStore ccs = new CreateClientStore(auth);
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);

        //calculations
        boolean b = ccs.validateClient(c1);

        //assert
        assertEquals(true,b);
    }


    @Test
    public void testSaveClient() {

        //arrange
        AuthFacade auth = new AuthFacade();
        CreateClientStore ccs = new CreateClientStore(auth);
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);

        //calculations
        boolean b = ccs.saveClient(c1,"pwd");

        //assert
        assertEquals(true,b);
    }

    @Test
    public void testGetClientList() {
        AuthFacade auth = null;
        CreateClientStore ccs = new CreateClientStore(auth);
        Client c1 = new Client(new Email("user1@gmail.com"), "John", 1111111111, 1111111111111111l, 111111111111l, new Date("12/12/2021"), "M", 111111111111l);
        List<Client> testList = new ArrayList<>();

        //calculations
        ccs.setClientList(c1);
        testList.add(c1);
        //assemble
        assertEquals(testList,ccs.getClientList());
    }
}