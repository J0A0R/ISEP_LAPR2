package app.ui.console;

import app.controller.ReceptionistController;
import app.controller.VaccinationCenterController;
import app.domain.model.User;
import app.domain.model.UserEntry;
import app.domain.model.VaccinationCenter;
import app.ui.console.utils.Utils;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Scanner;

public class NewUserEntryUI implements Runnable{

    /**
     * Specify new ReceptionistController
     */
    private static ReceptionistController ctrl;

    private  static VaccinationCenterController vaccinationCenterController;

    /**
     * Instantiates a NewUserEntryUI
     */
    public NewUserEntryUI(){
        if( ctrl== null)
            ctrl = new ReceptionistController();
        if(vaccinationCenterController==null)
            vaccinationCenterController = new VaccinationCenterController();
    }

    private User user;
    private VaccinationCenter center;

    /**
     * Run new user entrty creation.
     */
    @Override
    public void run() {
        String centerName;
        String name = null;
        String sex = null;
        String birthday= null;
        String address = null;
        int phoneNumber = 0;
        String email = null;
        int snsNumber = 0;
        int citezenCardNumber = 0;

        try{
            System.out.println("-----------------------------------");
            System.out.println("Request data");

            centerName = Utils.readLineFromConsole("Enter Vaccination Center name: ");

            System.out.println("Enter User Information:");
            name = Utils.readLineFromConsole("Enter name: ");
            phoneNumber = Integer.parseInt(Objects.requireNonNull(Utils.readLineFromConsole("Enter phone: ")));
            address = Utils.readLineFromConsole("Enter address: ");
            email = Utils.readLineFromConsole("Enter e-mail address: ");
            birthday = Utils.readLineFromConsole("Enter birthday: ");
            sex = Utils.readLineFromConsole("Enter sex: ");
            snsNumber = Integer.parseInt(Objects.requireNonNull(Utils.readLineFromConsole("Enter sns Number: ")));
            citezenCardNumber = Integer.parseInt(Objects.requireNonNull(Utils.readLineFromConsole("Enter citezen Card Number: ")));

            center = vaccinationCenterController.getVaccinationCenterByName(centerName);

            user = new User(name,sex,birthday,address,phoneNumber,email,snsNumber,citezenCardNumber);

        }catch (IllegalArgumentException exception){
            exception.printStackTrace();
        }
        System.out.println("Check data:");
        System.out.println("Name:"+user.getName()+"\nPhoneNumber:"+phoneNumber+"\nAddress:"+address+"\ne-mail:"+email+"\nbirthday:"+birthday+"\nsex:"+sex+"\nsnsNumber:"+snsNumber+"\ncitezenCardNumber:"+citezenCardNumber);
        save();
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
     *
     * @param option option you want to save
     */
    public void checkSave(int option){
        if (option != 1 && option != 2) {
            save();
        } else if (option == 1) {
            boolean successValidate = ctrl.registerUserArrival(user,center);
            if (!successValidate) {
                System.out.println("Error saving.");
                new NewVaccinationCenterUI();
            }else{
                System.out.println("Successfully saved.");
            }
        }
    }
}
