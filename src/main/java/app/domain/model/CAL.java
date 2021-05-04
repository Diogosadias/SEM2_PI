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
    private int phoneNumber;
    private int tinNumber;
    private boolean performsCovidTest;
    private int laboratoryId;
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
    public CAL(int labId, String labName, int phoneNumber, String address, int tin, boolean answer){
        this.laboratoryId=labId;
        this.labName = labName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.tinNumber = tin;
        this.performsCovidTest = answer;
    }

    //gets:

    public String getLabName(){
        return labName;
    }
    public String getAddress(){
        return address;
    }
    public int getPhoneNumber(){
        return phoneNumber;
    }
    public int getTinNumber(){
        return tinNumber;
    }
    public boolean getPerformsCovidTest(){
        return performsCovidTest;
    }
    public int getLaboratoryId(){
        return laboratoryId;
    }

    //sets:

    public void setLabName(String labName){
        this.labName = labName;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public void setPhoneNumber(int phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public void setTinNumber(int tinNumber){
        this.tinNumber = tinNumber;
    }
    public void setPerformsCovidTest(boolean performsCovidTest){
        this.performsCovidTest = performsCovidTest;
    }
    public void setLaboratoryId(int laboratoryId){
        this.laboratoryId = laboratoryId;
    }



}
