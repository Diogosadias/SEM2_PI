package app.ui.console;

import app.ui.console.utils.Utils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 * @author Tom s Pinto <1181835@isep.ipp.pt>
 */

public class AdminUI implements Runnable{
    public AdminUI()
    {
    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Create type of test", new CreateTypeTestUI()));
        options.add(new MenuItem("Edit type test", new ShowTextUI("You have chosen Option B.")));
        options.add(new MenuItem("List types of test", new ShowTextUI("You have chosen Option C.")));
        options.add(new MenuItem("Search types of test", new ShowTextUI("You have chosen option D")));
        options.add(new MenuItem("Delete type of test", new ShowTextUI("You have chosen option E")));

        int option = 0;
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

    public static class CreateTypeTestUI implements Runnable {


        public void run() {

        }
    }
}
