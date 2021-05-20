package app.domain.model;

import app.domain.dto.*;
import app.domain.shared.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 */
public class TestStore {

    private Company company;

    private Client client;

    private List<Test> testlist;

    private Test test;

    private long numRegisteredTest = 100000000000L;
    private final long MAX_NUM_TEST = 1000000000000L;

    public TestStore(){
        testlist = new ArrayList<>();
    }

    public void setCompany (Company company) {
        this.company = company;
    }

    public boolean checkRegisteredClient(long cc) {
        ClientStore cStore = this.company.getCreateClientStore();
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
        if(numRegisteredTest + 1 == MAX_NUM_TEST) {
            throw new IllegalArgumentException("Reached maximum number of Tests.");
        }
        this.test.setCode(numRegisteredTest + 1);
    }

    public List getListParameters(String category) {
        ParameterStore pStore = this.company.getParameterStore();
        ParameterMapper pMapper = new ParameterMapper();
        return pMapper.toDto(pStore.getParameterList(),category);
    }

    public boolean addParameterToTest(String parameterCode) {
        ParameterStore pStore = this.company.getParameterStore();
        List<Parameter> list = this.test.getListParameters();
        Parameter parameter = pStore.getParameterByCode(parameterCode);
        if(list.isEmpty() || !list.contains(parameter)){
            this.test.addParameter(parameter);
            return true;
        }
        System.out.println("Test already contains the selected Parameter.");
        return false;
    }

    public void addNhsCodeToTest(String nhs) {
        this.test.setNhsCode(nhs);
    }

    public boolean validateTest() {
        for (Test t : testlist) {
            if (t.getClient().equals(this.test.getClient()) && t.getTestType().equals(this.test.getTestType()) && t.getListParameters().equals(this.test.getListParameters()) && t.getDescription().equals(this.test.getDescription()) && t.getNhsCode().equals(this.test.getNhsCode())) {
                System.out.println("Error: Test was already registered with same Client, TestType and list of Parameters");
            }
        }
        return true;
    }

    public String getTestToString() {
        String s =  "\nClient: " + this.test.getClient().getCitizenCard() +
                    "\nType of Test: " + this.test.getTestType().getDescription() +
                    "\nCollection Method: " + this.test.getDescription()+
                    "\nNhs Code: " + this.test.getNhsCode() +
                    "\n\nList of Parameters to be measured: ";
        for (Parameter p : this.test.getListParameters()) {
            s = s + "\n - " + p.getName();
        }
        return s;
    }

    public void saveTest() {
        if(!testlist.contains(this.test)) {
            testlist.add(this.test);
            numRegisteredTest += 1;
        } else {
            throw new IllegalArgumentException("Test is already registered.");
        }
    }

    public void addTest(Test test){
        this.test = test;
        this.saveTest();
    }

    public boolean getTest(Test test) {
        if (checkCompleted(test))
            return true;
        return false;
    }

    public boolean checkCompleted(Test test) {
        return test.checkCompleted();
    }



    public void addSampletoTest(Sample sample, Test test) {

        for (Test t : testlist) {
            if (t == test)
                t.setSampleList(sample);
        }
    }

    public List<Test> getRegisteredTests () {
        return this.getTests(Constants.REGISTERED);
    }

    public List<Test> getTests (String state) {
        if(this.testlist!=null) {
            if (this.testlist.isEmpty()) {
                throw new IllegalArgumentException("Test list is empty.");
            }
            List<Test> temp = new ArrayList<>();
            for (Test t : this.testlist) {
                if (t.hasCondition(state)) {
                    temp.add(t);
                }
            }
            if (temp.isEmpty()) {
                System.out.println("There are no Tests under condition: " + state);
                return null;
            }
            return temp;
        }
        return null;
    }


    public Test getTestByCode( long code){

        for(Test t : this.testlist){
            if(t.getCode() == code)
                return t;
        }
        throw new IllegalArgumentException("Test with that code doesn't exist!");
    }

}
