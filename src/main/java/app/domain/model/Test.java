package app.domain.model;

import app.controller.App;
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
    private String parameterValue;
    private List<Sample> sampleList = new ArrayList<>();


    private Client client;
    private String nhsCode;
    private String description;
    private TestType type;
    private String code;
    private List<Parameter> listParameters;
    private List<ParameterCategory> listCategories;
    private String state;

    
    public Test (TestType type, String description,Client client) {
        checkTypeAttribute(type);
        checkDescriptionAttribute(description);
        checkClientAttribute(client);

        this.type = type;
        this.description = description.trim();
        this.client = client;
        this.state = Constants.REGISTERED;
        this.listParameters = new ArrayList<>();
        this.listCategories = new ArrayList<>();
    }

    public boolean addTestResult(String parameterCode, String code, String metric){


        return true;
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

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        if (code == null) {
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

    public void addSample(Sample sample){
        this.sampleList.add(sample);
    }

    public boolean hasCondition(String state) {
        return this.state.equals(state);
    }


    @Override
    public String toString() {
        String s =  "\n --- Many Labs Test --- " +
                "\nTest n: " + this.code +
                "\nClient CC: " + this.client.getCitizenCard() +
                "\nType of Test: " + this.type.getDescription() +
                "\nCollection Method: " + this.description+
                "\nNhs Code: " + this.nhsCode +
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

    public String toStringParameters() {
        String s = "\n\nList of Parameter(s) for each Category to be analysed: ";
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
