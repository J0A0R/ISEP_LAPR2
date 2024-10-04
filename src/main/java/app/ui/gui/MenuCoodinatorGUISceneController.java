
package app.ui.gui;

import app.controller.App;
import app.domain.model.Company;
import app.ui.utils.Utils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuCoodinatorGUISceneController implements Initializable {

    private final App app;
    private MainMenuGUISceneController menuUI;
    private Company company;


    public MenuCoodinatorGUISceneController() {
        this.app = App.getInstance();
        company= new Company();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private Button buttonExport;

    @FXML
    private Button buttonReturn;

    @FXML
    void buttonExportAction(ActionEvent event) {
        try{
            this.company.exportToCsv();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setContentText("Data was sucessfully exported do data.csv");
            Optional<ButtonType> result = alert.showAndWait();

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fail");
            alert.setContentText("Data was not exported");
            e.printStackTrace();
        }


        /**Stage stage2 = exportData();
        if(stage2 == null) {
            return;
        }
        stage2.showAndWait();**/
    }

    @FXML
    void buttonReturnAction(ActionEvent event) {
        Window window = buttonReturn.getScene().getWindow();
        window.fireEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST));
    }


    public void associarParentUI(MainMenuGUISceneController mainMenuGUISceneController) {
        this.menuUI = mainMenuGUISceneController;
    }

    private Stage exportData(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/ui/gui/ExportDataGUIScene.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage newExportDataStage = new Stage();
            newExportDataStage.initModality(Modality.APPLICATION_MODAL);
            newExportDataStage.setTitle("Export Data");
            newExportDataStage.setMaximized(true);
            newExportDataStage.setScene(scene);
            newExportDataStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    app.doLogout();

                }
            });

            ExportDataGUISceneController newExportDataGUISceneUI = loader.getController();
            newExportDataGUISceneUI.associarParentUI(this);
            return newExportDataStage;
        } catch (IOException ex) {
            Utils.createAlert(Alert.AlertType.ERROR, "Erro", ex.getMessage());
            return null;
        }
    }

}


