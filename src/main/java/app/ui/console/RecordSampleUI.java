package app.ui.console;



import app.controller.RecordSampleController;
import app.domain.dto.TestDto;
import app.domain.model.SampleStore;
import app.ui.console.utils.Utils;

import java.util.List;

public class RecordSampleUI implements Runnable{

    RecordSampleController rsc;

    public RecordSampleUI(){

        this.rsc = new RecordSampleController();
    }

    @Override
    public void run() {
        if(!writeTests()){


        }



    }



    public boolean writeTests(){
        System.out.println(rsc);
        System.out.println(rsc.getSampleStore());
        List<TestDto> set = rsc.getSampleStore().getTests();
        TestDto test = (TestDto) Utils.showAndSelectOne(set,"\nTests");

        if(test != null){
       return false;

        }
        return true;


    }
}
