package app.ui.console;

import app.ui.console.Menu.MenuItem;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class SNSUserUI implements Runnable {
    public SNSUserUI() {
    }

    @Override
    public void run() {
        List<app.ui.console.Menu.MenuItem> options = new ArrayList<app.ui.console.Menu.MenuItem>();
        options.add(new MenuItem("A", new SNSUserUI()));
        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nSNS User Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
