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
    private TestDto testdto;
    private TestStore testStore;

    public WriteReportController(){
        this.company = App.getInstance().getCompany();
    }


    public WriteReportController(Company company){
        this.company = App.getInstance().getCompany();
        this.reportStore = company.getReportStore();
        this.testStore = company.getTestStore();

    }

    public boolean createReport(String diagnosis, Test test){
        this.report = reportStore.createReport(diagnosis, test);
        return reportStore.validateReport(this.report);
    }

    public boolean saveReport(){
        return this.reportStore.saveReport(this.report);
    }

    public List<TestDto> getTestCompletedList(){
        return testMapper.getTestCompletedList(testStore);
    }

    public void ShowList(){
        getTestCompletedList();
        //Shows list of tests completed
    }

    public Test getTestInformation(TestDto test){        
        Test aux = testMapper.getTest(test);
        aux.getInformation(aux);
        return aux;
    }

}
