/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.domain.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static app.domain.shared.Constants.*;
import static org.junit.Assert.*;

/**
 *
 * @author Bruno Pereira
 */
public class OrgRoleStoreTest {

    OrgRole role = new OrgRole(RECEPTIONIST, MODEL_CLASS_PATH+ ROLE_RECEP);
    OrgRoleStore rs = new OrgRoleStore();

    /**
     * Test of addOrgRole method, of class OrgRoleStore.
     */
    @Test
    public void testAddOrgRole() {
        System.out.println("addOrgRole");
        OrgRoleStore instance = new OrgRoleStore();
        instance.addOrgRole(role);
        assertEquals(role, instance.getRoleById(role.getId()));
    }

    /**
     * Test of getOrgRoles method, of class OrgRoleStore.
     */
    @Test
    public void testGetOrgRoles() {
        System.out.println("getOrgRoles");
        OrgRoleStore instance = rs;
        List<OrgRole> expResult = new ArrayList<>();
        expResult.add(role);
        instance.addOrgRole(role);
        List<OrgRole> result = instance.getOrgRoles();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRoleById method, of class OrgRoleStore.
     */
    @Test
    public void testGetRoleById() {
        System.out.println("getRoleById");
        String id = role.getId();
        OrgRoleStore instance = rs;
        instance.addOrgRole(role);
        OrgRole expResult = role;
        OrgRole result = instance.getRoleById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of setLor method, of class OrgRoleStore.
     */
    @Test
    public void testSetLor() {
        System.out.println("setLor");
        List<OrgRole> lor = new ArrayList<>();
        lor.add(role);
        OrgRoleStore instance = rs;
        instance.setLor(lor);
        assertEquals(lor,instance.getOrgRoles());
    }
    
}
