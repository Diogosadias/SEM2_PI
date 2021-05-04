package app.controller;

import app.domain.model.*;

public class ParameterCategoryController {


    private Company company;
    private ParameterCategory pc;
    private ParameterCategoryStore parameterStore;
    private ParameterCategoryStore pcs = new ParameterCategoryStore();

    public ParameterCategoryController(){
        this(App.getInstance().getCompany());
    }

    public ParameterCategoryController(Company company){
        this.company = company;
        this.pc = null;
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

    public void writeParameters(){

        for(ParameterCategory f : pcs.getParameterCategoryList())
            System.out.println(f); }

    public boolean saveParameterCategory(){
        return this.parameterStore.saveParameterCategory(pc);
    }
}
