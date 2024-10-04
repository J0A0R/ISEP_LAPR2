package app.ui.console;

import app.controller.SpecifyNewEmployeeController;
import app.controller.VaccinationCenterController;
import app.ui.console.utils.Utils;

import java.util.Objects;
import java.util.Scanner;

/**
 * The type New employee ui.
 */
public class NewEmployeeUI implements Runnable{

    /**
     * Specify new employee controller
     */
    private final SpecifyNewEmployeeController ctrl;

    /**
     * Instantiates new employee ui.
     */
    public NewEmployeeUI(){
        ctrl = new SpecifyNewEmployeeController();
    }

    /**
     * Run employee creation.
     */
    @Override
    public void run() {
        boolean success;
        String name;
        String address;
        int phoneNumber;
        String email;
        String citizenCardIDNumber;
        String password;
        String username;
        String userID;
        int option;
        do {
            Scanner myObj = new Scanner(System.in);
            System.out.println("Choose the type of employee.");
            System.out.println("1. Receptionist");
            System.out.println("2. Nurse");
            System.out.println("3. Adminstrator");
            System.out.println("4. Coordinator");
            option = myObj.nextInt();
        }while (option != 1 && option != 2 && option != 3 && option != 4);
        System.out.println("-----------------------------------");
        System.out.println("Request data");
        name = Utils.readLineFromConsole("Enter name: ");
        citizenCardIDNumber = Utils.readLineFromConsole("Enter citizen card ID number: ");
        address = Utils.readLineFromConsole("Enter address: ");
        email = Utils.readLineFromConsole("Enter email: ");
        phoneNumber = Integer.parseInt(Objects.requireNonNull(Utils.readLineFromConsole("Enter phoneNumber: ")));
        username = Utils.readLineFromConsole("Enter username: ");
        userID = Utils.readLineFromConsole("Enter userID: ");
        password = Utils.readLineFromConsole("Enter password: ");
        success = chooseEmployee(option, name, address, phoneNumber,email,citizenCardIDNumber,password,username,userID);
        if (!success) {
            System.out.println("Invalid request data");
        }else{
            System.out.println("Check data:");
            System.out.println("Name: " + name + ", Citizen Card ID Number: " + citizenCardIDNumber + "\n" +
                    "Address: " + address + ", Email: " + email+ ", Phone Number: " + phoneNumber + "\n" +
                    "User name: " + username + ", User ID: " + userID + ", Password: " +password);
            save();
        }
    }

    /**
     * Depending on the type of employee a new employee is created
     * @param option employee type option
     * @param name employer's name
     * @param address employer's name
     * @param phoneNumber employer's name
     * @param email employer's name
     * @param citizenCardIDNumber employer's name
     * @param password employer's name
     * @param username employer's name
     * @param userID employer's name
     * @return true if employee is created, otherwise false.
     */
    private boolean chooseEmployee(int option, String name, String address, int phoneNumber, String email, String citizenCardIDNumber, String password, String username, String userID){
        boolean success = false;
        if (option == 1) {
            try{
                success = ctrl.createEmployeeReceptionist(name, address, phoneNumber,email,citizenCardIDNumber,password,username,userID);
            }catch (IllegalArgumentException exception){
                new NewVaccineTypeUI();
            }
        } else if (option ==2) {
            try{
                success = ctrl.createEmployeeNurse(name, address, phoneNumber,email,citizenCardIDNumber,password,username,userID);
            }catch (IllegalArgumentException exception){
                new NewVaccineTypeUI();
            }
        }else if (option ==3){
            try{
                success = ctrl.createEmployeeAdminstrator(name, address, phoneNumber,email,citizenCardIDNumber,password,username,userID);
            }catch (IllegalArgumentException exception){
                new NewVaccineTypeUI();
            }
        }else{
            try{
                success = ctrl.createEmployeeCoordinator(name, address, phoneNumber,email,citizenCardIDNumber,password,username,userID);
            }catch (IllegalArgumentException exception){
                new NewVaccineTypeUI();
            }
        }
        return success;
    }

    /**
     * Menu to save a new employee
     */
    private void save(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Do you want to save?");
        System.out.println("1. Yes");
        System.out.println("2. NO");
        int optionSabe = myObj.nextInt();
        checkSave(optionSabe);
    }

    /**
     * Checks if the chosen option is valid
     * @param option menu option to save
     */
    private void checkSave(int option){
        if (option != 1 && option != 2) {
            save();
        } else if (option == 1) {
            boolean successValidate = ctrl.saveEmployee();
            if (!successValidate) {
                System.out.println("Error saving.");
                new NewEmployeeUI();
            }else{
                System.out.println("Successfully saved.");
            }
        }
    }
}
