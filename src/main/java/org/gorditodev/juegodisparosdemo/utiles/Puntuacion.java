package org.gorditodev.juegodisparosdemo.utiles;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Puntuacion extends Text {
    private static int puntuacion = 0;
    private static double multiplicador = 1;
    private static Puntuacion p = new Puntuacion();

    private Puntuacion() {
        super(String.valueOf(puntuacion));
        setFont(new Font("Consolas", 40));// fuente de texto
        setFill(Color.PERU);
    }

    public static void subirPuntuacion(int cantidad) {
        double puntos = cantidad * multiplicador;// al ser un double dara numero con decimales, toca covertir a entero
        int puntoInt = (int)Math.round(puntos);// Hacer el recasting de gouble a entero

        puntuacion += puntoInt;
        p.setText(String.valueOf(puntuacion));
    }

    public static Puntuacion getPuntuacion() {
        return p;
    }

    public static void aumentarMultiplicador(boolean subir){
        if(subir) multiplicador += 0.1;
        else multiplicador = 1;
    }

}
