package app.domain.model;

import app.domain.shared.Constants;
import app.domain.shared.ExternalModule;
import com.example2.EMRefValue;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

/**
 * This domain class allows to build an instance of test.
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 * @author Tiago Ferreira <1200601@isep.ipp.pt>
 */

public class Test {

    /**
     * The state of test.
     */
    private String state;

    /**
     * The client of test.
     */
    private Client client;

    /**
     * The nhsCode of test.
     */
    private String nhsCode;

    /**
     * The description of test.
     */
    private String description;

    /**
     * The TestType of test.
     */
    private TestType type;

    /**
     * The code of test.
     */
    private String code;

    /**
     * parameterList - Contains the parameter
     */
    private final List<Parameter> listParameters;

    /**
     * ParameterCategoryList - Contains the parameter categories
     */
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

    /**
     * Check if the type attribute it's within the rules.
     *
     * @param type - TestType
     */
    private void checkTypeAttribute (TestType type) {
        if(type == null) {
            throw new IllegalArgumentException("Creating Test Error: Test type is null.");
        }
    }

    /**
     * Check if the description attribute it's within the rules.
     *
     * @param description - TestType's description
     */
    private void checkDescriptionAttribute (String description) {
        if(description.trim().length() == 0) {
            throw new IllegalArgumentException("Creating Test Error: Description is empty.");
        }
    }

    /**
     * Check if the client attribute it's within the rules.
     *
     * @param client - TestType's client
     */
    private void checkClientAttribute (Client client) {
        if(client == null) {
            throw new IllegalArgumentException("Creating Test Error: Client is null.");
        }
    }

    /**
     * Check if the nhsCode attribute it's within the rules.
     *
     * @param nhsCode - TestType's nhsCode
     */
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

    /**
     * Change the test's nhsCode.
     *
     * @param nhsCode test's nhsCode
     */
    public void setNhsCode(String nhsCode) {
        checkNhsCodeAttribute(nhsCode);
        this.nhsCode = nhsCode;
        this.state = Constants.REGISTERED;
        this.dateRegistered = new Date(System.currentTimeMillis());
    }

    /**
     * Return the parameter's code.
     *
     * @param code parameter's code
     */
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

    /**
     * Method for getting the available test parameter.
     *
     * @return List<TestType>
     */
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

    /**
     * Change the test's code.
     *
     * @param code test's code
     */
    public void setCode(String code) {
        if (code == null || code.equals("")) {
            throw new IllegalArgumentException("Error: Code is null.");
        }
        this.code = code;
    }

    /**
     * Change the test's TestType.
     *
     * @param type test's TestType
     */
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

    /**
     * Change the test's client.
     *
     * @param client test's client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Change the test's description.
     *
     * @param description test's description
     */
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

    /**
     * Return the textual description of the parameter.
     *
     * @return parameter's features
     */
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

    /**
     * Return the textual description of the test.
     *
     * @return test's features
     */
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
