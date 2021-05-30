package app.domain.model;

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

    /**
     * Initialize a list of samples.
     */
    private final List<Sample> sampleList;

    /**
     * Initialize a list of Sample's store.
     */
    public SampleStore(){
        this.sampleList = new ArrayList<>();
    }

    /**
     * Creates a Sample instance and returns it.
     *
     * @param id Sample's id
     *
     * @return Sample
     *
     * @throws BarcodeException Barcode
     * @throws OutputException Output
     * @throws IOException IO
     */

    public Sample createSample(String id) throws BarcodeException, OutputException, IOException {
        return new Sample(id);
    }

    /**
     * Saves the new Sample.
     *
     * @param sample - Sample
     *
     * @return boolean
     */

    public boolean saveSample(Sample sample){
        if(validateSample(sample))
            return this.sampleList.add(sample);
        else
            return false;
    }

    /**
     * Validates Sample attributes for business model rules.
     *
     * @param sample - Sample
     *
     * @return boolean
     */

    public boolean validateSample(Sample sample){
        for (Sample s : this.sampleList) {
            if (s.getSampleBarcode().equals(sample.getSampleBarcode())) return false;
        }
        return true;
    }

    /**
     * Return the Sample's list.
     *
     * @return Sample's list
     */

    public List<Sample> getSamples(){
        return this.sampleList;
    }
}
