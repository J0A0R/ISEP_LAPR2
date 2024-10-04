package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class SpecifyNewVaccineTypeUI implements Runnable{
    public SpecifyNewVaccineTypeUI() {

    }

    @Override
    public void run() {
        List<MenuVaccineType> options = new ArrayList<>();
        options.add(new MenuVaccineType("Specifying a new vaccine type", new NewVaccineTypeUI()));
        options.add(new MenuVaccineType("Show existing vaccine types", new ShowVaccineType()));
        int option ;

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
