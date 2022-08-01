package by.tms.lesson41homework.service;

import by.tms.lesson41homework.dao.InMemoryUserDao;
import by.tms.lesson41homework.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private InMemoryUserDao userDao;

    public void save(User user) {
        user.setRegistered(LocalDate.now());
        userDao.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
