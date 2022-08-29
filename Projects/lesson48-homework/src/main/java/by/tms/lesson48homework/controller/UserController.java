package by.tms.lesson48homework.controller;

import by.tms.lesson48homework.dao.InMemoryUserDao;
import by.tms.lesson48homework.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@Tag(name = "user", description = "Operations about user")
public class UserController {

    @Autowired
    private InMemoryUserDao userDao;

    @Operation(summary = "Create user", description = "This can only be done by the logged in user.",
            responses = @ApiResponse(responseCode = "default", description = "successful operation"))
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userDao.createUser(user), HttpStatus.CREATED);
    }

    @Operation(summary = "Creates list of users with given input array",
            responses = @ApiResponse(responseCode = "default", description = "successful operation"))
    @PostMapping("/createWithList")
    public ResponseEntity<List<User>> createWithList(@RequestBody List<User> users) {
        return new ResponseEntity(userDao.createWithList(users), HttpStatus.CREATED);
    }

    @Operation(summary = "Get user by user name")
    @GetMapping("/{username}")
    public ResponseEntity<User> findByUsername(@PathVariable String username) {
        Optional<User> optionalUser = userDao.findByUsername(username);
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Updated user", description = "This can only be done by the logged in user.")
    @PutMapping("/{username}")
    public ResponseEntity<User> updateByUsername(@PathVariable String username, @RequestBody User user) {
        Optional<User> optionalUser = userDao.updateByUsername(username, user);
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Delete user", description = "This can only be done by the logged in user.")
    @DeleteMapping("/{username}")
    public ResponseEntity<User> deleteByUsername(@PathVariable String username) {
        Optional<User> optionalUser = userDao.deleteByUsername(username);
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
