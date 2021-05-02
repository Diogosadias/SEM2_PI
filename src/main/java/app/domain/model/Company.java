package app.domain.model;

import auth.AuthFacade;
import auth.domain.model.Email;
import auth.domain.model.Password;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Tiago Ferreira <1200601@isep.ipp.pt>
 */
public class Company {

    private String designation;
    private AuthFacade authFacade;


    public Company(String designation)
    {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
    }

    public String getDesignation() {
        return designation;
    }

    public AuthFacade getAuthFacade() {
        return authFacade;
    }


    public SpecifyNewTestStore getSpecifyNewTypeTestStore(SpecifyNewTestStore tpl){
        return tpl;
        }

    public TestType createTestType(String code, String description, String collectionMethod) {
        return new TestType(code, description, collectionMethod);
    }

    public Client createNewClient(String id, String pwd, String name, int nhs, int citizenCard, int tin, String birthDate, String sex, int pNumber)  {
        Email email = new Email(id);
        Password password = new Password(pwd);
            return  new Client(email,password,name,nhs,citizenCard,tin,birthDate,sex,pNumber);
         }

    public CAL createNewCAL(String labname, String address, int phone_number, int tin_number){
        return new CAL(labname,address,phone_number,tin_number);
    }




}
