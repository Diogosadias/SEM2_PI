package app.ui.console;

import java.util.ArrayList;
import java.util.List;

public class ClinicalChemistryTechnologistUI implements Runnable {


    public ClinicalChemistryTechnologistUI(){

    }

    public void run(){
        List<MenuItem> options = new ArrayList<MenuItem>();

        options.add(new MenuItem("Record Test Result:", new RecordTestResultUI()));
    }


}
