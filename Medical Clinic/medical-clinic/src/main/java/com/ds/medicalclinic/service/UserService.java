package com.ds.medicalclinic.service;

import com.ds.medicalclinic.dao.UserRepository;
import com.ds.medicalclinic.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public Optional<User> findUserById(Long id) {
        User user = userRepository.findUserById(id);
        return Optional.of(user);
    }

    public Optional<User> findUserByUsername(String username) {
        User user = userRepository.findUserByUsername(username);
        return Optional.of(user);
    }
}
