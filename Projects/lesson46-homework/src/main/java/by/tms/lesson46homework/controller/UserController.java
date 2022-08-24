package by.tms.lesson46homework.controller;

import by.tms.lesson46homework.dao.InMemoryUserDao;
import by.tms.lesson46homework.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private InMemoryUserDao userDao;

    @PostMapping
    public ResponseEntity<User> save(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userDao.save(user), HttpStatus.CREATED);
    }

    @GetMapping("/id")
    public ResponseEntity<User> findById(long id) {
        Optional<User> optionalUser = userDao.findById(id);
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/username")
    public ResponseEntity<User> findByUsername(String username) {
        Optional<User> optionalUser = userDao.findByUsername(username);
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userDao.findAll();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @PutMapping()
    public ResponseEntity<User> update(@RequestBody User user) {
        Optional<User> optionalUser = userDao.update(user);
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody User user) {
        if (userDao.delete(user)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/id")
    public ResponseEntity<User> deleteById(long id) {
        Optional<User> optionalUser = userDao.deleteById(id);
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.get());
        }
        return ResponseEntity.badRequest().build();
    }
}
