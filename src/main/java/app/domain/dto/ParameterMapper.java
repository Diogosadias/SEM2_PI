package app.domain.dto;

import app.domain.model.Parameter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */

public class ParameterMapper {

    public List toDto(List<Parameter> list, String category) {
        List<ParameterDto> parametersDto = new ArrayList<>();
        for (Parameter p : list) {
            if (p.getCategory().equals(category)) {
                String code = p.getCode();
                String name = p.getName();
                parametersDto.add(new ParameterDto(code,name));
            }
        }
        return parametersDto;
    }
}
