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

    public List<TestDto> toDto(List<Test>list){
        List<TestDto> testDto = new ArrayList<>();

        for(Test test: list){
            long code = test.getCode();
            String description = test.getDescription();
            Client client = test.getClient();

            TestDto dto = new TestDto(code,description,client.getCitizenCard());
            dto.setNhsCode(test.getNhsCode());
            testDto.add(dto);
        }
        return testDto;
    }
    
    public List<TestDto> getTestCompletedList(TestStore testStore) {
        return testStore.getTestCompletedList();
    }


    public Test getTest(TestDto test) {     
        return this.company.getTestStore().getTestByCode(test.getCode());
    }


    public Test getTestInformation(Test test) {
        //possible changes to this
        return test;
    } 

}
