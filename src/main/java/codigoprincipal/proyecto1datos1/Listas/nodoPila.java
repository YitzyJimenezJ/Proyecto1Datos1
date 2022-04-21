package codigoprincipal.proyecto1datos1.Listas;

import codigoprincipal.proyecto1datos1.protocolos.objetosImagenes;

public class nodoPila {
    private objetosImagenes valor;
    private nodoPila siguiente;
    /**
     * Constructor del nodo
     */
    public void nodoPila(){
        this.valor = null;
        this.siguiente = null;
    }

    public objetosImagenes getValor() {
        return valor;
    }

    public void setValor(objetosImagenes valor) {
        this.valor = valor;
    }

    public void setSiguiente(nodoPila siguiente) {
        this.siguiente = siguiente;
    }
}
