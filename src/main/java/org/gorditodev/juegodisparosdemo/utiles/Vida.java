package org.gorditodev.juegodisparosdemo.utiles;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import org.gorditodev.juegodisparosdemo.vista.PanelInferior;

import java.util.ArrayList;

public class Vida extends Rectangle {

    private Image imagen = new Image("file:src/main/java/org/gorditodev/juegodisparosdemo/img/vida.jpg");// si sale error en la imgen debes revisar el link y buscarlo en google y copiar desde src
    private static ArrayList<Vida> vidas;
    private static int indiceActual = 2;

    private Vida(){
        super(50, 50);
        setFill(new ImagePattern(imagen));
    }

    public static ArrayList<Vida> getVidas() {
        if(vidas == null) crearVidas();
        return vidas;
    }

    private static void crearVidas() {
        vidas = new ArrayList<Vida>();
        for (int i=0; i<3; i++) vidas.add(new Vida());
    }

    public static void reducirVida(){
        if(indiceActual >= 0 ){
            Vida v = vidas.get(indiceActual);
            PanelInferior.getPanel().getChildren().remove(v);
            vidas.remove(indiceActual);
            indiceActual--;
            Puntuacion.aumentarMultiplicador(false);
        }
    }
}
