package app.domain.model;

import auth.domain.model.Email;
import auth.domain.model.Password;

import java.util.ArrayList;

public class CreateClientStore {
    private ArrayList<Client> clientList;


    public CreateClientStore(){

        clientList = new ArrayList<>();
    }

    public Client createClient(Email id, Password pwd, String name, int nhs, int citizenCard, int tin, String birthDate, String sex, int pNumber ){
        return new Client(id,pwd,name,nhs,citizenCard,tin,birthDate,sex,pNumber );
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

}
