package app.domain.stores;

import app.domain.model.Sample;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Sample Store - Stores the registered samples
 *
 * @author Gil Pereira
 */
public class SampleStore {

    private final List<Sample> sampleList;

    public SampleStore(){
        this.sampleList = new ArrayList<>();
    }

    public Sample createSample(String id) throws BarcodeException, OutputException, IOException {
        return new Sample(id);
    }

    public boolean saveSample(Sample sample){
        if(validateSample(sample))
            return this.sampleList.add(sample);
        else
            return false;
    }

    public boolean validateSample(Sample sample){
        for (Sample s : this.sampleList) {
            if (s.getSampleBarcode().equals(sample.getSampleBarcode())) return false;
        }
        return true;
    }
        
    public List<Sample> getSamples(){
        return this.sampleList;
    }
}
