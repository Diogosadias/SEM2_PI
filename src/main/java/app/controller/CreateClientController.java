package app.controller;

import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.model.CreateClientStore;
import auth.AuthFacade;

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

    private CreateClientStore createClientStore;
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
        this.createClientStore = this.company.getClientStore();
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

        this.rc = this.createClientStore.createClient(id,name,nhs,citizenCard,tin,birthDate,sex,pNumber);

        if(!this.createClientStore.validateClient(this.rc)){return false;}
        saveClient(this.rc);
        return true;

    }

    /**
     * Saves the new Client instance.
     *
     * @return boolean
     */
    public boolean saveClient(Client rc){
        return this.createClientStore.saveClient(rc);
    }

    /**
     * Write the Client instance.
     */
    public void writeClient(){
        System.out.println(createClientStore.getClientList().size());
        for(Client c : createClientStore.getClientList())
            System.out.println(c);
    }

}
