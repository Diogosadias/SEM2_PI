package app.domain.stores;

import app.domain.model.TestType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 */
public class TestTypeStore {

    /**
     * store - list of the test types available
     */
    private List<TestType> store;

    /**
     * Constructor for the test type store.
     * Initializes the list.
     */
    public TestTypeStore(){
        store = new ArrayList<>();
    }

    /**
     * Method for creating a new test type without parameters.
     *
     * @param code - Test Type Code
     * @param description - Test Type Description
     * @param collectingMethod - Test Type Collection Method
     *
     * @return TestType
     */
    public TestType createTestType(String code, String description, String collectingMethod) {
        if (code == null || description == null || collectingMethod == null) return null;
        return new TestType(code, description, collectingMethod);
    }

    /**
     * Method for the test type validation.
     *
     * @param tt - Test Type
     *
     * @return true/false
     */
    public boolean validateTestType(TestType tt){
        if(tt == null)
            return false;
        return ! this.store.contains(tt);
    }

    /**
     * Method for saving a new test type upon validation.
     *
     * @param tt - Test Type
     *
     * @return true/false
     */
    public boolean saveTestType(TestType tt){
        if (validateTestType(tt)) {
            return this.store.add(tt);
        } else {
            System.out.println("TestType " + tt.toString() + " already exists");
            return false;
        }
    }

    public boolean addTestType(TestType type) {
        return this.saveTestType(type);
    }

    /**
     * Method for deleting an existing test type.
     *
     * @param code - Test Type Code
     *
     * @return true/false
     */
    public boolean deleteTestType(String code){
        TestType testType = getTestTypeByCode(code);
        if(getTestTypeList().contains(testType)) {
            getTestTypeList().remove(testType);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Method for checking if a test type exists.
     *
     * @param code - Test Type Code
     *
     * @return true/false
     */
    public boolean searchTestType(String code) {
        TestType testType = getTestTypeByCode(code);
        if (getTestTypeList().contains(testType)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method for getting a test type by it's code.
     *
     * @param code - Test Type Code
     *
     * @return TestType/null
     */
    public TestType getTestTypeByCode(String code){
        for( TestType f : getTestTypeList()){
            if(code.equals(f.getCode()))
                return f;
        }
        return null;
    }

    /**
     * Method for getting the available test types.
     *
     * @return List<TestType>
     */
    public List<TestType> getTestTypeList(){
        return this.store;
    }
}
