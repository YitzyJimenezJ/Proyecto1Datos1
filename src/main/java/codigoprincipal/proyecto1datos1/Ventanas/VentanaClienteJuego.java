package codigoprincipal.proyecto1datos1.Ventanas;

import codigoprincipal.proyecto1datos1.Imagenes.Fondo;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class VentanaClienteJuego {
    private static Stage stageJuego;
    private static Stage stagePrincipal;
    public static Group ventanaJuego = null;

    public VentanaClienteJuego(Stage stagePrimario) throws FileNotFoundException{
        stagePrincipal = stagePrimario;
        ventanaJuego = new Group();
        Scene sceneJuego = new Scene(ventanaJuego, 550, 600);
        stageJuego = new Stage();
        stageJuego.setScene(sceneJuego);

        Fondo.IniciarFondo(ventanaJuego);
        //boton para volver a la ventana principal
        Button botonSalida = new Button("SALIR");
        botonSalida.setOnAction(event -> {
            stageJuego.close();
            stagePrimario.show();
        });
        botonSalida.setLayoutX(20);
        botonSalida.setLayoutY(15);
        botonSalida.setWrapText(true);

        ventanaJuego.getChildren().add(botonSalida);

        stageJuego.show();
    }
}
