package app.ui.gui;

import app.controller.App;
import app.domain.model.Company;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

public class AdverseReactionsController {

    private final App app;

    private MenuNurseGUISceneController menuUI;

    private static Company company;

    public AdverseReactionsController(){
        app = App.getInstance();
        if(company == null){
            company = App.getInstance().getCompany();
        }
    }

    @FXML
    private TextArea adversereactions;

    @FXML
    private Button btnCheckUser;

    @FXML
    private Button btnCheckVacc;

    @FXML
    private Button btnInsert;

    @FXML
    private TextField snsnumber;

    @FXML
    private Label wrongUser;

    @FXML
    private Label wrongVaccination;

    @FXML
    void checkUserExistence(ActionEvent event) {
        String user = snsnumber.getText();
        int user1 = Integer.parseInt(user);
        company.checkUserExistence(user1);
        if(company.checkUserExistence(user1)){
            wrongUser.setText("User Found!");
        }

        else if (snsnumber.getText().isEmpty()){
            wrongUser.setText("Please insert a SNS User Number!");
        }

        else {
            wrongUser.setText ("Please insert a valid SNS User!");
        }
    }

    @FXML
    void checkUserVaccination(ActionEvent event) {
        String user = snsnumber.getText();
        int user1 = Integer.parseInt(user);
        company.checkUserExistence(user1);
        if(company.checkUserExistence(user1)){
            wrongUser.setText("User Vaccinated!");
        }

        else if (snsnumber.getText().isEmpty()){
            wrongUser.setText("Please insert a SNS User Number!");
        }

        else {
            wrongUser.setText ("User not Vaccinated!");
        }

    }

    @FXML
    void insertReactions(ActionEvent event) {
        String reactions = adversereactions.getText();
        String user = snsnumber.getText();
        int user1 = Integer.parseInt(user);
        if (company.checkUserExistence(user1)) {
            if (reactions.length() < 300) {
                company.addAdverseReactions(user1, reactions);
                wrongVaccination.setText("Adverse Reactions Registered!");
            } else {
                wrongVaccination.setText("Adverse Reactions cannot have more than 300 characters!");
            }

        }
        if(reactions.isEmpty()){
            wrongVaccination.setText("Please insert text in Adverse Reactions!");
        }
    }


    public void associarParentUI(MenuNurseGUISceneController menuNurseGUISceneController) {
        this.menuUI = menuNurseGUISceneController;
    }

    @FXML
    void buttonReturn(ActionEvent event) {
        Window window = btnReturn.getScene().getWindow();
        window.fireEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    @FXML
    private Button btnReturn;



}


