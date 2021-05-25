package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class MedicalLabTechnicianUI implements  Runnable {

    public MedicalLabTechnicianUI(){

    }


    @Override
    public void run(){

        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Create Sample", new RecordSampleUI()));
        options.add(new MenuItem("List Test Sample(s)", new ListSampleCollectedUI()));

        boolean success = false;
        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nMedicalLabTechnician Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );


    }
}
