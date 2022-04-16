package codigoprincipal.proyecto1datos1.protocolos;

import codigoprincipal.proyecto1datos1.Listas.Lista;
import codigoprincipal.proyecto1datos1.Listas.ListaCircular;

public class elementosGraficos {
    private Lista<objetosImagenes> elementos = new ListaCircular<>();
    public static final elementosGraficos singleton=new elementosGraficos();

    public objetosImagenes crearElemento(String id, String tipoImagen){
        objetosImagenes imagenActual = new objetosImagenes(id, tipoImagen);
        return imagenActual;
    }

    public Lista<objetosImagenes> getElementos(){return elementos;}
    public void addElemento(objetosImagenes elemento){elementos.agregarUltimo(elemento);}
    public void crearElementos(){
        for(int i=0;i<elementos.tamanoLista();i++){
            elementos.obtenerDato(i).quitarImagen();
            elementos.borrarDato(elementos.obtenerDato(i));
        }
    }
    public void removerElemento(String ID){
        int i = encontrarElementoIndice(ID);
        if(i>=0){
            elementos.obtenerDato(i).quitarImagen();
            elementos.borrarDato(elementos.obtenerDato(i));
        }
    }
    public objetosImagenes encontrarElemento(String ID){
        for(int i=0;i<elementos.tamanoLista();i++){
            String IDelemento = elementos.obtenerDato(i).getId();
            if(ID.equals(IDelemento)){
                return elementos.obtenerDato(i);
            }
        }
        return null;
    }


    public int encontrarElementoIndice(String ID){
        int i = 0;
        while(i< elementos.tamanoLista()){
            String IDelemento = elementos.obtenerDato(i).getId();
            if(ID.equals(IDelemento)){
                return i;
            }
            i++;
        }
        return -1;
    }

}
