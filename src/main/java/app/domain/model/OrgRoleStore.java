package app.domain.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 */

public class OrgRoleStore {

    private List<OrgRole> lor;

    public OrgRoleStore () {
        this.lor = new ArrayList<>();
    }
    public void addOrgRole (OrgRole role) {
        this.lor.add(role);
    }

    public List<OrgRole> getOrgRoles () {
        if(lor!=null) {
            if (lor.isEmpty()) {
                throw new IllegalArgumentException("Organization Roles list is empty.");
            }
            return lor;
        }
        return null;
    }

    public OrgRole getRoleById(String id) {
        for (OrgRole role : this.lor) {
            if(role.getId().equals(id)) return role;
        }
        throw new IllegalArgumentException("There is no Organization Role with that Id.");
    }

    public void setLor(List<OrgRole> lor){
        this.lor=lor;
    }
}
