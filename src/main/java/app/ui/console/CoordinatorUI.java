package app.ui.console;

import app.ui.console.Menu.MenuItem;
import app.ui.console.Specify.SpecifyNewImportUI;
import app.ui.console.Specify.SpecifyNewUserEntryUI;
import app.ui.console.Specify.SpecifyNewVaccinationCenterUI;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class CoordinatorUI implements Runnable {
    @Override
    public void run() {
        {
            List<app.ui.console.Menu.MenuItem> options = new ArrayList<app.ui.console.Menu.MenuItem>();

            options.add(new MenuItem("Export data to csv file", new ExportToCsvUI()));


            int option = 0;
            do
            {
                option = Utils.showAndSelectIndex(options, "\n\nCoordinator Menu:");

                if ( (option >= 0) && (option < options.size()))
                {
                    options.get(option).run();
                }
            }
            while (option != -1 );
        }
    }
}
