package org.gorditodev.juegodisparosdemo.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.gorditodev.juegodisparosdemo.utiles.ConexionBBDD;
import org.gorditodev.juegodisparosdemo.utiles.GestionEscenas;
import org.gorditodev.juegodisparosdemo.utiles.Puntuacion;

public class PanelPuntuaciones extends BorderPane {

    private Text texto;
    private Button botonMenu;

    private TableView<Puntuacion> tabla;
    private TableColumn<Puntuacion, Integer> colPuntos;
    private TableColumn<Puntuacion, String> coltiempo;

    public PanelPuntuaciones() {
        texto = new Text("Mejores puntuaciones sabrosonas");
        botonMenu = new Button("Volver");
        prepararColumnas();
        montarEscena();
    }

    private void montarEscena() {

        texto.setFont(new Font("Roboto", 35));
        setTop(texto);
        BorderPane.setAlignment(texto, Pos.CENTER);

        setCenter(tabla);

        botonMenu.setOnAction(e -> GestionEscenas.escenaMenu());
        setBottom(botonMenu);
        BorderPane.setAlignment(botonMenu, Pos.CENTER);
        BorderPane.setMargin(botonMenu, new Insets(20));
    }

    private void prepararColumnas() {
        tabla = new TableView<>();
        tabla.setMaxHeight(270);

        colPuntos = new TableColumn<>("Puntos");
        colPuntos.setCellValueFactory(new PropertyValueFactory<>("puntos"));
        colPuntos.setPrefWidth(249);

        coltiempo = new TableColumn<>("Tiempo");
        coltiempo.setCellValueFactory(new PropertyValueFactory<>("tiempo"));
        coltiempo.setPrefWidth(249);

        tabla.getColumns().addAll(colPuntos, coltiempo);

        tabla.setItems(ConexionBBDD.obtenerLista);
    }


}
