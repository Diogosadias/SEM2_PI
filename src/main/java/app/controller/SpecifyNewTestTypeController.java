package app.controller;

import app.domain.model.Company;
import app.domain.model.SpecifyNewTestStore;
import app.domain.model.TestType;

public class SpecifyNewTestTypeController {


    private Company company;
    private TestType tp;
    private SpecifyNewTestStore storeTestType;

    public SpecifyNewTestTypeController(){
        this(App.getInstance().getCompany());
    }

    public SpecifyNewTestTypeController(Company company){
        this.company = company;
        this.tp = null;
    }

    public boolean createTestType(String code, String description, String collectingMethods){
        this.tp = this.company.createTestType(code,description,collectingMethods);
        return this.storeTestType.validateTestType(tp);
    }

    public boolean saveTestType(){
        return this.storeTestType.saveTestType(tp);
    }
}