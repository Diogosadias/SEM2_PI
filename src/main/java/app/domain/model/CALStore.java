package app.domain.model;

import auth.domain.model.Email;
import auth.domain.model.Password;

import java.util.ArrayList;

public class CALStore {

    private ArrayList<CAL> calList = new ArrayList<>();

    public CALStore(){
        calList = new ArrayList<>();
    }


    public CAL createCAL(String labname, String address, int phone_number, int tin_number ){
        return new CAL(labname,address,phone_number,tin_number);
    }
    public boolean validateCAL(CAL cal){
        if(cal == null)
            return false;
        return ! this.calList.contains(cal);
    }

    public boolean saveCAL(CAL cal){
        if(!validateCAL(cal))
            return false;
        return this.calList.add(cal);
    }
}
