package codigoprincipal.proyecto1datos1.Imagenes;

import codigoprincipal.proyecto1datos1.Listas.Lista;
import codigoprincipal.proyecto1datos1.Listas.ListaDoble;

public class posicionesCartas {
    public ListaDoble<Integer> posiciones;

    public posicionesCartas(){
        posiciones=new ListaDoble<>();
    }
    public void cargarPosiciones(){
        int posicionX=106;
        int posicionY=100;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                posiciones.agregarUltimo(posicionX);
                posiciones.agregarUltimo(posicionY);
                posicionX+=76;
            }
            posicionX=106;
            posicionY+=80;
        }
    }
    public int getPosicion(int i){
        return posiciones.obtenerDato(i);
    }


}
