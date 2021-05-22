package app.domain.model;

import app.domain.shared.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 */
public class Test {
    
    public String sampleDate;
    private String dateValidation;
    private String dateDiagnosis;
    public String dateChemical;
    private String description;
    private String NHSCode;
    private String parameterValue;
    private Client client;
    private List<Sample> sampleList = new ArrayList<>();
    private TestType type;
    private long code;
    private List<Parameter> listParameters = new ArrayList<>();
    private String state;

    /**
     *
     * @param type
     * @param description
     * @param client
     */
    public Test(TestType type, String description, Client client){
        checkTypeAttribute(type);
        checkDescriptionAttribute(description);
        checkClientAttribute(client);
        
        this.type = type;
        this.description = description.trim();
        this.client = client;
        this.state = Constants.REGISTERED;
        this.listParameters = new ArrayList();
    }
    
    /**
     *
     * @param sampleDate
     * @param dateValidation
     * @param dateDiagnosis
     * @param dateChemical
     * @param description
     * @param NHSCode
     * @param parameterValue
     * @param client
     * @param sampleList
     */
    public Test(String sampleDate, String dateValidation, String dateDiagnosis, String dateChemical, String description, String NHSCode, String parameterValue, Client client, List<Sample> sampleList) {
        
        checkChemicalDate(dateChemical);
        checkSampleDate(sampleDate);
        checkDescriptionAttribute(description);
        checkClientAttribute(client);
        checkNhsCodeAttribute(NHSCode);
                       
        this.sampleDate = sampleDate;
        this.dateValidation = dateValidation;
        this.dateDiagnosis = dateDiagnosis;
        this.dateChemical = dateChemical;
        this.description = description;
        this.NHSCode = NHSCode;
        this.parameterValue = parameterValue;
        this.client = client;
        this.sampleList = sampleList;
    }

    /**
     *
     */
    public Test() {
    }

    public void setNhsCode(String nhsCode) {
        checkNhsCodeAttribute(nhsCode);
        this.NHSCode = nhsCode;
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

    public boolean checkChemicalDate(String dateChemical){
        if(dateChemical==null){
            return false;
        }
        return true;
    }

    public boolean checkSampleDate(String sampleDate){
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
        return this.NHSCode;
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

    public boolean hasCondition(String state) {
        return this.state.equals(state);
    }

    public String getSampleDate() {
        return sampleDate;
    }

    public String getDateValidation() {
        return dateValidation;
    }

    public String getDateDiagnosis() {
        return dateDiagnosis;
    }

    public String getDateChemical() {
        return dateChemical;
    }

    public String getNHSCode() {
        return NHSCode;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public List<Sample> getSampleList() {
        return sampleList;
    }

    public TestType getType() {
        return type;
    }

    public String getState() {
        return state;
    }
    
    

    @Override
    public String toString() {
        String s =  "\n --- Many Labs Test --- " +
                "\nClient CC: " + this.client.getCitizenCard() +
                "\nType of Test: " + this.type.getDescription() +
                "\nCollection Method: " + this.description+
                "\nNhs Code: " + this.NHSCode +
                "\n\nList of Parameters to be measured: ";
        for (Parameter p : this.getListParameters()) {
            s = s + "\n - " + p.getName();
        }
        return s;
    }

}
