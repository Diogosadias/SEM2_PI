package app.domain.model;

import app.domain.shared.Constants;

import java.util.ArrayList;
import java.util.List;


public class Test {
    private String sampleTime;
    public String sampleDate;
    private String timeValidation;
    private String dateValidation;
    private String timeDiagnosis;
    private String dateDiagnosis;
    private String timeChemical;
    public String dateChemical;
    private String parameterValue;

    private List<Sample> sampleList;

    private Client client;
    private String nhsCode;
    private String description;
    private TestType type;
    private long code;
    private List<Parameter> listParameters;
    private String state;


    public Test (TestType type, String description,Client client) {
        checkTypeAttribute(type);
        checkDescriptionAttribute(description);
        checkClientAttribute(client);

        this.type = type;
        this.description = description.trim();
        this.client = client;
        this.state = Constants.REGISTERED;
        listParameters = new ArrayList<>();
    }

    private void checkTypeAttribute (TestType type) {
        if(type == null) {
            throw new IllegalArgumentException("Creating Test Error: Test type is null.");
        }
    }
    private void checkDescriptionAttribute (String description) {
        if(description.trim().length() == 0) {
            throw new IllegalArgumentException("Creating Test Error: Description is empty.");
        }
    }
    private void checkClientAttribute (Client client) {
        if(client == null) {
            throw new IllegalArgumentException("Creating Test Error: Client is null.");
        }
    }

    public long getCode() {
        return this.code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public void setTestType(TestType type) {
        this.type = type;
    }

    public TestType getTestType() {
        return this.type;
    }

    public List<Parameter> getListParameters() {
        return this.listParameters;
    }

    public void addParameter(Parameter parameter) {
        listParameters.add(parameter);
    }


    public boolean getInformation(Test test){
        if(test!=null){
            //print information

        }
        return false;
    }

    public boolean checkChemicalDate(Test test){
        if(dateChemical==null){
            return false;
        }
        return true;
    }

    public boolean checkSampleDate(Test test){
        if(sampleDate == null){
            return false;
        }
        return true;
    }

    public boolean checkCompleted(){
        if(true){
            return true;
        }
        return false;
    }

    public Client getClient() {
        return client;
    }

    public String getDescription() {
        return description;
    }

    public String getNhsCode() {
        return this.nhsCode;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSampleList(Sample sample){
        this.sampleList.add(sample);
    }

    public void setNhsCode(String nhsCode) {
        checkNhsCodeAttribute(nhsCode);
        this.nhsCode = nhsCode;
    }

    private void checkNhsCodeAttribute (String nhsCode) {
        int count = 0;
        for(int i = 0; i < nhsCode.length(); i++) {
            if(nhsCode.charAt(i) != ' ')
                count++;
        }
        if(count != 12) {
            throw new IllegalArgumentException("Adding NhsCode to Test Error: NhsCode needs 12 alphanumeric characters.");
        }
    }

    public boolean hasCondition(String state) {
        return this.state.equals(state);
    }

    @Override
    public String toString() {
        String s =  "\n --- Many Labs Test --- " +
                "\nClient CC: " + this.client.getCitizenCard() +
                "\nType of Test: " + this.type.getDescription() +
                "\nCollection Method: " + this.description+
                "\nNhs Code: " + this.nhsCode +
                "\n\nList of Parameters to be measured: ";
        for (Parameter p : this.getListParameters()) {
            s = s + "\n - " + p.getName();
        }
        return s;
    }

}
