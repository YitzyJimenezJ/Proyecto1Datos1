package codigoprincipal.proyecto1datos1.Comunicaciones;

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

            //GraphicElements lastState = new GraphicElements();

            long lastSentTime = 0;



        }catch(Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }



}
