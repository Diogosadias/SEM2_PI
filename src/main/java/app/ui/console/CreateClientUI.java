package app.ui.console;

import app.controller.CreateClientController;


import java.util.InputMismatchException;
import java.util.Scanner;

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
        //String stringID;
        String id;
        // String stringpwd;
        String password = null;
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
            name = read.next();

            System.out.print("Email: ");
            id = read.next();


            System.out.print("Password: ");
            password = read.next();

            System.out.print("National Health Service: ");
            nhs = read.nextLong();

            System.out.print("Citizen Card: ");
            citizenCard = read.nextLong();

            System.out.print("TIN: ");
            tin = read.nextLong();

            System.out.print("Birth Date: ");
            birthDate = read.next();

            System.out.print("Sex: ");
            sex = read.next();

            System.out.print("Phone Number: ");
            pNumber = read.nextLong();





            CreateClientController controllerClient = new CreateClientController();


            boolean validate = controllerClient.createClient(id,name,nhs,citizenCard,tin,birthDate,sex,pNumber,password);
            if(validate)
                System.out.println("Succesfully Registered the Client");


            //listar info

            //perguntar confirmar
            //se sim, save

        }catch (InputMismatchException ex){
            System.out.println("Data input error");
        }catch (IllegalArgumentException ex){
            System.out.println("Invalid data input");
        }



    }
}