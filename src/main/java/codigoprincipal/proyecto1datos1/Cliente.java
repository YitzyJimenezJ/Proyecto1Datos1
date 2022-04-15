package codigoprincipal.proyecto1datos1;

import codigoprincipal.proyecto1datos1.Ventanas.CargarVentanaPrincipal;
import codigoprincipal.proyecto1datos1.Ventanas.ClientCargarVentana;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Cliente extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        new ClientCargarVentana(stage);
    }

    public static void main(String[] args) {

        if(args.length > 0){
            CargarVentanaPrincipal.host=args[0]; //setea el host
        }
        if(args.length > 1){
            CargarVentanaPrincipal.port = Integer.parseInt(args[1]); //setea el port del cliente en los args del main
        }
        launch();

        System.out.println("Programa cerrado");
    }
}