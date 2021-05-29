package app.domain.model;

import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 *
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */

public class SampleStoreTest {
    Sample s1 = new Sample("98949851479");
    SampleStore store = new SampleStore();

    public SampleStoreTest() throws OutputException, BarcodeException, IOException {
    }

    @Test
    public void createSample() throws OutputException, BarcodeException, IOException {
        SampleStore store = new SampleStore();
        //calculations
        Sample s2 = new Sample("98949851479");

        //assert
        /*assertEquals(s1.getSampleBarcode(), s2.getSampleBarcode());*/
    }

    @Test
    public void saveSample() {
    }

    @Test
    public void validateSample() {
    }

    @Test
    public void getSamples() {
    }
}