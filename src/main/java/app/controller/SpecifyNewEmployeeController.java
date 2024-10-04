package app.controller;

import app.domain.model.Company;
import app.domain.model.Employee;

/**
 * Specify new employee controller.
 */
public class SpecifyNewEmployeeController {

    /**
     * Company
     */
    private static Company company;

    /**
     * Employee
     */
    private Employee em;

    /**
     * Instantiates a new employee controller.
     */
    public SpecifyNewEmployeeController(){
        if (company == null)
            company = new Company();
    }

    /**
     * Instantiates a new employee controller.
     *
     * @param company the company
     */
    public SpecifyNewEmployeeController(Company company) {
        this.company = company;
        this.em = null;
    }

    /**
     * Create employee boolean.
     *
     * @param name the name of the employee
     * @param address the address of the employee
     * @param phoneNumber the phone number of the employee
     * @param email the email of the employee
     * @param citizenCardIDNumber the citizen card id number of the employee
     * @param password the password of the employee
     * @param username the username of the employee
     * @return true if the employee exist in the employee list, otherwise it returns false.
     */
    public boolean createEmployee(String name, String address, int phoneNumber, String email, String citizenCardIDNumber, String password, String username){
        this.em = this.company.createEmployee(name, address, phoneNumber, email, citizenCardIDNumber, password, username);
        return this.company.validateEmployee(em);
    }

    /**
     * Create employee receptionist boolean.
     *
     * @param name the name of the receptionist
     * @param address the address of the receptionist
     * @param phoneNumber the phone number of the receptionist
     * @param email the email of the receptionist
     * @param citizenCardIDNumber the citizen card id number of the receptionist
     * @param password the password of the receptionist
     * @param username the username of the receptionist
     * @param userID the user id of the receptionist
     * @return the boolean true if the employee exist in the employee list, otherwise it returns false.
     */
    public boolean createEmployeeReceptionist(String name, String address, int phoneNumber, String email, String citizenCardIDNumber, String password, String username, String userID){
        this.em = this.company.createEmployeeReceptionist(name, address, phoneNumber, email, citizenCardIDNumber, password, username, userID);
        return this.company.validateEmployee(em);
    }

    /**
     * Create employee nurse boolean.
     *
     * @param name the name of the nurse
     * @param address the address of the nurse
     * @param phoneNumber the phone number of the nurse
     * @param email the email of the nurse
     * @param citizenCardIDNumber the citizen card id number of the nurse
     * @param password the password of the nurse
     * @param username the username of the nurse
     * @param userID the user id of the nurse
     * @return true if the employee exist in the employee list, otherwise it returns false.
     */
    public boolean createEmployeeNurse(String name, String address, int phoneNumber, String email, String citizenCardIDNumber, String password, String username, String userID){
        this.em = this.company.createEmployeeNurse(name, address, phoneNumber, email, citizenCardIDNumber, password, username, userID);
        return this.company.validateEmployee(em);
    }

    /**
     * Create employee adminstrator boolean.
     *
     * @param name the name of the adminstrator
     * @param address the address of the adminstrator
     * @param phoneNumber the phone number of the adminstrator
     * @param email the email of the adminstrator
     * @param citizenCardIDNumber the citizen card id number of the adminstrator
     * @param password the password of the adminstrator
     * @param username the username of the adminstrator
     * @param userID the user id of the adminstrator
     * @return true if the employee exist in the employee list, otherwise it returns false.
     */
    public boolean createEmployeeAdminstrator(String name, String address, int phoneNumber, String email, String citizenCardIDNumber, String password, String username, String userID){
        this.em = this.company.createEmployeeAdminstrator(name, address, phoneNumber, email, citizenCardIDNumber, password, username, userID);
        return this.company.validateEmployee(em);
    }

    /**
     * Create employee coordinator boolean.
     *
     * @param name the name of the coordinator
     * @param address the address of the coordinator
     * @param phoneNumber the phone number of the coordinator
     * @param email the email of the coordinator
     * @param citizenCardIDNumber the citizen card id number of the coordinator
     * @param password the password of the coordinator
     * @param username the username of the coordinator
     * @param userID the user id of the coordinator
     * @return true if the employee exist in the employee list, otherwise it returns false.
     */
    public boolean createEmployeeCoordinator(String name, String address, int phoneNumber, String email, String citizenCardIDNumber, String password, String username, String userID){
        this.em = this.company.createEmployeeCoordinator(name, address, phoneNumber, email, citizenCardIDNumber, password, username, userID);
        return this.company.validateEmployee(em);
    }

    /**
     * Save employee.
     *
     * @return true if employee is saved. False otherwise
     */
    public boolean saveEmployee() {
        return company.saveEmployee(em);
    }

    /**
     * List employee.
     */
    public void listEmployee() { this.company.listEmployee(); }

    /**
     * List receptionist.
     */

    public void listReceptionist() { this.company.listReceptionist(); }

    /**
     * List nurse.
     */

    public void listNurse() { this.company.listNurse();}

    /**
     * List administrator.
     */

    public void listAdministrator() { this.company.listAdministrator();}

    /**
     * List coordinator.
     */

    public void listCoordinator() { this.company.listCoordinator();}



}
