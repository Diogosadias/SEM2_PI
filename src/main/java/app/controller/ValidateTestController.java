package app.controller;

import app.domain.dto.TestDto;
import app.domain.dto.TestMapper;
import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.model.TestStore;
import app.domain.shared.Constants;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for the US15 realization - Validate a test by the clinical chemistry technologist
 *
 */

public class ValidateTestController {

    private Company company;

    private TestStore tStore;

    private List<Test> validated;

    /**
     * Constructor for a given Company instance.
     */

    public ValidateTestController () {
        this.company = App.getInstance().getCompany();
        this.tStore = this.company.getTestStore();
        this.validated = new ArrayList<>();
    }

    /**
     * Return the list of the diagnosed tests.
     *
     * @return DiagnosedTest's List
     */

    public List getDiagnosedTestList() {
        TestMapper mapper = new TestMapper();
        return mapper.listTestDiagnosedToDto(this.tStore.getTests(Constants.DIAGNOSIS_MADE));
    }

    /**
     * Creates a Valid Test instance and validate.
     *
     * @param dto TestDto
     *
     * @return boolean
     */

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

    /**
     * Change the tests to validated.
     *
     * @return boolean
     */

    public boolean changeTestsToValidated () {
        if(validated.isEmpty()) {
            return false;
        }
        for (Test test : validated) {
            test.isValidated();
        }
        return true;
    }

    /**
     * Return the Company.
     *
     * @return Company
     */

    public Company getCompany () {
        return this.company;
    }

    /**
     * Return the Test Store.
     *
     * @return TestStore
     */

    public TestStore getTestStore() {
        return this.tStore;
    }

    /**
     * Return the List of Test Type.
     *
     * @return TestType's List
     */

    public List getListTestType() {
        return tStore.getListTestType();
    }

}
