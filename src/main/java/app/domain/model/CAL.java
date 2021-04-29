package app.domain.model;

/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class CAL {
    private String labname;
    private String address;
    private int phone_number;
    private int tin_number;
    private boolean performs_covid_test;
    private int laboratory_id;

    public CAL(String labname, String address, int phone_number, int tin_number){
        this.labname=labname;
        this.address=address;
        this.phone_number=phone_number;
        this.tin_number=tin_number;
        performs_covid_test=false;
        //laboratory_id=laboratory_id+1;
    }

    //gets:

    public String getLabname(){
        return labname;
    }
    public String getAddress(){
        return address;
    }
    public int getPhone_number(){
        return phone_number;
    }
    public int getTin_number(){
        return tin_number;
    }
    public boolean getPerforms_covid_test(){
        return performs_covid_test;
    }
    public int getLaboratory_id(){
        return laboratory_id;
    }

    //sets:

    public void setLabname(String labname){
        this.labname=labname;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public void setPhone_number(int phone_number){
        this.phone_number=phone_number;
    }
    public void setTin_number(int tin_number){
        this.tin_number=tin_number;
    }
    public void setPerforms_covid_test(boolean performs_covid_test){
        this.performs_covid_test=performs_covid_test;
    }
    public void setLaboratory_id(int laboratory_id){
        this.laboratory_id=laboratory_id;
    }



}
