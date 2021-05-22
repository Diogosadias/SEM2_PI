package app.controller;

import app.domain.model.*;
import app.domain.model.stores.ParameterCategoryStore;

/**
 * Controller for the US11 realization - Register a new Parameter Category
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Tiago Ferreira <1200601@isep.ipp.pt>
 */
public class ParameterCategoryController {


    private Company company;
    private ParameterCategory pc;
    private ParameterCategoryStore parametercategoryStore;
    private ParameterCategoryStore pcs;

    /**
     *  Public empty constructor
     */
    public ParameterCategoryController(){
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor for a given Company instance
     * @param company
     */
    public ParameterCategoryController(Company company){
        this.company = company;
        this.pc = null;
        this.pcs = company.getParameterCategoryStore();
    }

    /**
     * Create a new Parameter Category and validates it.
     *
     * @param code ParameterCategory's code
     * @param description ParameterCategory's description
     * @param nhsid ParameterCategory's nhsid
     *
     * @return boolean
     */
    public boolean createParameterCategory(String code, String description, String nhsid){


        this.pc = this.pcs.createParameterCategory(code,description,nhsid);
        if(this.pcs.validateParameterCategory(pc)){
            pcs.saveParameterCategory(pc);
            return true;
        }
        else {
            return false;
        }

    }

    /**
     * Write the Parameter Category.
     */
    public void writeParameterCategories(){
        System.out.println(pcs.toString());

    }

    /**
     * Return the Parameter Category instance.
     *
     * @param code ParameterCategory's code
     *
     * @return ParameterCategory's code
     */
    public ParameterCategory getParameterCategory(String code){

        for(ParameterCategory f : pcs.getParameterCategoryList()){
            if(f.getCode().equals(code))
                return f;
        }
        return null;
    }

    /**
     * Saves the new Parameter Category instance.
     *
     * @return boolean
     */
    public boolean saveParameterCategory(){
        return this.parametercategoryStore.saveParameterCategory(pc);
    }
}
