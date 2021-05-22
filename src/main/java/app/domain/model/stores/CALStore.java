package app.domain.model.stores;
import app.domain.model.CAL;

import java.util.ArrayList;
/**
 * CALStore - Class responsible for managing CALs
 *
 * @author Gil <1180838@isep.ipp.pt>
 */
public class CALStore {
    private  ArrayList<CAL> calList;

    /**
     * Create Store instance with empty array.
     */
    public CALStore(){
        calList = new ArrayList<>();
    }

    /**
     * Creates a CAL instance and returns it.
     *
     * @param labId - Laboratory Id
     * @param labName - Laboratory Name
     * @param phoneNumber - Laboratory Phone Number
     * @param address - Laboratory address
     * @param tin - Laboratory TIN
     * @param answer - Answer if Laboratory performs Covid-19 tests
     *
     * @return CAL
     */

    public CAL registerNewCAL(String labId, String labName, long phoneNumber, String address, long tin, boolean answer ){
        if(labId==null || labName==null  || address==null  ){
            return null;
        }
        return new CAL(labId, labName, phoneNumber, address, tin, answer);
    }
    /**
     * Validates CAL attributes for business model rules.
     *
     * @param cal - Clinical Analysis Laboratory
     *
     * @return boolean
     */
    public boolean validateCAL(CAL cal){
        if(cal!=null) {
            if (!this.calList.isEmpty()) {
                for (CAL temp : calList) {
                    if (temp.equals(cal)) {
                        System.out.println("Employee already exists.");
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
    /**
     * Saves the new CAL.
     *
     * @param cal - Clinical Analysis Laboratory
     *
     * @return boolean
     */
    public boolean saveCAL(CAL cal){
        if(!validateCAL(cal))
            return false;
        return this.calList.add(cal);
    }
}
