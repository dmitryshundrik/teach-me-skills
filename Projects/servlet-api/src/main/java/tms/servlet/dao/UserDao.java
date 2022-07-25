package tms.servlet.dao;

import tms.servlet.entity.User;

import java.util.Optional;

public interface UserDao {

    public User createUser(String name, String username, String password);

    void save(User user);

    public Optional<User> findByUsername(String requiredUsername);

}
