package app.domain.model;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;

/**
 * Sample - Domain Class representing a sample. Identified by it´s Barcode and Name.
 *
 * @author Gil Pereira
 */
public class Sample {

    private final Barcode sampleBarcode;

    //AC: Sample should only have Barcode
    public Sample(String id)throws BarcodeException {
        this.sampleBarcode = BarcodeFactory.createUPCA(id+System.currentTimeMillis());
    }

    public Barcode getSampleBarcode(){
        return this.sampleBarcode;
    }

}
