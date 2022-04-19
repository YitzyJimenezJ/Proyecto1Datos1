package codigoprincipal.proyecto1datos1.Ventanas;

import codigoprincipal.proyecto1datos1.Imagenes.Fondo;
import codigoprincipal.proyecto1datos1.Imagenes.Imagenes;
import codigoprincipal.proyecto1datos1.Listas.Lista;
import codigoprincipal.proyecto1datos1.Listas.ListaDoble;
import codigoprincipal.proyecto1datos1.protocolos.objetosImagenes;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class VentanaClienteJuego {
    private static Stage stageJuego;
    private static Stage stagePrincipal;
    public static Group ventanaJuego = null;
    private static Lista<objetosImagenes> listaCartas= new ListaDoble<>();


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
    public Group getGroup(){
        return ventanaJuego;
    }
    public void crearCartas(double posX, double posY, String nombre){
        objetosImagenes objetoImg = new objetosImagenes("1",nombre,posX,posY);
        ImageView carta = objetoImg.getImagen();
        ventanaJuego.getChildren().add(carta);





    }
}
