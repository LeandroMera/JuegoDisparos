package org.gorditodev.juegodisparosdemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage escenario) throws Exception {
        Scene scena = new Scene(new PanelRaiz(), 500, 800); // cambia el ancho y el alto del contenedor del juego, es la clase principal
        escenario.setScene(scena);
        escenario.show();

    }

    public static void main(String[] args) {

        launch(args);
    }


}
