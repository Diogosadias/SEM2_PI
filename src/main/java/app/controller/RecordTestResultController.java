package app.controller;

import app.domain.dto.ParameterDto;
import app.domain.dto.TestDto;
import app.domain.dto.TestMapper;
import app.domain.model.*;
import app.domain.shared.ExternalModule;

import java.util.List;

import static app.domain.shared.Constants.*;

public class RecordTestResultController {
    private Company company;
    private TestStore tstore;

    public RecordTestResultController(){
        /*if (!App.getInstance().getCurrentUserSession().isLoggedInWithRole(ROLE_CHEM_TECH)) {
            throw new IllegalStateException("Access Unauthorized!");
        }*/
        this.company = App.getInstance().getCompany();
        this.tstore = this.company.getTestStore();
    }

    public TestStore getTestStore () {
        return this.tstore;
    }

    public List<ParameterDto> getListParameters (String testCode) {
        this.tstore.setTest(this.company.getTestStore().getTestByCode(testCode));
        return this.tstore.getListParametersFromTest();
    }

    public boolean addTestResult(ParameterDto dto, String result, double metric){
        this.tstore.getTest().addTestResult(dto.getCode(),result,metric);
        return this.validateTestResult();
    }

    public boolean validateTestResult () {
        List<TestParameter> listTestParameter = this.tstore.getTest().getListTestParameter();
        TestParameter testParam = this.tstore.getTest().getCurrentTestParameter();
        for (TestParameter tp : listTestParameter) {
            if (tp.getParameter().getCode().equals(testParam.getParameter().getCode())){
                System.out.println("Error: This parameter is already tested.");
                return false;
            }
        }
        return (testParam.getResult() != null);
    }

    public boolean saveTestResult() {
        return this.tstore.getTest().addResultToList();
    }


    public List<TestDto> getTests() {
        List<Test> tests = this.tstore.getSampleCollectedTests();
        TestMapper mapper = new TestMapper();
        return mapper.testSamples_toDto(tests);
    }

    public Company getCompany() {
        return company;
    }
}
