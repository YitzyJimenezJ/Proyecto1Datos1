package codigoprincipal.proyecto1datos1.Comunicaciones;

import codigoprincipal.proyecto1datos1.protocolos.Protocolo;
import codigoprincipal.proyecto1datos1.protocolos.elementosGraficos;

import java.io.*;
import java.net.Socket;
import java.util.Random;

public class SesionCliente implements Runnable {
    Socket socketCliente;
    BufferedWriter bw;

    String IdJugador;

    public SesionCliente(Socket socketCliente){
        this.socketCliente = socketCliente;
    }

    @Override
    public void run(){
        OutputStream os = null;
        OutputStreamWriter osw;
        //BufferedWriter bw;
        InputStream is = null;
        InputStreamReader isr;
        BufferedReader br;
        IdJugador = generarId();
        try{
            os = socketCliente.getOutputStream();
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
            is = socketCliente.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            Protocolo.writeMessage(bw, Protocolo.cmdInicio, IdJugador);

            System.out.println("ID es "+IdJugador);

            System.out.println("Comando inicio enviado");

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
