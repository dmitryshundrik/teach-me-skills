package by.tms.lesson48homework.dao;

import by.tms.lesson48homework.entity.Pet;
import by.tms.lesson48homework.status.PetStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Integer> {
    List<Pet> findAllByStatus(PetStatus status);
}
