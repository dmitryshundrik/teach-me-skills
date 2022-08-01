package tms.service;

import org.springframework.stereotype.Service;
import tms.entity.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();

    public void save(User user) {
        users.add(user);
    }
}
