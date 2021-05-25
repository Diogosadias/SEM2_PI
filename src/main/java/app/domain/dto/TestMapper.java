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
    List<TestDto> testDto;
    public TestMapper () {
        this.company = App.getInstance().getCompany();
        testDto = new ArrayList<>();
    }

    public List<TestDto> toDto(List<Test> list){

        for(Test test: list){
            String code = test.getCode();
            String description = test.getDescription();
            Client client = test.getClient();

            TestDto dto = new TestDto(code,description,client.getCitizenCard());

            testDto.add(dto);
        }
        return testDto;
    }

    public List<TestDto> testParameters_toDto(List<Test> list){

        for(Test test: list){
            String code = test.getCode();
            List<ParameterCategory> listCategory = test.getListCategories() ;
            List<Parameter> listParameter = test.getListParameters() ;
            TestDto dto = new TestDto(code,listCategory,listParameter);
            testDto.add(dto);
        }
        return testDto;
    }

    public List<TestDto> testSamples_toDto(List<Test> list){

        for(Test test: list){
            String code = test.getCode();
            String collectionMethod = test.getDescription();
            List<Sample> listSample = test.getListSamples() ;
            TestDto dto = new TestDto(code,collectionMethod,listSample);
            testDto.add(dto);
        }
        return testDto;
    }

    public List<TestDto> testResults_toDto(List<Test> list){

        for(Test test: list){
            String code = test.getCode();
            List<TestParameter> listTP = test.getListTestParameter();
            TestDto dto = new TestDto(code,listTP);
            testDto.add(dto);
        }
        return testDto;
    }

}
