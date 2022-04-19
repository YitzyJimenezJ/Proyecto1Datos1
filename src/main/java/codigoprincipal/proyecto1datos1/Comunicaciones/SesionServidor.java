package codigoprincipal.proyecto1datos1.Comunicaciones;

import codigoprincipal.proyecto1datos1.Imagenes.posicionesCartas;
import codigoprincipal.proyecto1datos1.Listas.Lista;
import codigoprincipal.proyecto1datos1.protocolos.Protocolo;
import codigoprincipal.proyecto1datos1.protocolos.elementosGraficos;
import codigoprincipal.proyecto1datos1.protocolos.objetosImagenes;

import java.io.*;
import java.net.Socket;
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
        //intenta obtener datos de algun cliente
        try{
            os = socket.getOutputStream();
            osw= new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);


            is = socket.getInputStream();
            //dis = new DataInputStream(is);
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            elementosGraficos ultimoEstado = new elementosGraficos();

            long lastSentTime = 0;
            do{
                /*
                if(System.currentTimeMillis()-lastSentTime>200){
                    Lista<objetosImagenes> elementos = elementosGraficos.singleton.getElementos();//direccion de memoria de la lista
                    int tamanoElementos = elementos.tamanoLista();

                    for(int i=0;i<tamanoElementos;i++){

                        objetosImagenes elemento = elementos.obtenerDato(i);
                        double posicionX = elemento.getPosicionX();
                        double posicionY = elemento.getPosicionY();

                        objetosImagenes ultimoElementoEstado = ultimoEstado.encontrarElemento(elemento.getId());
                        if(ultimoElementoEstado==null || ultimoElementoEstado.getPosicionX() != posicionX || ultimoElementoEstado.getPosicionY()!=posicionY){
                            Protocolo.writeMessage(bw,"Messages sent from server");
                        }
                    }
                }
                */
                if(is.available()>0){
                    String[] comandoCompleto = Protocolo.readSplitMessage(br);
                    String comando = comandoCompleto[0];

                    switch (comando){
                        case Protocolo.cmdInicio -> {
                            String nombre1=comandoCompleto[1];
                            String nombre2=comandoCompleto[2];
                            String categoria=comandoCompleto[3];

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
                                        Protocolo.writeMessage(bw,Protocolo.cmdCrear,mensaje);
                                        i+=2;
                                    }
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
                                        Protocolo.writeMessage(bw,Protocolo.cmdCrear,mensaje);
                                        i+=2;
                                    }
                                    break;

                                }
                                case "FRUTAS"->{
                                    int i=0;

                                    elementosGraficos tiposCartas = new elementosGraficos();

                                    while(i<32){

                                        int posX =posicionesCartas.getPosicion(i);
                                        int posY= posicionesCartas.getPosicion(i+1);
                                        String tipoImagen="NULL";
                                        int tipo = tiposCartas.generarTipo();
                                        if(tipo==1){
                                            tipoImagen="bananos.jpg";
                                        }else if(tipo==2){
                                            tipoImagen="fresas.jpg";
                                        }else if(tipo==3){
                                            tipoImagen="kiwi.jpg";
                                        }else if(tipo==4){
                                            tipoImagen="naranja.jpg";
                                        }else if(tipo==5){
                                            tipoImagen="papaya.jpg";
                                        }else if(tipo==6){
                                            tipoImagen="pina.jpg";
                                        }else if(tipo==7){
                                            tipoImagen="sandia.jpg";
                                        }else if(tipo==8){
                                            tipoImagen="uvas.jpg";
                                        }

                                        String mensaje=categoria+" "+posX+" "+posY+" "+tipoImagen;
                                        Protocolo.writeMessage(bw,Protocolo.cmdCrear,mensaje);
                                        i+=2;
                                    }
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            }while(socket.isBound());

        }catch(Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }



}
