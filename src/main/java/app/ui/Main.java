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

            //for tests
            //CreateClientController controllerClient = new CreateClientController();
            //controllerClient.createClient("em2ail@ton.com","124", 1231231321, 1231231232, 123123113, "20/02/2002", "01/03/2001", 123423123, "1322");
            //controllerClient.createClient("email@ton.com","123", 1231231321, 1231231231, 123123123, "20/02/2002", "01/02/2001", 123423123, "123");
            menu.run();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}
