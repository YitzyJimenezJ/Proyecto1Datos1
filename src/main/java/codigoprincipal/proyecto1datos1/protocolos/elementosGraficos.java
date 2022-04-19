package codigoprincipal.proyecto1datos1.protocolos;

import codigoprincipal.proyecto1datos1.Listas.Lista;
import codigoprincipal.proyecto1datos1.Listas.ListaCircular;

import java.util.Random;

public class elementosGraficos {
    private Lista<objetosImagenes> elementos = new ListaCircular<>();
    public static final elementosGraficos singleton = new elementosGraficos();

    private int tipo1 = 0;
    private int tipo2 = 0;
    private int tipo3 = 0;
    private int tipo4 = 0;
    private int tipo5 = 0;
    private int tipo6 = 0;
    private int tipo7 = 0;
    private int tipo8 = 0;


    public objetosImagenes crearElemento(String id, String tipoImagen) {
        objetosImagenes imagenActual = new objetosImagenes(id, tipoImagen);
        return imagenActual;
    }

    public Lista<objetosImagenes> getElementos() {
        return elementos;
    }

    public void addElemento(objetosImagenes elemento) {
        elementos.agregarUltimo(elemento);
    }

    public void crearElementos() {
        for (int i = 0; i < elementos.tamanoLista(); i++) {
            elementos.obtenerDato(i).quitarImagen();
            elementos.borrarDato(elementos.obtenerDato(i));
        }
    }

    public void removerElemento(String ID) {
        int i = encontrarElementoIndice(ID);
        if (i >= 0) {
            elementos.obtenerDato(i).quitarImagen();
            elementos.borrarDato(elementos.obtenerDato(i));
        }
    }

    public objetosImagenes encontrarElemento(String ID) {
        for (int i = 0; i < elementos.tamanoLista(); i++) {
            String IDelemento = elementos.obtenerDato(i).getId();
            if (ID.equals(IDelemento)) {
                return elementos.obtenerDato(i);
            }
        }
        return null;
    }


    public int encontrarElementoIndice(String ID) {
        int i = 0;
        while (i < elementos.tamanoLista()) {
            String IDelemento = elementos.obtenerDato(i).getId();
            if (ID.equals(IDelemento)) {
                return i;
            }
            i++;
        }
        return -1;
    }


    public void sumarTipo(int numero) {
        if (numero == 1) {
            tipo1 += 1;
        } else if (numero == 2) {
            tipo2 += 1;
        } else if (numero == 3) {
            tipo3 += 1;
        } else if (numero == 4) {
            tipo4 += 1;
        } else if (numero == 5) {
            tipo5 += 1;
        } else if (numero == 6) {
            tipo6 += 1;
        } else if (numero == 7) {
            tipo7 += 1;
        } else if (numero == 8) {
            tipo8 += 1;
        }
    }

    public boolean verificar(int numero) {
        boolean repetido = false;
        if (numero == 1) {
            if (tipo1 >= 2) {
                repetido = true;
            }
        } else if (numero == 2) {
            if (tipo2 >= 2) {
                repetido = true;
            }
        } else if (numero == 3) {
            if (tipo3 >= 2) {
                repetido = true;
            }
        } else if (numero == 4) {
            if (tipo4 >= 2) {
                repetido = true;
            }
        } else if (numero == 5) {
            if (tipo5 >= 2) {
                repetido = true;
            }
        } else if (numero == 6) {
            if (tipo6 >= 2) {
                repetido = true;
            }
        } else if (numero == 7) {
            if (tipo7 >= 2) {
                repetido = true;
            }
        } else if (numero == 8) {
            if (tipo8 >= 2) {
                repetido = true;
            }
        }
        return repetido;
    }

    public int generarTipo() {
        Random rand = new Random();
        int numero = rand.nextInt(8) + 1;
        if (numero == 1 && !verificar(numero)) {
            sumarTipo(numero);
        } else if (numero == 2 && !verificar(numero)) {
            sumarTipo(numero);
        } else if (numero == 3 && !verificar(numero)) {
            sumarTipo(numero);
        } else if (numero == 4 && !verificar(numero)) {
            sumarTipo(numero);
        } else if (numero == 5 && !verificar(numero)) {
            sumarTipo(numero);
        } else if (numero == 6 && !verificar(numero)) {
            sumarTipo(numero);
        } else if (numero == 7 && !verificar(numero)) {
            sumarTipo(numero);
        } else if (numero == 8 && !verificar(numero)) {
            sumarTipo(numero);
        } else if (verificar(numero)) {
            return generarTipo();
        }
        return numero;
    }
}