package app.domain.model;

import java.util.ArrayList;

/**
 * CALStore - Class responsible for managing CALs
 *
 * @author Gil <1180838@isep.ipp.pt>
 */
public class CALStore {

    private ArrayList<CAL> calList;

    /**
     * Create Store instance with empty array.
     */
    public CALStore(){
        calList = new ArrayList<>();
    }

    /**
     * Creates a CAL instance and returns it.
     * @param labId
     * @param labName
     * @param phoneNumber
     * @param address
     * @param tin
     * @param answer
     * @return CAL
     */
    public CAL createCAL(String labId, String labName, int phoneNumber, String address, int tin, boolean answer ){
        return new CAL(labId, labName, phoneNumber, address, tin, answer);
    }

    /**
     * Validates CAL attributes for business model rules
     * @param cal
     * @return boolean
     */
    public boolean validateCAL(CAL cal){
        if(cal == null)
            return false;
        for (CAL cal1: this.calList) {
            if(cal1.getLaboratoryId()==cal.getLaboratoryId() || cal1.getPhoneNumber()==cal.getPhoneNumber() ||
                cal1.getTinNumber()==cal.getTinNumber() || cal1.getAddress().equalsIgnoreCase(cal.getAddress())){
                return false;
            }
            int length = String.valueOf(cal.getPhoneNumber()).length();
            length += String.valueOf(cal.getTinNumber()).length();
            length += String.valueOf(cal.getLaboratoryId()).length();
            //phone number- 10 nº tin-10nº labID-?
            if(length!=20) return false;
        }
        return true;
    }

    /**
     * Saves the new CAL
     * @param cal
     * @return boolean
     */
    public boolean saveCAL(CAL cal){
        if(!validateCAL(cal))
            return false;
        return this.calList.add(cal);
    }
}
