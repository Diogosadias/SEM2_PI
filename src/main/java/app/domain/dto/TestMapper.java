package app.domain.dto;

import app.domain.model.Client;
import app.domain.model.OrgRole;
import app.domain.model.Test;
import app.domain.model.TestStore;

import java.util.ArrayList;
import java.util.List;

public class TestMapper {
    private ArrayList<Test> testlist;


    public TestMapper(){ }

    public List<TestDto> toDto(List<Test>list){

        List<TestDto> testDto = new ArrayList<>();

        for(Test test: list){
            String code = test.getNHSCode();
            Client client = test.getClient();

            TestDto dto = new TestDto(code,client);

            testDto.add(dto);
        }
        return testDto;
    }

    public TestDto getTestCompletedList(TestStore testStore) {
        return testStore.getTestCompletedList();
    }


    public Test getTestInformation(Test test) {
        //possible changes to this
        return test;
    }
}
