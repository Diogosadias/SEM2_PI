package app.domain.model;

import java.util.ArrayList;
import java.util.List;

/**
 * ParameterStore - Class responsible for managing Parameters.
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */

public class ParameterStore extends Store{

    /**
     * The Parameter.
     */
    private Parameter parameter;
    /**
     * parameterList - List containing the Parameters
     */
    private final List<Parameter> parameterList;

    /**
     * Constructor for the store, initializes the array.
     */
    public ParameterStore(){
        this.parameterList = new ArrayList<>();
    }

    /**
     * Method for creating a Parameter
     * @param code - Parameter Code
     * @param name - Parameter Name
     * @param description - Parameter Description
     * @param category - Parameter Category
     * @return Parameter
     */

    public Parameter createParameter(String code, String name, String description, String category){
        if (code == null && name == null && description == null && category == null) return null;
        this.parameter = new Parameter(code, name, description,category);
        return parameter;
    }

    /**
     * Method for deleting a parameter.
     * @param code - Code of the parameter to be deleted
     * @return true/false
     */

    public boolean deleteParameter(String code){
        Parameter param = getParameterByCode(code);
        if(parameterList.contains(param)) {
            parameterList.remove(param);
            return true;
        }
        else{
                return false;
        }
    }

    /**
     * Method for getting a parameter by code.
     * @param code - Parameter Code
     * @return Parameter Category/null
     */

    public Parameter getParameterByCode(String code){
        for( Parameter f : parameterList){
            if(code.equals(f.getCode()))
                return f;
        }
        return null;
    }

    /**
     * Method for parameter validation.
     * @param p - Parameter
     * @return true/false
     */

    public boolean validateParameter(Parameter p){
        if(p!=null) {
            for (Parameter param: this.parameterList) {
                    if(p.getCode().equals(param.getCode())){
                        System.out.println("This code is already being used!");
                        return false;
                    }
                    if(p.getDescription()==param.getDescription()){
                        System.out.println("This description card is already being used!");
                        return false;
                    }
                    if(p.getName()==param.getName()){
                        System.out.println("This name is already being used!");
                        return false;
                    }
            }


            return ! this.parameterList.contains(p);
        }
        return false;
    }

    /**
     * Method for saving a parameter
     * @param p - Parameter
     * @return true/false
     */

    public boolean saveParameter(Parameter p){
        if(!validateParameter(p))
            return false;
        return this.parameterList.add(p);
    }

    /**
     * Add a Parameter.
     *
     * @param parameter - Parameter
     *
     * @return boolean
     */

    public boolean addParameter(Parameter parameter) {
        if(this.parameterList.contains(parameter)) {
            throw new IllegalArgumentException("Parameter already exists.");
        }
        this.parameter = parameter;
        return this.saveParameter(this.parameter);
    }

    /**
     * Method for getting the parameter list.
     * @return parameterList
     */

    public List<Parameter> getParameterList() {
        return parameterList;
    }

    /**
     * Return the textual description of the parameter.
     *
     * @return Parameter's features
     */

    @Override
    public String toString() {
        List<Parameter> copy = new ArrayList<>(parameterList);
        StringBuilder s = new StringBuilder();
        if(parameterList.isEmpty()){
            System.out.println("There are no parameter categories created.");
        }else {
            for (Parameter param : copy) {
                s.append(param);
                s.append("\n");
            }
        }
        return s.toString();
    }

    /**
     * Return the List's store.
     *
     * @return List
     */

    @Override
    public List getListObjects() {
        //Change list of objects in Store to a List Object
        List<Object> list = new ArrayList<>();
        for(Parameter p: parameterList) {
            list.add(p);
        }
        return list;
    }

    /**
     * Get the name of the file.
     *
     * @return File's name
     */

    @Override
    public String getFileName() {
        // Path - "Folder: ser" / "File Name: this store's object class" "Suffix: .txt"
        return "ser/parameter.txt";
    }

    /**
     * Read Object from File and import as this store's object class.
     *
     * @param o Object
     */

    @Override
    public void importObject(Object o) {
        // Read Object from File and import as this store's object class
        this.parameter = (Parameter) o;
        this.saveParameter(parameter);
    }
}
