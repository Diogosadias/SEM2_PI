package app.controller;

import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.model.ParameterCategory;
import app.domain.model.ParameterCategoryStore;
import app.domain.shared.Constants;
import auth.AuthFacade;

public class AdminController {

    private Company company;
    private AuthFacade authfacade;
    private App app;
    private ParameterCategoryStore pcs = new ParameterCategoryStore();


    private ParameterCategory pc;

    public AdminController(){
        this.company = company;
        this.pc = pc;

    }


    public boolean createParameterCategory(String code, String description, String nhsid){


        this.pc = this.pcs.createParameterCategory(code,description,nhsid);
        if(this.pcs.validateParameterCategory(pc)){
            pcs.saveParameterCategory(pc);
            return true;
        }
        else {
            return false;
        }

    }

    public boolean saveParameterCategory(ParameterCategory pc){
        return this.pcs.saveParameterCategory(pc);
    }

    public void writeParameters(){

        for(ParameterCategory f : pcs.getParameterCategoryList())
            System.out.println(f);

    }
}
