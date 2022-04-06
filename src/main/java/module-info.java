module codigoprincipal.proyecto1datos1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens codigoprincipal.proyecto1datos1 to javafx.fxml;
    exports codigoprincipal.proyecto1datos1;
}