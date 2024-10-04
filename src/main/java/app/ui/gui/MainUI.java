package app.ui.gui;

import app.controller.App;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainUI extends Application {
    public static void main2() {
        String[] args = new String[0];
        main(args);
    }

    /*public static void main(String[] args)
        {
            try
            {
                MainMenuUI menu = new MainMenuUI();
    
                menu.run();
            }
            catch( Exception e )
            {
                e.printStackTrace();
            }
        }*/
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/ui/gui/MainMenuGUIScene.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                App.getInstance().fechar(event);
            }
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void Fechar(WindowEvent event) {
        Alert aviso = new Alert(Alert.AlertType.CONFIRMATION, "Deseja mesmo sair?", ButtonType.YES, ButtonType.NO);
        aviso.setHeaderText("Confirma��o da a��o");
        aviso.showAndWait();
        ButtonType resultado = aviso.getResult();
        if(resultado == ButtonType.NO) {
            event.consume();
        }
    }
}
