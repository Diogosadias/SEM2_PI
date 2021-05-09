package app.controller;

import app.domain.model.*;

/**
 * Controller for the US10 realization - Register a new Parameter and categorize it
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class ParameterController {

    private Company company;
    private Parameter p;
    private ParameterStore ps;

    /**
     *  Public empty constructor
     */
    public ParameterController(){
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor for a given Company instance
     * @param company
     */
    public ParameterController(Company company){
        this.company = company;
        this.p = null;
        this.ps = company.getParameterStore();
    }

    /**
     * Create a new Parameter and validates it.
     *
     * @param code Parameter's code
     * @param name Parameter's name
     * @param description Parameter's description
     * @param category Parameter's category
     *
     * @return boolean
     */
    public boolean createParameter(String code, String name, String description, String category){


        this.p = this.ps.createParameter(code,name,description,category);
        if(this.ps.validateParameter(p)){
            ps.saveParameter(p);
            return true;
        }
        else {
            return false;
        }

    }

    /**
     * Delete an existing Parameter.
     *
     * @return boolean
     */
    public boolean deleteParameter(String code){
        if(ps.deleteParameter(code)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Write the Parameter instance.
     */
    public void writeParameters(){
        System.out.println(ps.toString());

    }

    /**
     * Return the Parameter instance.
     *
     * @param code Parameter's code
     *
     * @return Parameter's code or null
     */
    public Parameter getParameter(String code){
        Parameter x = ps.getParameterByCode(code);
        if(x==null)
            return null;
        else
            return x;
    }

    /**
     * Saves the new Parameter instance.
     *
     * @return boolean
     */
    public boolean saveParameter(){
        return this.ps.saveParameter(p);
    }

}
