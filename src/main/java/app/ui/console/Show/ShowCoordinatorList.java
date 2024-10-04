package app.ui.console.Show;

import app.controller.SpecifyNewEmployeeController;
import app.controller.VaccinationCenterController;
import app.domain.model.Company;

public class ShowCoordinatorList implements Runnable {
    /**
     * Specify new employee controller
     */
    private  final SpecifyNewEmployeeController ctrl;

    public ShowCoordinatorList(){
        ctrl = new SpecifyNewEmployeeController(new Company());
    }

    @Override
    public void run() {
        ctrl.listCoordinator();
    }
}