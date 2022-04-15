package codigoprincipal.proyecto1datos1.protocolos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Protocolo {
    //Servidor manda
    public static final String cmdClear = "clear";
    public static final String cmdCrear = "crear";
    public static final String cmdVoltear = "voltear";
    public static final String cmdFallo = "fallo";

    //Cliente manda
    public static final String cmdInicio="iniciar";
    public static final String cmd="iniciar";

    public static void writeMessage(BufferedWriter bw, String message) throws IOException {
        bw.write(message);
        bw.newLine();
        bw.flush();
    }

    public static void writeMessage(BufferedWriter bw, String message, String parameter) throws IOException {
        writeMessage(bw, message + " " + parameter);

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