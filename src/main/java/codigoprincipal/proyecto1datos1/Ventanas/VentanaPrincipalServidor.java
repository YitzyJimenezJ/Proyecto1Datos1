package codigoprincipal.proyecto1datos1.Ventanas;
import codigoprincipal.proyecto1datos1.Imagenes.posicionesCartas;
import codigoprincipal.proyecto1datos1.Listas.Lista;
import codigoprincipal.proyecto1datos1.Listas.ListaDoble;
import codigoprincipal.proyecto1datos1.Listas.Pila;
import codigoprincipal.proyecto1datos1.protocolos.objetosImagenes;

import javax.swing.*;
import java.awt.*;


public class VentanaPrincipalServidor extends Canvas{
    private String nombre1;
    private String nombre2;
    private Lista<objetosImagenes> ubicacionesCartas;
    public Graficos n;
    public JFrame principal;
    public int turno; //turno
    public int seleccionadas; //contador de cartas seleccionadas por turno
    public String tipo1;
    public String tipo2;
    public int puntaje1;
    public int puntaje2;
    public posicionesCartas cartas;
    public objetosImagenes carta1;
    public objetosImagenes carta2;
    public Pila emparejadas;
    public int ubiPosicion1;
    public int ubiPosicion2;
    public String tipoElim;
    public String posicionVoltear;
    public String voltear1;
    public String voltear2;
    public int posicionUbicacion1;
    public int posicionUbicacion2;

    /**
     * Funcion constructor de la ventana del servidor
     * @param nombre1 instancia del nombre 1
     * @param nombre2 instancia del nombre 2
     */
    public VentanaPrincipalServidor(String nombre1, String nombre2){
        this.nombre1=nombre1;
        this.nombre2=nombre2;
        ubicacionesCartas=new ListaDoble<>();
        n=new Graficos();
        this.turno=0;
        this.seleccionadas=0;
        this.tipo1="";
        this.tipo2="";
        this.puntaje1=0;
        this.puntaje2=0;
        cartas= new posicionesCartas();
        cartas.cargarPosiciones();
        emparejadas= new Pila();
        this.tipoElim="NULL";
        this.voltear2="NULL";
        this.voltear1="NULL";

    }

    /**
     * se inicia la venta del servidor para llevar las cartas
     */
    public void IniciarVentana(){
        JFrame framePrincipal = new JFrame("Ventana Servidor");
        JLabel labelNombre1 = new JLabel();
        principal=framePrincipal;
        labelNombre1.setText("Jugador 1: "+nombre1);
        JLabel labelNombre2 = new JLabel();
        labelNombre2.setText("Jugador 2: "+nombre2);

        JLabel puntos1= new JLabel();
        JLabel puntos2=new JLabel();
        puntos1.setText(String.valueOf(puntaje1));
        puntos2.setText(String.valueOf(puntaje2));


        //Creacion de tablero

        puntos1.setBounds(210,5,100,30);
        puntos2.setBounds(210,20,100,30);
        labelNombre1.setBounds(5,5,200,30);
        labelNombre2.setBounds(5,20,200,30);
        framePrincipal.add(labelNombre1);
        framePrincipal.add(labelNombre2);
        framePrincipal.add(puntos1);
        framePrincipal.add(puntos2);
        framePrincipal.add(n); //crea el tablero
        framePrincipal.setSize(500,500);
        framePrincipal.setVisible(true);

    }

    /**
     * Funcion que crea cada cartas
     * @param id id de la carta
     * @param tipo nombre de la imagen de la carta
     * @param posX posicion en X de la carta
     * @param posY posicion Y de la carta
     */
    public void crearCartas(String id, String tipo, double posX, double posY){
        objetosImagenes objeto = new objetosImagenes(id, tipo, posX,posY);
        ubicacionesCartas.agregarUltimo(objeto);
        principal.setVisible(false);
        refrescar();

    }

    /**
     * funcion que refresca la ventana para actualizar los objetos
     */
    public void refrescar(){
        JFrame framePrincipal = new JFrame("Ventana Servidor");
        principal=framePrincipal;
        JLabel labelNombre1 = new JLabel();
        labelNombre1.setText("Jugador 1: "+nombre1);
        JLabel labelNombre2 = new JLabel();
        labelNombre2.setText("Jugador 2: "+nombre2);
        labelNombre1.setBounds(5,5,100,30);
        labelNombre2.setBounds(5,20,100,30);

        JLabel puntos1= new JLabel();
        JLabel puntos2=new JLabel();
        puntos1.setText(String.valueOf(puntaje1));
        puntos2.setText(String.valueOf(puntaje2));
        puntos1.setBounds(210,5,100,30);
        puntos2.setBounds(210,20,100,30);
        int i=0;
        int largo=ubicacionesCartas.tamanoLista();
        //crea cada carta en el grid
        while(i<largo){
            JLabel carta = new JLabel();
            int posY= (int) ubicacionesCartas.obtenerDato(i).getPosicionY();
            int posX= (int) ubicacionesCartas.obtenerDato(i).getPosicionX();
            String tipo = ubicacionesCartas.obtenerDato(i).getId();
            carta.setText(tipo);
            carta.setBounds(posX-50,posY-24,15,15);
            framePrincipal.add(carta);
            i++;
        }

        framePrincipal.add(labelNombre1);
        framePrincipal.add(labelNombre2);
        framePrincipal.add(puntos1);
        framePrincipal.add(puntos2);

        framePrincipal.add(n); //crea el tablero
        framePrincipal.setSize(500,500);
        framePrincipal.setVisible(true);

    }


