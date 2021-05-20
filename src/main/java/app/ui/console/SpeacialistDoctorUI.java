package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class SpeacialistDoctorUI implements Runnable {


    public SpeacialistDoctorUI(){

    }


    @Override
    public void run(){

        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Create Sample", new RecordSampleUI()));


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
