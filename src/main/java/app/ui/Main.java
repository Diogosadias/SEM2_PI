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
            /*CreateClientController controllerClient = new CreateClientController();
            controllerClient.createClient("em2ail@ton.com","awd", 1231231321l, 1231231232123123l, 123123113123l, "2002/02/20", "F", 123423123123l);
            controllerClient.createClient("em2ail@ton.com","awd", 1231231321l, 1231231232123123l, 123123113123l, "2002/02/20", "F", 123423123123l);
*/



            menu.run();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}
