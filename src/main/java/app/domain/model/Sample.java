package app.domain.model;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;

/**
 * Sample - Domain Class representing a sample. Identified by it´s Barcode and Name.
 *
 * @author Gil Pereira
 * @author Tiago Ferreira
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */

public class Sample  implements Serializable {

    /**
     * The barcode of Sample.
     */
    private final Barcode sampleBarcode;

    /**
     * The jpegPath of Sample.
     */
    private final String jpegPath;

    /**
     * Constructor Sample with the id.
     *
     * @param id Sample's id.
     *
     * @throws BarcodeException Barcode
     * @throws OutputException Output
     * @throws IOException IO
     */

    //AC: Sample should only have Barcode
    public Sample(String id) throws BarcodeException, OutputException, IOException {

        Random r = new Random();
        long numbers = r.nextInt(1_000_000_000)
                + (r.nextInt(90) + 10) * 1_000_000_000L;
        System.out.println(String.valueOf(numbers));

        this.sampleBarcode = BarcodeFactory.createCode128(String.valueOf(numbers));

        //Save as JPEG
        File barcodeJPEG = new File("samples/sample_"+id+"_"+ numbers+".jpeg");

        if (!barcodeJPEG.exists()){
            this.jpegPath = null;
        }else{
            this.jpegPath="Sample_" + id;
        }
        BarcodeImageHandler.saveJPEG(sampleBarcode, barcodeJPEG);
    }

    /**
     * Return the sample's barcode.
     *
     * @return sample's barcode
     */

    public Barcode getSampleBarcode(){
        return this.sampleBarcode;
    }
}
