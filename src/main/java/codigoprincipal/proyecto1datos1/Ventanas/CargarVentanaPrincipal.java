package codigoprincipal.proyecto1datos1.Ventanas;

import codigoprincipal.proyecto1datos1.Comunicaciones.SesionCliente;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class CargarVentanaPrincipal {
    //private boolean estadoMusica = true;
    public static String host = "127.0.0.1";
    public static int port = 9000;
    public static Socket socketCliente = null;
    public static SesionCliente sesionCliente = null;
    public static String categoria="FRUTAS";

    public CargarVentanaPrincipal(Group root, Stage Lobby){
        String nombre1="Susana";
        String nombre2="Horia";


        //Boton categoria frutas
        Button catFrutas = new Button("Frutas");
        catFrutas.setOnAction(event -> categoria="FRUTAS");
        catFrutas.setLayoutX(150);
        catFrutas.setLayoutY(400);
        catFrutas.setWrapText(true);

        //Boton categoria Animales
        Button catAnimales = new Button("Animales");
        catAnimales.setOnAction(event -> categoria="ANIMALES");
        catAnimales.setLayoutX(240);
        catAnimales.setLayoutY(400);
        catAnimales.setWrapText(true);

        //Boton categoria Flores
        Button catFlores = new Button("Flores");
        catFlores.setOnAction(event -> categoria="FLORES");
        catFlores.setLayoutX(360);
        catFlores.setLayoutY(400);
        catFlores.setWrapText(true);

        //se crea el boton de inicio
        Button inicioJuego = new Button("Iniciar Juego");
        inicioJuego.setOnAction(e->{
            Lobby.hide();
            System.out.println("Se presiono el inicio del juego");
            //agregar try catch con informacion del cliente
            try{
                VentanaClienteJuego ventanaCliente = new VentanaClienteJuego(Lobby); //crea la ventana de juego
                socketCliente=new Socket(host, port); //setea el socket que se conectara al servidor
                System.out.println("Conectando al servidor . . .");

                sesionCliente=new SesionCliente(socketCliente,nombre1,nombre2);

                Thread hiloSesionCliente = new Thread(sesionCliente);
                hiloSesionCliente.start();// inicia el cliente en un hilo


                Scanner scanner = new Scanner(System.in);
                System.out.println("presione enter para terminar");

            }catch(IOException fileNotFoundException){
                fileNotFoundException.printStackTrace();
            }



        });
        inicioJuego.setLayoutX(230);
        inicioJuego.setLayoutY(500);
        inicioJuego.setWrapText(true);
        root.getChildren().add(inicioJuego);
        root.getChildren().add(catFrutas);
        root.getChildren().add(catAnimales);
        root.getChildren().add(catFlores);

    }

}
