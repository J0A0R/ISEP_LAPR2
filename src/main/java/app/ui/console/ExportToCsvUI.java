package app.ui.console;

import app.controller.ExportToCsvController;

public class ExportToCsvUI implements Runnable {

    ExportToCsvController ctrl = new ExportToCsvController();

    @Override
    public void run() {

        System.out.println("Data is Being Exported");

        try {
            ctrl.exportFilesToCSV();
            System.out.println("Exported Successfully");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
