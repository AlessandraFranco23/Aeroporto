package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    private static Connection connection;

    //Função para abrir conexão com o banco de dados passando a url e senha
    //Utilizando o DriverManager para buscar o driver do banco de dados e passando as informações
    //abresse uma conexão com o banco.
    public static Connection createConnection() {
        try {
            final String URL = "jdbc:mysql://localhost:3306/aeroporto1?useTimezone=true&serverTimezone=UTC";
            final String USER = "root";
            final String PASSWORD = "";

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Função para fechar a conexão com o banco de dados
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
