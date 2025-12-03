package org.gorditodev.juegodisparosdemo.vista;

import javafx.scene.layout.Pane;
import org.gorditodev.juegodisparosdemo.utiles.GestionEnemigos;
import org.gorditodev.juegodisparosdemo.utiles.GestionObjetos;
import org.gorditodev.juegodisparosdemo.utiles.PJ;

public class PanelJuego extends Pane {

    private static PanelJuego panel;
    private PJ pj;
    public PanelJuego() {
        widthProperty().addListener((obs, oldV, newV) -> montarEscena());
        heightProperty().addListener((obs, oldV, newV) -> montarEscena());

        panel = this;
        pj = new PJ();
        montarEscena();
        GestionEnemigos.comenzar();
        GestionObjetos.comenzar();
    }
    private void montarEscena() {
        //anadir personaje al panel
        String bg = getClass().getResource("/img/fondo.png").toExternalForm();
        setStyle("-fx-background-image: url('" + bg + "');" +
                "-fx-background-size: cover;" +
                "-fx-background-repeat: no-repeat;" +
                "-fx-background-position: center;");
        getChildren().add(pj);

    }



    public static PanelJuego getPanel() {
        return panel;
    }
}

