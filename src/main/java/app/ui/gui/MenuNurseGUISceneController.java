package app.ui.gui;

import app.controller.App;
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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;

public class MenuNurseGUISceneController implements Initializable {
	
	private MainMenuGUISceneController menuUI;
	private final App app;
	@FXML
	private Label lblNameNurse;
	
	public MenuNurseGUISceneController() {
		this.app = App.getInstance();
	}
	
	@Override
    public void initialize(URL url, ResourceBundle rb){
		String email = String.valueOf(app.getCurrentUserSession().getUserId());
    }

	public void associarParentUI(MainMenuGUISceneController mainMenuGUISceneController) {
		this.menuUI = mainMenuGUISceneController;
	}


	@FXML
	void menuExitAction(ActionEvent event) {
        Window window = lblNameNurse.getScene().getWindow();
        window.fireEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST));
    }


	@FXML
	void botonVaccineAdministration(ActionEvent event) throws IOException {
		Stage stage1 = vaccineadministration();
		if(stage1 == null) {
			return;
		}
		stage1.showAndWait();
	}

	@FXML
	void buttonAdverseReactions(ActionEvent event) {
		Stage stage2 = adverseReactions();
		if(stage2 == null) {
			return;
		}
		stage2.showAndWait();
	}


	private Stage adverseReactions(){
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/ui/gui/AdverseReactionsScene.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root);

			Stage novoVaccineAdministrationStage = new Stage();
			novoVaccineAdministrationStage.initModality(Modality.APPLICATION_MODAL);
			novoVaccineAdministrationStage.setTitle("Adverse Reactions");
			novoVaccineAdministrationStage.setMaximized(true);
			novoVaccineAdministrationStage.setScene(scene);
			novoVaccineAdministrationStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent event) {
					app.doLogout();
					Stage window = (Stage)lblNameNurse.getScene().getWindow();
					window.show();

				}
			});

			AdverseReactionsController novoVaccineAdministrationUI = loader.getController();
			novoVaccineAdministrationUI.associarParentUI(this);
			return novoVaccineAdministrationStage;
		} catch (IOException ex) {
			Utils.createAlert(Alert.AlertType.ERROR, "Erro", ex.getMessage());
			return null;
		}
	}



	private Stage vaccineadministration() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/ui/gui/VaccineAdministrationGUIScene.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root);

			Stage novoVaccineAdministrationStage = new Stage();
			novoVaccineAdministrationStage.initModality(Modality.APPLICATION_MODAL);
			novoVaccineAdministrationStage.setTitle("VaccineAdministration");
			novoVaccineAdministrationStage.setMaximized(true);
			novoVaccineAdministrationStage.setScene(scene);
			novoVaccineAdministrationStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent event) {
					app.doLogout();
					Stage window = (Stage)lblNameNurse.getScene().getWindow();
					window.show();
				}
			});

			VaccineAdministrationGUIScene1Controller novoVaccineAdministrationUI = loader.getController();
			novoVaccineAdministrationUI.associarParentUI(this);
			return novoVaccineAdministrationStage;
		} catch (IOException ex) {
			Utils.createAlert(Alert.AlertType.ERROR, "Erro", ex.getMessage());
			return null;
		}
	}
}
