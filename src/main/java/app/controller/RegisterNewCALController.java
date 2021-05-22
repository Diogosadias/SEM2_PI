package app.controller;

import app.domain.model.*;
import app.domain.model.CALStore;

/**
 *  Controller for the US8 realization - Register a new CAL
 *
 * @author Gil <1180838@isep.ipp.pt>
 */
public class RegisterNewCALController {

    private Company company;
    private CAL cal;
    private CALStore calStore;

    /**
     *  Public empty constructor
     */
    public RegisterNewCALController(){
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor for a given Company instance
     * @param company
     */
    public RegisterNewCALController(Company company){
        this.company = company;
        this.calStore = company.getCalStore();
    }

    /**
     * Creates a CAL instance and validates it.
     *
     * @param labId Laboratory's id
     * @param labName Laboratory's name
     * @param phoneNumber Laboratory's phone number
     * @param address Laboratory's address
     * @param tin Laboratory's tin number
     * @param answer Laboratory's answer
     *
     * @return boolean
     */
    public boolean registerNewCAL(String labId, String labName, long phoneNumber, String address, long tin, boolean answer){
        cal = calStore.registerNewCAL(labId, labName, phoneNumber, address, tin, answer);
        return calStore.validateCAL(cal);
    }

    /**
     * Saves the new CAL instance.
     * @return boolean
     */
    public boolean saveCAL(){
        return this.calStore.saveCAL(cal);
    }
}
