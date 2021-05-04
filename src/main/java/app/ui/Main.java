package app.ui;


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

            //for tests
            //ReceptionistController controllerClient = new ReceptionistController();
            //controllerClient.createClient("em2ail@ton.com","124", "XZ", 1231231232, 123123113, 153123123, "01/03/2001", "Masculine", 123423123);
            //controllerClient.createClient("email@ton.com","123", "XD", 1231231231, 123123123, 123123123, "01/02/2001", "Masculine", 123123123);
            menu.run();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}
