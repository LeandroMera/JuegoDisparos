package org.gorditodev.juegodisparosdemo.enemigos;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

public class EnemigoZig extends EnemigoAbs {
    private boolean derecha;

    public EnemigoZig() {
        super(Math.random() *460, -25, 40, 25, (Math.random() * 2) + dificultad, 2, 25);// el random multiplica la velocidad

        derecha = Math.random() > 0.5 ? true : false;
        establecerImagen();
        bajar();
    }

    private void establecerImagen() {
        if(derecha) imagen = new Image("file:src/main/java/org/gorditodev/juegodisparosdemo/img/zigD.png");
        else imagen = new Image("file:src/main/java/org/gorditodev/juegodisparosdemo/img/zigI.png");
        setFill(new ImagePattern(imagen));
    }

    @Override
    protected void bajar() {
        t = new AnimationTimer() {

            @Override
            public void handle(long ahora) {

                setLayoutY(getLayoutY() + 0.2);// hace aparecer el enemigo en la linea de caida o Y
                if(derecha) setLayoutX(getLayoutX() + velocidad);
                else setLayoutX(getLayoutX() - velocidad);

                if(getBoundsInParent().getMaxX() >= panel.getWidth())  {
                    derecha = false;
                    establecerImagen();
                }
                if(getBoundsInParent().getMinX() <= 0) {
                    derecha = true;
                    establecerImagen();
                }

                comprobarMuerte();
            }
        };
        t.start();

    }
}
