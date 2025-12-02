package org.gorditodev.juegodisparosdemo.vista;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import org.gorditodev.juegodisparosdemo.utiles.GestionEscenas;

import java.awt.*;

public class MenuInicio extends BorderPane {

    private Button bJugar, bSalir;
    private VBox boxBotones;

    public MenuInicio() {
        bJugar = new Button("Jugar");
        bSalir = new Button("Salir");
        boxBotones = new VBox(10);
        montarEscena();
    }
    private void montarEscena() {
        bJugar.setOnAction(e -> GestionEscenas.escenaJuego());
        bSalir.setOnAction(e -> System.exit(0));
        boxBotones.getChildren().addAll(bJugar, bSalir);
        boxBotones.setAlignment(Pos.CENTER);
        setCenter(boxBotones);
    }
}
