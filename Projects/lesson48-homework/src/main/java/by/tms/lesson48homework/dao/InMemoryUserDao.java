package by.tms.lesson48homework.dao;

import by.tms.lesson48homework.entity.AppUser;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoryUserDao {

    private final List<AppUser> users = new ArrayList<>();
    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    public AppUser createUser(AppUser user) {
        user.setId(atomicInteger.getAndIncrement());
        users.add(user);
        return user;
    }

    public List<AppUser> createWithList(List<AppUser> userList) {
        List<AppUser> resultList = new ArrayList<>();
        for (AppUser user : userList) {
            resultList.add(createUser(user));
        }
        return resultList;
    }

    public Optional<AppUser> findByUsername(String username) {
        for (AppUser user : users) {
            if (user.getUsername().equals(username)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public Optional<AppUser> updateByUsername(String username, AppUser user) {
        if (username.equals(user.getUsername())) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(username)) {
                    return Optional.of(users.set(i, user));
                }
            }
        }
        return Optional.empty();
    }

    public Optional<AppUser> deleteByUsername(String username) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                return Optional.of(users.remove(i));
            }
        }
        return Optional.empty();
    }
}
