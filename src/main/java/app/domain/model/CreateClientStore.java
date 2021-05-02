package app.domain.model;



import auth.domain.model.Email;
import auth.domain.model.Password;

import java.util.ArrayList;

/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class CreateClientStore {
    private final ArrayList<Client> clientList;

    //private final AuthFacade authFacade = new AuthFacade();

    public CreateClientStore(){

        clientList = new ArrayList<>();
    }

    public Client createClient(String id, String pwd, String name, long nhs, long citizenCard, long tin, String birthDate, String sex, long pNumber ){
        Email email = new Email(id);
        Password password = new Password(pwd);
        //boolean validateuser =  fazer try catch ou validateuser
               // this.authFacade.addUserWithRole(name, id, pwd, Constants.ROLE_CLIENT);

        return new Client(email, password, name, nhs, citizenCard, tin, birthDate, sex, pNumber);

    }

    public boolean validateClient(Client rc){
        if(rc == null)
            return false;
        return ! this.clientList.contains(rc);
    }



    public boolean saveClient(Client rc){
        if(!validateClient(rc))
            return false;
        return this.clientList.add(rc);
    }

    public void writeClients(){

        for(Client f : this.clientList) {
            System.out.println("awd");
            System.out.println(f);
        }
    }

}
