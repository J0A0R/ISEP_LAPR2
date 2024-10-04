package app.ui.console.Specify;

import app.ui.console.Menu.MenuVaccinationCenter;
import app.ui.console.NewVaccinationCenterUI;
import app.ui.console.Show.ShowVaccinationCenter;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * UI to create a new VaccinationCenter
 */
public class SpecifyNewVaccinationCenterUI implements Runnable{

    /**
     * Contructor for SpecifyNewVaccinationCenterUI
     */
    public SpecifyNewVaccinationCenterUI() {
    }

    /**
     * Method to run new Vaccination Center UI
     */
    @Override
    public void run() {


        List<MenuVaccinationCenter> options = new ArrayList<>();
        options.add(new MenuVaccinationCenter("Create a new Vaccination Center", new NewVaccinationCenterUI()));
        options.add(new MenuVaccinationCenter("Show existing Vaccination Centers", new ShowVaccinationCenter()));
        int option;

        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nVaccination Center Menu");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }

}
