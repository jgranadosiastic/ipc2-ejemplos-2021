package com.jgranados.calcappapi.operations.db;


import com.jgranados.calcappapi.operations.domain.Historial;
import com.jgranados.calcappapi.operations.domain.Operation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author jose
 */
public class DBCalculator {

    private static final String USER = "root2";
    private static final String PASSWORD = "root12345";
    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/calculos";
    private static final String HISTORIAL = "historial";
    private Connection connection = null;

    public DBCalculator() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL_MYSQL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(Historial historial) {
        try {
            PreparedStatement insert = connection
                    .prepareStatement(String.format(
                            "INSERT INTO %s (numero1, numero2, operacion, resultado) VALUES(?,?,?,?)",
                            HISTORIAL
                    ));
            insert.setInt(1, historial.getNumero1());
            insert.setInt(2, historial.getNumero2());
            insert.setString(3, historial.getOperacion().toString());
            insert.setString(4, historial.getResultado());

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

    public List<Historial> getAllHistoricals() {
        List<Historial> list = new ArrayList<>();
        try {
            PreparedStatement allQuery = connection
                    .prepareStatement("SELECT * FROM " + HISTORIAL);
            ResultSet result = allQuery.executeQuery();

            while (result.next()) {
                list.add(convertRecord(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Optional<Historial> getHistoricalById(int id) {
        try {
            PreparedStatement recordQuery = connection
                    .prepareStatement(String.format("SELECT * FROM %s WHERE id_historial = ?", HISTORIAL));
            recordQuery.setInt(1, id);
            ResultSet result = recordQuery.executeQuery();

            if (result.next()) {
                return Optional.of(convertRecord(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
    
    public void update(Historial operationRecord) {
        try {
            PreparedStatement update = connection
                    .prepareStatement(String.format(
                            "UPDATE %s SET numero1 = ?, numero2 = ?, operacion = ?, resultado = ? WHERE id_historial = ?",
                            HISTORIAL
                    ));
            update.setInt(1, operationRecord.getNumero1());
            update.setInt(2, operationRecord.getNumero2());
            update.setString(3, operationRecord.getOperacion().toString());
            update.setString(4, operationRecord.getResultado());
            update.setInt(5, operationRecord.getIdHistorial());

            update.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Historial convertRecord(ResultSet resultSet) throws SQLException {
        Historial historial = new Historial();
        historial.setIdHistorial(resultSet.getInt("id_historial"));
        historial.setNumero1(resultSet.getInt("numero1"));
        historial.setNumero2(resultSet.getInt("numero2"));
        historial.setOperacion(Operation.valueOf(resultSet.getString("operacion")));
        historial.setResultado(resultSet.getString("resultado"));

        return historial;
    }
}
