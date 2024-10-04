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

public class VaccineAdministrationGUISceneController implements Initializable {

    public Label lblVaccineAdministration;

    private MenuNurseGUISceneController menuUI;

    private final App app;

    public VaccineAdministrationGUISceneController() {
        this.app = App.getInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        String email = String.valueOf(app.getCurrentUserSession().getUserId());
    }

    @FXML
    private void menuExitAction(ActionEvent event) {
        Window window = lblVaccineAdministration.getScene().getWindow();
        window.fireEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    public void associarParentUI(MenuNurseGUISceneController menuNurseGUISceneController) {
        this.menuUI = menuNurseGUISceneController;
    }
}
