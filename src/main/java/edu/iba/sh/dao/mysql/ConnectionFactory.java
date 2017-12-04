package edu.iba.sh.dao.mysql;

import edu.iba.sh.dao.DaoException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory {
    private static ResourceBundle resources = ResourceBundle.getBundle("mysql");

    static Connection getConnection() throws DaoException {
        try {
            java.sql.Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);

            return DriverManager.getConnection(resources.getString("url"),
                    resources.getString("user"),
                    resources.getString("password"));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

}
