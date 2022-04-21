package codigoprincipal.proyecto1datos1.Ventanas;

import codigoprincipal.proyecto1datos1.Imagenes.Fondo;
import codigoprincipal.proyecto1datos1.Listas.Lista;
import codigoprincipal.proyecto1datos1.Listas.ListaDoble;
import codigoprincipal.proyecto1datos1.protocolos.objetosImagenes;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;

public class VentanaClienteJuego{
    private static Stage stageJuego;
    public static Group ventanaJuego = null;
    private static final Lista<objetosImagenes> listaCartas= new ListaDoble<>();
    private static final Lista<objetosImagenes> listaTapas= new ListaDoble<>();

    /**
     * Funcion constructor de la ventana de juego
     * @param stagePrimario
     * @param nombre1
     * @param nombre2
     * @throws FileNotFoundException
     */
    public VentanaClienteJuego(Stage stagePrimario,String nombre1, String nombre2) throws FileNotFoundException{
        ventanaJuego = new Group();
        Scene sceneJuego = new Scene(ventanaJuego, 550, 600);
        stageJuego = new Stage();
        stageJuego.setScene(sceneJuego);

        Text nom1 = new Text();
        Text nom2= new Text();
        nom1.setText(nombre1);
        nom2.setText(nombre2);
        nom1.setX(10);
        nom1.setY(10);
        nom2.setY(25);
        nom2.setX(10);
        nom1.setFont(Font.font("Arial", FontWeight.BOLD,12));
        nom2.setFont(Font.font("Arial", FontWeight.BOLD,12));


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
        ventanaJuego.getChildren().add(nom1);
        ventanaJuego.getChildren().add(nom2);

        stageJuego.show();
    }
    public Group getGroup(){
        return ventanaJuego;
    }
    public void crearCartas(double posX, double posY, String nombre){
        objetosImagenes objetoImg = new objetosImagenes("1",nombre,posX,posY);
        ImageView carta = objetoImg.getImagen();
        carta.setX(posX);
        carta.setY(posY);
        ventanaJuego.getChildren().add(carta);
    }
    public void taparCartas(double posX, double posY){
        objetosImagenes cubierta = new objetosImagenes("1","fur.jpg",posX,posY);
        listaTapas.agregarUltimo(cubierta);
        Timeline espera = new Timeline(new KeyFrame(Duration.seconds(5),colocar -> {
            ImageView atras = cubierta.getImagen();
            atras.setX(posX);
            atras.setY(posY);
            ventanaJuego.getChildren().add(atras);

        }));
        espera.play();

    }
    public void descubrirCarta(int posicion){
        objetosImagenes cubierta = listaTapas.obtenerDato(posicion);
        ImageView carta = cubierta.getImagen();
        ventanaJuego.getChildren().remove(carta);
    }
    public void retaparCarta(int posicion){
        objetosImagenes cubierta = listaTapas.obtenerDato(posicion);
        ImageView tapa = cubierta.getImagen();
        ventanaJuego.getChildren().add(tapa);
    }


}
