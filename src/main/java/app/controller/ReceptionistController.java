package app.controller;

import app.domain.model.*;
import auth.domain.model.Email;
import auth.domain.model.Password;

import java.util.Scanner;
/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class ReceptionistController {


    private Company company;
    private Client rc;
    private CreateClientStore clientStore;

    public ReceptionistController(){
        this(App.getInstance().getCompany());
    }

    public ReceptionistController(Company company){
        this.company = company;
        this.rc = null;
    }

    public boolean createClient(String id, String pwd, String name, long nhs, long citizenCard, long tin, String birthDate, String sex, long pNumber){
        this.rc = this.clientStore.createClient(id,pwd,name,nhs,citizenCard,tin,birthDate,sex,pNumber);
        return this.clientStore.validateClient(rc);
    }

    public boolean saveClient(){
        return this.clientStore.saveClient(rc);
    }


}
