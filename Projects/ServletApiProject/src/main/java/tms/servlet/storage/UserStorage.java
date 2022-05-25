package tms.servlet.storage;

import tms.servlet.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserStorage {

    private static List<User> userLis = new ArrayList<>();

    public void save(User user) {
        userLis.add(user);
    }

    public Optional<User> findByUsername(String username) {
        for (User user : userLis) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
