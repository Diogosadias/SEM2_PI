package app.controller;

import app.domain.model.*;
import app.domain.store.ParameterCategoryStore;

/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class ParameterCategoryController {


    private Company company;
    private ParameterCategory pc;
    private ParameterCategoryStore parametercategoryStore;
    private ParameterCategoryStore pcs;

    public ParameterCategoryController(){
        this(App.getInstance().getCompany());
    }

    public ParameterCategoryController(Company company){
        this.company = company;
        this.pc = null;
        this.pcs = company.getParameterCategoryStore();
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

    public void writeParameterCategories(){
        System.out.println(pcs.toString());

    }

    public ParameterCategory getParameterCategory(String code){

        for(ParameterCategory f : pcs.getParameterCategoryList()){
            if(f.getCode().equals(code))
                return f;
        }
        return null;
    }

    public boolean saveParameterCategory(){
        return this.parametercategoryStore.saveParameterCategory(pc);
    }
}
