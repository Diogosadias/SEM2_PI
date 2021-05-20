package app.ui.console;



import app.controller.RecordSampleController;
import app.domain.dto.TestDto;
import app.domain.model.Sample;
import app.domain.model.SampleStore;
import app.ui.console.utils.Utils;

import java.io.IOException;
import java.util.List;

public class RecordSampleUI implements Runnable{

    RecordSampleController rsc;

    Sample sample;

    public RecordSampleUI(){

        this.rsc = new RecordSampleController();
    }

    @Override
    public void run() {
        writeTests();

        try {
            sample = rsc.createSample();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }









    public void writeTests(){
        List<TestDto> set = rsc.getSampleStore().getTests();

        TestDto test = (TestDto) Utils.showAndSelectOne(set,"\nTests");


        rsc.convertDtoToTest(test);


    }
}
