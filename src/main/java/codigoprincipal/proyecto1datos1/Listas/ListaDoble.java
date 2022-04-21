package codigoprincipal.proyecto1datos1.Listas;

import java.io.Serializable;
import java.util.List;

public class ListaDoble<T> implements Serializable, Lista<T> {
    public Nodo<T> primero;
    public Nodo<T> ultimo;
    private int largo;

    public ListaDoble(){
        primero=null;
        ultimo=null;
        largo=0;
    }
    public int tamanoLista(){return largo;}

    public void agregarPrimero(T dato) {
        if (this.primero == null) {
            this.primero = new Nodo<>();
            this.ultimo = this.primero;
        } else {
            Nodo<T> actual = new Nodo<>(dato);
            actual.siguiente = this.primero;
            this.primero.anterior = actual;
            this.primero = actual;
        }
        largo++;
    }
    public void agregarUltimo(T dato) {
        if (this.primero == null) {
            this.primero = new Nodo<>(dato);
            this.ultimo = this.primero;
        } else {
            Nodo<T> actual = this.primero;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            Nodo<T> temporal = this.ultimo;
            Nodo<T> anterior = temporal;
            temporal.siguiente = new Nodo<>(dato);
            temporal = temporal.siguiente;
            temporal.anterior = anterior;
            this.ultimo = temporal;
        }
        largo++;
    }
    public void borrarDato(T t) {
        if (this.primero == null) {
            return;
        }
        Nodo<T> nodo = this.primero;
        if (nodo.getDato() == t) {
            this.primero = this.primero.siguiente;
        } else {
            boolean estaContenido = false;
            Nodo<T> temporal = this.primero;
            while (temporal.siguiente != null) {
                if (temporal.siguiente.getDato() == t) {
                    estaContenido = true;
                    Nodo<T> ante = temporal.siguiente.siguiente;
                    temporal.siguiente = temporal.siguiente.siguiente;
                    ante.anterior = ante.anterior.anterior;
                    break;
                } else {
                    temporal = temporal.siguiente;
                }
            }
        }largo--;
    }
    public T obtenerDato(int index){
        if (index >= largo){
            return null;
        }
        Nodo<T> actual= primero;
        for(int i = 0; i < index; ++i){
            actual = actual.siguiente;
        }
        return actual.getDato();
    }

    public static void main(String[] args){
        ListaDoble<String> L = new ListaDoble<>();
        L.agregarUltimo("2");
        L.agregarUltimo("4");
        System.out.println(L.tamanoLista());
    }
}



