package app.domain.dto;

import app.domain.model.ParameterCategory;
import app.domain.model.TestType;

import java.util.ArrayList;
import java.util.List;

public class TestTypeMapper {

    public TestTypeMapper() {
    }

    public List toDto(List<TestType> types) {
        List<TestTypeDto> dto =new ArrayList<>();
        for (TestType t : types) {
            String code = t.getCode();
            String description = t.getDescription();
            List<ParameterCategory> lpc = t.getListParameters();
            dto.add(new TestTypeDto(code,description,lpc));
        }
        return dto;
    }
}
