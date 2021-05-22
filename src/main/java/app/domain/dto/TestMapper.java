package app.domain.dto;

import app.controller.App;
import app.domain.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 */
public class TestMapper {
    
    private Company company;

    public TestMapper () {
        this.company = App.getInstance().getCompany();
    }

    public List<TestDto> toDto(List<Test> list){
        List<TestDto> testDto = new ArrayList<>();
        for(Test test: list){
            String code = test.getCode();
            String description = test.getDescription();
            Client client = test.getClient();

            TestDto dto = new TestDto(code,description,client.getCitizenCard());

            testDto.add(dto);
        }
        return testDto;
    }

}
