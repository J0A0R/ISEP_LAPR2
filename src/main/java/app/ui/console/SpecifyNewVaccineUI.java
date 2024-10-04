package app.ui.console;

import app.AgeGroup.AgeGroup;
import app.controller.SpecifyNewVaccineController;
import app.ui.console.utils.Utils;

import java.util.Scanner;

public class SpecifyNewVaccineUI implements Runnable{

    private  final SpecifyNewVaccineController ctrl;

    /**
     * Instantiates a new Specify vaccine ui.
     */
    public SpecifyNewVaccineUI() {
        ctrl = new SpecifyNewVaccineController();
    }


    @Override
    public void run() {
        ctrl.listVaccineType2();
        String name;
        String brand;
        String dosages;
        int number, age;
        Scanner myObj = new Scanner(System.in);
        do {
            System.out.println("Choose the vaccine type number.");
            number = myObj.nextInt();
        }while (number<=0 || number> ctrl.numberVaccineType());
        try {
            name = Utils.readLineFromConsole("Enter name: ");
            brand = Utils.readLineFromConsole("Enter brand: ");
            do {
                System.out.println("Choose age group.");
                System.out.println("1) Child [5-12]");
                System.out.println("2) Younger [13-18]");
                System.out.println("3) Adult, +18");
                age = myObj.nextInt();
            }while (age<1 && age>3);
            dosages = Utils.readLineFromConsole("Enter dosages: ");
            System.out.println("Enter the number of doses");
            double numberDoses = myObj.nextDouble();
            if(age==1){
                ctrl.createVaccine(number,name,brand,numberDoses,dosages, AgeGroup.age.CHILD);
            }else if(age ==2){
                ctrl.createVaccine(number,name,brand,numberDoses,dosages, AgeGroup.age.YOUNG);
            }else
                ctrl.createVaccine(number,name,brand,numberDoses,dosages, AgeGroup.age.ADULT);
        }catch (IllegalArgumentException exception){
            new SpecifyNewVaccineUI();
        }
        save();
        ctrl.listVaccine();
    }

    /**
     * Menu to save a new vaccine type
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
     * Checks if the chosen option is valid
     * @param option menu option to save
     */
    public void checkSave(int option){
        if (option != 1 && option != 2) {
            save();
        } else if (option == 1) {
            boolean successValidate = ctrl.saveVaccine();
            if (!successValidate) {
                System.out.println("Error saving.");
                new SpecifyNewVaccineUI();
            }else{
                System.out.println("Successfully saved.");
            }
        }
    }
}
