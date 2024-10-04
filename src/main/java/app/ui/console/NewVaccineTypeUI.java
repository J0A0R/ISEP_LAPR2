package app.ui.console;

import app.controller.SpecifyNewVaccineController;
import app.ui.console.utils.Utils;

import java.util.Scanner;

/**
 * IU of the new type of vaccine
 */
public class NewVaccineTypeUI implements Runnable{

    /**
     * Specify new vaccine controller
     */
    private final SpecifyNewVaccineController ctrl;

    /**
     * Instantiates a new vaccine type ui.
     */
    public NewVaccineTypeUI(){
        ctrl = new SpecifyNewVaccineController();
    }

    /**
     * Run vaccine type creation.
     */
    @Override
    public void run() {
        boolean success = false;
        String code = null;
        String designation = null;
        String whoID = null;
        try{
        System.out.println("-----------------------------------");
        System.out.println("Request data");
        code = Utils.readLineFromConsole("Enter code: ");
        designation = Utils.readLineFromConsole("Enter designation: ");
        whoID = Utils.readLineFromConsole("Enter whoID");
        success = ctrl.createVaccineType(code, designation, whoID);
        }catch (IllegalArgumentException exception){
            new NewVaccineTypeUI();
        }
        if (!success) {
            System.out.println("Invalid request data");
        }else{
            System.out.println("Check data:");
            System.out.println("Code: " + code + ", designation: " + designation + ", whowID: " +whoID);
            save();
        }
    }

    /**
     * Save menu, shows options.
     */
    public void save(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Do you want to save?");
        System.out.println("1. Yes");
        System.out.println("2. NO");
        int optionSabe = myObj.nextInt();
        checkSave(optionSabe);
    }

    /**
     * Checks if the option is valid and saves the type of vaccine if there is no error.
     * @param option option you want to save
     */
    public void checkSave(int option){
        if (option != 1 && option != 2) {
            save();
        } else if (option == 1) {
            boolean successValidate = ctrl.saveVaccineType();
            if (!successValidate) {
                System.out.println("Error saving.");
                new NewVaccineTypeUI();
            }else{
                System.out.println("Successfully saved.");
            }
        }
    }

    /**
     * List Vaccine Type
     */
    public void list(){
        ctrl.listVaccineType();
    }
}
