package com.ds.medicalclinic.dao;

import com.ds.medicalclinic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);

    User findUserByUsername(String username);
}
