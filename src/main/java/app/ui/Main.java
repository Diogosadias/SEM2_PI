package app.ui;


import app.controller.CreateClientController;
import app.ui.console.MainMenuUI;
import app.ui.console.ReceptionistUI;
import auth.domain.model.Email;
import auth.domain.model.Password;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Main {

    public static void main(String[] args)
    {
        try
        {

            MainMenuUI menu = new MainMenuUI();

            menu.run();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}
