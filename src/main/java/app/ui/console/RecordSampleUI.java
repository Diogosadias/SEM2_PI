package app.ui.console;


import app.controller.RecordSampleController;
import app.domain.dto.TestDto;
import app.ui.console.utils.Utils;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;

import java.io.IOException;

/**
 * RecordSampleUI - UI for US5, registering a sample to a test.
 *
 * @author Gil Pereira
 */
public class RecordSampleUI implements Runnable {

    private final RecordSampleController rsc;

    public RecordSampleUI(){
        this.rsc = new RecordSampleController();
    }

    @Override
    public void run() {
        try {
            TestDto chosenTest = writeTests();
            Barcode result = rsc.createSample(chosenTest.getNhsCode()).getSampleBarcode();

            /*
            * PRINT BARCODE
            * SAVE BARCODE AS JPEG
            */

            if(Utils.confirm("Do you wish to register this sample?")) {
                if(this.rsc.saveSample(chosenTest)) {
                    System.out.println("Sample registered with success!");
                }else{
                    System.out.println("Sample was not registered!");
                }
            }
        } catch (IOException | BarcodeException e) {
            e.printStackTrace();
        }

    }

    public TestDto writeTests(){
        return (TestDto) Utils.showAndSelectOne(rsc.getTests(),"\nTests");
    }
}
