package app.ui.console;

import app.controller.SpecifyNewVaccineController;
import app.domain.model.CompanyDGS;

public class ShowVaccineType implements Runnable{

    private  final SpecifyNewVaccineController ctrl;

    public ShowVaccineType(){
        ctrl = new SpecifyNewVaccineController(new CompanyDGS());
    }

    @Override
    public void run() {
        ctrl.listVaccineType();
    }
}
