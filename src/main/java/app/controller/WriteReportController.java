package app.controller;

import app.domain.dto.*;
import app.domain.model.*;
import app.domain.model.ReportStore;
import app.domain.model.TestStore;

import java.util.List;

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
        this.company = App.getInstance().getCompany();
        this.testStore = company.getTestStore();
        this.reportStore = company.getReportStore();
        this.testMapper = new TestMapper();
    }

    public List<TestDto> getTestList() {
        List<Test> list = this.testStore.getSampleAnalysisTests();
        return this.testMapper.testResults_toDto(list);
    }

    public void getTestInformation(TestDto test) {
        Test aux = this.company.getTestStore().getTestByCode(test.getCode());
        this.testStore.setTest(aux.getCode());
        System.out.println(aux);
    }

    public boolean createReport(String diagnosis, String testCode){
        Test test = this.testStore.getTestByCode(testCode);
        this.report = reportStore.createReport(diagnosis, test);
        return reportStore.validateReport(this.report);
    }

    public boolean saveReport(TestParameter tp){

        this.testStore.getTest().setTestParameterReport(tp,this.report);
        return this.reportStore.saveReport(this.report);
    }

    public String getReportToString() {        
        String s = "Diagnosis: " + this.report.getDiagnosis() + "\n" + "Test: " + this.report.getTest().toString() + "\n" ;
        return s;
    }

}
