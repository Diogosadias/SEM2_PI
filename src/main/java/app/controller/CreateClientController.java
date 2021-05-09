package app.controller;

import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.model.CreateClientStore;
import auth.AuthFacade;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class CreateClientController {

    private Company company;
    private AuthFacade authFacade;
    private App app;

    private CreateClientStore clientStore;
    Client rc;
    //private ReceptionistUI.CreateClientUI recep = new ReceptionistUI.CreateClientUI();



    //public ReceptionistController()
    //{
    //  this.app = App.getInstance();
    // }

    public CreateClientController(){this(App.getInstance().getCompany());}

    public CreateClientController(app.domain.model.Company company){
        this.company = company;
        this.authFacade = this.company.getAuthFacade();
        this.clientStore = this.company.getCreateClientStore();
    }


    public boolean createClient(String id, String name, long nhs, long citizenCard, long tin, String birthDate, String sex, long pNumber){

        this.rc = this.clientStore.createClient(id,name,nhs,citizenCard,tin,birthDate,sex,pNumber);

        if(!this.clientStore.validateClient(this.rc)){return false;}
        String testpass = makerandompass();
        sendPassEmail(testpass);

        saveClient(this.rc,testpass);
        return true;

    }

    public boolean saveClient(Client rc,String pwd){
        return this.clientStore.saveClient(this.rc, pwd);
    }

    public void writeClient(){
        System.out.println(clientStore.getClientList().size());
        for(Client c : clientStore.getClientList())
            System.out.println(c);
    }


    private void sendPassEmail(String pass){
        try{
            FileWriter myWriter = new FileWriter(rc.getCitizenCard()+"Password.txt");
            myWriter.write("Hello "+rc.getName()+",\nhere is your new password:\n\n");
            myWriter.append("Email: " + rc.getId() + "\n");
            myWriter.append("Password: " + pass + "\n");
            myWriter.append("\nBest regards\n");
            myWriter.append("ManyLabs team.");
            System.out.println("Sending your new password to your email...");
            myWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    private String makerandompass(){
        String password = "";
        for(int i= 0; i<10; i++){
            password = password+randomCharacter("abcdefghijklmnopqrstuvwxyz0123456789");
        }
        return password;
    }
    private String randomCharacter(String chars){
        int length = chars.length();
        int position = (int)(length*Math.random());
        return chars.substring(position,position+1);
    }
}
