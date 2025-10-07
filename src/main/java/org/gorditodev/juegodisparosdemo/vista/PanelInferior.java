package org.gorditodev.juegodisparosdemo.vista;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import org.gorditodev.juegodisparosdemo.utiles.ContadorTiempo;
import org.gorditodev.juegodisparosdemo.utiles.Puntuacion;
import org.gorditodev.juegodisparosdemo.utiles.Vida;

import java.util.ArrayList;

public class PanelInferior extends HBox {
    private Puntuacion puntos;
    private ArrayList<Vida> vidas;
    private static PanelInferior panel;

    public PanelInferior() {
        puntos = Puntuacion.getPuntuacion();
        vidas = Vida.getVidas();
        setStyle("-fx-background-color: #DED8D7");
        montarEscena();
        panel = this;
        //HBox puntuaciones = new HBox();
    }
    private void montarEscena() {
        Region espacio = new Region();
        HBox.setHgrow(espacio, Priority.ALWAYS);

        Region espacio2 = new Region();
        HBox.setHgrow(espacio2, Priority.ALWAYS);

        for(Vida v : vidas) getChildren().add(v);
        getChildren().addAll((Node) espacio, ContadorTiempo.getContador(), espacio2, puntos);
        setAlignment(Pos.CENTER);
    }

    public static PanelInferior getPanel(){
        return panel;
    }
}
