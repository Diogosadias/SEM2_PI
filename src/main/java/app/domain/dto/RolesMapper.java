package app.domain.dto;

import app.domain.model.OrgRole;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago Rocha
 */
public class RolesMapper {



    public RolesMapper () {

    }

    public List<OrgRoleDto> toDto(List<OrgRole> list) {
        List<OrgRoleDto> rolesDto = new ArrayList<>();
        for (OrgRole role : list) {
            String id =  role.getId();
            String description = role.getDesignation();
            OrgRoleDto dto = new OrgRoleDto(id,description);
            rolesDto.add(dto);
        }
        return rolesDto;
    }
}
