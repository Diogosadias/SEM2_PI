package app.domain.model;

import app.domain.dto.*;
import app.domain.shared.Constants;
import app.domain.shared.GenerateTestCode;
import java.util.ArrayList;
import java.util.List;

/**
 * TestStore - Class responsible for managing tests.
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */

public class TestStore extends Store{

    /**
     * The company.
     */
    private Company company;

    /**
     * The client.
     */
    private Client client;

    /**
     * Initialize a list of tests.
     */
    private final List<Test> testList;

    /**
     * The test.
     */
    private Test test;

    /**
     * The number of registered tests.
     */
    private long numRegisteredTest = 0;

    /**
     * Initialize a list of Test's store.
     */
    public TestStore() {
        super();
        testList = new ArrayList<>();
    }

    /**
     * Changes the company.
     *
     * @param company - Company
     */

    public void setCompany (Company company) {
        this.company = company;
    }

    /**
     * Return the company.
     *
     * @return Company
     */

    public Company getCompany () {
        return company;
    }

    /**
     * Check if the registered date it's within the rules.
     *
     * @param tin - Client's TIN
     */

    public boolean checkRegisteredClient(long tin) {
        ClientStore cStore = this.company.getClientStore();
        this.client = cStore.getClientByTIN(tin);
        return (client != null) ;
    }

    /**
     * Return the TestType's list.
     *
     * @return TestType's list
     */

    public List<TestTypeDto> getListTestType() {
        TestTypeStore ttStore = this.company.getTestTypeStore();
        TestTypeMapper ttMapper = new TestTypeMapper();
        return ttMapper.toDto(ttStore.getTestTypeList());
    }

    /**
     * Creates a Test instance.
     *
     * @param typeCode - Test's code
     */

    public void newTest(String typeCode) {
        TestTypeStore ttStore = this.company.getTestTypeStore();
        TestType type = ttStore.getTestTypeByCode(typeCode);
        String description = type.getCollectingMethod();
        this.test = new Test(type,description,this.client);
        generateTestCode();
    }

    /**
     * Generate code of the test.
     */

    private void generateTestCode() {
        String testCode = new GenerateTestCode(numRegisteredTest).getCode();
        long newNum = (numRegisteredTest);
        for (int i = 0; i < this.testList.size(); i++ ) {
            if(testCode.equals(testList.get(i).getCode())) {
                newNum++;
                testCode = new GenerateTestCode(newNum).getCode();
            }
        }
        this.test.setCode(testCode);
    }

    /**
     * Add a category to test.
     *
     * @param categoryCode - Category's code
     */

    public void addCategoryToTest (String categoryCode) {
        ParameterCategoryStore pcStore = this.company.getParameterCategoryStore();
        ParameterCategory category = pcStore.getParameterCategoryByCode(categoryCode);
        this.test.addCategory(category);
    }

    /**
     * Return the Parameter's list.
     *
     * @return Parameter's list
     */

    public List getListParameters(String categoryCode) {
        ParameterStore pStore = this.company.getParameterStore();
        ParameterMapper pMapper = new ParameterMapper();
        return pMapper.toDto(pStore.getParameterList(),categoryCode);
    }

    /**
     * Add a parameter to test.
     *
     * @param parameterCode - Parameter's code
     */

    public boolean addParameterToTest(String parameterCode) {
        ParameterStore pStore = this.company.getParameterStore();
        Parameter parameter = pStore.getParameterByCode(parameterCode);
        return this.test.addParameter(parameter);
    }

    /**
     * Add a nhsCode to test.
     *
     * @param nhs - Test's nhsCode
     */

    public void addNhsCodeToTest(String nhs) {
        this.test.setNhsCode(nhs);
    }

    /**
     * Validates Test attributes for business model rules.
     *
     * @return boolean
     */

    public boolean validateTest() {
        for (Test t : testList) {
            if (t.getNhsCode().equals(this.test.getNhsCode())) {
                System.out.println("Error: Test was already registered with same Nhs code.");
                return false;
            }
            if (t.getCode().equals(this.test.getCode())) {
                System.out.println("Error: Test was already registered with same code.");
                return false;
            }
        }
        return true;
    }

    /**
     * Saves the new Test.
     */

    public void saveTest() {
        if(!testList.contains(this.test)) {
            testList.add(this.test);
            numRegisteredTest += 1;
        } else {
            throw new IllegalArgumentException("Test is already registered.");
        }
    }

    /**
     * Add a Test.
     *
     * @param test - Test
     */

    public void addTest(Test test){
        this.test = test;
        this.saveTest();
    }

    /**
     * Add a sample of the test.
     *
     * @param sample - Test's sample
     */

    public boolean addSampleToTest(Sample sample) {
        return this.test.addSample(sample);
    }

