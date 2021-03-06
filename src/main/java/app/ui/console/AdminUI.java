package app.ui.console;

import app.ui.console.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 * @author Gil <1180838@isep.ipp.pt>
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Tiago Ferreira <1200601@isep.ipp.pt>
 */
/*
public class AdminUI implements Runnable{

    public void run()
    {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Create type of test", new SpecifyNewTestTypeUI()));
        options.add(new MenuItem("List types of test", new ListTypeTestUI()));
        options.add(new MenuItem("Search types of test", new SearchTestTypeUI()));
        options.add(new MenuItem("Delete type of test", new DeleteTypeTestUI()));
        options.add(new MenuItem("New Parameter", new SpecifyNewParameterUI()));
        options.add(new MenuItem("List Parameters", new ListParametersUI()));
        options.add(new MenuItem("Delete Parameter", new DeleteParameterUI()));
        options.add(new MenuItem("New Parameter Category", new CreateNewParameterCategoryUI()));
        options.add(new MenuItem("List Parameter Categories", new ListParameterCategoryUI()));
        options.add(new MenuItem("Register employee", new RegisterEmployeeUI()));
        options.add(new MenuItem("List Registered Employees", new ListEmployeesUI()));
        options.add(new MenuItem("Register new Clinical Analysis Laboratory", new RegisterNewCALUI()));
        options.add(new MenuItem("Send Covid report to Nhs", new CovidNhsReportUI()));

        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }






        }





*/