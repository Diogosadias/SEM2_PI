package app.controller;

import app.domain.model.Company;
import app.domain.model.ParameterCategory;
import app.domain.model.TestTypeStore;
import app.domain.model.TestType;

/**
 *  Controller for the US9 realization - Register a new Test Type
 *
 * @author Bruno Pereira <1191454@isep.ipp.pt>
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */
public class SpecifyNewTestTypeController {

    private Company company;
    private TestType tt;
    private TestTypeStore ts;

    /**
     * Constructor for a given Company instance.
     */
    public SpecifyNewTestTypeController(){
        this.company = App.getInstance().getCompany();
        this.ts = this.company.getTestTypeStore();
        this.tt = new TestType();
    }

    /**
     * Creates a Test Type instance and validate.
     *
     * @param code TestType's code
     * @param description TestType's description
     * @param collectingMethods TestType's collecting method
     *
     * @return true or false
     */
    public boolean createTestType(String code, String description, String collectingMethods){
        this.tt = this.ts.createTestType(code, description, collectingMethods);
        if(this.ts.validateTestType(tt)){
            saveTestType();
            return true;
        }
        else
            return false;
    }

    /**
     * Show Test Type by the code.
     */
    public void writeTestTypeByCode(String code) {
        for( TestType f : ts.getTestTypeList()){
            if(code.equals(f.getCode()))
                System.out.println(f);
        }
    }

    /**
     * Write a Test Type.
     */
    public void writeTestType(){

        for(TestType t : ts.getTestTypeList())
            System.out.println(t); }

    /**
     * Delete an existing Test Type.
     *
     * @return boolean
     */
    public boolean deleteTestType(String code){
        if(ts.deleteTestType(code)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Search Test Type.
     *
     * @return boolean
     */
    public boolean searchTestType (String code) {
        if(ts.searchTestType(code)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Saves the new Test Type instance.
     *
     * @return boolean
     */
    public boolean saveTestType(){
        return this.ts.saveTestType(tt);
    }

    /**
     * Add parameter category to the new Test Type instance.
     */
    public void addParameterToTest(ParameterCategory pc){
        this.tt.setCategory(pc);
    }
}