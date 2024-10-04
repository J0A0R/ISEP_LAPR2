package app.ui.console;

import app.controller.SpecifyNewEmployeeController;
import app.domain.model.Company;

public class ShowReceptionistList implements Runnable{
    /**
     * Specify new employee controller
     */
    private  final SpecifyNewEmployeeController ctrl;

    public ShowReceptionistList(){
        ctrl = new SpecifyNewEmployeeController(new Company());
    }

    @Override
    public void run() {
        ctrl.listReceptionist();
    }
}
