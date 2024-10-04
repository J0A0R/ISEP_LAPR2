package app.ui.console.Specify;

import app.ui.console.Menu.MenuVaccinationCenter;
import app.ui.console.NewUserEntryUI;
import app.ui.console.NewVaccinationCenterUI;
import app.ui.console.Show.ShowNewUserEntryUI;
import app.ui.console.Show.ShowVaccinationCenter;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class SpecifyNewUserEntryUI implements Runnable{

    /**
     * Contructor for SpecifyNewUserEntryUI
     */
    public SpecifyNewUserEntryUI() {
    }

    /**
     * Method to run new SpecifyNewUserEntryUI
     */
    @Override
    public void run() {

        List<MenuVaccinationCenter> options = new ArrayList<>();
        options.add(new MenuVaccinationCenter("Register new userEntry", new NewUserEntryUI()));
        options.add(new MenuVaccinationCenter("List User Entries",new ShowNewUserEntryUI()));
        int option;

        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nUser Entry Menu");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
