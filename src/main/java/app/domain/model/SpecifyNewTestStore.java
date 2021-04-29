package app.domain.model;

import java.util.ArrayList;

class SpecifyNewTypeTestStore {

    private ArrayList <TestType> TestTypeList;

    public SpecifyNewTypeTestStore(){
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
