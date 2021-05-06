package app.domain.store;

import app.domain.model.TestType;

import java.util.ArrayList;

/**
 *
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */

public class SpecifyNewTestStore {

    private ArrayList <TestType> TestTypeList;

    public SpecifyNewTestStore(){
        TestTypeList = new ArrayList<>();
    }

    public TestType createNewTestType(String code, String description, String collectingMethod) {
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
