package app.ui.console.Show;

import app.controller.App;
import app.controller.VaccinationCenterController;
import app.domain.model.Company;

import java.util.Scanner;

public class ShowWaitingRoomList implements Runnable{

    /**
     * Instanciate VaccinationCenterController
     */
    private final VaccinationCenterController ctrl;
    /**
     * Instanciate Company
     */
    private static Company company;

    /**
     * Constructor Method that instanciates the Controller and checks if Company is null and gets an instance of it
     */
    public ShowWaitingRoomList(){
        ctrl = new VaccinationCenterController();
        if(company == null)
            company =App.getInstance().getCompany();
    }

    /**
     *Show Vaccination Center List, choose a vaccination center, get the list of users on the waiting room of that Vaccination Center and order it.
     */
    @Override
    public void run() {
        ctrl.showVaccinationCenterList();
        String centerName;
        int cont=0;
        boolean check;
        Scanner myObj = new Scanner(System.in);
        do {
            System.out.println("Insert the Vaccination Center name:");
            centerName = myObj.nextLine();
            cont++;
            check = ctrl.checkVaccinationCenter(centerName);
        }while (check == false && cont < 3 );

        if(check == true){
            ctrl.orderUserEntryList(centerName);
        }



    }

}
