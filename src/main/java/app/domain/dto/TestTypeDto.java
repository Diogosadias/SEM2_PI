package app.domain.dto;

import java.util.List;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 */
public class TestTypeDto {

    private String code;
    private String description;
    private List<ParameterCategoryDto> listCategories;

    public TestTypeDto(String code, String description, List<ParameterCategoryDto> listCategories) {
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
    public List<ParameterCategoryDto> getListCategories() {
        return listCategories;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setListParameters(List<ParameterCategoryDto> listCategories) {
        this.listCategories = listCategories;
    }

    @Override
    public String toString() {
        return "[ " + description + " ]\n";
    }
}
