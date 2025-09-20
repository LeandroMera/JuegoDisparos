package org.gorditodev.juegodisparosdemo;

import javafx.animation.AnimationTimer;

import java.util.ArrayList;



public class GestionEnemigos {

    private static AnimationTimer t;
    private static PanelJuego panel;
    private static long tAparicion = 2_000_000_000;
    private static long tAnterior = 0;

    //Array para guardar los enemigos
    private static ArrayList<EnemigoAbs> enemigos = new ArrayList<EnemigoAbs>();

    public static void comenzar(){// hace aparecer el enemigo con el tiempo de salida

        panel = PanelJuego.getPanel();

        t = new AnimationTimer() {
            @Override
            public void handle(long ahora) {
                if(ahora - tAnterior >= tAparicion){//Aqui se calcula el tiempo de salida

                    if (tAparicion > 500_000_000) tAparicion -= 5_000_000;//Hace que los enemigos salgan mas rapidos por que resta

                    EnemigoAbs e = new EnemigoComun();
                    enemigos.add(e);
                    panel.getChildren().add(e);
                    tAnterior = ahora;
                }
            }
        };

        t.start();
    }

    public static ArrayList<EnemigoAbs> getEnemigos(){
        return enemigos;
    }
}

