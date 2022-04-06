package codigoprincipal.proyecto1datos1;

import codigoprincipal.proyecto1datos1.Ventanas.ClientCargarVentana;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Cliente extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        new ClientCargarVentana(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}