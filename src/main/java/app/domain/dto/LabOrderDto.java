package app.domain.dto;

import app.domain.model.Parameter;

import java.util.List;

public class LabOrderDto {

    private String type ;

    private List<Parameter> listParameters;

    public LabOrderDto(String type, List<Parameter> listParameters) {
        this.type = type;
        this.listParameters = listParameters;
    }

    public String getType() {
        return type;
    }

    public List<Parameter> getListParameters() {
        return listParameters;
    }
}
