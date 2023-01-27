package by.tms.lesson41homework.dao;

import java.util.Optional;

public interface UserDao<T> {
    void save(T t);

    Optional<T> findByUsername(String username);
}
