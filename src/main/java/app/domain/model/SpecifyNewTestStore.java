package app.domain.model;

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

    public TestType createTestType(String code, String description, String collectingMethod) {
        return new TestType(code,description,collectingMethod );
    }


    public boolean validateTestType(TestType tt){
        if(tt == null)
            return false;
        return ! this.TestTypeList.contains(tt);
    }


    public boolean saveTestType(TestType tt){
        if(!validateTestType(tt))
            return false;
        return this.TestTypeList.add(tt);
    }

    public ArrayList<TestType> getTestTypeList(){
        return TestTypeList;
    }
}
