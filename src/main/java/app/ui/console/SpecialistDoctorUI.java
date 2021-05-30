package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */

public class SpecialistDoctorUI implements Runnable {

    @Override
    public void run(){

        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Diagnosis - Write Report", new WriteReportUI()));
        options.add(new MenuItem("List Diagnosed Tests", new ListDiagnosedTestUI()));

        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nReceptionist Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );


    }
}
