package app.ui.console.Show;

import app.controller.SpecifyNewEmployeeController;
import app.controller.VaccinationCenterController;
import app.domain.model.Company;

/**
 * Show employees
 */
public class ShowEmployee implements Runnable{

    /**
     * Specify new employee controller
     */
    private  final SpecifyNewEmployeeController ctrl;


    /**
     * Instantiates a new show employee.
     */
    public ShowEmployee(){
        ctrl = new SpecifyNewEmployeeController(new Company());
    }

    /**
     * run/show employee list
     */
    @Override
    public void run() {
        ctrl.listEmployee();
    }
}
