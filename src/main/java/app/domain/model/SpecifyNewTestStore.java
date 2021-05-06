package app.domain.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */

public class SpecifyNewTestStore {
    
    private final Set<TestType> store;

    public SpecifyNewTestStore(){
        store = new HashSet<TestType>();
    }

    public TestType createTestType(String code, String description, String collectingMethod) {
        return new TestType(code, description, collectingMethod);
    }


    public boolean validateTestType(TestType tt){
        if(tt == null)
            return false;
        return ! this.store.contains(tt);
    }


    public boolean saveTestType(TestType tt){
        if (validateTestType(tt)) {
            return this.store.add(tt);
        } else {
            System.out.println("TestType " + tt.toString() + " already exists");
            return false;
        }
    }

    public Set<TestType> getTestTypeList(){
        return this.store;
    }
}
