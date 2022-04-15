package codigoprincipal.proyecto1datos1.protocolos;

import codigoprincipal.proyecto1datos1.Imagenes.Imagenes;
import javafx.scene.image.ImageView;

public class objetosImagenes {
    private String id;
    private String tipoImagen;
    private ImageView imagen;
    private double posicionX;
    private double posicionY;
    private String estado;

    public objetosImagenes(String id, String tipoImagen, double posicionX, double posicionY){
        this(id, tipoImagen);
        this.posicionX=posicionX;
        this.posicionY=posicionY;

    }

    public objetosImagenes(String id, String tipoImagen) {
        this.imagen = new ImageView(Imagenes.getInstancia().cargarImagen(tipoImagen));
        this.tipoImagen = tipoImagen;
        this.id = id;
        imagen.setId(id);
    }

    public void reposition(double x, double y){
        imagen.setX(x);
        imagen.setY(y);
        posicionY=y;
        posicionX=x;
    }

    public void quitarImagen(){
        imagen.setVisible(false);
    }

    public String getId(){return id;}
    public ImageView getImagen(){return imagen;}
    public double getPosicionX(){return posicionX;}
    public double getPosicionY(){return posicionY;}
    public String getTipoImagen(){return tipoImagen;}
}


