package br.rmginner.factory.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connection factory;
 */
public class ConnectionFactory {

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalho_2", "root", "123456");
        } catch (ClassNotFoundException | SQLException cnfex) {
            cnfex.printStackTrace();
        }

        return null;
    }

}
