package app.ui.console.Show;

import app.controller.SpecifyNewVaccineController;
import app.domain.model.CompanyDGS;

/**
 * Show Vaccine Type
 */
public class ShowVaccineType implements Runnable{

    /**
     * Specify new vaccine controller
     */
    private  final SpecifyNewVaccineController ctrl;

    /**
     * Instantiates a new show vaccine type.
     */
    public ShowVaccineType(){
        ctrl = new SpecifyNewVaccineController(new CompanyDGS());
    }

    /**
     * run/show vaccine list
     */
    @Override
    public void run() {
        ctrl.listVaccineType();
    }
}
