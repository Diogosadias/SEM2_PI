package app.domain.model;

import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */

public class SampleStoreTest {
    Sample s1 = new Sample("98949851479");
    SampleStore store = new SampleStore();

    public SampleStoreTest() throws OutputException, BarcodeException, IOException {
    }

    @Test
    public void createSample() throws OutputException, BarcodeException, IOException {
        try{
            Sample s = store.createSample("38943351479");
        }catch(BarcodeException ex){
            assertNull(ex);
        }catch (OutputException ex){
            assertNull(ex);
        }catch (IOException ex){
            assertNull(ex);
        }


    }


    @Test
    public void saveSample() {
        assertTrue(store.saveSample(s1));
        assertFalse(store.saveSample(s1));
    }

    @Test
    public void validateSample() {
        assertTrue(store.validateSample(s1));
        store.saveSample(s1);
        assertFalse(store.validateSample(s1) );
    }

    @Test
    public void getSamples() {
        store.saveSample(s1);
        List<Sample> testlist = new ArrayList<>();
        testlist.add(s1);
        assertEquals(testlist,store.getSamples());
    }
}