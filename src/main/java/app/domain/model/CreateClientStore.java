package app.domain.model;

import auth.domain.model.Email;
import auth.domain.model.Password;

import java.util.ArrayList;
/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class CreateClientStore {
    private ArrayList<Client> clientList;


    public CreateClientStore(){

        clientList = new ArrayList<>();
    }

    public Client createClient(String id, String pwd, String name, long nhs, long citizenCard, long tin, String birthDate, String sex, long pNumber ){
        return new Client(id,pwd,name,nhs,citizenCard,tin,birthDate,sex,pNumber );
    }
    public boolean validateClient(Client rc){
        if(rc == null)
            return false;
        return ! this.clientList.contains(rc);
    }

    public void addClient(Client rc){
        clientList.add(rc);
    }

    public boolean saveClient(Client rc){
        if(!validateClient(rc))
            return false;
        return this.clientList.add(rc);
    }

    public void writeClients(){
        for(Client f : clientList)
            System.out.println(f);
    }

}
