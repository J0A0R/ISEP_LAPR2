package app.domain.model;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a Vaccine Type through your name, sex, birthday, address, phone number, email, SNS User Number and citizen card number.
 */
public class User implements Serializable {

    /**
     * The username.
     */
    private String name;

    /**
     * The user sex.
     */
    private String sex;

    /**
     * User's date of birth
     */
    private String birthDate;

    /**
     * User address
     */
    private String address;

    /**
     * User's phone number
     */
    private int phoneNumber;

    /**
     * User email
     */
    private String email;

    /**
     * SNS User number
     */
    private int snsUserNumber;

    /**
     * User's citizen card number
     */
    private int citizenCardNumber;

    /**
     * Builds an instance of the User receiving the name, sex, birthday, address, phone number, email, SNS User Number and citizen card number.
     *
     * @param name              the username
     * @param sex               the user sex
     * @param birthDate         the user's date of birth
     * @param address           the user address
     * @param phoneNumber       the user's phone number
     * @param email             the user email
     * @param snsUserNumber     the sns user number
     * @param citizenCardNumber the user's citizen card number
     */
    public User(String name, String sex, String birthDate, String address, int phoneNumber, String email, int snsUserNumber, int citizenCardNumber) {
        setName(name);
        setSex(sex);
        setBirthDate(birthDate);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setSnsUserNumber(snsUserNumber);
        setCitizenCardNumber(citizenCardNumber);
    }

    /**
     * Empty Constructor for User
     */
    public User() {
    }

    /**
     * Modify the username and tested the credibility.
     *
     * @param name the new username
     */
    public void setName(String name) {
        if (name.isBlank())
            throw new IllegalArgumentException("Name cannot be null.");
        else
            this.name = name;
    }

    /**
     * Modify the user's date of birth and tested the credibility.
     *
     * @param birthDate the new user's date of birth
     */
    public void setBirthDate(String birthDate) {
        if (birthDate.isBlank())
            throw new IllegalArgumentException("Birth date cannot be null.");
        else
            this.birthDate = birthDate;
    }

    /**
     * Modify the user sex and tested the credibility.
     *
     * @param sex the new user sex
     */
    public void setSex(String sex) {
        /* String uCh1 = StringUtils.upperCase(sex);
        if (sex.isBlank())
            throw new IllegalArgumentException("Sex cannot be null.");
        else if(!Objects.equals(uCh1, "MASCULINE") && !Objects.equals(uCh1, "FEMININE") && !Objects.equals(uCh1, "MAX") && !Objects.equals(uCh1, "FEM")){
            throw new IllegalArgumentException("invalid sex.");
        }
        else*/
        this.sex = sex;
    }

    /**
     * Modify the user address and tested the credibility.
     *
     * @param address the new user address
     */
    public void setAddress(String address) {
        if (address.isBlank())
            throw new IllegalArgumentException("Address cannot be null.");
        else
            this.address = address;
    }

    /**
     * Modify the user phone number and tested the credibility.
     *
     * @param phoneNumber the new user phone number
     */
    public void setPhoneNumber(int phoneNumber) {
        String phone = String.valueOf(phoneNumber);
        if (phone.isBlank())
            throw new IllegalArgumentException("Phone number cannot be null.");
        else if ( phone.length() != 9)
            throw new IllegalArgumentException("Phone number must have 9 digits.");
        else
            this.phoneNumber = phoneNumber;
    }

    /**
     * Modify the user email and tested the credibility.
     *
     * @param email the new user email
     */
    public void setEmail(String email) {
        if (email.isBlank())
            throw new IllegalArgumentException("E-mail cannot be null.");
        else
            this.email = email;
    }

    /**
     * Modify the sns user number and tested the credibility.
     *
     * @param snsUserNumber the new sns user number
     */
    public void setSnsUserNumber(int snsUserNumber) {
        String snsNumber = String.valueOf(snsUserNumber);
        if (snsNumber.isBlank())
            throw new IllegalArgumentException("SNS User Number cannot be null.");
        else if ( snsNumber.length() != 9)
            throw new IllegalArgumentException("SNS User Number must have 9 digits.");
        else
            this.snsUserNumber = snsUserNumber;
    }

    /**
     * Modify the user's citizen card number and tested the credibility.
     *
     * @param citizenCardNumber the new user's citizen card number
     */
    public void setCitizenCardNumber(int citizenCardNumber) {
        String citizenCard = String.valueOf(citizenCardNumber);
        if (citizenCard.isBlank())
            throw new IllegalArgumentException("Citizen Card Number cannot be null.");
        else if ( citizenCard.length() != 8)
            throw new IllegalArgumentException("Citizen Card Number must have 8 digits.");
        else
            this.citizenCardNumber = citizenCardNumber;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public int getSnsUserNumber() {
        return snsUserNumber;
    }

    public int getCitizenCardNumber() {
        return citizenCardNumber;
    }

    /**
     * Compare two users type objects
     * @param o another object
     * @return False if object O is null or if class type is different, otherwise return true.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return phoneNumber == user.phoneNumber && snsUserNumber == user.snsUserNumber && citizenCardNumber == user.citizenCardNumber && Objects.equals(name, user.name) && Objects.equals(sex, user.sex) && Objects.equals(birthDate, user.birthDate) && Objects.equals(address, user.address) && Objects.equals(email, user.email);
    }

    /**
     * Returns the textual description of the user
     * @return Name, sex, birthday, address, phone number, email, SNS User Number and citizen card number.
     */
    @Override
    public String toString() {
        return String.format("name= " + name  + ", sex= " + sex + ", birth date= " + birthDate + ", address= " + address + ", phoneNumber= " + phoneNumber +
                ", email= " + email + ", SNSUserNumber= " + snsUserNumber + " and citizenCardNumber=" + citizenCardNumber);
    }
}