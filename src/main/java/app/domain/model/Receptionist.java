package app.domain.model;

import app.domain.store.CreateClientStore;

public class Receptionist {
    private String email;
    private String employeeId;
    private String name;
    private String address;
    private String phoneNumber;
    private String socCode;
    private CreateClientStore createClientStore;


    public CreateClientStore getClientStore(){
        return createClientStore;
    }
}
