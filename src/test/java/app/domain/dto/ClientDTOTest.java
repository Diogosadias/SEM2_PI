/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.dto;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruno Pereira
 */
public class ClientDTOTest {

    ClientDTO c = new ClientDTO("Teste", 11111111111L);

    /**
     * Test of getName method, of class ClientDTO.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        ClientDTO instance = c;
        String expResult = "Teste";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTin method, of class ClientDTO.
     */
    @Test
    public void testGetTin() {
        System.out.println("getTin");
        ClientDTO instance = c;
        long expResult = 11111111111L;
        long result = instance.getTin();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ClientDTO.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ClientDTO instance = c;
        String expResult = "ClientDTO{name='"+ c.getName() +"', tin=" + c.getTin() +"";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toStringNameAndTIN method, of class ClientDTO.
     */
    @Test
    public void testToStringNameAndTIN() {
        System.out.println("toStringNameAndTIN");
        ClientDTO instance = c;
        String expResult = c.getName() +", TIN: " + c.getTin();
        String result = instance.toStringNameAndTIN();
        assertEquals(expResult, result);
    }
    
}
