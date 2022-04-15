package codigoprincipal.proyecto1datos1;

import codigoprincipal.proyecto1datos1.Comunicaciones.SesionServidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
    public static int port = 9000;
    public static ServerSocket socketServidor;

    public static void startServer(){
        System.out.println("SUCCESS");
        Server server = new Server();
        Thread hiloServidor = new Thread(server); //crea el servidor en un hilo
        hiloServidor.start();
    }

    public static void stopServer() throws IOException{
        System.out.println("servidor cerrado");
        socketServidor.close();
    }

    public static void main(String[] args) {
        startServer();
    }

    @Override
    public void run(){
        System.out.println("Anroemdp server al puerto "+port);
        try{
            socketServidor= new ServerSocket(port);

            do{
                System.out.println("Esperando conexiones...");
                Socket cliente = socketServidor.accept();
                System.out.println("Cliente conectado");
                SesionServidor sesionServidor = new SesionServidor(cliente);
                Thread hiloSesionServidor = new Thread(sesionServidor);
                hiloSesionServidor.start();
            }while(socketServidor.isBound());
            stopServer();
        }catch (IOException e){
            System.out.println("ERROR: server fallo al iniciar: "+e.getMessage());
        }
    }
}
