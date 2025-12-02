package org.gorditodev.juegodisparosdemo.utiles;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class ConexionBBDD {
    public static javafx.collections.ObservableList<Puntuacion> obtenerLista;
    private static Connection miCon;
    private static Statement miSt;

    //private static String buildJdbcUrl() {
        //String host = System.getenv().getOrDefault("DB_HOST", "localhost");
        //String port = System.getenv().getOrDefault("DB_PORT", "3307");
        //String db   = System.getenv().getOrDefault("DB_NAME", "ejercicios");
        //return String.format("jdbc:mysql://%s:%s/%s?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", host, port, db);
    //}

    private static void conectar() {
        try {
            miCon = DriverManager.getConnection("jdbc:mysql://localhost:3307/ejercicios","root", "");
            miSt = miCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void desconectar() {
        try {
             miSt.close();
            miCon.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void enviarPuntuacion() {

        comprobarPuntuaciones();

        int puntos = EtPuntuacion.getPuntos();
        String tiempo = ContadorTiempo.formatoContador();

        conectar();

        try {
            miSt.execute("INSERT INTO juego (puntuacion, tiempo)"
            + " VALUES ('" + puntos + "', '" + tiempo + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        desconectar();
    }

    private static boolean comprobarPuntuaciones() {
        conectar();
        try {
            ResultSet miRs = miSt.executeQuery("SELECT * FROM juego ORDER BY puntuacion DESC ");

            miRs.last();
            int numRegistros = miRs.getRow();
            if(numRegistros < 10) {
                return true;
            }

            int puntos = EtPuntuacion.getPuntos();
            if(puntos > miRs.getInt("puntuacion")){
                miSt.execute("DELETE FROM juego WHERE puntuacion= ' " + miRs.getInt(1) + " ' ");
                return true;
            }
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            desconectar();
            System.out.printf("Perdiste Looser... jajajaj");
        }
    }

    public static ObservableList<Puntuacion> obtenerLista() {

        ObservableList<Puntuacion> lista = FXCollections.observableArrayList();
        conectar();

        try{
            ResultSet miRs = miSt.executeQuery("SELECT puntuacion FROM juego ORDER BY puntuacion DESC ");
            while(miRs.next()){
                int puntos = miRs.getInt(1);
                String tiempo = miRs.getString(2);
                lista.add(new Puntuacion(puntos, tiempo));
            }
            return lista;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }finally {
            desconectar();
        }

    }

}


