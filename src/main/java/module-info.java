module codigoprincipal.proyecto1datos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens codigoprincipal.proyecto1datos1 to javafx.fxml;
    exports codigoprincipal.proyecto1datos1;
}