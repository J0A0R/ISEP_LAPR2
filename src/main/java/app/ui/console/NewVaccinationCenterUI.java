package app.ui.console;

import app.controller.App;
import app.controller.VaccinationCenterController;
import app.domain.model.VaccinationCenter;
import app.ui.console.utils.Utils;

import java.util.Objects;
import java.util.Scanner;

public class NewVaccinationCenterUI implements Runnable {

    /**
     * Specify new vaccine controller
     */
    private final VaccinationCenterController ctrl;

    /**
     * Instantiates a new vaccine type ui.
     */
    public NewVaccinationCenterUI(){
        ctrl = new VaccinationCenterController(App.getInstance().getCompany());
    }

    VaccinationCenter newVaccinationCenter;

    /**
     * Run vaccine type creation.
     */
    @Override
    public void run() {
        boolean success = false;
        String name = null;
        int fax = 0;
        int phone= 0;
        String address = null;
        String mail = null;
        String website = null;
        int opening_hours = 0;
        int closing_hours = 0;
        int slot_duration = 0;
        int max_number_per_slot = 0;


        try{
            System.out.println("-----------------------------------");
            System.out.println("Request data");
            name = Utils.readLineFromConsole("Enter name: ");
            phone = Integer.parseInt(Objects.requireNonNull(Utils.readLineFromConsole("Enter phone: ")));
            address = Utils.readLineFromConsole("Enter address: ");
            mail = Utils.readLineFromConsole("Enter e-mail address: ");
            website = Utils.readLineFromConsole("Enter website: ");
            fax = Integer.parseInt(Objects.requireNonNull(Utils.readLineFromConsole("Enter fax: ")));
            opening_hours = Integer.parseInt(Objects.requireNonNull(Utils.readLineFromConsole("Enter opening hours: ")));
            closing_hours = Integer.parseInt(Objects.requireNonNull(Utils.readLineFromConsole("Enter closing hours: ")));
            slot_duration = Integer.parseInt(Objects.requireNonNull(Utils.readLineFromConsole("Enter slot duration: ")));
            max_number_per_slot = Integer.parseInt(Objects.requireNonNull(Utils.readLineFromConsole("Enter max number per slot: ")));
            newVaccinationCenter = new VaccinationCenter(name,address,phone,mail,fax,website,opening_hours,closing_hours,slot_duration,max_number_per_slot);
        }catch (IllegalArgumentException exception){
            System.out.println(exception);
        }
        if (newVaccinationCenter.equals(null)) {
            System.out.println("Invalid  data");
        }else{
            System.out.println("Check data:");
            System.out.println(newVaccinationCenter);
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
            boolean successValidate = ctrl.saveVaccinationCenter(newVaccinationCenter);
            if (!successValidate) {
                System.out.println("Error saving.");
                new NewVaccinationCenterUI();
            }else{
                System.out.println("Successfully saved.");
            }
        }
    }

    /**
     * List Vaccine Type
     */
    public void list(){
        ctrl.listVaccinationCenter();
    }
}
