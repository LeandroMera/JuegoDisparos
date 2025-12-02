package org.gorditodev.juegodisparosdemo.utiles;

import javafx.animation.AnimationTimer;
import org.gorditodev.juegodisparosdemo.vista.PanelJuego;


public class GestionObjetos {
    private static AnimationTimer t;
    private static PanelJuego panel;
    private  static boolean crearObj = false;

    public static void comenzar(){// hace aparecer el enemigo con el tiempo de salida

        panel = PanelJuego.getPanel();

        t = new AnimationTimer() {
            @Override
            public void handle(long ahora) {
                if((ContadorTiempo.getSegundos() % 30)  == 0 && crearObj == true){//Aqui se calcula el tiempo de salida

                    ObjMejora o = new ObjMejora();
                    panel.getChildren().add(o);
                    crearObj = false;
                }

                if ((ContadorTiempo.getSegundos() % 30)  != 0){
                    crearObj = true;
                }
            }
        };

        t.start();
    }
}
