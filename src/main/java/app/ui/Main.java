package app.ui;

import app.controller.FileController;
import app.ui.console.MainMenuUI;
import java.io.IOException;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Main {

    public static void main(String[] args) throws IOException {
        MainMenuUI menu = new MainMenuUI();
        FileController fileController = new FileController();
        try
        {
            fileController.runFileInputStreams();
            menu.run();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
        fileController.runFileOutputStreams();
    }

}
