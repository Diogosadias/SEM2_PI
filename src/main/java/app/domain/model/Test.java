package app.domain.model;



import app.domain.shared.Constants;
import app.domain.shared.ExternalModule;
import com.example2.EMRefValue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 */
public class Test {

    private String state;
    private Client client;
    private String nhsCode;
    private String description;
    private TestType type;
    private String code;
    private final List<Parameter> listParameters;
    private final List<ParameterCategory> listCategories;
    private TestParameter testParam;
    private final List<TestParameter> listTestParameter;
    private final List<Sample> sampleList = new ArrayList<>();
    private Date dateRegistered;
    private Date dateChemical;
    private Date dateDiagnosis;
    private Date dateValidation;

    public Test (TestType type, String description,Client client) {
        checkTypeAttribute(type);
        checkDescriptionAttribute(description);
        checkClientAttribute(client);

        this.type = type;
        this.description = description.trim();
        this.client = client;

        this.listParameters = new ArrayList<>();
        this.listCategories = new ArrayList<>();
        this.listTestParameter = new ArrayList<>();
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
    public void setNhsCode(String nhsCode) {
        checkNhsCodeAttribute(nhsCode);
        this.nhsCode = nhsCode;
        this.state = Constants.REGISTERED;
        this.dateRegistered = new Date(System.currentTimeMillis());
    }

    public Parameter getParameterByCode(String code) {
        for (Parameter p : listParameters) {
            if (p.getCode().equals(code)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Test: No Parameter with that Code.");
    }

    public void addTestResult (String code, String result, double metric) {
        TestType testType = this.getTestType();
        Parameter param = this.getParameterByCode(code);
        this.testParam = new TestParameter(param);
        ExternalModule em = testType.getExternalModule();
        EMRefValue refValue = em.getEMRefValue(this.description,param);
        this.testParam.addResult(result,metric,refValue);
    }

    public boolean addResultToList () {
        if (!listTestParameter.isEmpty() && listTestParameter.contains(this.testParam) ) {
            return false;
        }
        this.state = Constants.SAMPLE_ANALYSED;
        this.dateChemical = new Date(System.currentTimeMillis());
        return this.listTestParameter.add(this.testParam);
    }

    public List getListTestParameter() {return this.listTestParameter;}

    public TestParameter getCurrentTestParameter () {
        return this.testParam;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        if (code == null || code.equals("")) {
            throw new IllegalArgumentException("Error: Code is null.");
        }
        this.code = code;
    }

    public void setTestType(TestType type) {
        this.type = type;
    }

    public TestType getTestType() {
        return this.type;
    }

    public List<Parameter> getListParameters() {
        if (listParameters.isEmpty()) {
            throw new IllegalArgumentException("Test: List Parameter is empty.");
        }
        return this.listParameters;
    }

    public List<ParameterCategory> getListCategories() {
        if (listCategories.isEmpty()) {
            throw new IllegalArgumentException("Test: List ParameterCategory is empty.");
        }
        return this.listCategories;
    }

    public boolean addParameter(Parameter parameter) {
        if (listParameters.contains(parameter)) {
            System.out.println("Test: Parameter already exists.");
            return false;
        }
        return listParameters.add(parameter);
    }

    public void addCategory(ParameterCategory category) {
        if (listCategories.contains(category)) {
            throw new IllegalArgumentException("Test: ParameterCategory already exists.");
        }
        listCategories.add(category);
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

    public boolean addSample(Sample sample){
        if(!this.sampleList.isEmpty() && this.sampleList.contains(sample)) {
            return false;
        }
        this.state = Constants.SAMPLE_COLLECTED;
        return (this.sampleList.add(sample));
    }

    public List getListSamples() {
        return this.sampleList;
    }

    public boolean hasCondition(String state) {
        return this.state.equals(state);
    }

    public boolean testDiagnosisCompleted () {
        this.state = Constants.DIAGNOSIS_MADE;
        this.dateDiagnosis = new Date(System.currentTimeMillis());
        return true;
    }

    public Date getDateRegistered() {
        return this.dateRegistered;
    }

    public Date getDateChemicalAnalysis() {
        return this.dateChemical;
    }

    public Date getDateDiagnosis() {
        return this.dateDiagnosis;
    }

    public Date getDateValidation() {
        return this.dateValidation;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public String Parameters_toString() {
        String s = "\n\nList of Parameter(s) for each Category to be analysed: ";
        for (ParameterCategory category : this.getListCategories()) {
            s = s + "\n\n - " + category.getDescription();
            for (Parameter parameter : this.getListParameters()) {
                if (parameter.getCategory().equals(category.getCode()))
                {
                    s += "\n" + parameter.getName();
                }
            }
        }
        return s;
    }
    

    @Override
    public String toString() {
        String s =  "\n --- Many Labs Test --- " +
                "\nTest n: " + this.code +
                "\nClient CC: " + this.client.getCitizenCard() +
                "\nType of Test: " + this.type.getDescription() +
                "\nCollection Method: " + this.description+
                "\nNhs Code: " + this.nhsCode +
                "\nRegistration date: " + Constants.FORMATTER.format(this.dateRegistered) +
                "\n\nList of Parameter(s) for each Category to be analysed: ";
        for (ParameterCategory category : this.getListCategories()) {
            s = s + "\n\n - " + category.getDescription();
            for (Parameter parameter : this.getListParameters()) {
                if (parameter.getCategory().equals(category.getCode()))
                {
                    s = s + "\n" + parameter.getName();
                }
            }
        }
        return s;
    }

}
