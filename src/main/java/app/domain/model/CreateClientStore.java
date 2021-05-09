package app.domain.model;

import app.controller.App;
import app.domain.shared.Constants;
import auth.AuthFacade;
import auth.domain.model.Email;
import auth.domain.model.Password;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * CreateClientStore - Class responsible for managing Clients.
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Tiago Ferreira <1200601@isep.ipp.pt>
 * @author Gil <1180838@isep.ipp.pt>
 */
public class CreateClientStore {

    /**
     * Initialize a list of clients.
     */
    private final List<Client> clientList;

    /**
     * The AuthFacade of CreateClientStore.
     */
    private final AuthFacade authFacade;

    /**
     * Create Store instance with empty array.
     */
    public CreateClientStore(AuthFacade authFacade){
        this.clientList = new ArrayList<>();
        this.authFacade = authFacade;
    }

    /**
     * Creates a Client instance and returns it.
     *
     * @param id client's id
     * @param name client's name
     * @param nhs client's nhs
     * @param citizenCard client's citizen card
     * @param tin client's tin
     * @param birthDate client's birth date
     * @param sex client's sex
     * @param pNumber client's phone number
     *
     * @return Client
     */
    public Client createClient(String id, String name, long nhs, long citizenCard, long tin, String birthDate, String sex, long pNumber ){
        Email email = new Email(id);

        String[] date = birthDate.split("/");
        Date birthDateFormat = new Date(Integer.valueOf(date[0]),Integer.valueOf(date[1]),Integer.valueOf(date[2]));

        return new Client(email, name, nhs, citizenCard, tin, birthDateFormat, sex, pNumber);
    }

    /**
     * Validates Client attributes for business model rules.
     *
     * @param rc - Client
     *
     * @return boolean
     */
    public boolean validateClient(Client rc){
        if(rc!=null) {
            return ! this.clientList.contains(rc);
        }
        return false;
    }

    /**
     * Saves the new Client.
     *
     * @param rc - Client
     * @param pwd - Client's password
     *
     * @return boolean
     */
    public boolean saveClient(Client rc, String pwd){
        if(validateClient(rc)){
            this.authFacade.addUserWithRole(rc.getName(), rc.getId().getEmail(), pwd , Constants.ROLE_CLIENT);
            return this.clientList.add(rc);
        }
            return false;


    }

    /**
     * Change the Client's list.
     *
     * @param rc Client
     */
    public void setClientList(Client rc){
        clientList.add(rc);
    }

    /**
     * Return the Client's list.
     *
     * @return Client's list
     */
    public List<Client> getClientList() {
        return clientList;
    }




}
