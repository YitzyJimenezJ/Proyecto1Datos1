package codigoprincipal.proyecto1datos1.Listas;

import codigoprincipal.proyecto1datos1.protocolos.objetosImagenes;


public class Pila {

    private nodoPila inicio;
    private int tamanio;

    public Pila(){
        inicio = null;
        tamanio = 0;
    }
    /**
     * Consulta si la pila esta vacia.
     * @return true si el inicio esta vacio y false si no
     */
    public boolean esVacia(){
        return inicio == null;
    }
    /**
     * Agrega un nuevo nodo a la pila.
     * @param valor a agregar.
     */
    public void apilar(objetosImagenes valor){
        nodoPila nuevo = new nodoPila();
        nuevo.setValor(valor);
        if (esVacia()) {
            inicio = nuevo;
        }
        else{
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
        tamanio++;
    }
}
