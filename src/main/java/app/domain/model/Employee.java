package app.domain.model;

/**
 * The type Employee.
 * Represents an employee through your name, address, phoneNumber, email, citizen card ID number,password and username.
 */
public class Employee {

    /**
     * The Employee name.
     */
    private String name;

    /**
     * The Employee address.
     */
    private String address;

    /**
     * The Employee phone number.
     */
    private int phoneNumber;

    /**
     * The Employee email.
     */
    private String email;

    /**
     * The Employee citizen card ID number.
     */
    private String citizenCardIDNumber;

    /**
     * The Employee password.
     */
    private String password;

    /**
     * The Employee username.
     */
    private String username;

    /**
     * Builds an instance of the Employee.
     *
     * @param name the name of the employee
     * @param address the address of the employee
     * @param phoneNumber the phone number of the employee
     * @param email the email of the employee
     * @param citizenCardIDNumber the citizen card id number of the employee
     * @param password the password of the employee
     * @param username the username of the employee
     */
    public Employee(String name, String address, int phoneNumber, String email, String citizenCardIDNumber, String password, String username) {
        setName(name);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCitizenCardIDNumber(citizenCardIDNumber);
        setPassword(password);
        setUsername(username);
    }

    /**
     * Set the employee name and tested the credibility.
     *
     * @param name the new employee name
     */
    public void setName(String name) {
        if (name.isBlank())
            throw new IllegalArgumentException("Name cannot be null.");
        else
            this.name = name;
    }

    /**
     * Set the employee address and tested the credibility.
     *
     * @param address the new employee address
     */
    public void setAddress(String address) {
        if (address.isBlank())
            throw new IllegalArgumentException("Address cannot be null.");
        else
            this.address = address;
    }

    /**
     * Set the employee phone number and tested the credibility.
     *
     * @param phoneNumber the new employee phone number
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
     * Set the employee email and tested the credibility.
     *
     * @param email the new employee email
     */
    public void setEmail(String email) {
        if (email.isBlank())
            throw new IllegalArgumentException("Email cannot be null.");
        else
            this.email = email;
    }

    /**
     * Set the employee citizen card id number and tested the credibility.
     *
     * @param citizenCardIDNumber the new employee citizen card id number
     */
    public void setCitizenCardIDNumber(String citizenCardIDNumber) {
        if (citizenCardIDNumber.isBlank())
            throw new IllegalArgumentException("Citizen Card ID Number cannot be null.");
        else
            this.citizenCardIDNumber = citizenCardIDNumber;
    }

    /**
     * Set the employee password and tested the credibility.
     *
     * @param password the new employee password
     */
    public void setPassword(String password) {
        if (password.isBlank())
            throw new IllegalArgumentException("Password cannot be null.");
        else
            this.password = password;
    }

    /**
     * Set the employee username and tested the credibility.
     *
     * @param username the new employee username
     */
    public void setUsername(String username) {
        if (username.isBlank())
            throw new IllegalArgumentException("User Name cannot be null.");
        else
            this.username = username;
    }

    /**
     * Compare two objects of type employee.
     * @param o used object to be compared
     * @return true if the object is the same and when the username and citizen card ID number are the same. Otherwise return false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return citizenCardIDNumber.equals(employee.citizenCardIDNumber) && username.equals(employee.username);
    }

    /**
     * Returns the textual description of the employee.
     * @return Characteristics of the employee
     */
    @Override
    public String toString() {
        return String.format("Employee" + "\n" + "-name: " + name + '\n' + "-address: " + address + '\n' + "-phone number: " + phoneNumber + '\n'+
                "-email: " + email + '\n' + "-citizenCardIDNumber: " + citizenCardIDNumber + '\n' + "-password: " + password + '\n' + "-username: " + username + '\n');
    }
}
