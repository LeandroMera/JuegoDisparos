module org.gorditodev.juegodisparosdemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.desktop;
    requires javafx.graphics;
    requires java.sql;
    // requires org.gorditodev.juegodisparosdemo;

    opens org.gorditodev.juegodisparosdemo to javafx.fxml;
    exports org.gorditodev.juegodisparosdemo;
    exports org.gorditodev.juegodisparosdemo.vista;
    opens org.gorditodev.juegodisparosdemo.vista to javafx.fxml;
    exports org.gorditodev.juegodisparosdemo.enemigos;
    opens org.gorditodev.juegodisparosdemo.enemigos to javafx.fxml;
    exports org.gorditodev.juegodisparosdemo.utiles;
    opens org.gorditodev.juegodisparosdemo.utiles to javafx.fxml;
}