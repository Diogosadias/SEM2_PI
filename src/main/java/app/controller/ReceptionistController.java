package app.controller;

import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.model.CreateClientStore;
import app.domain.shared.Constants;
import app.ui.console.ReceptionistUI;
import auth.AuthFacade;
import auth.domain.model.Email;
import auth.domain.model.Password;
import auth.mappers.dto.UserRoleDTO;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Gil <1180838@isep.ipp.pt>
 */
public class ReceptionistController {


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

    public ReceptionistController(){this(App.getInstance().getCompany());}

    public ReceptionistController(Company company){
        this.company = company;
        this.authFacade = this.company.getAuthFacade();
        this.clientStore = this.company.getCreateClientStore();
    }

    public boolean createClient(String id, String name, long nhs, long citizenCard, long tin, String birthDate, String sex, long pNumber,String testpass){

        this.rc = this.clientStore.createClient(id,name,nhs,citizenCard,tin,birthDate,sex,pNumber);

        if(!this.clientStore.validateClient(this.rc)){return false;}

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






}
