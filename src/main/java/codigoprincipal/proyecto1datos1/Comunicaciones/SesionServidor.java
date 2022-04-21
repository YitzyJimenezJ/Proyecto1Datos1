package codigoprincipal.proyecto1datos1.Comunicaciones;

import codigoprincipal.proyecto1datos1.Imagenes.posicionesCartas;
import codigoprincipal.proyecto1datos1.Ventanas.VentanaPrincipalServidor;
import codigoprincipal.proyecto1datos1.protocolos.Protocolo;
import codigoprincipal.proyecto1datos1.protocolos.elementosGraficos;


import java.io.*;
import java.net.Socket;
import java.util.Objects;
import java.util.Random;

public class SesionServidor implements Runnable {
    private Socket socket;

    public SesionServidor(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run(){
        posicionesCartas posicionesCartas = new posicionesCartas();
        posicionesCartas.cargarPosiciones();
        OutputStream os = null;
        OutputStreamWriter osw;
        BufferedWriter bw;
        InputStream is = null;
        InputStreamReader isr;
        BufferedReader br;
        VentanaPrincipalServidor ventanaServidor;
        boolean colocadas=false;
        //intenta obtener datos de algun cliente
        try{
            os = socket.getOutputStream();
            osw= new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            ventanaServidor=new VentanaPrincipalServidor("","");

            do{
                if(is.available()>0){
                    String[] comandoCompleto = Protocolo.readSplitMessage(br);
                    String comando = comandoCompleto[0];

                    switch (comando){
                        case Protocolo.cmdInicio -> {
                            String nombre1=comandoCompleto[1];
                            String nombre2=comandoCompleto[2];
                            String categoria=comandoCompleto[3];
                            ventanaServidor=new VentanaPrincipalServidor(nombre1,nombre2);
                            ventanaServidor.IniciarVentana();
                            switch (categoria){
                                case "FLORES"->{
                                    int i=0;

                                    elementosGraficos tiposCartas = new elementosGraficos();

                                    while(i<32){

                                        int posX =posicionesCartas.getPosicion(i);
                                        int posY= posicionesCartas.getPosicion(i+1);
                                        String tipoImagen="NULL";
                                        int tipo = tiposCartas.generarTipo();
                                        if(tipo==1){
                                            tipoImagen="blanzas.jpg";
                                        }else if(tipo==2){
                                            tipoImagen="florAzul.jpg";
                                        }else if(tipo==3){
                                            tipoImagen="girasol.jpg";
                                        }else if(tipo==4){
                                            tipoImagen="moradas.jpg";
                                        }else if(tipo==5){
                                            tipoImagen="rosa.jpg";
                                        }else if(tipo==6){
                                            tipoImagen="rosadas.jpg";
                                        }else if(tipo==7){
                                            tipoImagen="rosadasihj.jpg";
                                        }else if(tipo==8){
                                            tipoImagen="tulipanes.jpg";
                                        }

                                        String mensaje=categoria+" "+posX+" "+posY+" "+tipoImagen;
                                        String ID= String.valueOf(tipo);
                                        ventanaServidor.crearCartas(ID,tipoImagen,posX,posY);
                                        Protocolo.writeMessage(bw,Protocolo.cmdCrear,mensaje);
                                        i+=2;
                                    }

                                    int j =0;
                                    while(j<32){
                                        int posX =posicionesCartas.getPosicion(j);
                                        int posY= posicionesCartas.getPosicion(j+1);

                                        String mensaje=posX+" "+posY;
                                        Protocolo.writeMessage(bw,Protocolo.cmdTapar,mensaje);
                                        j+=2;
                                    }
                                    colocadas=true;

                                    break;


                                }
                                case "ANIMALES"->{
                                    int i=0;

                                    elementosGraficos tiposCartas = new elementosGraficos();

                                    while(i<32){

                                        int posX =posicionesCartas.getPosicion(i);
                                        int posY= posicionesCartas.getPosicion(i+1);
                                        String tipoImagen="NULL";
                                        int tipo = tiposCartas.generarTipo();
                                        if(tipo==1){
                                            tipoImagen="conejo.jpg";
                                        }else if(tipo==2){
                                            tipoImagen="erizo.jpg";
                                        }else if(tipo==3){
                                            tipoImagen="gato.jpg";
                                        }else if(tipo==4){
                                            tipoImagen="lapa.jpg";
                                        }else if(tipo==5){
                                            tipoImagen="nutria.jpg";
                                        }else if(tipo==6){
                                            tipoImagen="oso.jpg";
                                        }else if(tipo==7){
                                            tipoImagen="perro.jpg";
                                        }else if(tipo==8){
                                            tipoImagen="vaca.jpg";
                                        }

                                        String mensaje=categoria+" "+posX+" "+posY+" "+tipoImagen;
                                        String ID= String.valueOf(tipo);
                                        ventanaServidor.crearCartas(ID,tipoImagen,posX,posY);
                                        Protocolo.writeMessage(bw,Protocolo.cmdCrear,mensaje);
                                        i+=2;
                                    }
                                    int j =0;
                                    while(j<32){
                                        int posX =posicionesCartas.getPosicion(j);
                                        int posY= posicionesCartas.getPosicion(j+1);

                                        String mensaje=posX+" "+posY;
                                        Protocolo.writeMessage(bw,Protocolo.cmdTapar,mensaje);
                                        j+=2;
                                    }
                                    colocadas=true;
                                    break;

                                }
                                case "FRUTAS"->{
                                    int i=0;

                                    elementosGraficos tiposCartas = new elementosGraficos();

                                    while(i<32) {
                                        int posX = posicionesCartas.getPosicion(i);
                                        int posY = posicionesCartas.getPosicion(i + 1);
                                        String tipoImagen = "NULL";
                                        int tipo = tiposCartas.generarTipo();
                                        if (tipo == 1) {
                                            tipoImagen = "bananos.jpg";
                                        } else if (tipo == 2) {
                                            tipoImagen = "fresas.jpg";
                                        } else if (tipo == 3) {
                                            tipoImagen = "kiwi.jpg";
                                        } else if (tipo == 4) {
                                            tipoImagen = "naranja.jpg";
                                        } else if (tipo == 5) {
                                            tipoImagen = "papaya.jpg";
                                        } else if (tipo == 6) {
                                            tipoImagen = "pina.jpg";
                                        } else if (tipo == 7) {
                                            tipoImagen = "sandia.jpg";
                                        } else if (tipo == 8) {
                                            tipoImagen = "uvas.jpg";
                                        }

                                        String mensaje = categoria + " " + posX + " " + posY + " " + tipoImagen;
                                        String ID= String.valueOf(tipo);
                                        ventanaServidor.crearCartas(ID,tipoImagen,posX,posY);
                                        Protocolo.writeMessage(bw, Protocolo.cmdCrear, mensaje);
                                        i += 2;
                                    }

                                    int j =0;
                                    while(j<32){
                                        int posX =posicionesCartas.getPosicion(j);
                                        int posY= posicionesCartas.getPosicion(j+1);

                                        String mensaje=posX+" "+posY;
                                        Protocolo.writeMessage(bw,Protocolo.cmdTapar,mensaje);
                                        j+=2;
                                    }
                                    colocadas=true;
                                    break;
                                }
                            }
                            break;
                        }
                        case Protocolo.cmdClick->{
                            if(colocadas){
                                double posX=Integer.parseInt(comandoCompleto[1]);
                                double posY=Integer.parseInt(comandoCompleto[2]);
                                ventanaServidor.comparar(posX,posY);


                                String retornado1 = ventanaServidor.getPosicion1Regresar();
                                String retornado2 = ventanaServidor.getPosicion2Regresar();
                                if(retornado1 != "NULL" && retornado2 !="NULL"){
                                    Protocolo.writeMessage(bw,Protocolo.cmdFallo,retornado1+" "+retornado2);
                                }



                                String eliminar = ventanaServidor.getTipoEliminar();
                                if(eliminar.equals("NULL")){
                                    String volteable = ventanaServidor.getPosicionVoltear();
                                    Protocolo.writeMessage(bw,Protocolo.cmdVoltear,volteable);
                                }
                            if(!eliminar.equals("NULL")){
                                String retornadoA = ventanaServidor.getPosicion1Regresar();
                                String retornadoB = ventanaServidor.getPosicion2Regresar();
                                Protocolo.writeMessage(bw,Protocolo.cmdEliminar,retornadoA+" "+retornadoB);
                            }
                            }





                        }
                    }
                }
            }while(socket.isBound());

        }catch(Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }



}
