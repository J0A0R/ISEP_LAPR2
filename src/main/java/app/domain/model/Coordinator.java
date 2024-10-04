package app.domain.model;

/**
 * Represents a coordinator through your user ID, name and password.
 */

public class Coordinator extends Employee{

    /**
     * the coordinator's userID
     */
    private String userID;

    /**
     * the coordinator's name
     */
    private String name;

    /**
     * the coordinator's password
     */
    private String password;

    /**
     * Instantiates a new Coordinator.
     *
     * @param name the coordinator's name
     * @param address the coordinator's address
     * @param phoneNumber the coordinator's phone number
     * @param email the coordinator's email
     * @param citizenCardIDNumber the coordinator's citizen card id number
     * @param password the coordinator's password
     * @param username the coordinator's username
     * @param userID the coordinator's user id
     */
    public Coordinator(String name, String address, int phoneNumber, String email, String citizenCardIDNumber, String password, String username, String userID) {
        super(name, address, phoneNumber, email, citizenCardIDNumber, password, username);
        setUserID(userID);
        this.name = name;
        this.password = password;
    }

    /**
     * Sets user id.
     *
     * @param userID the user id
     */
    public void setUserID(String userID) {
        if (userID.isBlank())
            throw new IllegalArgumentException("UserID cannot be null.");
        else
            this.userID = userID;
    }

    /**
     * Returns the textual description of the coordinator.
     * @return Characteristics of the coordinator
     */
    @Override
    public String toString() {
        return String.format(super.toString()+"\n Your UserID is "+userID+" and has a password that is "+password);
    }
}
