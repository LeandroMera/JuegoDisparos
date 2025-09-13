package org.gorditodev.juegodisparosdemo;

import javafx.scene.layout.Pane;

public class PanelJuego extends Pane {

    private static PanelJuego panel;
    private PJ pj;
    public PanelJuego() {
        pj = new PJ();
        panel = this;
        montarEscena();
    }
    private void montarEscena() {
        //anadir personaje al panel
        getChildren().add(pj);

    }

    public static PanelJuego getPanel() {
        return panel;
    }
}
