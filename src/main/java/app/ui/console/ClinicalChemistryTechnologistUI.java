package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ClinicalChemistryTechnologistUI implements Runnable {


    public ClinicalChemistryTechnologistUI(){

    }

    @Override
    public void run(){
        List<MenuItem> options = new ArrayList<MenuItem>();

        options.add(new MenuItem("Record Test Result:", new RecordTestResultUI()));


        boolean success = false;
        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nClinicalChemistryTechnologist Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );


    }

}
