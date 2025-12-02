package org.gorditodev.juegodisparosdemo.utiles;


public class Puntuacion {
    private int puntos;
    private String tiempo;

    public Puntuacion(int puntos, String tiempo) {
        this.puntos = puntos;
        this.tiempo = tiempo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
}
