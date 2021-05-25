package app.ui.console;

import app.controller.CreateClientController;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Tiago Ferreira <1200601@isep.ipp.pt>
 */
public class CreateClientUI implements Runnable{



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
        String id;
        long nhs;
        long citizenCard;
        long tin;
        String birthDate;
        String sex;
        long pNumber;


        Scanner read = new Scanner(System.in);

        System.out.println("\n\nCreate New Client:");

        try {
            System.out.print("Name: ");
            name = read.nextLine();

            System.out.print("Email: ");
            id = read.next();


            /*System.out.print("Password: ");
            password = read.next();*/

            System.out.print("National Health Service (10 Digits): ");
            nhs = read.nextLong();

            System.out.print("Citizen Card (16 Digits): ");
            citizenCard = read.nextLong();

            System.out.print("TIN (12 Digits): ");
            tin = read.nextLong();

            System.out.print("Birth Date (YYYY/MM/DD): ");
            birthDate = read.next();

            System.out.print("Sex (M/F): ");
            sex = read.next();

            System.out.print("Phone Number (11 Digits): ");
            pNumber = read.nextLong();





            CreateClientController controllerClient = new CreateClientController();


            boolean validate = controllerClient.createClient(id,name,nhs,citizenCard,tin,birthDate,sex,pNumber);
            if(validate)
                System.out.println("Succesfully Registered the Client");


        }catch (InputMismatchException ex){
            System.out.println("Data input error");
        }catch (IllegalArgumentException ex){
            System.out.println("Invalid data input: "+ex);
        }



    }
}