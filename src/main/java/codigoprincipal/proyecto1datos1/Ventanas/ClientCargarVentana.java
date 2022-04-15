package codigoprincipal.proyecto1datos1.Ventanas;

import codigoprincipal.proyecto1datos1.Cliente;
import codigoprincipal.proyecto1datos1.Imagenes.Imagenes;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.ImageInput;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//esta clase se llama desde Cliente java
public class ClientCargarVentana {

    public ClientCargarVentana(Stage Lobby){
        //FXMLLoader fxmlLoader = new FXMLLoader(Cliente.class.getResource("hello-view.fxml"));

        //caracteristicas principales de la ventana
        Group root = new Group();
        Scene scene = new Scene(root, 550, 600, Color.valueOf("FAD0C3"));
        Lobby.setTitle("Juego Cartas");
        Lobby.setScene(scene);

        //Imagen de fondo
        ImageInput fondo = new ImageInput(Imagenes.getInstancia().getFondoPrincipal());
        Rectangle rectanguloFondo = new Rectangle();
        fondo.setX(0);
        fondo.setY(-5);
        rectanguloFondo.setEffect(fondo);
        root.getChildren().add(rectanguloFondo);

        //se manda a crear los elementos a colocar en la ventana principal
        new CargarVentanaPrincipal(root, Lobby);
        Lobby.show();
    }

}
