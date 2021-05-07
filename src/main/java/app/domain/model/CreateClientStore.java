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
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Tiago Ferreira <1200601@isep.ipp.pt>
 * @author Gil <1180838@isep.ipp.pt>
 */
public class CreateClientStore {
    private final List<Client> clientList;

    private final AuthFacade authFacade;

    public CreateClientStore(AuthFacade authFacade){
        this.clientList = new ArrayList<>();
        this.authFacade = authFacade;
    }



    public Client createClient(String id, String name, long nhs, long citizenCard, long tin, String birthDate, String sex, long pNumber ){
        Email email = new Email(id);

        String[] date = birthDate.split("/");
        Date birthDateFormat = new Date(Integer.valueOf(date[0]),Integer.valueOf(date[1]),Integer.valueOf(date[2]));

        return new Client(email, name, nhs, citizenCard, tin, birthDateFormat, sex, pNumber);
    }

    public boolean validateClient(Client rc){
        if(rc!=null) {
            return ! this.clientList.contains(rc);
        }
        return false;
    }

    public boolean saveClient(Client rc, String pwd){
        if(validateClient(rc)){
            this.authFacade.addUserWithRole(rc.getName(), rc.getId().getEmail(), pwd , Constants.ROLE_CLIENT);
            return this.clientList.add(rc);
        }
            return false;


    }


    public void setClientList(Client rc){
        clientList.add(rc);
    }

    public List<Client> getClientList() {
        return clientList;
    }




}
