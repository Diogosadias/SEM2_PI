package app.ui.console;

import app.controller.App;
import app.controller.RegisterNewCALController;
import app.ui.console.utils.Utils;
import auth.AuthFacade;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  UI for the US8 realization - Register a new CAL
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Gil <1180838@isep.ipp.pt>
 */
public class RegisterNewCALUI implements Runnable{

    private RegisterNewCALController registerNewCALController;
    private AuthFacade authFacade;

    /**
     * Constructor initiating the Controller and AuthFacade
     */
    public RegisterNewCALUI()
    {
        this.registerNewCALController= new RegisterNewCALController();
        this.authFacade = App.getInstance().getCompany().getAuthFacade();
    }

    /**
     * Method for user interaction regarding data input
     */
    public void run()
    {
        try {
            //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Scanner reader = new Scanner(System.in);

            System.out.println("REGISTER NEW CLINICAL ANALYSIS LABORATORY");

            System.out.println("ID:");

            String labId = reader.nextLine();//reader.read();

            System.out.println("Laboratory Name:");
            reader.nextLine();
            String labName = reader.nextLine();//reader.readLine();

            System.out.println("Phone Number:");
            int phoneNumber = reader.nextInt();//reader.read();

            System.out.println("Address:");
            reader.nextLine();
            String address = reader.nextLine();// reader.readLine();

            System.out.println("Tax Identification Number:");

            int tin = reader.nextInt();//reader.read();

            String answer;
            do{
                answer = Utils.readLineFromConsole("Does it perform Covid-19 tests? \n Y / N");
            }while(!answer.trim().equalsIgnoreCase("Y") && !answer.trim().equalsIgnoreCase("N"));

            //System.out.println("Enter the Receptionist ID:\n");

            //int receptionistID = reader.read();

            //System.out.println("Enter the Medical Lab Technician ID:");

            //int medLabTech = reader.read();

            //CONFIRMATION
            System.out.printf("ID: %d \n Name: %s \n Phone Number: %d \n Address: %s \n TIN: %d \n Covid Tests: %s \n",
                    labId, labName, phoneNumber, address, tin, answer);
            String confirmation;
            do{
                confirmation = Utils.readLineFromConsole("Do you wish to add this Laboratory? \n Y / N");
            }while(!confirmation.trim().equalsIgnoreCase("Y") && !confirmation.trim().equalsIgnoreCase("N"));

            boolean covidTestFlag;
            if(confirmation.equalsIgnoreCase("N")){
                return;
            }else{
                if(answer.equalsIgnoreCase("Y")){
                    covidTestFlag = true;
                }else{
                    covidTestFlag = false;
                }
            }

            if(this.registerNewCALController.createCAL(labId, labName, phoneNumber, address, tin, covidTestFlag)){
                this.registerNewCALController.saveCAL();
                System.out.println("Clinical Analysis Lab registered successfully!");
            }else{
                System.out.println("Invalid Data was introduced! Returning to the menu.");
            }

            return;

        } catch (IllegalArgumentException | InputMismatchException e) {
            e.printStackTrace();
            System.out.println("Invalid Input.");
            return;
        }
    }
}
