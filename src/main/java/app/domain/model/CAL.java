package app.domain.model;

import java.util.List;

/**
 *  CAL - Domain class representing a Clinical Analysis Laboratory
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Gil <1180838@isep.ipp.pt>
 */
public class CAL {

    private String labName;
    private String address;
    private long phoneNumber;
    private long tinNumber;
    private boolean performsCovidTest;
    private String laboratoryId;
    private List<TestType> testsAvailable;

    /**
     * CAL Constructor with all attributes (TestTypes not available yet)
     * @param labId
     * @param labName
     * @param phoneNumber
     * @param address
     * @param tin
     * @param answer
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
    private void checkLabIDrules(String labId) {
        if (labId.length() == 0)
            throw new IllegalArgumentException("Laboratory Id cannot be blank.");
        if (labId.length() != 5)
            throw new IllegalArgumentException("Lab Id must have 5 chars.");

    }

    private void checkaddressrules(String address) {
        if (address.length() == 0)
            throw new IllegalArgumentException("Address cannot be blank.");
        if ( address.trim().length() > 30)
            throw new IllegalArgumentException("Address must have no more than 30 characters.");
    }

    private void checkphoneNumberrules(long phoneNumber) {
        String temp = String.valueOf(phoneNumber);
        if ( temp.length() != 11)
            throw new IllegalArgumentException("Phone Number must have 11 chars.");
    }

    private void checkTINrules(long tin) {
        String temp = String.valueOf(tin);
        if (temp.length() == 0)
            throw new IllegalArgumentException("TIN cannot be blank.");
        if ( temp.length() != 10)
            throw new IllegalArgumentException("TIN must have 10 chars.");
    }

    private void checkNamerules(String labName) {
        if (labName.length() == 0)
            throw new IllegalArgumentException("Laboratory Name cannot be blank.");
        if ( labName.length() > 20)
            throw new IllegalArgumentException("Laboratory Name must have no more than 20 characters.");
    }



    //gets:

    public String getLabName(){
        return labName;
    }
    public String getAddress(){
        return address;
    }
    public long getPhoneNumber(){
        return phoneNumber;
    }
    public long getTinNumber(){
        return tinNumber;
    }
    public boolean getPerformsCovidTest(){
        return performsCovidTest;
    }
    public String getLaboratoryId(){
        return laboratoryId;
    }

    //sets:

    public void setLabName(String labName){
        this.labName = labName;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public void setPhoneNumber(long phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public void setTinNumber(int tinNumber){
        this.tinNumber = tinNumber;
    }
    public void setPerformsCovidTest(boolean performsCovidTest){
        this.performsCovidTest = performsCovidTest;
    }
    public void setLaboratoryId(String laboratoryId){
        this.laboratoryId = laboratoryId;
    }



}
