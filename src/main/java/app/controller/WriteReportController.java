package app.controller;

import app.domain.dto.*;
import app.domain.model.*;
import java.util.ArrayList;
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

    public boolean createReport(String diagnosis, Test test){
        this.report = reportStore.createReport(diagnosis, test);
        return reportStore.validateReport(this.report);
    }

    public boolean saveReport(){
        return this.reportStore.saveReport(this.report);
    }

    public List<TestDto> getTestCompletedList(){
        return this.testMapper.getTestCompletedList();
    }

    public void ShowList(){
        getTestCompletedList();
        //Shows list of tests completed
    }

    public Test getTestInformation(TestDto test){        
        return this.testMapper.getTestInformation(test);
    }

    public String getReportToString() {        
        String s = "Diagnosis: " + this.report.getDiagnosis() + "\n" + "Test: " + this.report.getTest().toString() + "\n" ;
        return s;
    }

}
