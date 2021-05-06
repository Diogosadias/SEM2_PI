package app.domain.model;

import java.util.ArrayList;

public class TestType extends SpecifyNewTestStore {

    private String code;
    private String description;
    private String collectingMethod;
    private ArrayList<ParameterCategoryStore> parameterList;

    public TestType(String code, String description, String collectingMethod) {
        try {
            checkCode(code);
        } catch (Exception e) {
            e.printStackTrace();
            String message = e.getMessage();
            System.out.println(message);
        }
        checkDescription(description);
        checkCollectingMethod(collectingMethod);
        this.code = code;
        this.description = description;
        this.collectingMethod = collectingMethod;
        parameterList = new ArrayList<ParameterCategoryStore>();
    }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getCollectingMethod() { return collectingMethod; }

    public void setCollectingMethod(String collectingMethod) { this.collectingMethod = collectingMethod; }

    private void checkCode(String code) {
        if(code.length() != 5 )
            throw new IllegalArgumentException("Code doesn't exist or doesn't have 5 alphanumeric numbers");
    }

    private void checkDescription(String description) {
        if(description.length() > 15 || description.length() == 0)
            throw new IllegalArgumentException("Description doesn't exist or surpasses the 15 characters rule!");
    }

    private void checkCollectingMethod(String collectingMethod) {
        if(collectingMethod.length() > 20 || collectingMethod.length() == 0)
            throw new IllegalArgumentException("Collecting Method doesn't exist or surpasses the 20 characters rule!");
    }
    public void setCategory(ParameterCategoryStore parameter){
        parameterList.add(parameter);
    }


    @Override
    public String toString() {
        return "TestType{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", collectingMethod='" + collectingMethod + '\'' +
                ", parameterList=" + parameterList +
                '}';
    }
}