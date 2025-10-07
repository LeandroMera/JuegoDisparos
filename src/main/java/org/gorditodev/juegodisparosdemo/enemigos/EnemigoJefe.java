package org.gorditodev.juegodisparosdemo.enemigos;

import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;

public class EnemigoJefe extends EnemigoAbs {
    public EnemigoJefe() {
        super(150, -100, 200, 100, (Math.random() * 2) + dificultad, 30, 1500);// el random multiplica la velocidad
        setFill(Color.PURPLE);
        bajar();
    }

    @Override
    protected void bajar() {
        t = new AnimationTimer() {

            @Override
            public void handle(long ahora) {
                setLayoutY(getLayoutY() + 0.3);// hace aparecer el enemigo en la linea de caida o Y

                comprobarMuerte();
            }
        };
        t.start();

    }
}
