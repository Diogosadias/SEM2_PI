package app.domain.model;

import java.util.ArrayList;

/**
 *
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */

public class TestType extends SpecifyNewTestStore {
    /**
     * code - 5 alphanumeric numbers and can´t be empty
     */
    private String code;
    /**
     * description - limited to 15 characters and can´t be empty
     */
    private String description;
    /**
     * collectingMethod - limited to 20 characters and can´t be empty
     */
    private String collectingMethod;
    /**
     * parameterList - Contains the parameter categories of the test type
     */
    private final ArrayList<ParameterCategory> parameterList = new ArrayList<ParameterCategory>();

    /**
     * Constructor for a test type.
     * @param code - Test Type Code
     * @param description - Test Type Description
     * @param collectingMethod - Test Type Collection Method
     */
    public TestType(String code, String description, String collectingMethod) {
        checkCode(code);
        checkDescription(description);
        checkCollectingMethod(collectingMethod);
        this.code = code;
        this.description = description;
        this.collectingMethod = collectingMethod;
    }

    public TestType() {
    }

    /**
     * Getters and setters for the attributes
     */
    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getCollectingMethod() { return collectingMethod; }

    public void setCollectingMethod(String collectingMethod) { this.collectingMethod = collectingMethod; }

    /**
     * Method for code validation.
     * @param code - Test Type Code
     * @throws IllegalArgumentException - Empty or not 5 characters.
     */
    private void checkCode(String code) {
        if(code.length() != 5 )
            throw new IllegalArgumentException("Code doesn't exist or doesn't have 5 alphanumeric numbers");
    }

    /**
     * Method for description validation.
     * @param description - Test Type Description
     * @throws IllegalArgumentException - Empty or 15+ characters.
     */
    private void checkDescription(String description) {
        if(description.length() > 15 || description.length() == 0)
            throw new IllegalArgumentException("Description doesn't exist or surpasses the 15 characters rule!");
    }

    /**
     * Method for the collectingMethod validation.
     * @param collectingMethod - Test Type Collection Method
     * @throws IllegalArgumentException - Empty or 20+ characters.
     */
    private void checkCollectingMethod(String collectingMethod) {
        if(collectingMethod.length() > 20 || collectingMethod.length() == 0)
            throw new IllegalArgumentException("Collecting Method doesn't exist or surpasses the 20 characters rule!");
    }
    /**
     * Method for setting a new parameter category for the test type.
     * @param parameter - Test Type Parameter Category
     */
    public void setCategory(ParameterCategory parameter){
        parameterList.add(parameter);
    }

    /**
     * Returns a summary of the test type data.
     * @return String
     */
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