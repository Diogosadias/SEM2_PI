package app.controller;

import app.domain.dto.*;
import app.domain.model.*;
import app.domain.model.ReportStore;
import app.domain.model.TestStore;

import java.util.List;

import static app.domain.shared.Constants.ROLE_ADMIN;
import static app.domain.shared.Constants.ROLE_SPEC_DOCTOR;

/**
 *
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 */

public class WriteReportController {
    private Company company;
    private Report report;
    private ReportStore reportStore;
    private TestMapper testMapper;
    private TestStore testStore;

    public WriteReportController(){
        if (!App.getInstance().getCurrentUserSession().isLoggedInWithRole(ROLE_SPEC_DOCTOR)) {
            throw new IllegalStateException("Utilizador nï¿½o Autorizado");
        }
        this.company = App.getInstance().getCompany();
        this.testStore = company.getTestStore();
        this.reportStore = company.getReportStore();
        this.testMapper = new TestMapper();
    }

    public List<TestDto> getTestList() {
        List<Test> list = this.testStore.getSampleAnalysisTests();
        return this.testMapper.listTestParameter_toDto(list);
    }

    public void getTestInformation(TestDto test) {
        Test aux = this.company.getTestStore().getTestByCode(test.getCode());
        this.testStore.setTest(aux);
        System.out.println(aux);
    }

    public boolean createReport(String diagnosis, String testCode){
        Test test = this.testStore.getTestByCode(testCode);
        this.report = reportStore.createReport(diagnosis, test);
        return reportStore.validateReport(this.report);
    }

    public boolean saveReport(){
        if(this.reportStore.saveReport(this.report)){
            return this.testStore.setTestStateDiagnosis(this.report.getTest());
        }
        return false;
    }

    public String getReportToString() {        
        String s = "Diagnosis: " + this.report.getDiagnosis() + "\n" + "Test: " + this.report.getTest().toString() + "\n" ;
        return s;
    }

    public List getDiagnosedTests () {
        List<Test> list = this.company.getTestStore().getDiagnosedTests();
        return testMapper.listTestParameter_toDto(list);
    }

    public String showDiagnosis(TestDto test) {
        String s = "\nTest n: " + test.getCode() + "\nClient: " + test.getClientCC() + "\nDate: " + test.getDateDiagnosis();
        for (TestParameter tp : test.getListTestParameter()) {
            s += "\n" + tp.getParameter() +
            "\nResult: " + tp.getResult().getResult();
        }
        s += "Report: " + this.reportStore.getReportByTestCode(test.getCode());
        return s;
    }

    public Company getCompany () {
        return this.company;
    }

}
