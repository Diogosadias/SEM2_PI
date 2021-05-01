package app.controller;

import app.domain.model.*;
import auth.domain.model.Email;
import auth.domain.model.Password;

public class CreateClientController {


    private Company company;
    private Client rc;
    private CreateClientStore clientStore;

    public CreateClientController(){
        this(App.getInstance().getCompany());
    }

    public CreateClientController(Company company){
        this.company = company;
        this.rc = null;
    }

    public boolean createClient(Email id, Password pwd, String name, int nhs, int citizenCard, int tin, String birthDate, String sex, int pNumber){
        this.rc = this.clientStore.createClient(id,pwd,name,nhs,citizenCard,tin,birthDate,sex,pNumber);
        return this.clientStore.validateClient(rc);
    }

    public boolean saveTestType(){
        return this.clientStore.saveClient(rc);
    }
}
