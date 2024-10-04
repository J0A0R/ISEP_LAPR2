package app.controller;

import app.Vaccines.Vaccines;
import app.domain.model.Company;
import app.domain.model.FileUtils;

public class SpecifyNewVaccineAdministrationController {
    /**
     * Company
     */
    private Company company;
    Company c = new Company(1);
    /**
     * Instantiates a new import controller.
     */
    public SpecifyNewVaccineAdministrationController(){
        if (this.company == null)
            company = App.getInstance().getCompany();
        if (this.c == null)
            c = App.getInstance().getCompany();
    }

    /**
     * Instantiates a new import controller.
     *
     * @param company the CompanyDGS
     */
    public SpecifyNewVaccineAdministrationController(Company company) {
        this.company = company;
    }

    /**
     * List user entry.
     */
    public String listUserEntryList(){
        return company.listUserEntryList();
    }

    public String getLista() {
        return company.toString();
    }

    /**
     * User choice.
     * @param number User list position
     */
    public boolean AddchooseUserAndVaccine(int number, Vaccines.vacine vaccine, String lot, int dose) {
        return company.AddchooseUserAndVaccine(number, vaccine, lot, dose);
    }

    /**
     * import from vaccinated users list.
     * @param ficheiro file name
     */
    public void importarLista(String ficheiro) {
        c = FileUtils.ler(ficheiro);
    }

    /**
     * export from vaccinated users list.
     * @param ficheiro file name
     */
    public boolean exportarLista(String ficheiro) {
        return FileUtils.gravar(c, ficheiro);
    }
}
