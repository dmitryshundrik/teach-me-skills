package by.tms.lesson48homework.dao;

import by.tms.lesson48homework.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoryUserDao {

    private final List<User> users = new ArrayList<>();
    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    public User createUser(User user) {
        user.setId(atomicInteger.getAndIncrement());
        users.add(user);
        return user;
    }

    public List<User> createWithList(List<User> userList) {
        List<User> resultList = new ArrayList<>();
        for (User user : userList) {
            resultList.add(createUser(user));
        }
        return resultList;
    }

    public Optional<User> findByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public Optional<User> updateByUsername(String username, User user) {
        if (username.equals(user.getUsername())) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(username)) {
                    return Optional.of(users.set(i, user));
                }
            }
        }
        return Optional.empty();
    }

    public Optional<User> deleteByUsername(String username) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                return Optional.of(users.remove(i));
            }
        }
        return Optional.empty();
    }
}
