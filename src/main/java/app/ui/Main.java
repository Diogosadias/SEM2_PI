package app.ui;


import app.controller.App;
import app.controller.FileController;
import app.ui.console.MainMenuUI;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
