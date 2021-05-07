package app.controller;

import app.domain.model.Company;
import app.domain.model.ParameterCategory;
import app.domain.model.SpecifyNewTestStore;
import app.domain.model.TestType;

public class SpecifyNewTestTypeController {


    private Company company;
    private TestType tt;
    private SpecifyNewTestStore ts;

    public SpecifyNewTestTypeController(){
        this.company = App.getInstance().getCompany();
        this.ts = this.company.getSpecifyNewTestStore();
        this.tt = new TestType();
    }

    public boolean createTestType(String code, String description, String collectingMethods){
        this.tt = this.ts.createTestType(code, description, collectingMethods);
        if(this.ts.validateTestType(tt)){
            ts.saveTestType(tt);
            return true;
        }
        else
            return false;
    }

    public void writeTestType(){

        for(TestType t : ts.getTestTypeList())
            System.out.println(t); }


    public boolean saveTestType(){
        return this.ts.saveTestType(tt);
    }

    public void addParameterToTest(ParameterCategory pc){
        this.tt.setCategory(pc);
    }
}