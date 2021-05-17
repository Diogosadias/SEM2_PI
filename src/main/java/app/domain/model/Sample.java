package app.domain.model;

import app.domain.shared.BarcodeAPI;

import java.io.File;
import java.io.IOException;

public class Sample implements BarcodeAPI {



    //AC: Sample should only have Barcode
    public Sample() throws IOException {
        File file = setBarcode();
    }


    public File setBarcode() throws IOException {
        return getBarcode();
    }

}
