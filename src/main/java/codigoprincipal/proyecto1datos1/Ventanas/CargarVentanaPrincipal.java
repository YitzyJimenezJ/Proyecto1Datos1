package codigoprincipal.proyecto1datos1.Ventanas;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.Socket;

public class CargarVentanaPrincipal {
    private boolean estadoMusica = true;
    public static String host = "127.0.0.1";
    public static int port = 9000;
    public static Socket clientSocket = null;
    //public static ClientSession clientSession = null;

    public CargarVentanaPrincipal(Group root, Stage Lobby){
        //se crea el boton de inicio
        Button inicioJuego = new Button("Iniciar Juego");
        inicioJuego.setOnAction(e->{
            //Lobby.hide();
            //agregar try catch con informacion del cliente
            System.out.println("Se presiono el inicio del juego");


        });
        inicioJuego.setLayoutX(200);
        inicioJuego.setLayoutY(400);
        inicioJuego.setWrapText(true);
        root.getChildren().add(inicioJuego);

    }

}
