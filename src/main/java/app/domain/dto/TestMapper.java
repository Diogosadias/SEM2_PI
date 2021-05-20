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
    
    private ClientStore cstore;
    private Company company;

    public TestMapper () {
        this.company = App.getInstance().getCompany();
        this.cstore = this.company.getCreateClientStore();
    }

//    public LabOrderDto toOrderDto(LabOrder order) {
//        String type = order.getTestType();
//        List<Parameter> listParameters  = order.getListParameters();
//        return new LabOrderDto(type,listParameters);
//    }

    public List<TestDto> toDto(List<Test>list){
        List<TestDto> testDto = new ArrayList<>();

        for(Test test: list){
            Client client = test.getClient();
            String dateChemical = test.getDateChemical();
            String dateDiagnosis = test.getDateDiagnosis();
            String dateValidation = test.getDateValidation();
            String description = test.getDescription();
            String nhsCode = test.getNHSCode();
            String parameterValue = test.getParameterValue();
            String dateSample = test.getSampleDate();
            List<Sample> sampleList = test.getSampleList();

            TestDto dto = new TestDto(dateSample, dateValidation, dateDiagnosis, dateChemical, description, nhsCode, parameterValue, client.toString(), sampleList);

            testDto.add(dto);
        }
        return testDto;
    }
    
    public List<TestDto> getTestCompletedList(TestStore testStore) {
        return testStore.getTestCompletedList();
    }


    public Test getTest(TestDto test) {
        Client client = this.cstore.getClientByCC(Long.valueOf(test.getClient()));        
        Test res = new Test(test.getSampleDate(), test.getDateValidation(), test.getDateDiagnosis(), test.getDateChemical(), test.getDescription(), test.getNHSCode(), test.getParameterValue(), client, test.getSampleList());        
        return res;
    }


    public Test getTestInformation(Test test) {
        //possible changes to this
        return test;
    } 

}
