package org.gorditodev.juegodisparosdemo.enemigos;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import org.gorditodev.juegodisparosdemo.utiles.GestionEnemigos;
import org.gorditodev.juegodisparosdemo.utiles.PJ;
import org.gorditodev.juegodisparosdemo.utiles.Vida;
import org.gorditodev.juegodisparosdemo.vista.PanelJuego;

public abstract class EnemigoAbs extends Rectangle {

    protected PanelJuego panel;
    protected double velocidad;
    protected int vida;
    protected Image imagen;
    protected AnimationTimer t;
    protected int puntuacion;
    protected static double dificultad = 0;

    public EnemigoAbs(double posX, double posY, double tamX, double tamY, double velocidad, int vida, int puntuacion) {
        super(posX, posY, tamX, tamY);// cada vez quye se crea el eme,igo se pasa el tamaño y posicion
        this.velocidad = velocidad;
        this.vida = vida;
        panel = PanelJuego.getPanel();
        this.puntuacion = puntuacion;
        if (dificultad <= 1) dificultad += 0.1;//incrementa la dificultad  del enemigo
        System.out.println(dificultad + " - " + velocidad);
    }

    protected abstract void bajar();

    public int getVida() {
        return vida;
    }

    public void reducirVida() {
        vida--;
    }

    public AnimationTimer getAnimador() {
        return t;
    }
    public int getPuntuacion() {
        return puntuacion;
    }
    protected void comprobarMuerte() {
        if (getBoundsInParent().getMaxY() >= panel.getHeight() || getBoundsInParent().intersects(PJ.getPosicion())) {// ase desaparecer el enemigo
            panel.getChildren().remove(this);// controla para desaparecer se especifica con this para decir que es esta clase
            GestionEnemigos.getEnemigos().remove(this);
            Vida.reducirVida();

            t.stop();
        }
    }
}
