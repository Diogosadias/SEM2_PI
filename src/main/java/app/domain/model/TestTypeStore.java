package app.domain.model;

import java.util.ArrayList;
import java.util.List;

/**
 * TestTypeStore - Class responsible for managing Test Types.
 *
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 */

public class TestTypeStore extends Store{

    /**
     * The Test Type.
     */
    private TestType type;

    /**
     * store - list of the test types available
     */
    private final List<TestType> store;

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
        this.type = new TestType(code, description, collectingMethod);
        return type;
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

    /**
     * Add a Test Type.
     *
     * @param type TestType
     *
     * @return boolean
     */

    public boolean addTestType(TestType type) {
        this.type = type;
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
        return getTestTypeList().contains(testType);
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

    /**
     * Return the List's store.
     *
     * @return List
     */

    @Override
    public List getListObjects() {
        //Change list of objects in Store to a List Object
        List<Object> list = new ArrayList<>();
        for(TestType tt: store) {
            list.add(tt);
        }
        return list;
    }

    /**
     * Get the name of the file.
     *
     * @return File's name
     */

    @Override
    public String getFileName() {
        // Path - "Folder: ser" / "File Name: this store's object class" "Suffix: .txt"
        return "ser/testtype.txt";
    }

    /**
     * Read Object from File and import as this store's object class.
     *
     * @param o Object
     */

    @Override
    public void importObject(Object o) {
        // Read Object from File and import as this store's object class
        this.type = (TestType) o;
        this.saveTestType(type);
    }
}
