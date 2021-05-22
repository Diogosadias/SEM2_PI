package app.ui.console;

import app.controller.App;
import app.controller.WriteReportController;
import app.domain.dto.TestDto;
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

    /**
     * Constructor initiating the Controller and AuthFacade
     */
    public WriteReportUI()
    {
        this.writeReportController = new WriteReportController();
        this.authFacade = App.getInstance().getCompany().getAuthFacade();    
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
        List<TestDto> set = writeReportController.getTestList();
        TestDto dto = (TestDto)Utils.showAndSelectOne(set, "\nList of Chemical Analysis Tests: \n");
        writeReportController.getTestInformation(dto);
        
        String diagnosis = Utils.readLineFromConsole("Diagnosis: ");
        
        writeReportController.createReport(diagnosis, App.getInstance().getCompany().getTestStore().getTestByCode(dto.getCode()));
        return writeReportController.saveReport();
    }

    private void presentsData() {
        System.out.println("\nReport:\n" + writeReportController.getReportToString());
    }

}