    public void comparar(double posX,double posY){
        ListaDoble<Integer> posiciones = cartas.posiciones;
        int largo = posiciones.tamanoLista();
        int i=0;
        int posicion =0;
        String tipo="";
        boolean cartaSeleccionada=false;
        //obtener el tipo de carta
        while(i<largo){
            int posiX=posiciones.obtenerDato(i);
            int posiX2=posiciones.obtenerDato(i)+66;
            int posiY=posiciones.obtenerDato(i+1);
            int posiY2=posiciones.obtenerDato(i+1)+69;
            if(posX<=posiX2 && posX>=posiX){
                if(posY>=posiY && posY<=posiY2){
                    objetosImagenes carta = ubicacionesCartas.obtenerDato(posicion); //se obtiene el elemento carta
                    tipo = carta.getId();
                    cartaSeleccionada=true;
                    posicionVoltear=String.valueOf(posicion);
                    if(seleccionadas==0){
                        posicionUbicacion1=i;
                    }else if(seleccionadas==1){
                        posicionUbicacion2=i;
                    }

                    break;
                }
            }
            posicion+=1;
            i+=2;
        }
        if(cartaSeleccionada) {
            if (seleccionadas == 0) { //si es la primera seleccion del turno
                seleccionadas += 1; //se le suma para saber que la proxima es la segunda
                tipo1 = tipo; //se guarda el tipo de la primera carta
                carta1 = ubicacionesCartas.obtenerDato(posicion);
                ubiPosicion1 = posicion;
            } else if (seleccionadas == 1) { //cuando ya hay 2 cartas seleccionadas
                carta2 = ubicacionesCartas.obtenerDato(posicion); //se obtiene la carta
                ubiPosicion2 = posicion;
                tipo2 = tipo;
                int tip1 = Integer.parseInt(tipo1);
                int tip2 = Integer.parseInt(tipo2);
                if (tip1 == tip2) {
                    ubicacionesCartas.borrarDato(carta1);
                    ubicacionesCartas.borrarDato(carta2);
                    emparejadas.apilar(carta1);
                    emparejadas.apilar(carta2);
                    posiciones.borrarDato(posicionUbicacion1);
                    posiciones.borrarDato(posicionUbicacion2);
                    if (turno == 0) {
                        puntaje1 += 1;
                    } else if (turno == 1) {
                        puntaje2 += 1;
                    }
                    principal.setVisible(false);
                    refrescar();
                } else {
                    voltear1=String.valueOf(ubiPosicion1);
                    voltear2=String.valueOf(ubiPosicion2);
                }
                //pasa al siguiente turno
                if (turno == 0) {
                    turno += 1;
                } else if (turno == 1) {
                    turno = 0;
                }
                seleccionadas = 0;
            }
        }

    }

    /**
     * Funcion que indica si hay un tipo de carta que eliminar
     * @return retorna el tipo de carta a eliminar o NULL si no hay que eliminar cartas
     */
    public String getTipoEliminar(){
        String tipoE=tipoElim;
        tipoElim="NULL";
        return tipoE;
    }

    /**
     * Funcion que dice cual posicion de carta se voltea
     * @return la posicion en la lista de la carta a voltear
     */
    public String getPosicionVoltear(){
        return posicionVoltear;
    }

    public String getPosicion1Regresar(){
        String posicion =voltear1;
        voltear1="NULL";
        return posicion;
    }
    public String getPosicion2Regresar(){
        String posicion=voltear2;
        voltear2="NULL";
        return posicion;
    }


}


class Graficos extends Canvas{
    private Graphics gra;
    public void paint(Graphics g){
        super.paint(g);
        int valorY=75;
        for(int i=0;i<5;i++){
            g.drawLine(40,valorY,300,valorY);
            valorY+=63;
        }
        int valorX=40;
        for(int j=0;j<5;j++){
            g.drawLine(valorX,75,valorX,327);
            valorX+=65;
        }
    }
}

