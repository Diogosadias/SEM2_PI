package app.domain.model;

import app.domain.dto.*;
import app.domain.shared.Constants;

import java.util.ArrayList;
import java.util.List;


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
        this.client = company.getCreateClientStore().getClientByCC(cc);
        return (client != null) ;
    }

    public List getListTestType() {
        TestTypeStore store = this.company.getTestTypeStore();
        TestTypeMapper mapper = new TestTypeMapper();
        return mapper.toDto(store.getTestTypeList());
    }

    public List getListParameters(String category) {
        ParameterStore store = this.company.getParameterStore();
        ParameterMapper mapper = new ParameterMapper();
        return mapper.toDto(store.getParameterList(),category);
    }

    public void newTest(String code) {
        TestType type = this.company.getTestTypeStore().getTestTypeByCode(code);
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

    public boolean addParameterToTest(String code) {
        List<Parameter> list = this.test.getListParameters();
        Parameter parameter = this.company.getParameterStore().getParameterByCode(code);
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
            if (t.getClient().equals(this.test.getClient()) && t.getTestType().equals(this.test.getTestType()) && t.getListParameters().equals(this.test.getListParameters())) {
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
            throw new IllegalArgumentException("Test already exists.");
        }
    }

    public boolean addTest(Test test){
        if(this.testlist.contains(test)) {
            throw new IllegalArgumentException("Test is already registered.");
        }
        return this.testlist.add(test);
    }

    public boolean getTest(Test test) {
        if (checkCompleted(test))
            return true;
        return false;
    }

    public boolean checkCompleted(Test test) {
        return test.checkCompleted();
    }

    public TestDto getTestCompletedList() {
        TestDto list = new TestDto();

        for (Test temp : testlist) {
            if (getTest(temp)) list.addTest(temp);
        }
        return list;
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



}
