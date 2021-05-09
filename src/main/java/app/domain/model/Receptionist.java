package app.domain.model;

public class Receptionist {
    /**
     * email - Receptionist's Email
     */
    private String email;
    /**
     * employeeId - Receptionist's ID
     */
    private String employeeId;
    /**
     * name - Receptionist's Name
     */
    private String name;
    /**
     * address - Receptionist's Address
     */
    private String address;
    /**
     * phoneNumber - Receptionist's Phone Number
     */
    private String phoneNumber;
    /**
     * socCode - Receptionist's SOC Code
     */
    private String socCode;

    /**
     * Receptionist's Constructor
     * @param email - Receptionist's Email
     * @param employeeId - Receptionist's ID
     * @param name - Receptionist's Name
     * @param address - Receptionist's Address
     * @param phoneNumber - Receptionist's Phone Number
     * @param socCode - Receptionist's SOC Code
     */
    public Receptionist(String email, String employeeId, String name, String address, String phoneNumber, String socCode){
        this.email = email;
        this.name = name;
        this.employeeId = employeeId;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.socCode = socCode;
    }
}
