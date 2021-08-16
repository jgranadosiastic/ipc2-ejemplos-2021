package com.jgranados.ejemplojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */
public class Main {

    private static final String USER = "root2";
    private static final String PASSWORD = "root12345";
    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/control_asignaciones";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String carnet = "19952684654567";
        String nombre = "nombre";
        String apellido = "apellido";
        String fechaNac = "1995-08-12";

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL_MYSQL, USER, PASSWORD);

            /*carnet = scanner.nextLine();
            nombre = scanner.nextLine();
            apellido = scanner.nextLine();
            fechaNac = scanner.nextLine();*/
 /*Statement insert = connection.createStatement();
            insert.executeUpdate(
                    "INSERT INTO estudiante VALUES(' " + carnet + "', '"
                    + nombre + "', ' " + apellido + "', '" + fechaNac + "')");*/
 /*Statement delete = connection.createStatement();
            delete.executeUpdate(
                    "DELETE FROM estudiante WHERE nombre = 'nombre'");*/
            //Statement query = connection.createStatement();
            /*ResultSet result = query.executeQuery("SELECT * FROM estudiante");
            
            while(result.next()) {
                System.out.println("Datos estudiante:");
                System.out.println(result.getString("carnet"));
                System.out.println(result.getString("nombre"));
                System.out.println(result.getString("apellidos"));
                System.out.println(result.getDate("fecha_nacimiento"));
            }*/
 /*
            result = query.executeQuery("SELECT nombre, apellidos FROM estudiante");
            
            while(result.next()) {
                System.out.println("Datos estudiante:");
                System.out.println(result.getString("nombre"));
                System.out.println(result.getString("apellidos"));
             */
 /*apellido = scanner.nextLine();
            
            PreparedStatement query = connection.prepareStatement("SELECT * FROM estudiante WHERE apellidos like ?");
            query.setString(1, "%" + apellido + "%");
            ResultSet result = query.executeQuery();
            
            
            
            while(result.next()) {
                System.out.println("Datos estudiante:");
                System.out.println(result.getString("carnet"));
                System.out.println(result.getString("nombre"));
                System.out.println(result.getString("apellidos"));
                System.out.println(result.getDate("fecha_nacimiento"));
            }*/
            System.out.println(connection.getAutoCommit());

            connection.setAutoCommit(false);

            try {
                Statement insert = connection.createStatement();
                insert.executeUpdate(
                        "UPDATE estudiante SET nombre = 'cambio5' WHERE carnet = '200356321'");
                insert.executeUpdate("UPDATE curso SET codigo = '201' WHERE codigo = '001'");
                connection.commit();
            } catch (SQLException e) {
                System.out.println("Se hace rollback");
                connection.rollback();
            } finally {
                connection.setAutoCommit(false);
            }

            

            

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {

                }
            }
        }

    }
}
