package app.controller;

import app.domain.dto.ParameterDto;
import app.domain.dto.TestDto;
import app.domain.dto.TestMapper;
import app.domain.model.*;

import java.util.List;

import static app.domain.shared.Constants.*;

public class RecordTestResultController {
    public Company company;
    public TestStore tstore;
    public ParameterStore ps;

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


    public boolean addTestResult(String parameterCode, String results, String metric){
        this.ps = this.company.getParameterStore();

        Parameter p = ps.getParameterByCode(parameterCode);

        if(p == null){
            System.out.println("Parameter Doesn't exist!");
        }
        else{

        }


        return true;
    }






    public List<TestDto> getTests() {
        List<Test> tests = this.tstore.getRegisteredTests();
        TestMapper mapper = new TestMapper();
        return mapper.toDto(tests);
    }
}
