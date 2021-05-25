package app.domain.model;

import app.domain.dto.*;
import app.domain.shared.Constants;
import app.domain.shared.GenerateTestCode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 */
public class TestStore {

    private Company company;

    private Client client;

    private List<Test> testlist;

    private Test test;

    private long numRegisteredTest = 0;

    public TestStore(){
        testlist = new ArrayList<>();
    }
    
    /*public boolean checkCompleted(Test test) {
        return test.checkCompleted();
    }*/



    public void setCompany (Company company) {
        this.company = company;
    }

    public boolean checkRegisteredClient(long cc) {
        ClientStore cStore = this.company.getClientStore();
        this.client = cStore.getClientByCC(cc);
        return (client != null) ;
    }

    public List getListTestType() {
        TestTypeStore ttStore = this.company.getTestTypeStore();
        TestTypeMapper ttMapper = new TestTypeMapper();
        return ttMapper.toDto(ttStore.getTestTypeList());
    }

    public void newTest(String typeCode) {
        TestTypeStore ttStore = this.company.getTestTypeStore();
        TestType type = ttStore.getTestTypeByCode(typeCode);
        String description = type.getCollectingMethod();
        this.test = new Test(type,description,this.client);
        generateTestCode();
    }

    private void generateTestCode() {
        String testCode = new GenerateTestCode(numRegisteredTest).getCode();
        this.test.setCode(testCode);
    }

    public void addCategoryToTest (String categoryCode) {
        ParameterCategoryStore pcStore = this.company.getParameterCategoryStore();
        ParameterCategory category = pcStore.getParameterCategoryByCode(categoryCode);
        this.test.addCategory(category);
    }

    public List getListParameters(String categoryCode) {
        ParameterStore pStore = this.company.getParameterStore();
        ParameterMapper pMapper = new ParameterMapper();
        return pMapper.toDto(pStore.getParameterList(),categoryCode);
    }

    public boolean addParameterToTest(String parameterCode) {
        ParameterStore pStore = this.company.getParameterStore();
        Parameter parameter = pStore.getParameterByCode(parameterCode);
        return this.test.addParameter(parameter);
    }

    public void addNhsCodeToTest(String nhs) {
        this.test.setNhsCode(nhs);
    }

    public boolean validateTest() {
        for (Test t : testlist) {
            if (t.getClient().equals(t.getNhsCode().equals(this.test.getNhsCode()))) {
                System.out.println("Error: Test was already registered with same Nhs code.");
            }
        }
        return true;
    }

    public void saveTest() {
        if(!testlist.contains(this.test)) {
            testlist.add(this.test);
            numRegisteredTest += 1;
        } else {
            throw new IllegalArgumentException("Test is already registered.");
        }
    }
    
    public void updateTestState(TestDto test, String state){
        for (Test t : testlist) {
            if (t.getCode().equals(test.getCode()))
                t.setState(state);
        }
    }

    public void addTest(Test test){
        this.test = test;
        this.saveTest();
    }

    public boolean addSampleToTest(Sample sample) {
        return this.test.addSample(sample);
    }

    public List<Test> getRegisteredTests () {
        // Test list with only new registered Tests
        return this.getTests(Constants.REGISTERED);
    }

    public List<Test> getSampleCollectedTests(){
        // Test list with at least one Sample collected
        return this.getTests(Constants.SAMPLE_COLLECTED);
    }

    public List<Test> getSampleAnalysisTests(){
        // Test list with Chemical analysis Samples
        return this.getTests(Constants.SAMPLE_ANALYSED);
    }

    public List<Test> getDiagnosedTests(){
        // Test list with Diagnosis made to chemical analysis
        return this.getTests(Constants.DIAGNOSIS_MADE);
    }

    public List<Test> getValidatedTests(){
        // Test list with diagnosis and report Validated
        return this.getTests(Constants.VALIDATED);
    }

    public List<Test> getTests (String state) {
        if(this.testlist!=null) {
            if (this.testlist.isEmpty()) {
                throw new IllegalArgumentException("Test list is empty.\n");
            }
            List<Test> temp = new ArrayList<>();
            for (Test t : this.testlist) {
                if (t.hasCondition(state)) {
                    temp.add(t);
                }
            }
            if (temp.isEmpty()) {
                throw new IllegalArgumentException("Sample Test list is empty.\n");
            }
            return temp;
        }
        return null;
    }

    public void setTest (String code) {
        this.test = this.getTestByCode(code);
    }

    public Test getTest () {
        return this.test;
    }

    public Test getTestByCode( String code){

        for(Test t : this.testlist){
            if(t.getCode().equals(code))
                return t;
        }
        throw new IllegalArgumentException("Test with that code doesn't exist!");
    }

    public List<ParameterDto> getListParametersFromTest () {
        ParameterMapper mapper = new ParameterMapper();
        List<Parameter> parameters = this.test.getListParameters();
        List<ParameterDto> dto = new ArrayList<>();
        for (ParameterCategory category : this.test.getListCategories()) {
            dto.addAll(mapper.toDto(parameters,category.getCode()));
        }
        return dto;
    }

    public String getTestToString() {
        String s =  "\nClient: " + this.test.getClient().getCitizenCard() +
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

    public String getTestResultToString() {
        TestParameter testParam = this.test.getCurrentTestParameter();
        String s = "\nType of Test: " + this.test.getTestType().getDescription() +
                "\nCollection Method: " + this.test.getDescription()+
                "\n" + testParam;
        return s;
    }
}
