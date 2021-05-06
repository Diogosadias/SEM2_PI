package app.controller;

import app.domain.model.*;

import java.util.ArrayList;

public class CreateTestTypeController {
    private Company company;
    private CreateTestTypeStore ts = new CreateTestTypeStore();
    private TestType tt;


    public CreateTestTypeController(){
        this(App.getInstance().getCompany());
    }


    public CreateTestTypeController(Company company){
        this.company = company;
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
            System.out.println("hello");
    }

    public void addParameterToTest(ParameterCategory pc){
        this.tt.setCategory(pc);
    }


}
