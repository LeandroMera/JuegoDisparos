package org.gorditodev.juegodisparosdemo.utiles;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class ContadorTiempo {
    //00:00
    private static int segundos = 0;
    private static Label etiqueta ;
    private static Timeline tl;
    private static ContadorTiempo contador = new  ContadorTiempo();

    private ContadorTiempo() {
        etiqueta = new Label();
        actEtiqueta();

        tl = new Timeline(new KeyFrame(Duration.seconds(1), e-> {
            segundos++;
            actEtiqueta();
            })
        );

        tl.setCycleCount(Timeline.INDEFINITE);

        empezar();
    }

    private static void actEtiqueta() {
        int minutos = segundos/60;  // obtenemos los minutis
        int segundosF = segundos%60; // obtenemos los segundos
        etiqueta.setText(String.format("%02d:%02d", minutos, segundosF));// Actualiza cada segundo el tiempo, debes hacer las etiquetas para minutos y segundos

    }

    public static void empezar(){
        tl.play();
    }

    public static Label getContador(){
        return etiqueta;
    }
}
