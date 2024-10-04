package app.ui.console;

import app.controller.SerializeController;
import app.domain.model.Serialize;
import app.ui.console.Menu.MenuItem;
import app.ui.console.utils.Utils;
import app.ui.gui.MainUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class MainMenuUI {

    public MainMenuUI()
    {
    }

    public void run() throws IOException
    {
        SerializeController sc = new SerializeController();
        sc.deserialize();
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Do Login", new AuthUI()));
        options.add(new MenuItem("Know the Development Team",new DevTeamUI()));
        options.add(new MenuItem("Grafic", new MainUI1()));
        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nMain Menu");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }


}
