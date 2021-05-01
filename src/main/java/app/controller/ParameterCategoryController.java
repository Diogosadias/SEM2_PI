package app.controller;

import app.domain.model.*;

public class ParameterCategoryController {


    private Company company;
    private ParameterCategory pc;
    private ParameterCategoryStore parameterStore;

    public ParameterCategoryController(){
        this(App.getInstance().getCompany());
    }

    public ParameterCategoryController(Company company){
        this.company = company;
        this.pc = null;
    }

    public boolean createParameterCagegory(String code, String description, String nhsId){
        this.pc = this.parameterStore.createParameterCategory(code,description,nhsId);
        return this.parameterStore.validateParameterCategory(pc);
    }

    public boolean saveParameterCategory(){
        return this.parameterStore.saveParameterCategory(pc);
    }
}
