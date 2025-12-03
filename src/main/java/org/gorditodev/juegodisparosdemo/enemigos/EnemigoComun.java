package org.gorditodev.juegodisparosdemo.enemigos;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

public class EnemigoComun extends EnemigoAbs {// como es un metodo abstracto debes añadir el constructor primero e implementar el metodo en este caso bajar

    public EnemigoComun() {
        super(Math.random() * 430, -50, 70, 50, (Math.random() * 2) + dificultad, 1, 5);// el random multiplica la velocidad
        imagen = new Image("file:src/main/java/org/gorditodev/juegodisparosdemo/img/comun.png");
        setFill(new ImagePattern(imagen));
        bajar();// llama el constructor
    }

    @Override
    protected void bajar() {
        t = new AnimationTimer() {

            @Override
            public void handle(long ahora) {
                setLayoutY(getLayoutY() + velocidad);// hace aparecer el enemigo en la linea de caida o Y

                comprobarMuerte();
            }
        };
        t.start();
    }
}
