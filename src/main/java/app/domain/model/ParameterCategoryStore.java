package app.domain.model;

import java.util.ArrayList;
import java.util.List;

/**
 * ParameterCategoryStore - Class responsible for managing ParameterCategories.
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Tiago Ferreira <1200601@isep.ipp.pt>
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */

public class ParameterCategoryStore extends Store{

    private ParameterCategory category;

    /**
     * parameterCategoryList - List containing Parameter Categories
     */
    private final List<ParameterCategory> parameterCategoryList = new ArrayList<>();

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

    public ParameterCategory getParameterCategoryByDescription(String description){
        for( ParameterCategory f : parameterCategoryList){
            if(description.equals(f.getDescription()))
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

    /**
     * Add a Parameter Category.
     *
     * @param category - Parameter Category
     *
     * @return boolean
     */

    public boolean addParameterCategory(ParameterCategory category) {
        if(this.parameterCategoryList.contains(category)) {
            throw new IllegalArgumentException("Parameter Category already exists.");
        }
        this.category = category;
        return this.parameterCategoryList.add(this.category);
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

    @Override
    public List getListObjects() {
        //Change list of objects in Store to a List Object
        List<Object> list = new ArrayList<>();
        for(ParameterCategory c: parameterCategoryList) {
            list.add(c);
        }
        return list;
    }

    @Override
    public String getFileName() {
        // Path - "Folder: ser" / "File Name: this store's object class" "Suffix: .txt"
        return "ser/parametercategory.txt";
    }

    @Override
    public void importObject(Object o) {
        // Read Object from File and import as this store's object class
        this.category = (ParameterCategory) o;
        this.saveParameterCategory(category);
    }
}