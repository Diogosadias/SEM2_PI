package app.domain.model;

import auth.domain.model.Email;
import auth.domain.model.Password;
import auth.domain.model.User;

public class Administrator extends User {

    private String adress;
    private String standardOcuppationalCode;
    private String employeeId;

    public Administrator(Email id, Password pwd, String name, String adress,String pNumber,String standardOcupationalCode,String employeeid) {
        super(id, pwd, name);
        this.adress = adress;
        this.standardOcuppationalCode = standardOcupationalCode;
        this.employeeId = employeeid;
    }

    //getters
    public String getAdress() {
        return this.adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getStandardOcuppationalCode() {
        return this.standardOcuppationalCode;
    }

    public void setStandardOcuppationalCode(String standardOcuppationalCode) {
        this.standardOcuppationalCode = standardOcuppationalCode;
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    //setters
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "adress='" + adress + '\'' +
                ", standardOcuppationalCode='" + standardOcuppationalCode + '\'' +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }
}
