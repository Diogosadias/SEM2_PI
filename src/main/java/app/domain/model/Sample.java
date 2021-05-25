package app.domain.model;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Sample - Domain Class representing a sample. Identified by it´s Barcode and Name.
 *
 * @author Gil Pereira
 */
public class Sample {

    private final Barcode sampleBarcode;
    private final String jpegPath;

    //AC: Sample should only have Barcode
    public Sample(String id) throws BarcodeException, OutputException, IOException {

        Random r = new Random();
        long numbers = r.nextInt(1_000_000_000)
                + (r.nextInt(90) + 10) * 1_000_000_000L;
        System.out.println(String.valueOf(numbers));

        this.sampleBarcode = BarcodeFactory.createCode128(String.valueOf(numbers));
        
        //Save as JPEG
        File barcodeJPEG = new File("Sample_" + id + ".jpeg");

        if (!barcodeJPEG.exists()){
            this.jpegPath = null;
        }else{
            this.jpegPath="Sample_" + id;
        }
        BarcodeImageHandler.saveJPEG(sampleBarcode, barcodeJPEG);

    }

    public Barcode getSampleBarcode(){
        return this.sampleBarcode;
    }

}
