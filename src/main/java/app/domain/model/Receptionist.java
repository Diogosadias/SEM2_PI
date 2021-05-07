package app.domain.model;

import auth.AuthFacade;

public class Receptionist {
    private String email;
    private String employeeId;
    private String name;
    private String address;
    private String phoneNumber;
    private String socCode;
    private CreateClientStore createClientStore;

    public Receptionist(String email, String employeeId, String name, String adress, String phoneNumber, String socCode){
        this.email = email;
        this.name = name;
        this.employeeId = employeeId;
        this.phoneNumber = phoneNumber;
        this.address = adress;
        this.socCode = socCode;
        createClientStore = new CreateClientStore(new AuthFacade());
    }


    public CreateClientStore getClientStore(){
        return createClientStore;
    }
}
