package app.ui.console;

import app.domain.shared.CSVFileConverter;
import app.ui.console.utils.Utils;

import java.io.FileNotFoundException;
import java.sql.SQLOutput;

public class ImportClinicalTestsUI implements Runnable {




    @Override
    public void run() {
        boolean flag = true;
        do {
            try {
                String fileName = Utils.readLineFromConsole("\nFile Name: ");
                System.out.println("\nImporting from CSV file...\n");
                CSVFileConverter converter = new CSVFileConverter();
                converter.convertToObject(fileName);
                System.out.println("\nFile imported successfully.");
            } catch (FileNotFoundException e) {
                if(Utils.readLineFromConsole("File was not found.\nPress Y to cancel?").equalsIgnoreCase("Y"))  {
                    flag = false;
                }
            }
        }while (!flag);
    }
}
