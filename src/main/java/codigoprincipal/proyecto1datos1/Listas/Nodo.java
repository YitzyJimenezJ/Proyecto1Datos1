package codigoprincipal.proyecto1datos1.Listas;

import java.io.Serializable;

class Nodo<T> implements Serializable {
    public Nodo siguiente;
    public Nodo anterior;
    public T valor;
    public int posicion;
    public Nodo(){
        this.valor=null;
        this.siguiente=null;
        this.anterior=null;
        this.posicion=0;
    }
    public Nodo(T dato){
        this.valor=null;
        this.siguiente=null;
        this.anterior=null;
        this.posicion=0;
    }

    public T getDato(){return this.valor;}
    public void setDato(T valor){this.valor=valor;}
    public Nodo<T> getSiguiente(){return this.siguiente;}
    public void setSiguiente(Nodo<T> nodo){this.siguiente = nodo;}
    public int getPosicion(){return posicion;}
    public void setPosicion(int posicion){this.posicion = posicion;}

}
