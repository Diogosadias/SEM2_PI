package app.domain.store;

import app.domain.model.TestType;
import auth.AuthFacade;


import java.util.ArrayList;

public class CreateTestTypeStore {

    private final ArrayList<TestType> testTypeList = new ArrayList<>();



    public TestType createTestType(String code, String description, String collectingMethod) {
        return new TestType(code,description,collectingMethod );
    }


    public boolean validateTestType(TestType tt){
        if(tt == null)
            return false;
        return ! this.testTypeList.contains(tt);
    }

    public boolean saveTestType(TestType tt){
        if(!validateTestType(tt))
            return false;
        return this.testTypeList.add(tt);
    }

    public ArrayList<TestType> getTestTypeList(){
        return testTypeList;
    }
}
