package app.controller;

import app.domain.dto.*;
import app.domain.model.*;
import app.domain.model.ReportStore;
import app.domain.model.TestStore;

import java.util.List;

import static app.domain.shared.Constants.ROLE_ADMIN;
import static app.domain.shared.Constants.ROLE_SPEC_DOCTOR;

/**
 * Controller for the US14 realization - Write Report
 *
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 */

public class WriteReportController {
    private Company company;
    private Report report;
    private ReportStore reportStore;
    private TestMapper testMapper;
    private TestStore testStore;

    /**
     * Constructor for a given Company instance.
     */

    public WriteReportController(){
        if (!App.getInstance().getCurrentUserSession().isLoggedInWithRole(ROLE_SPEC_DOCTOR)) {
            throw new IllegalStateException("Utilizador nï¿½o Autorizado");
        }
        this.company = App.getInstance().getCompany();
        this.testStore = company.getTestStore();
        this.reportStore = company.getReportStore();
        this.testMapper = new TestMapper();
    }

    /**
     * Return the list of the tests.
     *
     * @return Test's List
     */

    public List<TestDto> getTestList() {
        List<Test> list = this.testStore.getSampleAnalysisTests();
        return this.testMapper.listTestParameterToDto(list);
    }

    /**
     * Return the information of the tests.
     *
     * @param test TestDto
     */

    public void getTestInformation(TestDto test) {
        Test aux = this.company.getTestStore().getTestByCode(test.getCode());
        this.testStore.setTest(aux);
        System.out.println(aux);
    }

    /**
     * Creates a Report instance and validate.
     *
     * @param diagnosis Report's diagnosis
     * @param testCode Test's code
     *
     * @return boolean
     */

    public boolean createReport(String diagnosis, String testCode){
        Test test = this.testStore.getTestByCode(testCode);
        this.report = reportStore.createReport(diagnosis, test);
        return reportStore.validateReport(this.report);
    }

    /**
     * Saves the new Report instance.
     *
     * @return boolean
     */

    public boolean saveReport(){
        if(this.reportStore.saveReport(this.report)){
            return this.testStore.setTestStateDiagnosis(this.report.getTest());
        }
        return false;
    }

    /**
     * Get the textual description of the report.
     *
     * @return report's features
     */

    public String getReportToString() {        
        String s = "Diagnosis: " + this.report.getDiagnosis() + "\n" + "Test: " + this.report.getTest().toString() + "\n" ;
        return s;
    }

    /**
     * Return the list of the diagnosed tests.
     *
     * @return DiagnosedTest's List
     */

    public List getDiagnosedTests () {
        List<Test> list = this.company.getTestStore().getDiagnosedTests();
        return testMapper.listTestParameterToDto(list);
    }

    /**
     * Get the textual description of the diagnosis.
     *
     * @return Diagnosis
     */

    public String showDiagnosis(TestDto test) {
        String s = "\nTest n: " + test.getCode() + "\nClient: " + test.getClientCC() + "\nDate: " + test.getDateDiagnosis();
        for (TestParameter tp : test.getListTestParameter()) {
            s += "\n" + tp.getParameter() +
            "\nResult: " + tp.getResult().getResult();
        }
        s += "Report: " + this.reportStore.getReportByTestCode(test.getCode());
        return s;
    }

    /**
     * Return the Company.
     *
     * @return Company
     */

    public Company getCompany () {
        return this.company;
    }
}
