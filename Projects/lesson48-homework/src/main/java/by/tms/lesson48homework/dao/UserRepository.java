package by.tms.lesson48homework.dao;

import by.tms.lesson48homework.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Integer> {

    Optional<AppUser> findByUsername (String username);

    @Modifying
    @Transactional
    @Query("delete from AppUser u where u.username = :username")
    void myDeleteByUsername (@Param("username") String username);

}
