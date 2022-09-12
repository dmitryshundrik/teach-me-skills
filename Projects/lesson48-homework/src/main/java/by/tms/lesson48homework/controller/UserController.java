package by.tms.lesson48homework.controller;

import by.tms.lesson48homework.config.TokenProvider;
import by.tms.lesson48homework.dao.UserRepository;
import by.tms.lesson48homework.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    private UserRepository userRepository;

    @Autowired
    private TokenProvider tokenProvider;

    @Operation(summary = "Create user", description = "This can only be done by the logged in user.",
            responses = @ApiResponse(description = "successful operation"))
    @PostMapping("/join")
    public ResponseEntity<User> join(@Valid @RequestBody User user) {
        User save = userRepository.save(user);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(String username, String password) {
        Optional<User> byUsername = userRepository.findByUsername(username);
        if (byUsername.isPresent()) {
            User user = byUsername.get();
            String token = tokenProvider.generateToken(user.getUsername());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.badRequest().build();
    }

    @Operation(summary = "Creates list of users with given input array",
            responses = @ApiResponse(description = "successful operation"))
    @PostMapping("/createWithList")
    public ResponseEntity<List<User>> createWithList(@RequestBody List<User> users) {
        List<User> userList = userRepository.saveAll(users);
        return new ResponseEntity(userList, HttpStatus.CREATED);
    }

    @Operation(summary = "Get user by user name")
    @GetMapping("/{username}")
    public ResponseEntity<User> findByUsername(@PathVariable String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Updated user", description = "This can only be done by the logged in user.")
    @PutMapping("/{username}")
    public ResponseEntity<User> updateByUsername(@PathVariable String username, @RequestBody User user) {
        if (userRepository.findByUsername(username).isPresent()) {
            return ResponseEntity.ok(userRepository.save(user));
        }
        return ResponseEntity.badRequest().build();
    }

    @Operation(summary = "Delete user", description = "This can only be done by the logged in user.")
    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteByUsername(@PathVariable String username) {
        userRepository.myDeleteByUsername(username);
        return ResponseEntity.ok().build();
    }
}
