package org.gorditodev.juegodisparosdemo.vista;

import javafx.scene.layout.BorderPane;

public class PanelRaiz extends BorderPane {
    public PanelRaiz() {
        //set center
        setCenter(new PanelJuego());
        //set bottom
        setBottom(new PanelInferior());
    }
}
