package app.ui.gui;

import app.controller.SpecifyNewVaccineAdministrationController;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

public class VaccineAdministrationGUIScene1Controller implements Initializable {

    /**
     * file name to export
     */
    final static String FICHEIRO = "ficheiro.bin";

    private MenuNurseGUISceneController menuUI;

    @FXML
    private TextArea txtBoxListaTelefonica;

    private Stage newVaccineAdministrationStage;

    private SpecifyNewVaccineAdministrationController appController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
//carrega a janela secundária para memória sem a mostrar
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/ui/gui/AddVaccineAdministrationGUIScene.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            newVaccineAdministrationStage = new Stage();
            newVaccineAdministrationStage.initModality(Modality.APPLICATION_MODAL);
            newVaccineAdministrationStage.setScene(scene);
//associa a referência desta janela à secundária
            AddVaccineAdministrationGUISceneController novoUI = loader.getController();
            novoUI.associarParentUI(this);


            appController = new SpecifyNewVaccineAdministrationController();

            atualizaTextBoxLista();

        } catch (IOException ex) {
            criarAleta(Alert.AlertType.ERROR, "Erro", ex.getMessage());
        }
    }

    public SpecifyNewVaccineAdministrationController getAplicacaoController() {
        return appController;
    }

    public void atualizaTextBoxLista() {
        txtBoxListaTelefonica.setText(appController.getLista());
    }

    public void associarParentUI(MenuNurseGUISceneController menuNurseGUISceneController) {
        this.menuUI = menuNurseGUISceneController;
    }

    @FXML
    private void mnuNovoAction(ActionEvent event) throws IOException {
        newVaccineAdministrationStage.show();
    }

    @FXML
    void mnuSairAction(ActionEvent event) {
        Window window = txtBoxListaTelefonica.getScene().getWindow();
        window.fireEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    private Alert criarAleta(Alert.AlertType tipoAlerta, String cabecalho, String mensagem) {
        Alert alerta = new Alert(tipoAlerta);

        alerta.setTitle("Aplicação");
        alerta.setHeaderText(cabecalho);
        alerta.setContentText(mensagem);

        return alerta;
    }

    @FXML
    void importar(ActionEvent event) {
        appController.importarLista(FICHEIRO);
        atualizaTextBoxLista();
    }

    @FXML
    void exportar(ActionEvent event) {
        boolean gravou = appController.exportarLista(FICHEIRO);
        if(!gravou){
            Alert a = new Alert(Alert.AlertType.WARNING,"Didn't save!!");
            a.showAndWait();
        }
    }
}
