package app.ui.console;

import app.controller.App;
import app.controller.RegisterNewCALController;
import app.controller.WriteReportController;
import app.domain.dto.TestDto;
import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.model.TestStore;
import app.ui.console.utils.Utils;
import auth.AuthFacade;
import java.util.List;

/**
 *
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 */
public class WriteReportUI implements Runnable{
    
    private WriteReportController writeReportController;
    private AuthFacade authFacade;
    private Company company;
    private TestStore tstore;

    /**
     * Constructor initiating the Controller and AuthFacade
     */
    public WriteReportUI()
    {
        this.writeReportController = new WriteReportController();
        this.company = App.getInstance().getCompany();
        this.authFacade = this.company.getAuthFacade();        
        this.tstore = this.company.getTestStore();
    }

    @Override
    public void run() {
        System.out.println("\nWrite Report");
        
        if(registerData())
        {
            presentsData();

            if (Utils.confirm("Do you confirm the data? (Y/N)")) {
                        System.out.println("Report registered successfully!");
                } else
                {
                    System.out.println("Operation cancelled.");
                }
        }
        else
        {
            System.out.println("Error. Operation cancelled.");
        }

    }

    private boolean registerData() {
        List<TestDto> set = writeReportController.getTestCompletedList();
        TestDto test = (TestDto)Utils.showAndSelectOne(set, "\nList of Completed Tests\nNumber/id of role: \n");
        
        Test temp = writeReportController.getTestInformation(test);
                
        String diagnosis = Utils.readLineFromConsole("Diagnosis: ");
        
        writeReportController.createReport(diagnosis, this.tstore.getTestByCode(Long.valueOf(test.getNHSCode())));
        return writeReportController.saveReport();
    }

    private void presentsData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
