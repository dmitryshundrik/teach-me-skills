package by.tms.lesson48homework.dao;

import by.tms.lesson48homework.entity.Pet;
import by.tms.lesson48homework.status.PetStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoryPetDao {
    private final List<Pet> pets = new ArrayList<>();
    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    public Pet save(Pet pet) {
        pet.setId(atomicInteger.getAndIncrement());
        pets.add(pet);
        return pet;
    }

    public Optional<Pet> update(Pet pet) {
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getId() == pet.getId()) {
                pets.set(i, pet);
                return Optional.of(pet);
            }
        }
        return Optional.empty();
    }

    public List<Pet> findByStatus(String status) {
        List<Pet> statusPetList = new ArrayList<>();
        for (Pet pet : pets) {
            if (pet.getStatus().equals(PetStatus.valueOf(status))) {
                statusPetList.add(pet);
            }
        }
        return statusPetList;
    }

    public Optional<Pet> findById(int id) {
        for (Pet pet : pets) {
            if (pet.getId() == (id)) {
                return Optional.of(pet);
            }
        }
        return Optional.empty();
    }

    public Optional<Pet> updatePetById(int id, String name, String status) {
        for (Pet pet : pets) {
            if (pet.getId() == id) {
                pet.setName(name);
                pet.setStatus(PetStatus.valueOf(status));
                return Optional.of(pet);
            }
        }
        return Optional.empty();
    }

    public Optional<Pet> deleteAPet(int id) {
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getId() == id) {
                Pet pet = pets.get(i);
                pets.remove(i);
                return Optional.of(pet);
            }
        }
        return Optional.empty();
    }
}
