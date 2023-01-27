package by.tms.lesson46homework.dao;

import by.tms.lesson46homework.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryUserDao {

    private final List<User> users = new ArrayList<>();
    private final AtomicLong atomicLong = new AtomicLong(0);

    public User save(User user) {
        user.setId(atomicLong.getAndIncrement());
        users.add(user);
        return user;
    }

    public Optional<User> findById(long id) {
        for (User user : users) {
            if (user.getId() == (id)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public Optional<User> findByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    public Optional<User> update(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == user.getId()) {
                users.set(i, user);
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public boolean delete(User user) {
        return users.remove(user);
    }

    public Optional<User> deleteById(long id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                User user = users.remove(i);
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
