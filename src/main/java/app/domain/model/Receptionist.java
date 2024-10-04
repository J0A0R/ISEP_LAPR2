package app.domain.model;

/**
 * Represents a receptionist through your user ID, name and password.
 */
public class Receptionist extends Employee{

    /**
     * The receptionist userID.
     */
    private String userID;

    /**
     * The receptionist name.
     */
    private String name;

    /**
     * The receptionist password.
     */
    private String password;

    /**
     * Builds an instantiates a new Receptionist.
     *
     * @param name the receptionist's name
     * @param address the receptionist's address
     * @param phoneNumber the receptionist's phone number
     * @param email the receptionist's email
     * @param citizenCardIDNumber the receptionist's citizen card id number
     * @param password the receptionist's password
     * @param username the receptionist's username
     * @param userID the receptionist's user id
     */
    public Receptionist(String name, String address, int phoneNumber, String email, String citizenCardIDNumber, String password, String username, String userID) {
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
            throw new IllegalArgumentException("User ID cannot be null.");
        else
            this.userID = userID;
    }

    /**
     * Returns the textual description of the receptionist.
     * @return Characteristics of the receptionist
     */
    @Override
    public String toString() {
        return String.format(super.toString()+"\n Your UserID is "+userID+" and has a password that is "+password);
    }
}
