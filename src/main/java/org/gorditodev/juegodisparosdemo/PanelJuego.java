package org.gorditodev.juegodisparosdemo;

import javafx.scene.layout.Pane;

public class PanelJuego extends Pane {

    private static PanelJuego panel;
    private PJ pj;
    public PanelJuego() {
        panel = this;
        pj = new PJ();
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
