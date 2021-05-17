package app.domain.shared;

import org.krysalis.barcode4j.impl.upcean.EAN13Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public interface BarcodeAPI {

    public default File getBarcode() throws IOException {

        long min = 100000000000l;
        long max = 999999999999l;

        long random_bar = (long) Math.floor(Math.random() * (max - min + 1) + min);


        String barcode = String.valueOf(random_bar);


        System.out.println(barcode);


        BufferedImage b = generateEAN13BarcodeImage(barcode);


        File file = new File("myimage.png");
        //ImageIO.write(b,"png",file);
        return file;
    }


    public static BufferedImage generateEAN13BarcodeImage(String barcodeText) {

        EAN13Bean barcodeGenerator = new EAN13Bean();
        BitmapCanvasProvider canvas =
                new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY, false, 0);

        barcodeGenerator.generateBarcode(canvas, barcodeText);
        return canvas.getBufferedImage();
    }
}
