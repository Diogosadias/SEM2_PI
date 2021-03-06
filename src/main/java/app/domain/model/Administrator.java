package app.domain.model;

import auth.domain.model.Email;
import auth.domain.model.Password;
import auth.domain.model.User;

/**
 * This domain class allows to build an instance of administrator.
 *
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 * @author Tiago Ferreira <1200601@isep.ipp.pt>
 */

public class Administrator extends User {

    /**
     * The address of administrator.
     */
    private String adress;

    /**
     * The standard occupational code of administrator.
     */
    private String standardOcuppationalCode;


    /**
     * The employee of the administrator.
     */
    private String employeeId;

    /**
     * Initializes the administrator's constructor with the email, password, name,
     * address, phone number, standard occupational code and employee id.
     *
     * @param id administrator's email
     * @param pwd administrator's password
     * @param name administrator's name
     * @param adress administrator's address
     * @param pNumber administrator's phone number
     * @param standardOcupationalCode administrator's standard occupational code
     * @param employeeid administrator's employee id
     */

    public Administrator(Email id, Password pwd, String name, String adress,String pNumber,String standardOcupationalCode,String employeeid) {
        super(id, pwd, name);

        checkAdressrules(adress);
        checkStandardOcuppationalCoderules(standardOcupationalCode);
        checkEmployeeId(employeeid);

        this.adress = adress;
        this.standardOcuppationalCode = standardOcupationalCode;
        this.employeeId = employeeid;
    }

    /**
     * Check if the address it's within the rules.
     *
     * @param adress administrator's address
     */

    private boolean checkAdressrules(String adress) {
        if(adress!=null) {
        if (adress.length() == 0)
            throw new IllegalArgumentException("Address cannot be blank.");
        if ( adress.trim().length() > 30)
            throw new IllegalArgumentException("Address must have no more than 30 characters.");
        return true;
        }
        throw new IllegalArgumentException("Address cannot be null.");
    }

    /**
     * Check if the standard occupational code it's within the rules.
     *
     * @param standardOcupationalCode administrator's standard occupational code
     */

    private boolean checkStandardOcuppationalCoderules(String standardOcupationalCode) {

        if(standardOcupationalCode!=null) {
        if (standardOcupationalCode.length() == 0)
            throw new IllegalArgumentException("SOC cannot be blank.");
        if ( standardOcupationalCode.length() != 5)
            throw new IllegalArgumentException("SOC must have 5 chars.");
        return true;
    }
        throw new IllegalArgumentException("SOC cannot be null.");
    }

    /**
     * Check if the employee id it's within the rules.
     *
     * @param employeeid administrator's employee id
     */

    private boolean checkEmployeeId(String employeeid) {
        if(employeeid!=null) {
            if (employeeid.length() == 0)
                throw new IllegalArgumentException("Employee ID cannot be blank.");
            if (employeeid.length() != 5)
                throw new IllegalArgumentException("Employee ID must have 5 chars.");
            return true;
        }
        throw new IllegalArgumentException("Employee ID cannot be null.");
    }

    /**
     * Return the administrator's address.
     *
     * @return administrator's address
     */

    public String getAdress() {
        return adress;
    }

    /**
     * Change the administrator's address.
     *
     * @param adress administrator's address
     */

    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * Return the administrator's standard occupational code.
     *
     * @return administrator's standard occupational code
     */

    public String getStandardOcuppationalCode() {
        return this.standardOcuppationalCode;
    }

    /**
     * Change the administrator's standard occupational code.
     *
     * @param standardOcuppationalCode administrator's standard occupational code
     */

    public void setStandardOcuppationalCode(String standardOcuppationalCode) {
        this.standardOcuppationalCode = standardOcuppationalCode;
    }

    /**
     * Return the administrator's employee id.
     *
     * @return administrator's employee id
     */

    public String getEmployeeId() {
        return this.employeeId;
    }

    /**
     * Change the administrator's employee id.
     *
     * @param employeeId administrator's employee id
     */

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Return the textual description of the administrator.
     *
     * @return administrator's features
     */
    @Override

    public String toString() {
        return "Administrator{" +
                "address='" + adress + '\'' +
                ", standardOccupationalCode='" + standardOcuppationalCode + '\'' +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }
}
