package app.domain.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SampleStore {

    private final List<Sample> sampleList;


    public SampleStore(){
        this.sampleList = new ArrayList<>();
    }

    public Sample createSample() throws IOException {
        return new Sample();
    }

    public boolean saveSample(Sample sample){
        if(sampleList.add(sample))
            return true;
        else
            return false;
    }
}
