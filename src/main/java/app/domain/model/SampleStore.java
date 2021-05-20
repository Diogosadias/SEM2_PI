package app.domain.model;

import app.domain.dto.TestDto;
import app.domain.shared.Constants;
import net.sourceforge.barbecue.BarcodeException;

import java.util.ArrayList;
import java.util.List;

/**
 * Sample Store - Stores the registered samples
 *
 * @author Gil Pereira
 */
public class SampleStore {

    private final List<Sample> sampleList;
    Company company;

    public SampleStore(){
        this.sampleList = new ArrayList<>();
    }


    public void setCompany (Company company) {
        this.company = company;
    }

    public Sample createSample(String id) throws BarcodeException {
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

    public List<TestDto> getTests() {
        return this.company.getTestStore().getTests(Constants.REGISTERED);
    }

}
