package app.ui.console;

import app.controller.RegisterTestController;
import app.domain.model.Test;
import java.util.List;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */

public class ListRegisteredTestsUI implements Runnable {

    public void run() {
        RegisterTestController controller = new RegisterTestController();
        try {
            List<Test> list  = controller.getCompany().getTestStore().getRegisteredTests();
            for (Test t : list ) {
                System.out.println("\n" + t);
            }
            System.out.println("Reached end of registered Test list.\n");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

    }

}
