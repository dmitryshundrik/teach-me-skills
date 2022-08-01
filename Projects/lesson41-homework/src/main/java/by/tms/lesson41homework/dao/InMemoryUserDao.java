package by.tms.lesson41homework.dao;

import by.tms.lesson41homework.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryUserDao {
    private final List<User> users = new ArrayList<>();

    public void save(User user) {
        users.add(user);
    }

    public Optional<User> findByUsername(String username) {
        for (User user : users) {
            if (username.equals(user.getUsername())) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
