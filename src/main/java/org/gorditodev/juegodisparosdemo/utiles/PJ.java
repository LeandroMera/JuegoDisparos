package org.gorditodev.juegodisparosdemo.utiles;

import javafx.animation.AnimationTimer;
import javafx.geometry.Bounds;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import org.gorditodev.juegodisparosdemo.vista.PanelJuego;


public class PJ extends Rectangle {

    private PanelJuego panel;
    private boolean moviendoIzquierda, moviendoDerecha;
    private static Bounds posicion;

    public PJ() {
        super(225, 700, 50, 50);
        panel = PanelJuego.getPanel();
        setFill(Color.RED);// aveces sale erro por no importar la libreria -> import javafx.scene.paint.Color;
        ponerEnAccion();
        animarPJ();
    }

    private void ponerEnAccion() {
        sceneProperty().addListener((observar, antiguaEscena, nuevaEscena) -> {
           if(nuevaEscena != null){
               requestFocus();
           }
        });

        this.setOnKeyPressed(e ->{
            if(e.getCode() == KeyCode.A || e.getCode() == KeyCode.LEFT){
                moviendoIzquierda = true;
            }

            if(e.getCode() == KeyCode.D || e.getCode() == KeyCode.RIGHT){
                moviendoDerecha= true;
            }
        });

        this.setOnKeyReleased(e ->{
            if(e.getCode() == KeyCode.A || e.getCode() == KeyCode.LEFT){
                moviendoIzquierda = false;
            }

            if(e.getCode() == KeyCode.D || e.getCode() == KeyCode.RIGHT){
                moviendoDerecha= false;
            }

            if(e.getCode() == KeyCode.SPACE) disparar();// lisener para el boton de disparar
        });
    }

    private void disparar() {
        if(Disparo.getNDisparos() < 3 ){//con esta condional limitamos los disparos a 5 y hasta que no salga de pantalla no vuelve a disparar
            Bounds posPJ = this.getBoundsInParent();
            Disparo d = new Disparo(posPJ.getCenterX(), posPJ.getMinY());
            panel.getChildren().add(d);
        }
    }

    private void mover(){
        //panel = PanelJuego.getPanel();
        if(moviendoIzquierda && getBoundsInParent().getMinX() > 0){
            setLayoutX(getLayoutX() - 3);
        }
        if(moviendoDerecha && getBoundsInParent().getMaxX() < panel.getWidth()){
            setLayoutX(getLayoutX() + 3);
        }
    }

    private void animarPJ() {
        AnimationTimer t = new AnimationTimer() {
            @Override
            public void handle(long ahora) {
                mover();
                posicion = getBoundsInParent();
            }
        };
        t.start();// sino se mueve puede ser que olvidaste esta linea, crvg
    }

    public static Bounds getPosicion() {
        return posicion;
    }


}
