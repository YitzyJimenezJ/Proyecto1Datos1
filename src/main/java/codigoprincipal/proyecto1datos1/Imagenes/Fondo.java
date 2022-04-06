package codigoprincipal.proyecto1datos1.Imagenes;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class Fondo {
    private static ImageView fondo;
    public Fondo(Group juego){
        fondo = new ImageView(Imagenes.getInstancia().getFondoPrincipal());
        fondo.setX(0);
        fondo.setY(0);
        juego.getChildren().add(fondo);
    }

    public static void IniciarFondo(Group ventanaJuego){ new Fondo(ventanaJuego);}

    public static void setFondo(String categoria){
        switch (categoria){
            case "frutas": fondo.setImage(Imagenes.getInstancia().getFondoPrincipal());
            case "animales": fondo.setImage(Imagenes.getInstancia().getFondoPrincipal());
            case "flores": fondo.setImage(Imagenes.getInstancia().getFondoPrincipal());
        }
    }
}
