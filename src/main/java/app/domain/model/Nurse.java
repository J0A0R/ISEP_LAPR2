package app.domain.model;

/**
 * Represents a nurce through your user ID, name and password.
 */
public class Nurse extends Employee{

    /**
     * the nurse's userID
     */
    private String userID;

    /**
     * the nurse's name
     */
    private String name;

    /**
     * the nurse's password
     */
    private String password;

    /**
     * Instantiates a new Nurse.
     *
     * @param name the nurse's name
     * @param address the nurse's address
     * @param phoneNumber the nurse's phone number
     * @param email the nurse's email
     * @param citizenCardIDNumber the nurse's citizen card id number
     * @param password the nurse's password
     * @param username the nurse's username
     * @param userID the nurse's user id
     */
    public Nurse(String name, String address, int phoneNumber, String email, String citizenCardIDNumber, String password, String username, String userID) {
        super(name, address, phoneNumber, email, citizenCardIDNumber, password, username);
        setUserID(userID);
        this.name = name;
        this.password = password;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Sets user id.
     *
     * @param userID the user id
     */
    public void setUserID(String userID) {
        if (userID.isBlank())
            throw new IllegalArgumentException("User ID cannot be null.");
        else
            this.userID = userID;
    }

    /**
     * Returns the textual description of the nurse.
     * @return Characteristics of the nurse
     */
    @Override
    public String toString() {
        return String.format(super.toString()+"\n Your UserID is "+userID+" and has a password that is "+password);
    }
}
