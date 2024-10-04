package app.ui.console.Show;

import app.controller.ReceptionistController;
import app.controller.SpecifyNewEmployeeController;
import app.domain.model.Company;

public class ShowNewUserEntryUI implements Runnable{

    /**
     * Specify new Receptionist Controller
     */
    private  final ReceptionistController ctrl;

    public ShowNewUserEntryUI(){
        ctrl = new ReceptionistController();
    }

    @Override
    public void run() {
        ctrl.listAllUsersentry();
    }
}
