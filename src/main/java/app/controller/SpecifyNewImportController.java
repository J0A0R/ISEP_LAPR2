package app.controller;

import app.domain.model.Company;

/**
 * Specify new Import Controller
 */
public class SpecifyNewImportController {

    /**
     * Company
     */
    private static Company company;

    /**
     * Instantiates a new import controller.
     */
    public SpecifyNewImportController(){
        if (company == null)
            company = new Company();
    }

    /**
     * Instantiates a new import controller.
     *
     * @param company the CompanyDGS
     */
    public SpecifyNewImportController(Company company) {
        this.company = company;
    }

    /**
     * List users.
     */
    public void listUser(){
        company.listImportUser();
    }

    /**
     * Import CSV file.
     *
     * @param path CSV file path
     */
    public void importFile(String path){
        company.importFile(path);
    }
}
