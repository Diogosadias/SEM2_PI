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



    private ParameterCategory pc;

    public AdminController(){
        this.company = company;
        this.pc = pc;

    }



}
