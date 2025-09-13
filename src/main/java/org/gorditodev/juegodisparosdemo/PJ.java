package org.gorditodev.juegodisparosdemo;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import java.awt.*;




public class PJ extends Rectangle {

    private  PanelJuego panel;

    public PJ() {
        super(250, 700, 50, 50);
        panel = PanelJuego.getPanel();
        setFill(Color.RED);// aveces sale erro por no importar la libreria -> import javafx.scene.paint.Color;
    }


}
