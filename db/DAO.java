package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    private static Connection connection;

    public static Connection createConnection() {
        try {
            final String URL = "jdbc:mysql://localhost:3306/usuario_teste";
            final String USER = "root";
            final String PASSWORD = "";

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
