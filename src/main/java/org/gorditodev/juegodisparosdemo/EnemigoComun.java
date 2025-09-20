package org.gorditodev.juegodisparosdemo;

import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;

public class EnemigoComun extends EnemigoAbs{// como es un metodo abstracto debes añadir el constructor primero e implementar el metodo en este caso bajar

    public EnemigoComun() {
        super(Math.random()*450, -50, 50, 50, (Math.random()*2)+ dificultad, 1);// el random multiplica la velocidad
        setFill(Color.GRAY);
        bajar();// llama el constructor
    }

    @Override
    protected void bajar() {
        t = new AnimationTimer() {

            @Override
            public void handle(long ahora) {
                setLayoutY(getLayoutY() + velocidad);// hace aparecer el enemigo en la linea de caida o Y

                if(getBoundsInParent().getMaxY() >= panel.getHeight()){// ase desaparecer el enemigo
                    panel.getChildren().remove(EnemigoComun.this);// controla para desaparecer se especifica con this para decir que es esta clase
                    GestionEnemigos.getEnemigos().remove(EnemigoComun.this);
                    t.stop();
                }

            }
        };
        t.start();
    }
}
