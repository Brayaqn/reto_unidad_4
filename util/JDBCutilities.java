package util;
// receta de cocina 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCutilities {
 
    private final static String UBICACION_BD = "C:/Users/Brayan/Desktop/misiontic/programacion/ciclo 2/programacion/ejercicios/unidad 4/ProyectosConstruccion.db";
    // private final static String UBICACION_BD = "ProyectosConstruccion.db";

    // metodo dar conneccion

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + UBICACION_BD;
        return DriverManager.getConnection(url);
    }
}
