package app.ui.console;


import app.controller.ScheduleVaccineController;
import app.domain.model.ScheduleVaccine;
import app.ui.console.utils.Utils;

import java.util.Scanner;


public class ScheduleVaccineUI implements Runnable {

    private final ScheduleVaccineController ctrl;

    public ScheduleVaccineUI(){
        ctrl = new ScheduleVaccineController();
    }

    ScheduleVaccine newScheduleVaccine=null;


    /**
     * List Vaccine Type
     */
    //public void list(){ctrl.listVaccineType();    }

    @Override
    public void run() {
        boolean success = false;
        int snsUserNumber = 0;

        try{
            System.out.println("-----------------------------------");
            System.out.println("Request data");
            snsUserNumber = Utils.readIntegerFromConsole("Enter your SNS User: ");
           //success = ctrl.createScheduleVaccine
        }catch (IllegalArgumentException exception){
            new  ScheduleVaccineUI();
        }
        if (!success) {
            System.out.println("Invalid request data");
        }else{
            System.out.println("Check data:");
            System.out.println("SNS User: " + snsUserNumber );
            save();
        }
    }

    /**
     * List vaccine type.
     */
    /*public void listVaccineType() {
        company.listVaccinetype();
    }

     */

    public void save() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Confirm your appointment, please");
        System.out.println("1. Yes");
        System.out.println("2. NO");
        int optionSabe = myObj.nextInt();
        checkSave(optionSabe);

    }
    public void checkSave(int option){

   /*
        if (option != 1 && option != 2) {
            save();
        } else if (option == 1) {
            boolean successValidate = ctrl.saveScheduleVaccine();
            if (!successValidate) {
                System.out.println("Error saving.");
                new NewVaccineTypeUI();
            }else{
                System.out.println("Successfully saved.");
            }

    */
        }


}
