package app.domain.model;

import auth.domain.model.Email;
import auth.domain.model.Password;
import auth.domain.model.User;

public class Administrator extends User {

    private String address;
    private String standardOcuppationalCode;
    private String employeeId;

    public Administrator(Email id, Password pwd, String name, String adress, String standardOcupationalCode, String employeeid) {
        super(id, pwd, name);

        checkAdressrules(adress);
        checkStandardOcuppationalCoderules(standardOcupationalCode);
        checkEmployeeId(employeeid);

        this.address = adress;
        this.standardOcuppationalCode = standardOcupationalCode;
        this.employeeId = employeeid;
    }

    //checkers
    private void checkAdressrules(String adress) {
        if (adress.length() == 0)
            throw new IllegalArgumentException("Address cannot be blank.");
        if ( adress.length() > 30)
            throw new IllegalArgumentException("Address must have no more than 30 characters.");
    }

    private void checkStandardOcuppationalCoderules(String standardOcupationalCode) {
        if (standardOcupationalCode.length() == 0)
            throw new IllegalArgumentException("SOC cannot be blank.");
        if ( standardOcupationalCode.length() != 5)
            throw new IllegalArgumentException("SOC must have 5 chars.");
    }

    private void checkEmployeeId(String employeeid) {
        if (employeeid.length() == 0)
            throw new IllegalArgumentException("Employee ID cannot be blank.");
        if ( employeeid.length() != 5)
            throw new IllegalArgumentException("Employee ID must have 5 chars.");
    }
    //getters
    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    public String getStandardOcuppationalCode() {
        return this.standardOcuppationalCode;
    }

    //setters
    public void setStandardOcuppationalCode(String standardOcuppationalCode) {
        this.standardOcuppationalCode = standardOcuppationalCode;
    }

    public String getEmployeeId() {
        return this.employeeId;
    }


    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "adress='" + address + '\'' +
                ", standardOcuppationalCode='" + standardOcuppationalCode + '\'' +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }
}
