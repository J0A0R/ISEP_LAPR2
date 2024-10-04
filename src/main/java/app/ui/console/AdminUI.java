package app.ui.console;

import app.ui.console.Menu.MenuItem;
import app.ui.console.Specify.*;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */

public class AdminUI implements Runnable{
    public AdminUI()
    {
    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Vaccine Type", new SpecifyNewVaccineTypeUI()));
        options.add(new MenuItem("Employee ", new SpecifyNewEmployeeUI()));
        options.add(new MenuItem("Vaccine", new SpecifyNewVaccineUI()));
        options.add(new MenuItem("Vaccination Center ", new SpecifyNewVaccinationCenterUI()));
        options.add(new MenuItem("Import CSV", new SpecifyNewImportUI()));
        options.add(new MenuItem("Register a User Entry", new SpecifyNewUserEntryUI()));
        options.add(new MenuItem("Export data to csv file", new ExportToCsvUI()));

        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
