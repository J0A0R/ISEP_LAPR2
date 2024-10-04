package app.controller;

import app.domain.model.Company;

public class SerializeController {

    private static Company company;


    public SerializeController(){
        if(company == null){
            company = App.getInstance().getCompany();
            company.deserializeVaccineAdministrations();
            company.deserializeUserEntry();
            company.deserializeVaccinationCenter();
            company.deserializeAdverseReactions();
        }
    }

    public void deserialize(){

    }

}
