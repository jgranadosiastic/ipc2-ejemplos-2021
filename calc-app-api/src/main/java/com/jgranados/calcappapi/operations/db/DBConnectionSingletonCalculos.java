package com.jgranados.calcappapi.operations.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Singleton para tener una unica instancia de la conexion a DB
 * @author jose
 */
public class DBConnectionSingletonCalculos {

    private static final String USER = "root2";
    private static final String PASSWORD = "root12345";
    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/calculos";

    private static DBConnectionSingletonCalculos connectionSingleton = null;
    private Connection connection = null;

    private DBConnectionSingletonCalculos() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL_MYSQL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DBConnectionSingletonCalculos getDBConnectionSingleton() {
        if (connectionSingleton == null) {
            connectionSingleton = new DBConnectionSingletonCalculos();
        }

        return connectionSingleton;
    }
    
    public Connection getConnection() {
        return connection;
    }
}
