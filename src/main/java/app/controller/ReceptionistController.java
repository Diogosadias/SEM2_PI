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
 */
public class ReceptionistController {


    private Company company;
    private AuthFacade authFacade;

    private Client rc;
    private CreateClientStore clientStore =  new CreateClientStore();
    private ReceptionistUI.CreateClientUI recep = new ReceptionistUI.CreateClientUI();
    private App app;


    //public ReceptionistController()
    //{
      //  this.app = App.getInstance();
   // }

    public ReceptionistController(){this(App.getInstance().getCompany());}

    public ReceptionistController(Company company){
        this.company = company;
        this.rc = rc;
        this.authFacade = this.company.getAuthFacade();
    }

    public boolean createClient(String id, String pwd, String name, long nhs, long citizenCard, long tin, String birthDate, String sex, long pNumber){
        /*String email = String.valueOf(id);
        String password = String.valueOf(pwd);*/


        this.rc = this.clientStore.createClient(id,pwd,name,nhs,citizenCard,tin,birthDate,sex,pNumber);

        if(this.clientStore.validateClient(rc)){

            if(recep.answer()){//NAO FUNCIONA

                clientStore.saveClient(rc);
                return this.authFacade.addUserWithRole(name, id, pwd, Constants.ROLE_CLIENT);
            }else{
                return false;
            }

        }else{
            return false;
        }
    }

    public boolean saveClient(Client rc){
        return this.clientStore.saveClient(rc);
    }

    public void writeClient(){
        System.out.println(clientStore.getClientList().size());
        for(Client c : clientStore.getClientList())
            System.out.println(c);
    }






}
