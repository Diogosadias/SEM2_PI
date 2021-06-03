package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class LabCoordinatorUI implements Runnable {

    public void run() {

        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Validate Test", new ValidateTestUI()));
        options.add(new MenuItem("List Validated Tests", new ListValidateTestsUI()));
        options.add(new MenuItem("Import Clinical Tests from a CSV file",new ImportClinicalTestsUI()));
        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nLaboratory Coordinator Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );

    }


}
