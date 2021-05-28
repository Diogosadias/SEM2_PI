package app.domain.model;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class SampleTest {

    Sample s = new Sample("111111");


    public SampleTest() throws OutputException, BarcodeException, IOException {
    }

    @Test
    public void SampleTest()  {


        boolean b;

        if(s == null){
            b = false;
        }
        else
            b = true;

        assertEquals(true,b);


    }

}