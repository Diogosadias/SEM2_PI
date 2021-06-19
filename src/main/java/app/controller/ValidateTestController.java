package app.controller;

import app.domain.dto.TestDto;
import app.domain.dto.TestMapper;
import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.model.TestStore;
import app.domain.shared.Constants;

import java.util.ArrayList;
import java.util.List;

import static app.domain.shared.Constants.ROLE_LAB_COORDINATOR;

public class ValidateTestController {

    private Company company;

    private TestStore tStore;

    private List<Test> validated;

    public ValidateTestController () {



        this.company = App.getInstance().getCompany();
        this.tStore = this.company.getTestStore();
        this.validated = new ArrayList<>();
    }

    public List getDiagnosedTestList() {
        TestMapper mapper = new TestMapper();
        return mapper.listTestDiagnosedToDto(this.tStore.getTests(Constants.DIAGNOSIS_MADE));
    }

    public boolean newValidTest(TestDto dto) {
        if(!validated.isEmpty()) {
            for (Test t : validated) {
                if (t.getCode().equals(dto.getCode())) {
                    return false;
                }
            }
        }
        Test test = this.tStore.getTestByCode(dto.getCode());
        return validated.add(test);
    }

    public boolean changeTestsToValidated () {
        if(validated.isEmpty()) {
            return false;
        }
        for (Test test : validated) {
            test.isValidated();
        }
        return true;
    }

    public Company getCompany () {
        return this.company;
    }

    public TestStore getTestStore() {
        return this.tStore;
    }

    public List getListTestType() {
        return tStore.getListTestType();
    }

}
