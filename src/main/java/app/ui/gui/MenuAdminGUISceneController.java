package app.ui.gui;

import app.controller.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuAdminGUISceneController implements Initializable {
    private MainMenuGUISceneController menuUI;
    private App app;
public MenuAdminGUISceneController(){
    this.app=App.getInstance();
}
    @Override
    public void initialize(URL url, ResourceBundle rb){
    }
    public void associarParentUI(MainMenuGUISceneController mainMenuGUISceneController) {
        this.menuUI = mainMenuGUISceneController;
    }
    @FXML
    private Label lblAdmin;

    @FXML
    void menuExitAction(ActionEvent event) {
        Window window = lblAdmin.getScene().getWindow();
        window.fireEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST));
    }
}
