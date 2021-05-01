package app.domain.model;

import java.util.ArrayList;

public class SpecifyNewTestStore {

    private ArrayList <TestType> TestTypeList;

    public SpecifyNewTestStore(){
        TestTypeList = new ArrayList<>();
    }

    public TestType createNewTestType(String code, String description, String collectingMethod ){
        return new TestType(code,description,collectingMethod );
    }
    public boolean validateTestType(TestType tp){
        if(tp == null)
            return false;
        return ! this.TestTypeList.contains(tp);
    }

    public boolean saveTestType(TestType tp){
        if(!validateTestType(tp))
            return false;
        return this.TestTypeList.add(tp);
    }


}
