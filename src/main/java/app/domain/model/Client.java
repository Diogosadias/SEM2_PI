package app.domain.model;

import app.domain.shared.Constants;
import auth.AuthFacade;
import auth.domain.model.Email;
import auth.domain.model.Password;
import auth.domain.model.User;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class Client {//if needed use //extends User
    private long nhs;
    private long citizenCard;
    private long tin;
    private String birthDate;
    private String sex;
    private long pNumber;
    private AuthFacade authFacade = new AuthFacade();

    /**
     * Constructor Client
     * @param nhs
     * @param citizenCard
     * @param tin
     * @param birthDate
     * @param sex
     * @param pNumber
     */
    public Client(String id, String pwd, String name, long nhs, long citizenCard, long tin, String birthDate, String sex, long pNumber){
        this.authFacade.addUserWithRole(name, id, pwd, Constants.ROLE_CLIENT);

        checkNHS(nhs);
        checkCitizenNumber(citizenCard);
        checkTIN(tin);

        checkPNumber(pNumber);

        this.nhs = nhs;
        this.citizenCard = citizenCard;
        this.tin = tin;
        this.birthDate = birthDate; //fazer check birthdate
        this.sex = sex;
        this.pNumber = pNumber;
    }
    public Client(String id, String pwd, String name, long nhs, long citizenCard, long tin, String birthDate,String sex){
        this.authFacade.addUserWithRole(name, id, pwd, Constants.ROLE_CLIENT);
        this.nhs = nhs;
        this.citizenCard = citizenCard;
        this.tin = tin;
        this.birthDate = birthDate;
        this.sex = sex;
        pNumber = 0;
    }

    //gets:

    public long getNhs(){return nhs;}
    public long getCitizenCard(){return citizenCard;}
    public long getTin(){return tin;}
    public String getBirthDate(){return birthDate;}
    public String getSex(){return sex;}
    public long getPNumber(){return pNumber;}

    //sets:
    public void setNhs(long nhs){this.nhs=nhs;}
    public void setCitizenCard(long citizenCard){this.citizenCard=citizenCard;}
    public void setTin(long tin){this.tin=tin;}
    public void setBirthDate(String birthDate){this.birthDate=birthDate;}
    public void setSex(String sex){this.sex=sex;}
    public void setPNumber(long pNumber){this.pNumber=pNumber;}

    /*
    private boolean checkNHS(int nhs) {
        String check = String.valueOf(nhs);
        if (StringUtils.isBlank(check))
            return false;
        // Check for other invalid criteria here

        //
        if(check.length() != 10)
            return false;
        return true;
    }*/


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
                throw new IllegalArgumentException("TIN must have 12 chars");
            }
        }
    }

    public void checkSex(String sex){
        if(! sex.equals("Masculine") || ! sex.equals("Feminine") || ! sex.equals("M"))
            throw new IllegalArgumentException("This genre does not exist!");
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