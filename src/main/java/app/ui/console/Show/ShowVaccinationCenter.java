package app.ui.console.Show;

import app.controller.SpecifyNewEmployeeController;
import app.controller.VaccinationCenterController;
import app.domain.model.Company;
import app.domain.model.CompanyDGS;
import app.domain.model.VaccinationCenter;

public class ShowVaccinationCenter implements Runnable {


    /**
     * Specify new Vaccination Center controller
     */
    private  final VaccinationCenterController ctrl;


    /**
     * Instantiates a new ShowVaccinationCenter.
     */
    public ShowVaccinationCenter(){
        ctrl = new VaccinationCenterController();
    }

    /**
     * run/show VaccinationCenterList
     */
    @Override
    public void run() {
        ctrl.listVaccinationCenter();
    }
}
