package com.ds.medicalclinic.service;

import com.ds.medicalclinic.dto.UserDto;
import com.ds.medicalclinic.exception.UserAlreadyExistException;
import com.ds.medicalclinic.model.UserRole;
import com.ds.medicalclinic.repository.UserRepository;
import com.ds.medicalclinic.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(UserDto userDto) throws UserAlreadyExistException {
        log.info("Save user with username: {}", userDto.getUsername());
        if (usernameExists(userDto.getUsername())) {
            throw new UserAlreadyExistException("There is an account with that username: " + userDto.getUsername());
        }
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setPhone(userDto.getPhone());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setUserRoles(List.of(UserRole.USER));

        return userRepository.save(user);
    }

    private boolean usernameExists(String username) {
        return userRepository.findUserByUsername(username) != null;
    }

    public Optional<User> findUserByUsername(String username) {
        log.info("Find user by username: {}", username);
        User user = userRepository.findUserByUsername(username);
        return Optional.of(user);
    }

    public User findCurrentUser() {
        log.info("Find current user in security context");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        org.springframework.security.core.userdetails.User principal
                = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        String username = principal.getUsername();
        Optional<User> userByUsername = findUserByUsername(username);
        if (userByUsername.isPresent()) {
            return userByUsername.get();
        } else {
            throw new RuntimeException("User not found in security context");
        }
    }

    public void deleteUserById(Long id) {
        log.info("Delete user by user_ID: {}", id);
        userRepository.deleteUserById(id);
    }

}
