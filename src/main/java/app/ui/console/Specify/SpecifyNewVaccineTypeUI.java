package app.ui.console.Specify;

import app.ui.console.Menu.MenuVaccineType;
import app.ui.console.NewVaccineTypeUI;
import app.ui.console.Show.ShowVaccineType;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Specify new vaccine type ui.
 */
public class SpecifyNewVaccineTypeUI implements Runnable{


    /**
     * Instantiates a new Specify vaccine type ui.
     */
    public SpecifyNewVaccineTypeUI() {

    }

    /**
     * Add and choose one of the menu options
     */
    @Override
    public void run() {
        List<MenuVaccineType> options = new ArrayList<>();
        options.add(new MenuVaccineType("Specify a new vaccine type", new NewVaccineTypeUI()));
        options.add(new MenuVaccineType("Show existing vaccine types", new ShowVaccineType()));
        int option;

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
