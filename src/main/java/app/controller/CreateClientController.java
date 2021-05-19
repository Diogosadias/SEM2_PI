package app.controller;

import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.model.CreateClientStore;
import app.domain.shared.EmailSender;
import app.domain.shared.GeneratePassword;
import auth.AuthFacade;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Controller for the US3 realization - Register a new Client
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Tiago Ferreira <1200601@isep.ipp.pt>
 */
public class CreateClientController {

    private Company company;
    private AuthFacade authFacade;
    private App app;

    private CreateClientStore clientStore;
    Client rc;

    /**
     *  Public empty constructor
     */
    public CreateClientController(){this(App.getInstance().getCompany());}

    /**
     * Constructor for a given Company instance
     * @param company
     */
    public CreateClientController(app.domain.model.Company company){
        this.company = company;
        this.authFacade = this.company.getAuthFacade();
        this.clientStore = this.company.getCreateClientStore();
    }

    /**
     * Create a new Client and validates it.
     *
     * @param id Client's id
     * @param name Client's name
     * @param nhs Client's nhs
     * @param citizenCard Client's citizen card
     * @param tin Client's tin
     * @param birthDate Client's birth date
     * @param sex Client's sex
     * @param pNumber Client's phone number
     *
     * @return boolean
     */
    public boolean createClient(String id, String name, long nhs, long citizenCard, long tin, String birthDate, String sex, long pNumber){

        this.rc = this.clientStore.createClient(id,name,nhs,citizenCard,tin,birthDate,sex,pNumber);

        if(!this.clientStore.validateClient(this.rc)){return false;}
        saveClient(this.rc);
        return true;

    }

    /**
     * Saves the new Client instance.
     *
     * @return boolean
     */
    public boolean saveClient(Client rc){
        return this.clientStore.saveClient(this.rc);
    }

    /**
     * Write the Client instance.
     */
    public void writeClient(){
        System.out.println(clientStore.getClientList().size());
        for(Client c : clientStore.getClientList())
            System.out.println(c);
    }

}
