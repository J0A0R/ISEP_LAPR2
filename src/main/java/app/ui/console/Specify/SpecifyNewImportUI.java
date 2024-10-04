package app.ui.console.Specify;

import app.ui.console.Menu.MenuImport;
import app.ui.console.NewImportUI;
import app.ui.console.Show.ShowImport;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class SpecifyNewImportUI implements Runnable {

    /**
     * Instantiates a new specify import ui.
     */
    public SpecifyNewImportUI() {
    }

    @Override
    public void run() {
        List<MenuImport> options = new ArrayList<>();
        options.add(new MenuImport("Import CSV file", new NewImportUI()));
        options.add(new MenuImport("Show users", new ShowImport()));
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
