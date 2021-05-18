package app.domain.dto;

import app.domain.model.Parameter;

import java.util.ArrayList;
import java.util.List;

public class ParameterMapper {

    public ParameterMapper() {
    }

    public List toDto(List<Parameter> list, String category) {
        List<ParameterDto> dto = new ArrayList<>();
        for (Parameter p : list) {
            if (p.getCategory().equals(category)) {
                String code = p.getCode();
                String name = p.getName();
                dto.add(new ParameterDto(code,name));
            }
        }
        return dto;
    }
}
