/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.dto;

import app.domain.model.Client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import auth.domain.model.Email;
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
public class ClientMapperTest {

    ClientMapper mapper = new ClientMapper();
    Client c = new Client(new Email("teste@gmail.com"), "teste", 1111111111L, 11111111111L, 1111111111L, new Date(), 11111111111L);
    ClientDTO cDto = new ClientDTO("teste", 1111111111L);
    List<Client> clients = new ArrayList<>();

    /**
     * Test of toDto method, of class ClientMapper.
     */
    @Test
    public void testToDto() {
        System.out.println("toDto");
        List<ClientDTO> expResult = new ArrayList<>();
        expResult.add(cDto);
        clients.add(c);
        ClientMapper instance = mapper;
        List<ClientDTO> result = instance.toDto(clients);
        assertEquals(expResult.get(0).getName(), result.get(0).getName());
    }
    
}
