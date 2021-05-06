package app.controller;

import app.domain.model.*;

import java.util.ArrayList;

public class CreateTestTypeController {
    private Company company;
    private CreateTestTypeStore ts;
    private TestType tt;


    public CreateTestTypeController(){
        this.company = App.getInstance().getCompany();
        this.ts = company.getTestTypeStore();
    }

    public boolean createTestType(String code, String description, String collectingMethod) {
        this.tt = this.ts.createTestType(code,description,collectingMethod);
        if(this.ts.validateTestType(tt)){
            ts.saveTestType(tt);
            return true;
        }
        else
            return false;

    }

    public void writeTestType(){
        for(TestType t : ts.getTestTypeList())
            System.out.println(t); 
    }

    public void addParameterToTest(ParameterCategory pc){
        this.tt.setCategory(pc);
    }


}
