package app.ui.gui;

import app.Vaccines.Vaccines;
import app.controller.SpecifyNewVaccineAdministrationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddVaccineAdministrationGUISceneController implements Initializable {

    private SpecifyNewVaccineAdministrationController appController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    private VaccineAdministrationGUIScene1Controller janelaPrincipal;
    public void associarParentUI(VaccineAdministrationGUIScene1Controller vaccineAdministrationGUIScene1Controller) {
        this.janelaPrincipal = vaccineAdministrationGUIScene1Controller;
    }

    public void atualizar(){
        txtBoxListaUser.setText(appController.listUserEntryList());
    }

    @FXML
    private Button btnOk;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnAtualizar;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtNumero;

    @FXML
    private TextArea txtBoxListaUser;

    @FXML
    private TextField txtLot;

    @FXML
    private TextField txtdose;

    @FXML
    void cancelar(ActionEvent event) {
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    void atualizar(ActionEvent event) {
        atualizar();
    }

    @FXML
    void confirmar(ActionEvent event) {
        try {
//captura informação do ecrã
            int  numero = Integer.parseInt(txtNome.getText());
            int numeroVacina = Integer.parseInt(txtNumero.getText());
            int dose = Integer.parseInt(txtdose.getText());
            String lot = txtLot.getText().trim();

//obtém controller a partir da janela principal
            SpecifyNewVaccineAdministrationController appController = janelaPrincipal.getAplicacaoController();

            if (numeroVacina == 1)
                appController.AddchooseUserAndVaccine(numero, Vaccines.vacine.BioNtech,lot,dose);
            else if (numeroVacina == 2)
                appController.AddchooseUserAndVaccine(numero, Vaccines.vacine.Joshon,lot,dose);
            else if (numeroVacina == 3)
                appController.AddchooseUserAndVaccine(numero, Vaccines.vacine.Moderna,lot,dose);
            else if (numeroVacina == 4)
                appController.AddchooseUserAndVaccine(numero, Vaccines.vacine.Novavax,lot,dose);
            else
                appController.AddchooseUserAndVaccine(numero, Vaccines.vacine.Oxford,lot,dose);
//atualiza contactos na janela principal
            janelaPrincipal.atualizaTextBoxLista();
//fechar janela secundaria
            ((Node) event.getSource()).getScene().getWindow().hide();

        } catch (Exception ex) {
//para mostrar mensagem de erro
            Alert a = new Alert(Alert.AlertType.ERROR, "Invalid value");
            a.showAndWait();
        }
    }
}
