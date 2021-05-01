package app.domain.model;

import auth.domain.model.Email;
import auth.domain.model.Password;
import auth.domain.model.User;

/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class Client extends User {
    private String name;
    private int nhs;
    private int citizenCard;
    private int tin;
    private String birthDate;
    private String sex;
    private int pNumber;

    /**
     * Constructor Client
     * @param name
     * @param nhs
     * @param citizenCard
     * @param tin
     * @param birthDate
     * @param sex
     * @param pNumber
     */
    public Client(Email id, Password pwd, String name, int nhs, int citizenCard, int tin, String birthDate, String sex, int pNumber){
        super(id,pwd,name);
        this.name = name;
        this.nhs = nhs;
        this.citizenCard = citizenCard;
        this.tin = tin;
        this.birthDate = birthDate;
        this.sex = sex;
        this.pNumber = pNumber;
    }
    public Client(Email id, Password pwd, String name, int nhs, int citizenCard, int tin, String birthDate,String sex){
        super(id,pwd,name);
        this.name = name;
        this.nhs = nhs;
        this.citizenCard = citizenCard;
        this.tin = tin;
        this.birthDate = birthDate;
        this.sex = sex;
        pNumber = Integer.parseInt(null);
    }

    //gets:
    public String getName(){return name;}
    public int getNhs(){return nhs;}
    public int getCitizenCard(){return citizenCard;}
    public int getTin(){return tin;}
    public String getBirthDate(){return birthDate;}
    public String getSex(){return sex;}
    public int getPNumber(){return pNumber;}

    //sets:
    public void setName(String name){this.name=name;}
    public void setNhs(int nhs){this.nhs=nhs;}
    public void setCitizenCard(int citizenCard){this.citizenCard=citizenCard;}
    public void setTin(int tin){this.tin=tin;}
    public void setBirthDate(String birthDate){this.birthDate=birthDate;}
    public void setSex(String sex){this.sex=sex;}
    public void setPNumber(int pNumber){this.pNumber=pNumber;}


    public void checkNHS(){
        String check = String.valueOf(nhs);
        if(check.length() != 10)
            throw new IllegalArgumentException("NHS number must have 10 chars");
    }

    public void checkCitizenNumber(){
        String check = String.valueOf(citizenCard);
        if(check.length() != 16)
            throw new IllegalArgumentException("Citizen number must have 16 chars");
    }

    public void checkTIN(){
        String check = String.valueOf(tin);
        if(check.length() != 12)
            throw new IllegalArgumentException("TIN must have 12 chars");
    }

    public void checkPNumber(){
        String check = String.valueOf(pNumber);
        if(check.length() != 12)
            throw new IllegalArgumentException("TIN must have 12 chars");
    }

    public void checkSex(){
        if(! sex.equals("Masculine") || ! sex.equals("Feminine"))
        throw new IllegalArgumentException("This genre does not exist!");
    }
}
