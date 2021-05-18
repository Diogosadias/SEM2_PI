package app.domain.dto;

import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;

import java.util.List;

public class TestTypeDto {

    private String code;
    private String description;
    private List<ParameterCategory> listCategories;

    public TestTypeDto(String code, String description, List<ParameterCategory> listCategories) {
        this.code = code;
        this.description = description;
        this.listCategories = listCategories;
    }

    public String getCode() {
        return code;
    }
    public String getDescription() {
        return description;
    }
    public List<ParameterCategory> getListCategories() {
        return listCategories;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setListParameters(List<ParameterCategory> listCategories) {
        this.listCategories = listCategories;
    }

    @Override
    public String toString() {
        return "[ " + description + " ]\n";
    }
}
