package app.controller;

import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.model.CreateClientStore;
import auth.AuthFacade;

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


    public boolean createClient(String id, String name, long nhs, long citizenCard, long tin, String birthDate, String sex, long pNumber,String testpass){

        this.rc = this.clientStore.createClient(id,name,nhs,citizenCard,tin,birthDate,sex,pNumber);

        if(!this.clientStore.validateClient(this.rc)){return false;}

        saveClient(testpass);
        return true;

    }


    public boolean saveClient(String pwd){
        return this.clientStore.saveClient(this.rc, pwd);
    }

    public void writeClient(){

        for(Client c : clientStore.getClientList())
            System.err.println(c);
    }
}
