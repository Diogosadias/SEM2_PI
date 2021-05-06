package app.controller;

import app.domain.model.Company;
import app.domain.model.ParameterCategory;
import app.domain.model.SpecifyNewTestStore;
import app.domain.model.TestType;

public class SpecifyNewTestTypeController {


    private Company company;
    private TestType tt;
    private SpecifyNewTestStore storeTestType;

    public SpecifyNewTestTypeController(){
        this(App.getInstance().getCompany());
    }

    public SpecifyNewTestTypeController(Company company){
        this.company = company;
        this.storeTestType = this.company.getSpecifyNewTestStore();
        this.tt = new TestType();
    }

    public boolean createTestType(String code, String description, String collectingMethods){
        //this.tp = this.company.createTestType(code,description,collectingMethods);
        return this.storeTestType.validateTestType(tt);
    }

    public void writeTestType(){

        for(TestType t : storeTestType.getTestTypeList())
            System.out.println(t); }


    public boolean saveTestType(){
        return this.storeTestType.saveTestType(tt);
    }

    public void addParameterToTest(ParameterCategory pc){
        this.tt.setCategory(pc);
    }
}