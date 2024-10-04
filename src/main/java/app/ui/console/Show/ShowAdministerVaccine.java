package app.ui.console.Show;

import app.Vaccines.Vaccines;
import app.controller.SpecifyNewVaccineAdministrationController;

import java.util.Scanner;

public class ShowAdministerVaccine implements Runnable {

    private final SpecifyNewVaccineAdministrationController ctrl;

    /**
     * Instantiates new import users ui.
     */
    public ShowAdministerVaccine(){
        ctrl = new SpecifyNewVaccineAdministrationController();
    }
    @Override
    public void run() {
        int number, vaccine, dose;
        String lote;
        String adverseReactions = "";
        ctrl.listUserEntryList();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user number: ");
        number = sc.nextInt();
        System.out.println("1) BioNtech");
        System.out.println("2) Joshon");
        System.out.println("3) Moderna");
        System.out.println("4) Novavax");
        System.out.println("5) Oxford");
        System.out.println("Enter vaccine number: ");
        vaccine = sc.nextInt();
        System.out.println("Enter dose number: ");
        dose = sc.nextInt();
        System.out.println("Enter lote: ");
        lote = sc.next();

        if (vaccine == 1)
            ctrl.AddchooseUserAndVaccine(number, Vaccines.vacine.BioNtech,lote,number);
        else if (vaccine == 2)
            ctrl.AddchooseUserAndVaccine(number, Vaccines.vacine.Joshon,lote,number);
        else if (vaccine == 3)
            ctrl.AddchooseUserAndVaccine(number, Vaccines.vacine.Moderna,lote,number);
        else if (vaccine == 4)
            ctrl.AddchooseUserAndVaccine(number, Vaccines.vacine.Novavax,lote,number);
        else
            ctrl.AddchooseUserAndVaccine(number, Vaccines.vacine.Oxford,lote,number);
    }
}
