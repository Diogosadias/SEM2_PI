/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.dto;

import app.domain.model.OrgRole;

import java.util.ArrayList;
import java.util.List;

import app.domain.model.Parameter;
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
public class RolesMapperTest {

    RolesMapper mapper = new RolesMapper();
    OrgRole or = new OrgRole("123", "teste");
    OrgRoleDto orDto = new OrgRoleDto("123", "teste");
    List<OrgRole> orgRoles = new ArrayList<>();

    /**
     * Test of toDto method, of class RolesMapper.
     */
    @Test
    public void testToDto() {
        System.out.println("toDto");
        List<OrgRoleDto> expResult = new ArrayList<>();
        expResult.add(orDto);
        orgRoles.add(or);
        RolesMapper instance = mapper;
        List<OrgRoleDto> result = instance.toDto(orgRoles);
        assertEquals(expResult.get(0).getId(), result.get(0).getId());
    }
    
}
