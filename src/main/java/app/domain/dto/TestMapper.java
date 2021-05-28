package app.domain.dto;

import app.controller.App;
import app.domain.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

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
        if(list!=null) {
            for (Test test : list) {
                String code = test.getCode();
                String description = test.getDescription();
                Client client = test.getClient();

                TestDto dto = new TestDto(code, description, client.getCitizenCard());

                testDto.add(dto);
            }
            return testDto;
        }
        return null;
    }

    public List<TestDto> testParameters_toDto(List<Test> list){
        if(list!=null) {
        for(Test test: list){
            String code = test.getCode();
            List<ParameterCategory> listCategory = test.getListCategories() ;
            List<Parameter> listParameter = test.getListParameters() ;
            TestDto dto = new TestDto(code,listCategory,listParameter);
            testDto.add(dto);
        }
        return testDto;
        }
        return null;
    }

    public List<TestDto> testSamples_toDto(List<Test> list){
            if(list!=null) {
        for(Test test: list){
            String code = test.getCode();
            String collectionMethod = test.getDescription();
            List<Sample> listSample = test.getListSamples() ;
            TestDto dto = new TestDto(code,collectionMethod,listSample);
            testDto.add(dto);
        }
        return testDto;
            }
        return null;
    }

    public List<TestDto> listTestParameter_toDto(List<Test> list){
                if(list!=null) {
        for(Test test: list){
            String code = test.getCode();
            long tin = test.getClient().getTin();
            List<TestParameter> listTP = test.getListTestParameter();
            TestDto dto = new TestDto(code,tin,listTP);
            Date dateRegistered = test.getDateRegistered();
            Date dateChemical = test.getDateDiagnosis();
            dto.setDateRegistered(dateRegistered);
            dto.setDateChemicalAnalysis(dateChemical);
                if(test.getDateDiagnosis() != null) {
                    Date dateDiagnosis = test.getDateDiagnosis();
                    dto.setDateDiagnosis(dateDiagnosis);
                }
            testDto.add(dto);
            }
                    return testDto;
        }
        return null;
    }

}
