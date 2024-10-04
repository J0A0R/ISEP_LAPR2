package app.ui.gui;

import app.controller.App;
import app.domain.shared.Constants;
import app.ui.utils.Utils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import pt.isep.lei.esoft.auth.UserSession;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuGUISceneController {

	private App app;
	@FXML
	private Label lblInitial;

	public MainMenuGUISceneController() {
		this.app = App.getInstance();
	}

	
	private Stage loadLoginUi() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/ui/gui/AuthGUIScene.fxml"));
	        Parent root = loader.load();
	        
	        Scene scene = new Scene(root);
	        
	        Stage novoLoginStage = new Stage();
	        novoLoginStage.initModality(Modality.APPLICATION_MODAL);
	        novoLoginStage.setTitle("Login");
	        novoLoginStage.setResizable(false);
	        novoLoginStage.setScene(scene);
	        
	        AuthGUISceneController novoLoginUI = loader.getController();
	        novoLoginUI.associarParentUI(this);
	        
	        return novoLoginStage;
        } catch (IOException ex) {	
        	Utils.createAlert(Alert.AlertType.ERROR, "Erro", ex.getMessage());
            return null;
        }
	}

	public Label getLabel() {
		return this.lblInitial;
	}
	@FXML
    private void menuDevTeamAction(ActionEvent event) {
		String x = "Development Team:\n\t Tiago Miguel Soares Ribeiro - 1202054@isep.ipp.pt\n\t João Gonçalo Silva Rodrigues - 1210817@isep.ipp.pt\n";
        Utils.createAlert(Alert.AlertType.INFORMATION, "About",
                x);
    }


	@FXML
	void menuExitAction(ActionEvent event) {
		Window window = lblInitial.getScene().getWindow();
		window.fireEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST));
	}

	@FXML
	void menuLoginAction(ActionEvent event) {
		app.doLogout();
		Stage stage1 = loadLoginUi();
		if(stage1 == null) {
			return;
		}
		stage1.showAndWait();

		UserSession sessao = this.app.getCurrentUserSession();
		if(sessao == null) {
			return;
		}

		Stage stage = null;
		if(sessao.isLoggedInWithRole(Constants.ROLE_NURSE)) {
			stage = loadNurseUi();
		}
		if(sessao.isLoggedInWithRole(Constants.ROLE_COORDINATOR)){
			stage = loadCoordinatorUi();
		}
		if(stage == null) {
			return;
		}

		stage.show();

		Window window = lblInitial.getScene().getWindow();
		window.hide();
	}

	private Stage loadCoordinatorUi(){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/ui/gui/CenterCoordinatorGUIScene.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root);

			Stage newCoordinatorStage = new Stage();

			newCoordinatorStage.initModality(Modality.APPLICATION_MODAL);
			newCoordinatorStage.setTitle("Coordinator");
			newCoordinatorStage.setMaximized(true);
			newCoordinatorStage.setScene(scene);
			newCoordinatorStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent event) {
					app.doLogout();
					Stage window = (Stage)lblInitial.getScene().getWindow();
					window.show();
				}
			});

			MenuCoodinatorGUISceneController newCoordinatorUI = loader.getController();
			newCoordinatorUI.associarParentUI(this);

			return newCoordinatorStage;

		} catch (IOException e) {
			Utils.createAlert(Alert.AlertType.ERROR, "Erro", e.getMessage());
			return null;
		}

	}

	private Stage loadNurseUi() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/ui/gui/NurseGUIScene.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root);

			Stage novoNurseStage = new Stage();
			novoNurseStage.initModality(Modality.APPLICATION_MODAL);
			novoNurseStage.setTitle("Nurse");
			novoNurseStage.setMaximized(true);
			novoNurseStage.setScene(scene);
			novoNurseStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent event) {
					app.doLogout();
					Stage window = (Stage)lblInitial.getScene().getWindow();
					window.show();
				}
			});

			MenuNurseGUISceneController novoNurseUI = loader.getController();
			novoNurseUI.associarParentUI(this);

			return novoNurseStage;
		} catch (IOException ex) {
			Utils.createAlert(Alert.AlertType.ERROR, "Erro", ex.getMessage());
			return null;
		}
	}

}
