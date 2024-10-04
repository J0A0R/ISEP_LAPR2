package app.controller;

import app.AgeGroup.AgeGroup;
import app.domain.model.CompanyDGS;
import app.domain.model.Vaccine;
import app.domain.model.VaccineType;

/**
 * Specify new vaccine controller.
 */
public class SpecifyNewVaccineController {

    /**
     * CompanyDGS
     */
    private  static CompanyDGS company;

    /**
     * Vaccine Type
     */
    private VaccineType vt;
    private Vaccine v;

    /**
     * Instantiates a new vaccine controller.
     */
    public SpecifyNewVaccineController() {
        if (company == null){
            company = new CompanyDGS();
        }
    }

    /**
     * Instantiates a new vaccine controller.
     *
     * @param company the companyDGS
     */
    public SpecifyNewVaccineController(CompanyDGS company) {
        this.company = company;
        this.vt = null;
        this.v = null;
    }

    /**
     * Create vaccine type boolean.
     *
     * @param code vaccine type the code
     * @param designation the designation of the type of vaccines
     * @param whoId the who id of the type of vaccines
     * @return true if the vaccine type exist in the vaccine list, otherwise it returns false.
     */
    public boolean createVaccineType(String code, String designation, String whoId) {
        this.vt = this.company.createVaccineType(code, designation, whoId);
        return this.company.validateVaccineType(vt);
    }

    /**
     * Save vaccine type boolean.
     *
     * @return true if type of vaccines is saved, otherwise false.
     */
    public boolean saveVaccineType() {
        return this.company.saveVaccineType(vt);
    }

    /**
     * List vaccine type.
     */
    public void listVaccineType(){
        company.listVaccineType();
    }

    /**
     * create vaccine
     * @param number the vaccine number
     * @param name the name
     * @param brand the brand
     * @return true if vaccine is validate and create. False otherwise
     */

    public boolean createVaccine(int number, String name, String brand, Double numberDoses, String dosages, AgeGroup.age age) {
        this.v = this.company.createVaccine(number-1,  name,  brand,  numberDoses,  dosages, age);
        return this.company.validateVaccine(v);
    }

    /**
     * save vaccine
     * @return true if vaccine is saved. False otherwise
     */
    public boolean saveVaccine() {
        return this.company.saveVaccine(v);
    }

    /**
     * List vaccine.
     */
    public void listVaccine(){
        company.listVaccine();
    }

    /**
     * List vaccine type.
     */
    public void listVaccineType2() {
        company.listVaccinetype2();
    }

    /**
     * Number of vaccine type
     */

    public int numberVaccineType(){
        return company.numberVaccineType();
    }
}
