package com.jgranados.jsp_app.calc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author jose
 */
public class DBCalculator {

    private static final String USER = "root2";
    private static final String PASSWORD = "root12345";
    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/calculos";

    public void save(Record operationRecord) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL_MYSQL, USER, PASSWORD);
            PreparedStatement insert = connection
                    .prepareStatement("INSERT INTO historial (numero1, numero2, operacion, resultado) VALUES(?,?,?,?)");
            insert.setInt(1, operationRecord.getNumero1());
            insert.setInt(2, operationRecord.getNumero2());
            insert.setString(3, operationRecord.getOperacion().toString());
            insert.setString(4, operationRecord.getResultado());
            
            insert.executeUpdate();
            
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
        /// logica para guardar
    }
}
