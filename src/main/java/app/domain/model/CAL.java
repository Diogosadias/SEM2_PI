package app.domain.model;

import java.util.List;
import java.lang.Long;

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
    private int tinNumber;
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
    public CAL(String labId, String labName, long phoneNumber, String address, int tin, boolean answer){
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
    public long getPhoneNumber(){
        return phoneNumber;
    }
    public int getTinNumber(){
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
