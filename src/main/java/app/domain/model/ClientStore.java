package app.domain.model;


import app.domain.shared.Constants;


import auth.AuthFacade;
import auth.domain.model.Email;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * ClientStore - Class responsible for managing Clients.
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Tiago Ferreira <1200601@isep.ipp.pt>
 * @author Gil <1180838@isep.ipp.pt>
 */
public class ClientStore {

    /**
     * Initialize a list of clients.
     */
    private final List<Client> clientList;

    /**
     * The AuthFacade of ClientStore.
     */
    private final AuthFacade authFacade;

    /**
     * Create Store instance with empty array.
     */
    public ClientStore(AuthFacade authFacade){
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
        for (Client client: this.clientList) {
            if(rc.getId().equals(client.getId())){
                System.out.println("This email is already being used!");
                return false;
                //throw new IllegalArgumentException("This email is already being used!");
            }else
            if(rc.getCitizenCard()==client.getCitizenCard()){
                System.out.println("This citizen card is already being used!");
                return false;
                //throw new IllegalArgumentException("This citizen card is already being used!");
            }else
            if(rc.getNhs()==client.getNhs()){
                System.out.println("This nhs is already being used!");
                return false;
                //throw new IllegalArgumentException("This nhs is already being used!");
            }else
            if(rc.getPNumber()==client.getPNumber()){
                System.out.println("This phone number is already being used!");
                return false;
                //throw new IllegalArgumentException("This phone number is already being used!");
            }else
            if(rc.getTin()==client.getTin()){
                System.out.println("This tin is already being used!");
                return false;
                //throw new IllegalArgumentException("This tin is already being used!");
            }
        }

            return ! this.clientList.contains(rc);
        }
        return false;
    }

    public boolean saveClients(Client rc, String pwd){

            this.authFacade.addUserWithRole(rc.getName(), rc.getId().getEmail(), pwd , Constants.ROLE_CLIENT);
            return this.clientList.add(rc);

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

    public Client getClientByCC(long cc) {
        for ( Client c : clientList) {
            if (c.getCitizenCard() == cc) {
                return c;
            }
        }
        return null;
    }
    public Client getClientByTIN(long tin) {
        for ( Client c : clientList) {
            if (c.getTin() == tin) {
                return c;
            }
        }
        return null;
    }


}