    /**
     * Method for getting the Registered Tests List.
     *
     * @return registered tests list
     */

    public List<Test> getRegisteredTests () {
        // Test list with only new registered Tests
        return this.getTests(Constants.REGISTERED);
    }

    /**
     * Method for getting the Sample Collected List.
     *
     * @return sample collected list
     */

    public List<Test> getSampleCollectedTests(){
        // Test list with at least one Sample collected
        return this.getTests(Constants.SAMPLE_COLLECTED);
    }

    /**
     * Method for getting the Sample Analysed List.
     *
     * @return sample analysed list
     */

    public List<Test> getSampleAnalysisTests(){
        // Test list with Chemical analysis Samples
        return this.getTests(Constants.SAMPLE_ANALYSED);
    }

    /**
     * Method for getting the Diagnosed Tests List.
     *
     * @return diagnosed tests list
     */

    public List<Test> getDiagnosedTests(){
        // Test list with Diagnosis made to chemical analysis
        return this.getTests(Constants.DIAGNOSIS_MADE);
    }

    /**
     * Method for getting the Validated Tests List.
     *
     * @return validated tests list
     */

    public List<Test> getValidatedTests(){
        // Test list with diagnosis and report Validated
        try {
            return this.getTests(Constants.VALIDATED);
        }catch(IllegalArgumentException i) {
            System.out.println("\nTest list in Validated state is empty.");
        }
        return null;
    }

    /**
     * Method for getting the Test List.
     *
     * @param state - Test's state
     *
     * @return tests list
     */

    public List<Test> getTests (String state) {
        if(this.testList !=null) {
            if (this.testList.isEmpty()) {
                throw new IllegalArgumentException("Test list is empty.\n");
            }
            List<Test> temp = new ArrayList<>();
            for (Test t : this.testList) {
                if (t.hasCondition(state)) {
                    temp.add(t);
                }
            }
            if (temp.isEmpty()) {
                throw new IllegalArgumentException("No "+state+" tests");
            }
            return temp;
        }
        return null;
    }


    public void setTest (Test test) {
        this.test = test;
    }

    /**
     * Method for getting the Test List.
     *
     * @return Test
     */

    public Test getTest () {
        return this.test;
    }

    /**
     * Method for getting the Test by the code.
     *
     * @param code Test's code
     *
     * @return Test
     */

    public Test getTestByCode( String code){

        for(Test t : this.testList){
            if(t.getCode().equals(code))
                return t;
        }
        throw new IllegalArgumentException("Test with that code doesn't exist!");
    }

    /**
     * Method for getting the Parameter List of the test.
     *
     * @return parameter list of the test
     */

    public List<ParameterDto> getListParametersFromTest () {
        ParameterMapper mapper = new ParameterMapper();
        List<Parameter> parameters = this.test.getListParameters();
        List<ParameterDto> dto = new ArrayList<>();
        for (ParameterCategory category : this.test.getListCategories()) {
            dto.addAll(mapper.toDto(parameters,category.getCode()));
        }
        return dto;
    }

    /**
     * Change the test state diagnosis.
     *
     * @param test Test's diagnosis state
     */

    public boolean setTestStateDiagnosis(Test test) {
        return test.testDiagnosisCompleted();
    }

    /**
     * Return the textual description of the tests.
     *
     * @return Test features
     */

    public String getTestToString() {
        String s =  "\nClient: " + this.test.getClient().getTin() +
                "\nType of Test: " + this.test.getTestType().getDescription() +
                "\nCollection Method: " + this.test.getDescription()+
                "\nNhs Code: " + this.test.getNhsCode() +
                "\n\nList of Parameter(s) for each Category to be analysed: ";
        for (ParameterCategory category : this.test.getListCategories()) {
            s = s + "\n\n - " + category.getDescription();
            for (Parameter parameter : this.test.getListParameters()) {
                if (parameter.getCategory().equals(category.getCode()))                            {
                    s = s + "\n" + parameter.getName();
                }
            }
        }
        return s;
    }
    /**
     * Return the textual description of the test results.
     *
     * @return test results features
     */

    public String getTestResultToString() {
        TestParameter testParam = this.test.getCurrentTestParameter();
        return  "\nType of Test: " + this.test.getTestType().getDescription() +
                "\nCollection Method: " + this.test.getDescription()+
                "\n" + testParam;
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
        for(Test t: testList) {
            list.add(t);
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
        return "ser/test.txt";
    }

    /**
     * Read Object from File and import as this store's object class.
     *
     * @param o Object
     */

    @Override
    public void importObject(Object o) {
        // Read Object from File and import as this store's object class
        this.test = (Test) o;
        this.saveTest();
    }

    /**
     * Method for getting the Test List of all tests.
     *
     * @return Test List
     */

    public Iterable<Test> getAllTests() {
        return this.testList;
    }

}
