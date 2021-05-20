package app.domain.dto;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 */
public class OrgRoleDto {

    private String id;
    private String designation;

    public OrgRoleDto(String id, String designation) {
        this.id = id;
        this.designation = designation;
    }

    //gets
    public String getId() {
        return id;
    }
    public String getDesignation() {
        return designation;
    }

    //sets
    public void setId(String id) {
        this.id = id;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "[ " + this.id + " ]";
    }
}
