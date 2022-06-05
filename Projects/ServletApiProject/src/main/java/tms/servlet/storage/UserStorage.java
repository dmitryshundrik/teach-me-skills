package tms.servlet.storage;

import tms.servlet.entity.User;
import tms.servlet.service.DatabaseConnection;

import java.sql.*;
import java.util.Optional;

public class UserStorage {

    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    public User createUser(String name, String username, String password) {
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }

    public void save(User user) {
        try {
            PreparedStatement prepareStatement = databaseConnection.connection().
                    prepareStatement("insert into users values (?,?,?)");
            prepareStatement.setString(1, user.getUsername());
            prepareStatement.setString(2, user.getName());
            prepareStatement.setString(3, user.getPassword());
            prepareStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<User> findByUsername(String requiredUsername) {
        try {
            PreparedStatement preparedStatement = databaseConnection.connection().
                    prepareStatement("select * from users where username = ?");
            preparedStatement.setString(1, requiredUsername);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setUsername(resultSet.getString(1));
                user.setName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                return Optional.of(user);
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
