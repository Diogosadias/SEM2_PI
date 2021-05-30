package app.ui.console;


import app.controller.RecordSampleController;
import app.domain.dto.TestDto;
import app.ui.console.utils.Utils;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;

/**
 * RecordSampleUI - UI for US5, registering a sample to a test.
 *
 * @author Gil Pereira
 * @author Tiago Ferreira
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
            System.out.println(chosenTest);
            boolean testFlag = Utils.confirm(chosenTest+"\nClient Name: "+this.rsc.getTestClientNameByCC(chosenTest.getClientCC())
                    + "\nDo you wish to add samples to this test? Y/N");
            if(!testFlag) throw new Exception("RE-RUN-UI");
            int sampleNumber = Utils.readIntegerFromConsole("How many samples to collect?");

            for(int i=0; i<sampleNumber; i++){
                rsc.createSample(String.valueOf(chosenTest.getCode()),chosenTest.getCode());
                if(this.rsc.saveSample()) {
                    System.out.println("Sample nº "+ (i+1) + " registered with success!");
                }else{
                    System.out.println("Sample nº "+ i+1 + "was not registered!");
                }
            }
        } catch (IOException | BarcodeException | OutputException | IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            run();
        }

    }

    public TestDto writeTests(){
        return (TestDto) Utils.showAndSelectOne(rsc.getTests(),"\nTests");
    }

}
