package tms.servlet.dao;

import tms.servlet.entity.User;
import tms.servlet.service.DatabaseConnection;

import java.sql.*;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        userDao.save(new User.Builder().name("Arseni").username("arseni").password("arseni").build());


    }
    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    public User createUser(String name, String username, String password) {
        return new User.Builder().name(name).username(username).password(password).build();
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
                User user = new User.Builder()
                        .name(resultSet.getString(2))
                        .username(resultSet.getString(1))
                        .password(resultSet.getString(3)).build();
                return Optional.of(user);
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
