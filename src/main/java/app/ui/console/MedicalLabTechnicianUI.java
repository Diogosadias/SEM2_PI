package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */

public class MedicalLabTechnicianUI implements  Runnable {

    @Override
    public void run(){

        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Create Sample", new RecordSampleUI()));
        options.add(new MenuItem("List Test Sample(s)", new ListSampleCollectedUI()));

        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nMedical Laboratory Technician Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );


    }
}
