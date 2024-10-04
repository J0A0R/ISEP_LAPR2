package app.controller;

import app.domain.model.*;

import java.util.Scanner;

public class VaccinationCenterController {

    /**
     * Company
     */
    private static Company company;



    /**
     * Constructor
     * Instantiates a new center controller.
     */
    public VaccinationCenterController(){
        if (company == null)
            company = App.getInstance().getCompany();
    }

    /**
     * Constructor
     * Instantiates a new vaccination center controller.
     *
     * @param company the company
     */
    public VaccinationCenterController(Company company) {
        this.company = company;
    }


    /**
     * Method that creates a new Vaccination Center and returns it
     * @param name name of vaccination center
     * @param phone phone number of vaccination center
     * @param adress address of vacinnation center
     * @param mail e-mail address of vaccination center
     * @param fax fax of the vaccination center
     * @param website website of vaccination center
     * @param opening_hours time that the vaccination center opens
     * @param closing_hours time that the vaccination center closes
     * @param slot_duration duration of slot
     * @param max_number_person_per_slot max number of persons per slot
     * @return The new Vaccination Center Created
     */
    public VaccinationCenter RegisterVaccinationCenter(String name,int phone, String adress, String mail, int fax, String website,int opening_hours,int closing_hours,int slot_duration,int max_number_person_per_slot){


        return this.company.createVaccinationCenter(name,phone,adress,mail,fax,website,opening_hours,closing_hours,slot_duration,max_number_person_per_slot);

    }



    /**
     * Save center.
     *
     * @return true if center is saved. False otherwise
     */
    public boolean saveVaccinationCenter(VaccinationCenter center) {
        return this.company.saveVaccinationCenter(center);
    }

    public VaccinationCenter getVaccinationCenterByName(String name){

        try{
            for(VaccinationCenter center : this.company.getVaccinationCenterList()){
                if(center.getName().equals(name)){
                    return center;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * List V.
     */
    public void listVaccinationCenter(){
        this.company.listVaccinationCenter();
    }


    /**
     * Show the Vaccination Centers information on the Arraylist
     */
    public void showVaccinationCenterList(){
        company.printVaccinationCenterList();

    }

    /**
     * Method that verifies the size of the Vaccination Center Arraylist to check how many are registered
     * @return size of the arraylist containing the Vaccination Centers
     */
    public int numberVaccinationCenter() {
        return company.numberVaccinationCenter();
    }

    /**
     * Calls the method that orders the Arraylist containing the users in the Waiting Room
     * @param centerName - Vaccination Center name
     */
    public void orderUserEntryList(String centerName){
        company.orderUserEntryList(centerName);
    }

    /**
     * Checks whether a Vaccination Center exists or not using it's name
     * @param centerName - Vaccination Center name
     * @return true if Vaccination Center exists or false if not
     */
    public boolean checkVaccinationCenter(String centerName){
        return company.checkVaccinationCenterExistence(centerName);
    }


}

