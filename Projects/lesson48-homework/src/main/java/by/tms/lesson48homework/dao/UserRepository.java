package by.tms.lesson48homework.dao;

import by.tms.lesson48homework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername (String username);

    @Modifying
    @Query("delete from User u where u.username = :username")
    void myDeleteByUsername (@Param("username") String username);

}
