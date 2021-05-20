package app.controller;

import app.domain.dto.*;
import app.domain.model.*;

public class WriteReportController {
    private Company company;
    private Report report;
    private ReportStore reportStore;
    private TestMapper testMapper;
    private TestDto testdto;
    private TestStore testStore;

    public WriteReportController(){
        this(App.getInstance().getCompany());
    }


    public WriteReportController(Company company){
        this.company = company;
        this.reportStore = company.getReportStore();
        this.testStore = company.getTestStore();

    }

    public boolean createReport(String diagnosis, Test test){
        report = reportStore.createReport(diagnosis, test);
        return reportStore.validateReport(report);
    }

    public boolean saveReport(){
        return this.reportStore.saveReport(report);
    }


/*
    public TestDto getTestCompletedList(){
        return testMapper.getTestCompletedList(testStore);
    }

    public void ShowList(){
        getTestCompletedList();
        //Shows list of tests completed
    }

    public Test getTestInformation(Test test){
        return testMapper.getTestInformation(testdto.getTest(test));
    }
*/

}
