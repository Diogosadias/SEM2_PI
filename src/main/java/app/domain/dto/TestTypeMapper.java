package app.domain.dto;

import app.domain.model.ParameterCategory;
import app.domain.model.TestType;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 */

public class TestTypeMapper {

    public List<TestTypeDto> toDto(List<TestType> types) {
        List<TestTypeDto> ttDto =new ArrayList<>();
        for (TestType t : types) {
            String ttCode = t.getCode();
            String ttDescription = t.getDescription();
            List<ParameterCategory> listCategories = t.getListParameters();
            List<ParameterCategoryDto> categoriesDto = new ArrayList<>();
            for (ParameterCategory pc : listCategories) {
                String pcCode = pc.getCode();
                String pcDescription = pc.getDescription();
                ParameterCategoryDto pcDto = new ParameterCategoryDto(pcCode,pcDescription);
                categoriesDto.add(pcDto);
            }
            ttDto.add(new TestTypeDto(ttCode,ttDescription,categoriesDto));
        }
        return ttDto;
    }
}
