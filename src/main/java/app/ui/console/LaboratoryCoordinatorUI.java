package app.ui.console;

import java.util.ArrayList;
import java.util.List;

public class LaboratoryCoordinatorUI  implements Runnable {



    @Override
    public void run() {

        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Import Clinical Tests from a CSV file",new CreateClientUI()));

    }


}
