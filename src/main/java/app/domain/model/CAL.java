package app.domain.model;

import java.util.List;
import java.util.Objects;

/**
 *  CAL - Domain class representing a Clinical Analysis Laboratory
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Gil <1180838@isep.ipp.pt>
 * @author Tiago Ferreira <1200601@isep.ipp.pt>
 */
public class CAL {

    /**
     * The name of laboratory.
     */
    private String labName;

    /**
     * The address of laboratory.
     */
    private String address;

    /**
     * The phone number of laboratory.
     */
    private long phoneNumber;

    /**
     * The tin number of laboratory.
     */
    private long tinNumber;

    /**
     * The performs of covid test of laboratory.
     */
    private boolean performsCovidTest;

    /**
     * The id of laboratory.
     */
    private String laboratoryId;

    /**
     * The tests available of laboratory.
     */
    private List<TestType> testsAvailable;

    /**
     * CAL Constructor with all attributes (TestTypes not available yet)
     *
     * @param labId laboratory's id
     * @param labName laboratory's name
     * @param phoneNumber laboratory's phone number
     * @param address laboratory's address
     * @param tin laboratory's tin
     * @param answer laboratory's answer
     */

    public CAL(String labId, String labName, long  phoneNumber, String address, long tin, boolean answer){

        checkLabIDrules(labId);
        checkaddressrules(address);
        checkphoneNumberrules(phoneNumber);
        checkTINrules(tin);
        checkNamerules(labName);

        this.laboratoryId=labId;
        this.labName = labName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.tinNumber = tin;
        this.performsCovidTest = answer;
    }

    //rulecheckers:
    /*
    This checker may need to be private
     */

    /**
     * Check if the laboratory's id it's within the rules.
     *
     * @param labId laboratory's id
     */
    private void checkLabIDrules(String labId) {
        if (labId.length() == 0)
            throw new IllegalArgumentException("Laboratory Id cannot be blank.");
        if (labId.length() != 5)
            throw new IllegalArgumentException("Lab Id must have 5 chars.");

    }

    /**
     * Check if the address it's within the rules.
     *
     * @param address laboratory's address
     */
    private void checkaddressrules(String address) {
        if (address.length() == 0)
            throw new IllegalArgumentException("Address cannot be blank.");
        if ( address.trim().length() > 30)
            throw new IllegalArgumentException("Address must have no more than 30 characters.");
    }

    /**
     * Check if the phone number it's within the rules.
     *
     * @param phoneNumber laboratory's phone number
     */
    private void checkphoneNumberrules(long phoneNumber) {
        String temp = String.valueOf(phoneNumber);
        if ( temp.length() != 11)
            throw new IllegalArgumentException("Phone Number must have 11 chars.");
    }

    /**
     * Check if the tin it's within the rules.
     *
     * @param tin laboratory's tin
     */
    private void checkTINrules(long tin) {
        String temp = String.valueOf(tin);
        if ( temp.length() != 10)
            throw new IllegalArgumentException("TIN must have 10 chars.");
    }

    /**
     * Check if the name it's within the rules.
     *
     * @param labName laboratory's name
     */
    private void checkNamerules(String labName) {
        if (labName.length() == 0)
            throw new IllegalArgumentException("Laboratory Name cannot be blank.");
        if ( labName.length() > 20)
            throw new IllegalArgumentException("Laboratory Name must have no more than 20 characters.");
    }

    /**
     * Return the laboratory's name.
     *
     * @return laboratory's name
     */
    public String getLabName(){
        return labName;
    }

    /**
     * Return the laboratory's address.
     *
     * @return laboratory's address
     */
    public String getAddress(){
        return address;
    }

    /**
     * Return the laboratory's phone number.
     *
     * @return laboratory's phone number
     */
    public long getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * Return the laboratory's tin.
     *
     * @return laboratory's tin
     */
    public long getTinNumber(){
        return tinNumber;
    }

    /**
     * Return the laboratory's performs covid test.
     *
     * @return laboratory's performs covid test
     */
    public boolean getPerformsCovidTest(){
        return performsCovidTest;
    }

    /**
     * Return the laboratory's id.
     *
     * @return laboratory's id
     */
    public String getLaboratoryId(){
        return laboratoryId;
    }

    /**
     * Change the laboratory's name.
     *
     * @param labName laboratory's name
     */
    public void setLabName(String labName){
        this.labName = labName;
    }

    /**
     * Change the laboratory's address.
     *
     * @param address laboratory's address
     */
    public void setAddress(String address){
        this.address=address;
    }

    /**
     * Change the laboratory's phone number.
     *
     * @param phoneNumber laboratory's phone number
     */
    public void setPhoneNumber(long phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    /**
     * Change the laboratory's tin.
     *
     * @param tinNumber laboratory's tin
     */
    public void setTinNumber(long tinNumber){
        this.tinNumber = tinNumber;
    }

    /**
     * Change the laboratory's performs covid test.
     *
     * @param performsCovidTest laboratory's performs covid test
     */
    public void setPerformsCovidTest(boolean performsCovidTest){
        this.performsCovidTest = performsCovidTest;
    }

    /**
     * Change the laboratory's id.
     *
     * @param laboratoryId laboratory's id
     */
    public void setLaboratoryId(String laboratoryId){
        this.laboratoryId = laboratoryId;
    }

    /**
     * This method compares the equality of the current object
     * with the object of same type.
     *
     * @param o object
     *
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if(o!=null){
            if (!(o instanceof CAL)) return false;
            CAL cal = (CAL) o;
            return phoneNumber == cal.phoneNumber || Objects.equals(laboratoryId, cal.laboratoryId) || Objects.equals(address, cal.address) || Objects.equals(tinNumber, cal.tinNumber) ;
        }
        throw new NullPointerException("Object is null.");
    }

}
