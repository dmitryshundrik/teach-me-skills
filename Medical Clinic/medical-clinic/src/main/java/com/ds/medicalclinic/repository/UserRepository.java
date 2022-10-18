package com.ds.medicalclinic.repository;

import com.ds.medicalclinic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);

    User findUserByUsername(String username);

    void deleteUserById(Long id);
}
