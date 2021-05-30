package app.domain.model;

import app.domain.shared.Constants;
import app.domain.shared.ExternalModule;
import com.example2.EMRefValue;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 * @author Tiago Ferreira <1200601@isep.ipp.pt>
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
        EMRefValue refValue = em.getEMRefValue(this.type.getDescription(),param);
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

    public TestParameter getTestParameterByCode(String code) {
        for (TestParameter tp : listTestParameter) {
            if (tp.getParameter().getCode().equals(code)) {
                return tp;
            }
        }
        throw new IllegalArgumentException("Test: No Parameter with that Code.");
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
        return new ArrayList<>(this.listParameters);
    }

    public List<ParameterCategory> getListCategories() {
        if (listCategories.isEmpty()) {
            throw new IllegalArgumentException("Test: List ParameterCategory is empty.");
        }
        return new ArrayList<>(this.listCategories);
    }

    public boolean addParameter(Parameter parameter) {
        if (listParameters.contains(parameter)) {
            throw new IllegalArgumentException("Test: Parameter already exists.");
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

    public List<Sample> getListSamples() {
        return new ArrayList<>(this.sampleList);
    }

    public boolean hasCondition(String state) {
        return this.state.equals(state);
    }

    public boolean testDiagnosisCompleted () {
        this.state = Constants.DIAGNOSIS_MADE;
        this.dateDiagnosis = new Date(System.currentTimeMillis());
        return true;
    }

    public Date getDateRegistered() { return (this.dateRegistered == null) ? null : (Date) this.dateRegistered.clone();}

    public Date getDateChemicalAnalysis() { return (this.dateChemical == null) ? null :(Date) this.dateChemical.clone();}

    public Date getDateDiagnosis() {return (this.dateDiagnosis == null) ? null :(Date) this.dateDiagnosis.clone();}

    public Date getDateValidation() {return (this.dateValidation == null) ? null :(Date) this.dateValidation.clone();}

    public String parametersToString() {
        StringBuilder bld = new StringBuilder();
        bld.append("\n\nList of Parameter(s) for each Category to be analysed: ");
        for (ParameterCategory category : this.getListCategories()) {
            bld.append("\n\n - ").append(category.getDescription());
            for (Parameter parameter : this.getListParameters()) {
                if (parameter.getCategory().equals(category.getCode()))
                {
                    bld.append("\n").append(parameter.getName());
                }
            }
        }
        return bld.toString();
    }


    @Override
    public String toString() {
        StringBuilder bld = new StringBuilder();
        bld.append("\n --- Many Labs Test --- ")
                .append("\nTest n: ").append(this.code)
                .append("\nClient CC: ").append(this.client.getCitizenCard())
                .append("\nType of Test: ").append(this.type.getDescription())
                .append("\nCollection Method: ").append(this.description)
                .append("\nNhs Code: ").append(this.nhsCode)
                .append("\n\nList of Parameter(s) for each Category to be analysed: ");
        try {
            for (ParameterCategory category : this.getListCategories()) {
                bld.append("\n\n - ").append(category.getDescription());
                for (Parameter parameter : this.getListParameters()) {
                    if (parameter.getCategory().equals(category.getCode()))
                    {
                        bld.append("\n").append(parameter.getName());
                    }
                    if (state.equals(Constants.SAMPLE_ANALYSED))
                    {
                        bld.append("\n").append(this.getTestParameterByCode(parameter.getCode()).getResult());
                    }
                }
            }
            if (state.equals(Constants.SAMPLE_COLLECTED))
            {
                for (Sample sample : this.sampleList) {
                    bld.append("\n").append(sample.getSampleBarcode());
                }
            }
            bld.append("\n\nRegistration date: ").append(Constants.FORMATTER.format(this.dateRegistered));
            if (dateChemical != null)
            {
                bld.append("\nChemical Analysis date: ").append(Constants.FORMATTER.format(this.dateChemical));
            }
            if (dateDiagnosis != null)
            {
                bld.append("\nDiagnosis date: ").append(Constants.FORMATTER.format(this.dateDiagnosis));
            }
            if (dateValidation != null)
            {
                bld.append("\nValidation date: ").append(Constants.FORMATTER.format(this.dateValidation));
            }
        }catch (IllegalArgumentException ignored){}

        return bld.toString();
    }


}
