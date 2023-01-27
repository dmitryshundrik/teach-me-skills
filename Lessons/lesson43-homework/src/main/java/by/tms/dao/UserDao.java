package by.tms.dao;

import by.tms.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void save(User user);
    Optional<User> findById(long id);
    Optional<User> findByUsername(String username);
    List<User> findAll();
    void update(User user);
    void delete(long id);
}
