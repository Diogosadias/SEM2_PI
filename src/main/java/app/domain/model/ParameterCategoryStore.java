package app.domain.model;
import app.domain.model.ParameterCategory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ParameterCategoryStore - Class responsible for managing ParameterCategories.
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Tiago Ferreira <1200601@isep.ipp.pt>
 */
public class ParameterCategoryStore {

    /**
     * parameterCategoryList - List containing Parameter Categories
     */
    private List<ParameterCategory> parameterCategoryList = new ArrayList<>();

    /**
     * Method for creating a Parameter Category.
     * @param code - Parameter Category Code
     * @param description - Parameter Category Description
     * @param nhsId - Parameter Category's NHS ID
     * @return Parameter Category/null
     */
    public ParameterCategory createParameterCategory(String code, String description, String nhsId){
        if (code == null && description == null && nhsId == null) return null;
        return new ParameterCategory(code, description, nhsId);
    }

    /**
     * Method for getting a Parameter Category by it's code.
     * @param code - Parameter Category Code
     * @return Parameter Category/null
     */
    public ParameterCategory getParameterCategoryByCode(String code){
        for( ParameterCategory f : parameterCategoryList){
            if(code.equals(f.getCode()))
                return f;
        }
        return null;
    }

    /**
     * Method for validating the Parameter Category.
     * @param pc - Parameter Category
     * @return true/false
     */
    public boolean validateParameterCategory(ParameterCategory pc){
        if(pc == null)
            return false;
        return ! this.parameterCategoryList.contains(pc);
    }

    /**
     * Method for saving a Parameter Category.
     * @param pc - Parameter Category
     * @return true/false
     */
    public boolean saveParameterCategory(ParameterCategory pc){
        if(!validateParameterCategory(pc))
            return false;
        return this.parameterCategoryList.add(pc);
    }

    /**
     * Method for getting the Parameter Category List.
     * @return parameterCategoryList
     */
    public List<ParameterCategory> getParameterCategoryList() {
        return parameterCategoryList;
    }

    public boolean addParameterCategory(ParameterCategory category) {
        if(this.parameterCategoryList.contains(category)) {
            throw new IllegalArgumentException("Parameter Category already exists.");
        }
        return this.parameterCategoryList.add(category);
    }

    /**
     * Return the textual description of the parameter category.
     *
     * @return ParameterCategory's features
     */
    @Override
    public String toString() {

        List<ParameterCategory> copia = new ArrayList<>(parameterCategoryList);


        StringBuilder s = new StringBuilder();
        if(parameterCategoryList.isEmpty()){
            System.out.println("There are no parameter categories created.");
        }else {
            for (ParameterCategory param : copia) {
                s.append(param);
                s.append("\n");
            }
        }
        return s.toString();
    }
}