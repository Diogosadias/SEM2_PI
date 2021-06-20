package app.domain.model;

import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

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

    /**
     * Test of createSample method, of class SampleStore.
     */
    @Test
    public void testCreateSample() throws Exception {
        System.out.println("createSample");
        String id = "98949851479";
        SampleStore instance = store;
        Sample result = instance.createSample(id);
        instance.saveSample(result);
        Sample expResult = instance.getSamples().get(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of saveSample method, of class SampleStore.
     */
    @Test
    public void testSaveSample() {
        System.out.println("saveSample");
        Sample sample = s1;
        SampleStore instance = store;
        boolean expResult = true;
        boolean result = instance.saveSample(sample);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateSample method, of class SampleStore.
     */
    @Test
    public void testValidateSample() {
        System.out.println("validateSample");
        Sample sample = s1;
        SampleStore instance = store;
        boolean expResult = true;
        boolean result = instance.validateSample(sample);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSamples method, of class SampleStore.
     */
    @Test
    public void testGetSamples() {
        System.out.println("getSamples");
        SampleStore instance = store;
        List<Sample> expResult = new ArrayList<>();
        expResult.add(s1);
        instance.saveSample(s1);
        List<Sample> result = instance.getSamples();
        assertEquals(expResult, result);
    }
}