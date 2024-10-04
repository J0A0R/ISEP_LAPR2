package app.ui.console;

import app.controller.SpecifyNewImportController;
import app.ui.console.utils.Utils;

public class NewImportUI implements Runnable {

    private final SpecifyNewImportController ctrl;

    /**
     * Instantiates new import users ui.
     */
    public NewImportUI(){
        ctrl = new SpecifyNewImportController();
    }

    /**
     * Perform user import
     */
    @Override
    public void run(){

        String path = Utils.readLineFromConsole("Enter path: ");
        try {
            ctrl.importFile(path);
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
