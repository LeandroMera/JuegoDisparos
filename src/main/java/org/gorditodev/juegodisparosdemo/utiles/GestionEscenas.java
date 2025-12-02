package org.gorditodev.juegodisparosdemo.utiles;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.gorditodev.juegodisparosdemo.vista.Main;
import org.gorditodev.juegodisparosdemo.vista.MenuInicio;
import org.gorditodev.juegodisparosdemo.vista.PanelPuntuaciones;
import org.gorditodev.juegodisparosdemo.vista.PanelRaiz;

public class GestionEscenas {

    private static Stage escenario;
    private static Scene esMenu, esJuego, esPuntos;

    static{
        escenario = Main.getEscenario();
        esMenu = new Scene(new MenuInicio(), 500, 800);
    }

    public static void escenaMenu(){
        escenario.setScene(esMenu);
    }

    public static void escenaJuego(){
        esJuego = new Scene(new PanelRaiz(), 500, 800);
        ContadorTiempo.empezar();
        escenario.setScene(esJuego);
    }

    public static void escenaPuntos(){
        esPuntos = new Scene(new PanelPuntuaciones(), 500, 800);
        escenario.setScene(esPuntos);
    }


}
