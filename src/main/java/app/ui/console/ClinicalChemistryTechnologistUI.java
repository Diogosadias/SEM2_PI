package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */

public class ClinicalChemistryTechnologistUI implements Runnable {

    @Override
    public void run(){
        List<MenuItem> options = new ArrayList<>();

        options.add(new MenuItem("Record Test Result", new RecordTestResultUI()));
        options.add(new MenuItem("List Test Result", new ListChemicalAnalysedTestsUI()));
        options.add(new MenuItem("Overview the tests of a client",new OverviewAnalyzeTestsUI()));

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
