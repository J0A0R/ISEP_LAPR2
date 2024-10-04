package app.ui.console;

import app.controller.AdverseReactionsController;
import app.ui.console.utils.Utils;

import java.util.Scanner;

public class AdverseReactionsUI implements Runnable {

    /**
     * Create the controller instance
     */
    private final AdverseReactionsController ctrl;

    /**
     * Instantiate the controller
     */
    public AdverseReactionsUI(){
        ctrl = new AdverseReactionsController();
    }


    /**
     * Adverse Reactions Menu
     */
    @Override
    public void run() {
        int snsnumber;
        boolean check = false;
        System.out.println("Insert SNS User number: ");
        Scanner scanner = new Scanner(System.in);
        snsnumber = scanner.nextInt();
        check = ctrl.checkUserExistence(snsnumber);
        String adverseReactions = "";
        if (check == true){
            do{
                adverseReactions = Utils.readLineFromConsole("Adverse Reactions: ");
                if (adverseReactions.length() > 300){
                    System.out.println("The text can not have more than 300 characters!");
                }
            }while(adverseReactions.length() >300);
        }
        ctrl.addAdverseReactions(snsnumber,adverseReactions);

    }
}
