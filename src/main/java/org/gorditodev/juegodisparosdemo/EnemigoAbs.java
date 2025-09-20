package org.gorditodev.juegodisparosdemo;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public abstract class EnemigoAbs extends Rectangle{

    protected PanelJuego panel;
    protected double velocidad;
    protected int vida;
    protected Image imagen;
    protected AnimationTimer t;
    protected static double dificultad = 0;

    public EnemigoAbs(double posX, double posY, double tamX, double tamY, double velocidad, int vida){
        super(posX,posY,tamX,tamY);// cada vez quye se crea el eme,igo se pasa el tamaño y posicion
        this.velocidad=velocidad;
        this.vida=vida;
        panel= PanelJuego.getPanel();
        if(dificultad <= 1) dificultad += 0.1;//incrementa la dificultad  del enemigo
        System.out.println(dificultad + " - " + velocidad);
    }

    protected abstract void bajar();

    public int getVida(){
        return vida;
    }

    public void reducirVida(){
        vida--;
    }

    public AnimationTimer getAnimador(){
        return t;
    }
}
