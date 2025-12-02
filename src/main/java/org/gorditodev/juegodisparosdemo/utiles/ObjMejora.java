package org.gorditodev.juegodisparosdemo.utiles;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.gorditodev.juegodisparosdemo.vista.PanelJuego;

public class ObjMejora extends Rectangle {

    private PanelJuego panel;
    private Image imagen;
    private AnimationTimer t;

    public ObjMejora() {
        super(Math.random()*70, -30, 30, 30);
        setFill(Color.GOLD);
        panel = PanelJuego.getPanel();
        bajar();
    }

    private void bajar() {
        t = new AnimationTimer() {
            @Override
            public void handle(long ahora) {
                setLayoutY(getLayoutY() + 1);

                comprobarColision();
            }
        };
        t.start();
    }
    private void comprobarColision() {
        if(getBoundsInParent().getMaxY() >= panel.getHeight()){
            panel.getChildren().remove(this);
            t.stop();
        }

        if(getBoundsInParent().intersects(PJ.getPosicion())){
            panel.getChildren().remove(this);
            t.stop();
            PJ.aumentarDisparos();
            Disparo.aumentarAncho();
        }
    }
}
