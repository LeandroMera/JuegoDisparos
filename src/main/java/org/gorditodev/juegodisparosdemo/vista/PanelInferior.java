package org.gorditodev.juegodisparosdemo.vista;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import org.gorditodev.juegodisparosdemo.utiles.ContadorTiempo;
import org.gorditodev.juegodisparosdemo.utiles.EtPuntuacion;
import org.gorditodev.juegodisparosdemo.utiles.Vida;

import java.util.ArrayList;

public class PanelInferior extends StackPane {
    private EtPuntuacion puntos;
    private ArrayList<Vida> vidas;
    private static PanelInferior panel;
    private static HBox hBox;

    public PanelInferior() {
        puntos = EtPuntuacion.getPuntuacion();
        vidas = Vida.getVidas();
        hBox = new HBox(10);
        setStyle("-fx-background-color: #efe9e9");
        montarEscena();
        panel = this;
        //HBox puntuaciones = new HBox();
    }
    private void montarEscena() {
        Region espacio = new Region();
        HBox.setHgrow(espacio, Priority.ALWAYS);

        Region espacio2 = new Region();
        HBox.setHgrow(espacio2, Priority.ALWAYS);

        for(Vida v : vidas) hBox.getChildren().add(v);
        hBox.getChildren().addAll((Node) espacio, ContadorTiempo.getContador(), espacio2, puntos);
        hBox.setAlignment(Pos.CENTER);

        getChildren().addAll(hBox, ContadorTiempo.getContador());
        StackPane.setAlignment(ContadorTiempo.getContador(), Pos.CENTER);
    }

    public static PanelInferior getPanel(){
        return panel;
    }

    public HBox getHBox(){
        return hBox;
    }
}
