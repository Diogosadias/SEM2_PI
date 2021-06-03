package app.ui.console;

import app.domain.shared.CSVFileConverter;

import java.io.FileNotFoundException;

public class ImportClinicalTestsUI implements Runnable {




    @Override
    public void run() {
        System.out.println("\nImporting from CSV file...\n");
        CSVFileConverter converter = new CSVFileConverter();
        try {
            converter.convertToObject();
            System.out.println("\nFile imported successfully.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
