package by.tms.lesson46homework.controller;

import by.tms.lesson46homework.dao.InMemoryUserDao;
import by.tms.lesson46homework.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private InMemoryUserDao dao;

    @PostMapping
    public User save(@RequestBody User user) {
        dao.save(user);
        return null;
    }

    @GetMapping("/id")
    public User findById(long id) {
        Optional<User> user = dao.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @GetMapping("/username")
    public User findByUsername(String username) {
        Optional<User> user = dao.findByUsername(username);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @GetMapping("/all")
    public List<User> findAll() {
        return dao.findAll();
    }

    @PutMapping()
    public User update(@RequestBody User user) {
        User userAfterUpdate = dao.update(user);
        return userAfterUpdate;
    }

    @DeleteMapping
    public void delete(@RequestBody User user) {
        dao.delete(user);
    }

    @DeleteMapping("/id")
    public User deleteById(long id) {
        Optional<User> user = dao.deleteById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }
}
