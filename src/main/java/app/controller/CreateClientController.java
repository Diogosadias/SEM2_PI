package app.controller;

import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.model.ClientStore;
import app.domain.model.TestStore;
import app.domain.shared.EmailSender;
import app.domain.shared.GeneratePassword;
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

    private ClientStore clientStore;
    private TestStore testStore;
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
        this.clientStore = this.company.getClientStore();
        this.testStore = this.company.getTestStore();
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
        String pwd = new GeneratePassword().getPwd();
        String email = rc.getId().getEmail();
        new EmailSender(email,pwd);
        if(!this.clientStore.validateClient(this.rc)){return false;}
        saveClient(this.rc,pwd);
        return true;

    }

    /**
     * Saves the new Client instance.
     *
     * @return boolean
     */
    public boolean saveClient(Client rc,String pwd){
        if (this.clientStore.validateClient(rc)) {
            return this.clientStore.saveClients(rc,pwd);
        }else{
            return false;
        }
    }

    public Client getClientByTIN(long tin){
        return this.clientStore.getClientByTIN(tin);

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
