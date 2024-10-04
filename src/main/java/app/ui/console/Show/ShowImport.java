package app.ui.console.Show;

import app.controller.SpecifyNewImportController;

public class ShowImport implements Runnable {
    private final SpecifyNewImportController ctrl;

    /**
     * Instantiates new show users.
     */
    public ShowImport(){
        ctrl = new SpecifyNewImportController();
    }

    /**
     * Show users list.
     */
    @Override
    public void run(){
        ctrl.listUser();
    }
}
