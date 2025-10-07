package org.gorditodev.juegodisparosdemo.utiles;

import javafx.animation.AnimationTimer;
import org.gorditodev.juegodisparosdemo.enemigos.EnemigoAbs;
import org.gorditodev.juegodisparosdemo.enemigos.EnemigoComun;
import org.gorditodev.juegodisparosdemo.enemigos.EnemigoJefe;
import org.gorditodev.juegodisparosdemo.enemigos.EnemigoZig;
import org.gorditodev.juegodisparosdemo.vista.PanelJuego;

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
                    EnemigoAbs e2 = Math.random() > 0.15 ? new EnemigoComun() : new EnemigoZig();//Hace aparecer el enemigo zig

                    enemigos.add(e);
                    enemigos.add(e2);//añade a arraylist el nemigo zig
                    panel.getChildren().addAll(e, e2);
//Aparicion de el enemigo jefe 1
                    if(tAparicion < 1_000_000_000  && Math.random() > 0.95) {
                        EnemigoAbs e3 = new EnemigoJefe();
                        enemigos.add(e3);
                        panel.getChildren().add(e3);
                    }//
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

