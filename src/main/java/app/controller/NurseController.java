package app.controller;

import app.domain.model.Company;
import app.domain.model.CompanyDGS;

public class NurseController {
    /**
     * Get an instance of the company
     */
    private static Company company;

    /**
     * Constructor Method that instantiates the company after checking if it's null
     */
    public NurseController(){
        if (company == null){
            company = App.getInstance().getCompany();
        }
    }

    /**
     * Get the list of the Vaccination Centers with their information
     */
    public void listOfVaccinationCenters(){
        company.listVaccinationCenter();
    }

    /**
     * Method that returns the size of the arraylist containing the Vaccination Centers
     * @return the number of vaccination centers on the arraylist
     */
    public int numberVaccinationCenter(){
        return company.numberVaccinationCenter();
    }

}
