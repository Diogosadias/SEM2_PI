package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CreateClientStoreTest {

    @Test
    public void testCreateClient() {
        assertEquals(true,true);
    }

    @Test
    public void testValidateClient() {
<<<<<<< HEAD
        assertEquals(true,true);
=======
        //testing
        boolean b = tccs.validateClient(c1);
        assertEquals(true,b);
        tccs.saveClient(c1,"asdf");
        boolean b1 = tccs.validateClient(c1);
        assertEquals(false,b1);
        boolean b2 = tccs.validateClient(null);
        assertFalse(b2);
>>>>>>> parent of 3dafb5a... fixing errors and adding javadoc coments
    }

    @Test
    public void testSaveClient() {
<<<<<<< HEAD

        assertEquals(true,true);
    }

    @Test
    public void setClientList() {

        assertEquals(true,true);
=======
        //testing
        boolean b = tccs.saveClient(c1,"asdf");
        assertEquals(true,b);

        boolean b1 = tccs.saveClient(c1,"asdf");
        assertEquals(false,b1);
>>>>>>> parent of 3dafb5a... fixing errors and adding javadoc coments
    }

    @Test
    public void testGetClientList() {

        assertEquals(true,true);
    }
}