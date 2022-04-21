package codigoprincipal.proyecto1datos1.Listas;

import java.io.Serializable;

class Nodo<T> implements Serializable {
    public Nodo<T> siguiente;
    public Nodo<T> anterior;
    public T valor;
    public int posicion;
    public Nodo(){
        this.valor=null;
        this.siguiente=null;
        this.anterior=null;
        this.posicion=0;
    }
    public Nodo(T dato){
        this.valor=dato;
        this.siguiente=null;
        this.anterior=null;
        this.posicion=0;
    }

    public T getDato(){return this.valor;}

}
