package app.ui.console;

import app.domain.shared.CSVFileConverter;
import app.ui.console.utils.Utils;

import java.io.FileNotFoundException;

public class ImportClinicalTestsUI implements Runnable {




    @Override
    public void run() {
        String fileName = Utils.readLineFromConsole("\nFile Name: ");
        System.out.println("\nImporting from CSV file...\n");
        CSVFileConverter converter = new CSVFileConverter();
        try {
            converter.convertToObject(fileName);
            System.out.println("\nFile imported successfully.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
