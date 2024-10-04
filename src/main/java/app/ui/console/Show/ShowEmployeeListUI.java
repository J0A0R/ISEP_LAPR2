package app.ui.console.Show;

import app.ui.console.Menu.MenuEmployee;
import app.ui.console.ShowReceptionistList;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Show employee list ui.
 */
public class ShowEmployeeListUI implements Runnable{

    /**
     * Instantiates a new show employee list.
     */
    public ShowEmployeeListUI(){
    }

    /**
     * Add and choose one of the menu options
     */
    @Override
    public void run() {
        List<MenuEmployee> options = new ArrayList<>();
        options.add(new MenuEmployee("Receptionists", new ShowReceptionistList()));
        options.add(new MenuEmployee("Nurses", new ShowNurseList()));
        options.add(new MenuEmployee("Coordinators", new ShowAdministratorList()));
        options.add(new MenuEmployee("Administrators", new ShowCoordinatorList()));

        int option = 0;

        do {
            option = Utils.showAndSelectIndex(options, "\n\nMenu");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        }
        while (option != -1);
    }
}
