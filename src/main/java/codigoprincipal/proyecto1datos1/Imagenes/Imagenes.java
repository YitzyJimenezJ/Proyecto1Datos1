package codigoprincipal.proyecto1datos1.Imagenes;

import javafx.scene.image.Image;

import java.io.InputStream;

public class Imagenes {
    private static Imagenes instancia = null;

    public static final String imgFondoPrincipal="/codigoprincipal/proyecto1datos1/Imagenes/fondo.jpg";
    public static final String imgBananos="/codigoprincipal/proyecto1datos1/Imagenes/bananos.jpg";
    public static final String imgBlancas="/codigoprincipal/proyecto1datos1/Imagenes/blanzas.jpg";
    public static final String imgConejo="/codigoprincipal/proyecto1datos1/Imagenes/conejo.jpg";
    public static final String imgErizo="/codigoprincipal/proyecto1datos1/Imagenes/erizo.jpg";
    public static final String imgFlorAzul="/codigoprincipal/proyecto1datos1/Imagenes/florAzul.jpg";
    public static final String imgFondoAnimales="/codigoprincipal/proyecto1datos1/Imagenes/fondoAnimales.jpg";
    public static final String imgFresas="/codigoprincipal/proyecto1datos1/Imagenes/fresas.jpg";
    public static final String imgFur="/codigoprincipal/proyecto1datos1/Imagenes/fur.jpg";
    public static final String imgGato="/codigoprincipal/proyecto1datos1/Imagenes/gato.jpg";
    public static final String imgGirasol="/codigoprincipal/proyecto1datos1/Imagenes/girasol.jpg";
    public static final String imgKiwi="/codigoprincipal/proyecto1datos1/Imagenes/kiwi.jpg";
    public static final String imgLapa="/codigoprincipal/proyecto1datos1/Imagenes/lapa.jpg";
    public static final String imgMoradas="/codigoprincipal/proyecto1datos1/Imagenes/moradas.jpg";
    public static final String imgNaranja="/codigoprincipal/proyecto1datos1/Imagenes/naranja.jpg";
    public static final String imgNutria="/codigoprincipal/proyecto1datos1/Imagenes/nutria.jpg";
    public static final String imgOso="/codigoprincipal/proyecto1datos1/Imagenes/oso.jpg";
    public static final String imgPapaya="/codigoprincipal/proyecto1datos1/Imagenes/papaya.jpg";
    public static final String imgPerro="/codigoprincipal/proyecto1datos1/Imagenes/perro.jpg";
    public static final String imgPina="/codigoprincipal/proyecto1datos1/Imagenes/pina.jpg";
    public static final String imgRosa="/codigoprincipal/proyecto1datos1/Imagenes/rosa.jpg";
    public static final String imgRosadas="/codigoprincipal/proyecto1datos1/Imagenes/rosadas.jpg";
    public static final String imgRosada2="/codigoprincipal/proyecto1datos1/Imagenes/rosadasihj.jpg";
    public static final String imgSandia="/codigoprincipal/proyecto1datos1/Imagenes/sandia.jpg";
    public static final String imgTulipanes="/codigoprincipal/proyecto1datos1/Imagenes/tulipanes.jpg";
    public static final String imgUvas="/codigoprincipal/proyecto1datos1/Imagenes/uvas.jpg";
    public static final String imgVaca="/codigoprincipal/proyecto1datos1/Imagenes/vaca.jpg";

    //imagenes para seleccionar
    private Image fondoPrincipal=null;
    private Image bananos=null;
    private Image blancas=null;
    private Image conejo=null;
    private Image erizo=null;
    private Image florAzul=null;
    private Image fondoAnimales=null;
    private Image fresas=null;
    private Image gato=null;
    private Image girasol=null;
    private Image kiwi=null;
    private Image lapa=null;
    private Image moradas=null;
    private Image naranja=null;
    private Image nutria=null;
    private Image oso=null;
    private Image papaya=null;
    private Image perro=null;
    private Image pina=null;
    private Image rosa=null;
    private Image rosadas=null;
    private Image rosadas2=null;
    private Image sandia=null;
    private Image tulipanes=null;
    private Image uvas=null;
    private Image vaca=null;

    //constructor de las imagenes
    private Imagenes(){cargarImagenes();}

    //se hace sincronizado el metodo para evitar conflictos si se corre con hilos
    public static synchronized Imagenes getInstancia(){
        if(instancia==null){
            instancia=new Imagenes();
        }return instancia;
    }
    //le asigna a todas las imagenes su ruta
    private void cargarImagenes(){
        fondoPrincipal=cargarImagen(imgFondoPrincipal);
    }

    public Image cargarImagen(String nombre){
        Image enviar = null;
        try{
            InputStream inputS = this.getClass().getResourceAsStream(nombre);
            enviar = new Image(inputS);
        } catch (Exception e){
            e.printStackTrace();
        }return enviar;
    }
    public Image getFondoPrincipal(){return fondoPrincipal;}


}
