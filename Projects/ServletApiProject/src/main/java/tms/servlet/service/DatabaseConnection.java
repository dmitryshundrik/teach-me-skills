package tms.servlet.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection connection() {
        try (Connection connection = DriverManager.
                getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");) {
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
