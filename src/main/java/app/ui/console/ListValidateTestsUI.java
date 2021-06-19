package app.ui.console;

import app.controller.ValidateTestController;
import app.domain.model.Report;
import app.domain.model.Test;
import java.util.List;

public class ListValidateTestsUI implements Runnable {

    public void run() {
        ValidateTestController controller = new ValidateTestController();
        try {
            List<Test> list  = controller.getCompany().getTestStore().getValidatedTests();
            for (Test t : list ) {
                System.out.println("\n" + t);
                Report r = controller.getCompany().getReportStore().getReportByTestCode(t.getCode());
                System.out.println("Diagnosis: " + r.getDiagnosis());
            }
            System.out.println("Reached end of validated Test list.\n");
        } catch (IllegalArgumentException | NullPointerException e) {
        }
    }
}