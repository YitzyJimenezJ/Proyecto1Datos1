package codigoprincipal.proyecto1datos1.Comunicaciones;

import codigoprincipal.proyecto1datos1.protocolos.Protocolo;
import codigoprincipal.proyecto1datos1.protocolos.elementosGraficos;

import java.io.*;
import java.net.Socket;
import java.util.Random;

public class SesionCliente implements Runnable {
    Socket socketCliente;
    BufferedWriter bw;

    String NombreJugador;
    String NombreJugador2;

    public SesionCliente(Socket socketCliente, String Nombre1, String Nombre2){
        this.socketCliente = socketCliente;
        this.NombreJugador=Nombre1;
        this.NombreJugador2=Nombre2;
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

            Protocolo.writeStart(bw, Protocolo.cmdInicio, NombreJugador,NombreJugador2); //se llama al metodo del protocolo que envia el mensaje al servidor

            System.out.println("ID es "+NombreJugador+NombreJugador2);

            System.out.println("Comando inicio enviado");

            System.out.println("Iniciando prueba lectura");

            if(is.available()>0){
                String[] completeCommand = Protocolo.readSplitMessage(br);

                String commando = completeCommand[0]; //aqui se sabe cual comando recibio
                System.out.println(commando);

            }


            /*
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
            */
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
