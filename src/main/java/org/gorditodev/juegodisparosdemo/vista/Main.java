package org.gorditodev.juegodisparosdemo.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.gorditodev.juegodisparosdemo.utiles.GestionEscenas;

public class Main extends Application {

    private static Stage escenario;

    @Override
    public void start(Stage escenario) throws Exception {
        this.escenario = escenario;
        GestionEscenas.escenaMenu();
        escenario.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getEscenario() {
        return escenario;
    }


}
