package app.domain.model;

import app.domain.shared.Constants;
import auth.AuthFacade;
import auth.domain.model.Email;
import auth.domain.model.User;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;


/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Gil <1180838@isep.ipp.pt>
 */

public class Client {//if needed use //extends User
    private String name;
    private Email id;
    private long nhs;
    private long citizenCard;
    private long tin;
    private Date birthDate;
    private String sex;
    private long pNumber;



    /**
     * Constructor Client
     * @param nhs
     * @param citizenCard
     * @param tin
     * @param birthDate
     * @param sex
     * @param pNumber
     */
    public Client(Email id, String name, long nhs, long citizenCard, long tin, Date birthDate, String sex, long pNumber){



        this.name=name;
        this.id=id;
        this.nhs = nhs;
        this.citizenCard = citizenCard;
        this.tin = tin;
        this.birthDate = birthDate; //fazer check birthdate
        this.sex = sex;
        this.pNumber = pNumber;
    }
    public Client(Email id, String name, long nhs, long citizenCard, long tin, Date birthDate,String sex){
        //this.authFacade.addUserWithRole(name, id, pwd, Constants.ROLE_CLIENT);
        this.name=name;
        this.id=id;
        this.nhs = nhs;
        this.citizenCard = citizenCard;
        this.tin = tin;
        this.sex = sex;
        pNumber = 0;
    }

    //gets:

    public long getNhs(){return nhs;}
    public long getCitizenCard(){return citizenCard;}
    public long getTin(){return tin;}
    public Date getBirthDate(){return birthDate;}
    public String getSex(){return sex;}
    public long getPNumber(){return pNumber;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Email getId() {
        return id;
    }

    public void setId(Email id) {
        this.id = id;
    }


    //sets:
    public void setNhs(long nhs){this.nhs=nhs;}
    public void setCitizenCard(long citizenCard){this.citizenCard=citizenCard;}
    public void setBirthDate(Date birthDate){this.birthDate=birthDate;}
    public void setTin(long tin){this.tin=tin;}
    public void setSex(String sex){this.sex=sex;}
    public void setPNumber(long pNumber){this.pNumber=pNumber;}


    public void checkNHS(long nhs){
        String check = String.valueOf(nhs);
        if(check.length() != 10)
            throw new IllegalArgumentException("NHS number must have 10 chars");
    }

    public void checkCitizenNumber(long citizenCard){
        String check = String.valueOf(citizenCard);
        if(check.length() != 16)
            throw new IllegalArgumentException("Citizen number must have 16 chars");
    }

    public void checkTIN(long tin){
        String check = String.valueOf(tin);
        if(check.length() != 12)
            throw new IllegalArgumentException("TIN must have 12 chars");
    }

    public void checkPNumber(long pNumber){
        if (pNumber != 0) {
            String check = String.valueOf(pNumber);
            if (check.length() != 12) {
                throw new IllegalArgumentException("Phone Number must have 12 chars");
            }
        }
    }

    public void checkSex(String sex){

        if( sex != "Masculine" ^  sex != "Feminine" ^ sex != "M" ^ sex!="F")
            throw new IllegalArgumentException("This gender does not exist!");
    }

    @Override
    public String toString() {
        return "Client{" +
                "nhs=" + nhs +
                ", citizenCard=" + citizenCard +
                ", tin=" + tin +
                ", birthDate='" + birthDate + '\'' +
                ", sex='" + sex + '\'' +
                ", pNumber=" + pNumber +
                '}';
    }
}