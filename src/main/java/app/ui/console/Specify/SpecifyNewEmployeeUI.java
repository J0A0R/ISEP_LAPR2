package app.ui.console.Specify;

import app.ui.console.*;
import app.ui.console.Menu.MenuEmployee;
import app.ui.console.Show.*;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Specify new employee ui.
 */
public class SpecifyNewEmployeeUI implements Runnable{


    /**
     * Instantiates a new specify employee ui.
     */
    public SpecifyNewEmployeeUI(){

    }

    /**
     * Add and choose one of the menu options
     */
    @Override
    public void run() {
        List<MenuEmployee> options = new ArrayList<>();
        options.add(new MenuEmployee("Register a new employee", new NewEmployeeUI()));
        options.add(new MenuEmployee("Show existing employees", new ShowEmployee()));
        options.add(new MenuEmployee("Show list of receptionists", new ShowReceptionistList()));
        options.add(new MenuEmployee("Show list of nurses", new ShowNurseList()));
        options.add(new MenuEmployee("Show list of administrators", new ShowAdministratorList()));
        options.add(new MenuEmployee("Show list of coordinators", new ShowCoordinatorList()));


        int option = 0;

        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nMenu");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
