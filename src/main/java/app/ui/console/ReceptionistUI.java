package app.ui.console;

import app.controller.ReceptionistController;
import app.domain.model.Client;
import app.domain.model.CreateClientStore;
import app.ui.console.utils.Utils;
import auth.domain.model.Email;
import auth.domain.model.Password;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class ReceptionistUI implements Runnable {

    public ReceptionistUI() {
    }

    public void run() {

        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Create Client", new CreateClientUI()));
        options.add(new MenuItem("List Clients", new ListClientsUI()));
        //options.add(new MenuItem("Find Client"))    TO DO
        //options.add(new MenuItem("Remove Client"))  TO DO
        //options.add(new MenuItem("Edit Client"))    TO DO
        boolean success = false;
        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nReceptionist Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );

    }





    public static class CreateClientUI implements Runnable{



        public CreateClientUI()
        {

        }

        public void listClients(){

        }
        public boolean answer(){
            Scanner read = new Scanner(System.in);
            System.out.println("Are you sure you want to create this client?");
            String answer = read.next();
            if(answer.equals("Yes")){
                return true;
            }
            return false;
        }
        public void run() {

        String name;
        //String stringID;
        String id;
       // String stringpwd;
        String password;
        long nhs;
        long citizenCard;
        long tin;
        String birthDate;
        String sex;
        long pNumber;


        Scanner read = new Scanner(System.in);

        System.out.println("\n\nCreate New Client:");

        System.out.print("\nName: ");
        name = read.next();

        System.out.print("\nEmail: ");
        id = read.next();


        System.out.print("\nPassword: ");
        password= read.next();


        System.out.print("\nNational Health Service: ");
        nhs= read.nextLong();

        System.out.print("\nCitizen Card: ");
        citizenCard=read.nextLong();

        System.out.print("\nTIN: ");
        tin=read.nextLong();

        System.out.print("\nBirth Date: ");
        birthDate= read.next();

        System.out.print("\nSex: ");
        sex= read.next();

        System.out.print("\nPhone Number: ");
        pNumber=read.nextLong();

        ReceptionistController controllerClient = new ReceptionistController();


        boolean validate = controllerClient.createClient(id,password, name, nhs, citizenCard, tin, birthDate, sex, pNumber);
        if(validate)
            System.out.println("Succesfully Registered the Client");
        //listar info
            //perguntar confirmar
            //se sim, save


        }
    }
    public static class ListClientsUI implements Runnable {
        public ListClientsUI(){

        }

        public void run() {
            CreateClientStore clientStore = new CreateClientStore();
            clientStore.writeClients();
        }



    }
}
