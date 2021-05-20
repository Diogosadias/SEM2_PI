package app.domain.dto;

import app.domain.model.*;

import java.util.ArrayList;
import java.util.List;

public class TestMapper {


    public TestMapper () {

    }

    public List<TestDto> toDto(List<Test>list){

        List<TestDto> testDto = new ArrayList<>();

        for(Test test: list){
            long code = test.getCode();
            String description = test.getDescription();
            Client client = test.getClient();

            TestDto dto = new TestDto(code,description,client);

            testDto.add(dto);
        }
        return testDto;
    }

    public TestDto getTestCompletedList(TestStore testStore) {
        if(testStore!=null){
            return testStore.getTestCompletedList();

        }
        return null;
    }


    public Test getTestInformation(Test test) {
        //possible changes to this
        return test;
    }

}
