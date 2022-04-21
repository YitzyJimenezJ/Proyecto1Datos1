package codigoprincipal.proyecto1datos1.protocolos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
//Tiene la definicion de los protocolos y sus metodos
public class Protocolo {
    //Servidor manda
    public static final String cmdClear = "clear";
    public static final String cmdCrear = "crear";
    public static final String cmdVoltear = "voltear";
    public static final String cmdFallo = "fallo";
    public static final String cmdEliminar = "eliminar";

    //Cliente manda
    public static final String cmdInicio="iniciar";
    public static final String cmdClick="click";
    public static final String cmdTapar="cubrir";

    public static void writeMessage(BufferedWriter bw, String message) throws IOException {
        bw.write(message);
        bw.newLine();
        bw.flush();
    }

    public static void writeMessage(BufferedWriter bw, String message, String parameter) throws IOException {
        writeMessage(bw, message + " " + parameter);

    }
    public static void writeStart(BufferedWriter bw, String message, String nombre1, String nombre2) throws IOException{
        writeMessage(bw, message+" "+nombre1+" "+nombre2);
    }

    public static String readMessage(BufferedReader br) throws IOException {
        String command = br.readLine();
        return command;
    }

    public static String[] readSplitMessage(BufferedReader br) throws IOException {
        String command = readMessage(br);
        return command.split(" ");
    }
}
