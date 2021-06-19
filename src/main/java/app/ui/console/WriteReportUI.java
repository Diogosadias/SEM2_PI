package app.ui.console;

import app.controller.App;
import app.controller.WriteReportController;
import app.domain.dto.TestDto;
import app.domain.model.TestParameter;
import app.ui.console.utils.Utils;
import auth.AuthFacade;
import java.util.List;

/**
 *
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */

public class WriteReportUI implements Runnable{
    
    private final WriteReportController writeReportController;

    /**
     * Constructor initiating the Controller and AuthFacade
     */
    public WriteReportUI()
    {
        this.writeReportController = new WriteReportController();
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
        try{
            List<TestDto> set = writeReportController.getTestList();
            TestDto dto = (TestDto)Utils.showAndSelectOne(set, "\nList of Chemical Analysis Tests: \n");
            List<TestParameter> list = writeReportController.getCompany().getTestStore().getTestByCode(dto.getCode()).getListTestParameter();
            for(TestParameter p : list){
                System.out.println(p.getParameter().toString());
                System.out.println("Result: " + p.getResult() + "\n");
            }
            String diagnosis = Utils.readLineFromConsole("Diagnosis: ");

            writeReportController.createReport(diagnosis, dto.getCode());
            return writeReportController.saveReport();
        }
        catch (Exception e) {
            System.out.println("Empty List.");
            return false;
        }
    }

    private void presentsData() {
        System.out.println("\nReport:\n" + writeReportController.getReportToString());
    }

}
