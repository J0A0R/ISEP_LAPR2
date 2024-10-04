package app.ui.console;

import app.ui.console.Menu.MenuItem;
import app.ui.console.Show.ShowAdministerVaccine;
import app.ui.console.Show.ShowWaitingRoomList;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class NurseUI implements Runnable{

    /**
     * Constructor Method
     */
    public NurseUI (){

    }

    /**
     * Nurse Menu
     */
    @Override
    public void run() {

        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Choose Working Vaccination Center and Show Waiting List ordered:", new ShowWaitingRoomList()));
        options.add(new MenuItem("Administer vaccine", new ShowAdministerVaccine()));
        options.add(new MenuItem("Register Adverse Reactions", new AdverseReactionsUI()));
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
