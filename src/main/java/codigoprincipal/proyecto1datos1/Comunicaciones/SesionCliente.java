package codigoprincipal.proyecto1datos1.Comunicaciones;

import codigoprincipal.proyecto1datos1.Ventanas.VentanaClienteJuego;
import codigoprincipal.proyecto1datos1.protocolos.Protocolo;
import codigoprincipal.proyecto1datos1.protocolos.elementosGraficos;
import codigoprincipal.proyecto1datos1.protocolos.objetosImagenes;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

import java.io.*;
import java.net.Socket;
import java.util.Random;

public class SesionCliente implements Runnable {
    Socket socketCliente;
    BufferedWriter bw;

    String NombreJugador;
    String NombreJugador2;
    String categoria;
    VentanaClienteJuego ventanaCliente;

    public SesionCliente(Socket socketCliente, String Nombre1, String Nombre2, String categoria,VentanaClienteJuego ventanaCliente){
        this.socketCliente = socketCliente;
        this.NombreJugador=Nombre1;
        this.NombreJugador2=Nombre2;
        this.categoria=categoria;
        this.ventanaCliente=ventanaCliente;
    }

    @Override
    public void run(){
        OutputStream os = null;
        OutputStreamWriter osw;
        InputStream is = null;
        InputStreamReader isr;
        BufferedReader br;
        //NombreJugador = generarId();
        try{
            os = socketCliente.getOutputStream();
            osw = new OutputStreamWriter(os); //convierte los datos en string para enviar, en su parametro va el socket.el outputStream
            bw = new BufferedWriter(osw); //este enviara el mensaje al servidor

            is = socketCliente.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String mensaje = NombreJugador+" "+NombreJugador2+" "+categoria;

            Protocolo.writeMessage(bw, Protocolo.cmdInicio,mensaje); //se llama al metodo del protocolo que envia el mensaje al servidor

            System.out.println("ID es "+NombreJugador+NombreJugador2);

            System.out.println("Comando inicio enviado");

            System.out.println("Iniciando prueba lectura");

            do{
                if(is.available()>0){
                    String[] completeCommand = Protocolo.readSplitMessage(br);
                    String commando = completeCommand[0]; //aqui se sabe cual comando recibio

                    switch(commando) {
                        case Protocolo.cmdClear -> {
                            elementosGraficos.singleton.crearElementos();
                            break;
                        }
                        case Protocolo.cmdCrear -> {
                            double posX = Integer.parseInt(completeCommand[2]);
                            double posY =Integer.parseInt(completeCommand[3]);
                            String nombre=completeCommand[4];
                            System.out.println("X: "+completeCommand[2]);
                            System.out.println("Y: "+completeCommand[3]);
                            System.out.println("Tipo Imagen: "+completeCommand[4]);

                            //los objetos se crean en VentanaClienteJuego
                            ventanaCliente.crearCartas(posX,posY,nombre);

                            break;
                        }
                        case Protocolo.cmdVoltear -> {

                        }
                   }
                }
            }while(socketCliente.isConnected());//corre mientras el socket esta conectado
        }catch(Exception e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }
    //Falta un handle


    public static String generarId(){
        Random random = new Random();
        int valor = random.nextInt();
        return String.valueOf(valor);
    }
}
