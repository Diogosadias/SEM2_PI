package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class SpecialistDoctorUI implements Runnable {


    public SpecialistDoctorUI(){

    }


    @Override
    public void run(){

        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Diagnosis - Write Report", new WriteReportUI()));
        options.add(new MenuItem("List Diagnosed Tests", new ListDiagnosedTestUI()));

        boolean success = false;
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
