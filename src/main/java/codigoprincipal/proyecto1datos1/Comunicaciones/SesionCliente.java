package codigoprincipal.proyecto1datos1.Comunicaciones;

import codigoprincipal.proyecto1datos1.Ventanas.VentanaClienteJuego;
import codigoprincipal.proyecto1datos1.protocolos.Protocolo;
import codigoprincipal.proyecto1datos1.protocolos.elementosGraficos;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.net.Socket;
import java.util.Random;

public class SesionCliente implements Runnable, EventHandler<MouseEvent>{
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


            //invocacion de clicks
            VentanaClienteJuego.ventanaJuego.setOnMouseClicked(this);

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

                            //los objetos se crean en VentanaClienteJuego
                            Platform.runLater(()->{
                                ventanaCliente.crearCartas(posX,posY,nombre);
                                    }
                            );
                            break;
                        }
                        case Protocolo.cmdTapar -> {
                            double posX = Integer.parseInt(completeCommand[1]);
                            double posY = Integer.parseInt(completeCommand[2]);
                            Platform.runLater(()-> {
                                ventanaCliente.taparCartas(posX, posY);
                                }
                            );

                        }
                        case Protocolo.cmdFallo -> {
                            int iterando1 =Integer.parseInt(completeCommand[1]);
                            int iterando2 =Integer.parseInt(completeCommand[2]);
                            Platform.runLater(()->{
                                ventanaCliente.retaparCarta(iterando1);
                                ventanaCliente.retaparCarta(iterando2);
                            });


                        }

                        case Protocolo.cmdVoltear->{
                            String comandoVolt=completeCommand[1];
                            System.out.println(comandoVolt);
                            int posicionVoltear=Integer.parseInt(comandoVolt);

                            Platform.runLater(()->{
                                ventanaCliente.descubrirCarta(posicionVoltear);
                            });
                            System.out.println("a descubrir");
                        }
                        case Protocolo.cmdEliminar -> {
                            int posicion1 = Integer.parseInt(completeCommand[2]);
                            int posicion2 = Integer.parseInt(completeCommand[3]);
                            Platform.runLater(()->{
                                ventanaCliente.eliminarCarta(posicion1);
                                ventanaCliente.eliminarCarta(posicion2);
                            });
                            System.out.println("Eliminar");
                        }
                   }
                }
            }while(socketCliente.isConnected());//corre mientras el socket esta conectado
        }catch(Exception e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }

    @Override
    public void handle(MouseEvent event) {
        int posicionX = (int)event.getX();
        int posicionY = (int)event.getY();
        if (event.getClickCount() > 0) {
            try {
                String mensaje=posicionX+" "+posicionY;
                Protocolo.writeMessage(bw, Protocolo.cmdClick,mensaje);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public static String generarId(){
        Random random = new Random();
        int valor = random.nextInt();
        return String.valueOf(valor);
    }
}
