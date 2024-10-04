package app.controller;

import app.domain.model.Company;
import app.domain.model.User;
import app.domain.model.UserEntry;
import app.domain.model.VaccinationCenter;

public class ReceptionistController {

    /**
     * Company
     */
    private static Company company;


    /**
     * Constructor
     * Instaciates a new ReceptionistController
     */
    public ReceptionistController(){
        if(company == null)
            company = App.getInstance().getCompany();
    }

    /**
     * Constructor
     * Instaciates a new ReceptionistController
     */
    public ReceptionistController(Company company){
       this.company=company;
    }

    public boolean registerUserArrival(User user, VaccinationCenter center){

        try{
            this.company.registerNewUserArrival(user,center);
            this.company.createVaccinationCenter(center.getName(),center.getPhone(),center.getAddress2(),center.getMail(),center.getFax(),center.getWebsite(),center.getOpening_hours(),center.getClosing_hours(),center.getSlot_duration(),center.getMax_number_per_slot());

            return true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public void listAllUsersentry(){
        this.company.listAllUsersEntry();
    }


}
