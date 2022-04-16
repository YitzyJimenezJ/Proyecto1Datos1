package codigoprincipal.proyecto1datos1.Comunicaciones;

import codigoprincipal.proyecto1datos1.Listas.Lista;
import codigoprincipal.proyecto1datos1.protocolos.Protocolo;
import codigoprincipal.proyecto1datos1.protocolos.elementosGraficos;
import codigoprincipal.proyecto1datos1.protocolos.objetosImagenes;

import java.io.*;
import java.net.Socket;

public class SesionServidor implements Runnable {
    private Socket socket;

    public SesionServidor(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run(){
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
                Protocolo.writeMessage(bw,"Messages sent from server");

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

                if(is.available()>0){
                    String[] comandoCompleto = Protocolo.readSplitMessage(br);
                    String comando = comandoCompleto[0];

                    switch (comando){
                        case Protocolo.cmdInicio -> {
                            //Iniciar la creacion de cada carta

                        }
                    }
                }
            }while(socket.isBound());

        }catch(Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }



}
