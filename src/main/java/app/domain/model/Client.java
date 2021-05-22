package app.domain.model;

import auth.domain.model.Email;

import java.util.Date;


/**
 * This domain class allows to build an instance of client.
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Gil <1180838@isep.ipp.pt>
 */

public class Client {

    /**
     * The name of client.
     */
    private String name;

    /**
     * The email of client.
     */
    private Email id;

    /**
     * The nhs of client.
     */
    private long nhs;

    /**
     * The citizen card of client.
     */
    private long citizenCard;

    /**
     * The tin of client.
     */
    private long tin;

    /**
     * The birth date of client.
     */
    private Date birthDate;

    /**
     * The sex of client.
     */
    private String sex;

    /**
     * The phone number of client.
     */
    private long pNumber;


    /**
     * Constructor Client with the email, name, nhs, citizen card, tin number, birth date, sex
     * and phone number.
     *
     * @param id client's email
     * @param name client's name
     * @param nhs client's nhs
     * @param citizenCard client's citizen card
     * @param tin client's tin number
     * @param birthDate client's birth date
     * @param sex client's sex
     * @param pNumber client's phone number
     */

    public Client(Email id, String name, long nhs, long citizenCard, long tin, Date birthDate, String sex, long pNumber) {

        checkNHS(nhs);
        checkCitizenNumber(citizenCard);
        checkPNumber(pNumber);
        checkTIN(tin);
        checkSex(sex);


        this.name = name;
        this.id = id;
        this.nhs = nhs;
        this.citizenCard = citizenCard;
        this.tin = tin;
        this.birthDate = birthDate;
        this.sex = sex;
        this.pNumber = pNumber;
    }
    
    public Client(long citizenCard){
        checkCitizenNumber(citizenCard);
        this.citizenCard = citizenCard;
    }

    /**
     * Constructor Client with the email, name, nhs, citizen card, tin number, birth date and sex.
     *
     * @param id client's email
     * @param name client's name
     * @param nhs client's nhs
     * @param citizenCard client's citizen card
     * @param tin client's tin number
     * @param birthDate client's birth date
     * @param sex client's sex
     */


    /**
     * Return the client's nhs.
     *
     * @return client's nhs
     */
    public long getNhs() {
        return nhs;
    }

    /**
     * Return the client's citizen card.
     *
     * @return client's citizen card
     */
    public long getCitizenCard() {
        return citizenCard;
    }

    /**
     * Return the client's tin.
     *
     * @return client's tin
     */
    public long getTin() {
        return tin;
    }

    /**
     * Return the client's birth date.
     *
     * @return client's birth date
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Return the client's sex.
     *
     * @return client's sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * Return the client's phone number.
     *
     * @return client's phone number
     */
    public long getPNumber() {
        return pNumber;
    }

    /**
     * Return the client's name.
     *
     * @return client's name
     */
    public String getName() {
        return name;
    }

    /**
     * Change the client's name.
     *
     * @param name client's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the client's id.
     *
     * @return client's id
     */
    public Email getId() {
        return id;
    }

    /**
     * Change the client's id.
     *
     * @param id client's id
     */
    public void setId(Email id) {
        this.id = id;
    }

    /**
     * Change the client's nhs.
     *
     * @param nhs client's nhs
     */
    public void setNhs(long nhs) {
        this.nhs = nhs;
    }

    /**
     * Change the client's citizen card.
     *
     * @param citizenCard client's citizen card
     */
    public void setCitizenCard(long citizenCard) {
        this.citizenCard = citizenCard;
    }

    /**
     * Change the client's birth date.
     *
     * @param birthDate client's birth date
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Change the client's tin number.
     *
     * @param tin client's tin
     */
    public void setTin(long tin) {
        this.tin = tin;
    }

    /**
     * Change the client's sex.
     *
     * @param sex client's sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Change the client's phone number.
     *
     * @param pNumber client's phone number
     */
    public void setPNumber(long pNumber) {
        this.pNumber = pNumber;
    }

    /**
     * Check if the nhs it's within the rules.
     *
     * @param nhs client's nhs
     */
    public void checkNHS(long nhs) {
        String temp = String.valueOf(nhs);
        if (temp.length() != 10)
            throw new IllegalArgumentException("NHS code must have 10 chars.");
    }


    /**
     * Check if the citizen card it's within the rules.
     *
     * @param citizenCard
     */
    public void checkCitizenNumber(long citizenCard){
        String temp = String.valueOf(citizenCard);
        if (temp.length() != 16)
            throw new IllegalArgumentException("Citizen Card code must have 16 chars.");
    }

    /**
     * Check if the sex it's within the rules.
     *
     * @param sex
     */
    public void checkSex(String sex){
        if (!sex.equals("M") && !sex.equals("F"))
            throw new IllegalArgumentException("You must define your sex as 'M' or 'F'.");
    }

    /**
     * Check if the tin it's within the rules.
     *
     * @param tin
     */
    public void checkTIN(long tin){
        String temp = String.valueOf(tin);
        if (temp.length() != 12)
            throw new IllegalArgumentException("TIN code must have 12 chars.");
    }

    /**
     * Check if the phone number it's within the rules
     *
     * @param phonenumber
     */
    public void checkPNumber(long phonenumber){
        String temp = String.valueOf(phonenumber);
        if (temp.length() < 12)
            throw new IllegalArgumentException("Phone Number must have 11 chars.");
    }


    /**
     * Return the textual description of the client.
     *
     * @return client's features
     */
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