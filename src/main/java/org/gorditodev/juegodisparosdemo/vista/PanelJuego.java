package org.gorditodev.juegodisparosdemo.vista;

import javafx.scene.layout.Pane;
import org.gorditodev.juegodisparosdemo.utiles.GestionEnemigos;
import org.gorditodev.juegodisparosdemo.utiles.GestionObjetos;
import org.gorditodev.juegodisparosdemo.utiles.PJ;

public class PanelJuego extends Pane {

    private static PanelJuego panel;
    private PJ pj;
    public PanelJuego() {
        panel = this;
        pj = new PJ();
        montarEscena();
        GestionEnemigos.comenzar();
        GestionObjetos.comenzar();
    }
    private void montarEscena() {
        //anadir personaje al panel
        getChildren().add(pj);

    }

    public static PanelJuego getPanel() {
        return panel;
    }
}
