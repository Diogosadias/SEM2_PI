package app.domain.model;

import java.util.List;

public class LabOrder {

    private Client client;
    private List<Parameter> listParameters;
    private String testType;

    public LabOrder () {

    }

    public Client getClient () {
        return client;
    }

    public List<Parameter> getListParameters() {
        return listParameters;
    }

    public String getTestType() {
        return testType;
    }
}
