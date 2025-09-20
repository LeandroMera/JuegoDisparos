package org.gorditodev.juegodisparosdemo;

import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Disparo extends Rectangle {

    private PanelJuego panel;
    private AnimationTimer t;
    private boolean enPantalla;//booleano para controlar los disparos y asi se eliminen para que no consuma mas recursos
    private static int nDisparos = 0;// limite de disparos


    public Disparo(double posX, double posY) {
       super(posX, posY -25, 3, 25);//Tamaño del obj y posicion correcta del laser
       nDisparos++;// iniciamos contador de disparos
       panel = PanelJuego.getPanel();
       enPantalla = true;
       setFill(Color.DARKVIOLET);//color del laser
       subir();
    }

    private void subir() {
        t = new AnimationTimer() {
            @Override
            public void handle(long ahora) {
                setLayoutY(getLayoutY() - 7);
                if(getBoundsInParent().getMaxY() <= 0) enPantalla = false;//Controla para eliminar el disparo para no usar mas recursos
//Gestion de impactos y eliminacion de enemigos
                ArrayList<EnemigoAbs> enemigos = GestionEnemigos.getEnemigos();
                for(int i = 0; i<enemigos.size(); i++){
                    EnemigoAbs e = enemigos.get(i);

                    if(getBoundsInParent().intersects(e.getBoundsInParent())){
                        enPantalla = false;
                        e.reducirVida();

                        if(e.getVida()<= 0){
                            e.getAnimador().stop();
                            panel.getChildren().remove(e);
                            enemigos.remove(e);
                        }
                    }
                }
/// /////
                if(!enPantalla) {
                    nDisparos--;
                    t.stop();
                    panel.getChildren().remove(Disparo.this);
                }
            }
        };
        t.start();
    }

    public static int getNDisparos() {
        return nDisparos;
    }
}
