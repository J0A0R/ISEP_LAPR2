package app.domain.model;

/**
 * Represents an administrator through your name, password and userID.
 */
public class Adminstrator extends Employee{

    /**
     * The administrator userID.
     */
    private String userID;

    /**
     * The administrator name.
     */
    private String name;

    /**
     * The administrator password.
     */
    private String password;

    /**
     * Initializes the administrator with the name, password, and userID.
     * @param name the name of the administrator
     * @param userID the userID of the administrator
     * @param password the password of the administrator
     */
    public Adminstrator(String name, String address, int phoneNumber, String email, String citizenCardIDNumber, String password, String username, String userID) {
        super(name, address, phoneNumber, email, citizenCardIDNumber, password, username);
        setUserID(userID);
        this.name = name;
        this.password = password;
    }

    /**
     * Set the adminstrator userID and tested the credibility.
     *
     * @param userID the new adminstrator user id
     */
    public void setUserID(String userID) {
        if (userID.isBlank())
            throw new IllegalArgumentException("User ID cannot be null.");
        else
            this.userID = userID;
    }

    /**
     * Returns the textual description of the administrator.
     * @return description of the administrator
     */
    @Override
    public String toString() {
        return String.format(super.toString()+"\n Your UserID is "+userID+" and has a password that is "+password);
    }
}
