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
    private ParameterStore ps;
    private ExternalModule em;

    public RecordTestResultController(){
        if (!App.getInstance().getCurrentUserSession().isLoggedInWithRole(ROLE_CHEM_TECH)) {
            throw new IllegalStateException("Access Unauthorized!");
        }
        this.company = App.getInstance().getCompany();
        this.tstore = this.company.getTestStore();
    }

    public List<ParameterDto> getListParameters (String testCode) {
        this.tstore.setTest(testCode);
        return this.tstore.getListParametersFromTest();
    }


    public void addTestResult(ParameterDto dto){
        this.tstore.getTest().newTestParameter(dto.getCode());
        this.tstore.getTest().addTestResult();
    }






    public List<TestDto> getTests() {
        List<Test> tests = this.tstore.getRegisteredTests();
        TestMapper mapper = new TestMapper();
        return mapper.toDto(tests);
    }

    public void getExternalModule() {
        this.tstore.getTest().getTestType().getExternalModule();
    }
}
