package app.domain.model;

import java.util.ArrayList;
import java.util.List;

/**
 * OrgRoleStore - Class responsible for managing OrgRoles
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 */

public class OrgRoleStore {

    /**
     * Initialize a list of org role.
     */
    private List<OrgRole> lor;

    /**
     * Initialize a list of OrgRole's store.
     */

    public OrgRoleStore () {
        this.lor = new ArrayList<>();
    }

    /**
     * Add an OrgRole.
     *
     * @param role OrgRole's role
     */

    public void addOrgRole (OrgRole role) {
        this.lor.add(role);
    }

    /**
     * Return the OrgRole's list.
     */

    public List<OrgRole> getOrgRoles () {
        if(lor!=null) {
            if (lor.isEmpty()) {
                throw new IllegalArgumentException("Organization Roles list is empty.");
            }
            return lor;
        }
        return null;
    }

    /**
     * Return the OrgRole's list.
     *
     * @param id OrgRole's id
     */

    public OrgRole getRoleById(String id) {
        for (OrgRole role : this.lor) {
            if(role.getId().equals(id)) return role;
        }
        throw new IllegalArgumentException("There is no Organization Role with that Id.");
    }

    /**
     * Change the OrgRole's list.
     *
     * @param lor OrgRole's list
     */

    public void setLor(List<OrgRole> lor){
        this.lor=lor;
    }
}
