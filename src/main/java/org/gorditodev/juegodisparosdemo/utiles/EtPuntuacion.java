package org.gorditodev.juegodisparosdemo.utiles;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class EtPuntuacion extends Text {
    private static int puntuacion = 0;
    private static double multiplicador = 1;
    private static EtPuntuacion p = new EtPuntuacion();

    private EtPuntuacion() {
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

    public static EtPuntuacion getPuntuacion() {
        return p;
    }

    public static void aumentarMultiplicador(boolean subir){
        if(subir) multiplicador += 0.1;
        else multiplicador = 1;
    }

    public static int getPuntos(){
        return puntuacion;
    }

    public static void reiniciar() {
        puntuacion = 0;
        p.setText(String.valueOf(puntuacion));
    }

}
