package com.ds.medicalclinic.service;

import com.ds.medicalclinic.dto.UserDto;
import com.ds.medicalclinic.exception.UserAlreadyExistException;
import com.ds.medicalclinic.model.User;
import com.ds.medicalclinic.model.UserRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private UserDto userDto;
    private User user;

    @BeforeEach
    void initialize() {
        userDto = new UserDto();
        userDto.setFirstName("FIRSTNAME");
        userDto.setLastName("LASTNAME");
        userDto.setUsername("USERNAME");
        userDto.setPassword("PASSWORD");
        userDto.setPhone("PHONE");

        user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setPhone(userDto.getPhone());
    }

    @Test
    void save() {
        User savedUser = userService.save(userDto);
        assertEquals(savedUser.getFirstName(), user.getFirstName());
        assertEquals(savedUser.getLastName(), user.getLastName());
        assertEquals(savedUser.getUsername(), user.getUsername());
        assertTrue(passwordEncoder.matches(userDto.getPassword(), savedUser.getPassword()));
        assertEquals(savedUser.getPhone(), user.getPhone());
    }

    @Test
    void userAlreadyExist() {
        userDto.setUsername("USERNAME2");
        userService.save(userDto);
        assertThrows(UserAlreadyExistException.class, () -> userService.save(userDto));
    }
}