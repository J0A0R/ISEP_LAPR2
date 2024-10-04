package app.ui.gui;

import app.controller.App;
import app.domain.model.Company;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class ExportDataGUISceneController {

    private final App app;
    private MenuCoodinatorGUISceneController menuUI;
    private static Company company;


    @FXML
    private Button returnButton;

    @FXML
    private Text sucessMessage;

    public ExportDataGUISceneController() {
        app = App.getInstance();
        if(company == null){
            company = App.getInstance().getCompany();
        }
        sucessMessage.setText("Data Sucessfully Exported");
    }

    @FXML
    void returnButtonAction(ActionEvent event) {
        Window window = returnButton.getScene().getWindow();
        window.fireEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST));
    }



    public void associarParentUI(MenuCoodinatorGUISceneController menuCoodinatorGUISceneController) {
        this.menuUI = menuCoodinatorGUISceneController;
    }

}
