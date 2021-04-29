package app.domain.model;

import java.util.ArrayList;

public class TestType extends SpecifyNewTypeTestStore{

    private String code;
    private String description;
    private String collectingMethod;
    private ArrayList<Category> categoryList;

    public TestType(String code, String description,String collectingMethod){
        this.code = code;
        this.description = description;
        this.collectingMethod = collectingMethod;
        categoryList = new ArrayList<Category>();
    }


    private void checkMethod(String collectingMethod){
        if(collectingMethod.length() == 0)
            throw new IllegalArgumentException("Test type must at least have one collecting method");
    }

    private void checkCode(String code){
        if(code.length() == 0 || code.length() != 5 )
            throw new IllegalArgumentException("Code doesn't exist or doesn't have 5 alphanumeric numbers");
    }

    private void checkDescription(String description){
        if(description.length() > 15 || description.length() == 0)
            throw new IllegalArgumentException("Description doesn't exist or surpasses the 15 characters rule!");
    }

    private void checkCollectingMethod(String collectingMethod){
        if(collectingMethod.length() > 20 || collectingMethod.length() == 0)
            throw new IllegalArgumentException("Collecting Method doesn't exist or surpasses the 20 characters rule!");
    }
    public void setCateory(Category category){
        categoryList.add(category);
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getCollectingMethod() {
        return collectingMethod;
    }
}
