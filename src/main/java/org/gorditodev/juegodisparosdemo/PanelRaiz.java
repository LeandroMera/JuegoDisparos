package org.gorditodev.juegodisparosdemo;

import javafx.scene.layout.BorderPane;

public class PanelRaiz extends BorderPane {
    public PanelRaiz() {
        //set center
        setCenter(new PanelJuego());
        //set bottom
    }
}
