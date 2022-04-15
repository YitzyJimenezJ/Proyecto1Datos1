package codigoprincipal.proyecto1datos1.Ventanas;

import codigoprincipal.proyecto1datos1.Comunicaciones.SesionCliente;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class CargarVentanaPrincipal {
    private boolean estadoMusica = true;
    public static String host = "127.0.0.1";
    public static int port = 9000;
    public static Socket socketCliente = null;
    public static SesionCliente sesionCliente = null;
    public static String categoria="FRUTAS";

    public CargarVentanaPrincipal(Group root, Stage Lobby){
        //Boton categoria frutas
        Button catFrutas = new Button("Frutas");
        catFrutas.setOnAction(event -> {
            categoria="FRUTAS";
        });

        //Boton categoria Animales
        Button catAnimales = new Button("Animales");
        catAnimales.setOnAction(event -> {
            categoria="ANIMALES";
        });
        //Boton categoria Flores
        Button catFlores = new Button("Flores");
        catFlores.setOnAction(event -> {
            categoria="FLORES";
        });
        //se crea el boton de inicio
        Button inicioJuego = new Button("Iniciar Juego");
        inicioJuego.setOnAction(e->{
            Lobby.hide();
            //agregar try catch con informacion del cliente
            try{
                VentanaClienteJuego ventanaCliente = new VentanaClienteJuego(Lobby);
                socketCliente=new Socket(host, port);
                System.out.println("Conectando al servidor . . .");
                sesionCliente=new SesionCliente(socketCliente);
                Thread hiloSesionCliente = new Thread(sesionCliente);
                hiloSesionCliente.start();
                Scanner scanner = new Scanner(System.in);
                System.out.println("presione enter para terminar");

            }catch(IOException fileNotFoundException){
                fileNotFoundException.printStackTrace();
            }




            System.out.println("Se presiono el inicio del juego");


        });
        inicioJuego.setLayoutX(200);
        inicioJuego.setLayoutY(400);
        inicioJuego.setWrapText(true);
        root.getChildren().add(inicioJuego);

    }

}
