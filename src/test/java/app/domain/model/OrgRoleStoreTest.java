package app.domain.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */

public class OrgRoleStoreTest {
    OrgRole or1 = new OrgRole("123","aaaaa");
    OrgRole or2 = new OrgRole("142","aadaa");
    OrgRoleStore orStore = new OrgRoleStore();

    @Test
    public void addOrgRole() {
        List<OrgRole> listTest = new ArrayList<>();
        listTest.add(or1);
        listTest.add(or2);
        orStore.addOrgRole(or1);
        orStore.addOrgRole(or2);
        assertEquals(orStore.getOrgRoles(),listTest);
    }

    @Test
    public void getOrgRoles() {
        try{
            orStore.getOrgRoles();
        }catch(Exception ex){
            assertEquals(ex.getMessage(),"Organization Roles list is empty.");
        }
        orStore.setLor(null);
        assertEquals(orStore.getOrgRoles(),null);

    }

    @Test
    public void getRoleById() {
        try{
            orStore.getRoleById("123");
        }catch(Exception ex){
            assertEquals(ex.getMessage(),"There is no Organization Role with that Id.");
        }
    }

    @Test
    public void setLor() {
        List<OrgRole> listTest = new ArrayList<>();
        listTest.add(or1);
        listTest.add(or2);
        orStore.setLor(listTest);
        assertEquals(orStore.getOrgRoles(),listTest);
    }
}