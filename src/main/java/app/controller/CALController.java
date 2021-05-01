package app.controller;

import app.domain.model.*;
import auth.domain.model.Email;
import auth.domain.model.Password;

public class CALController {


    private Company company;
    private CAL cal;
    private CALStore calStore;

    public CALController(){
        this(App.getInstance().getCompany());
    }

    public CALController(Company company){
        this.company = company;
        this.cal = null;
    }

    public boolean createCAL(String labname, String address, int phone_number, int tin_number){
        this.cal = this.calStore.createCAL(labname,address,phone_number,tin_number);
        return this.calStore.validateCAL(cal);
    }

    public boolean saveCAL(){
        return this.calStore.saveCAL(cal);
    }
}
