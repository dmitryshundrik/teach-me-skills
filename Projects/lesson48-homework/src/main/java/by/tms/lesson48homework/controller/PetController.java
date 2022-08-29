package by.tms.lesson48homework.controller;

import by.tms.lesson48homework.dao.InMemoryPetDao;
import by.tms.lesson48homework.entity.Pet;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pet")
@Tag(name = "pet", description = "Everything about your Pets")
public class PetController {

    @Autowired
    private InMemoryPetDao petDao;


    @Operation(summary = "Add a new pet to the store")
    @PostMapping
    public ResponseEntity<Pet> save(@Valid @RequestBody Pet pet) {
        return new ResponseEntity<>(petDao.save(pet), HttpStatus.CREATED);
    }

    @Operation(summary = "Update an existing pet")
    @PutMapping
    public ResponseEntity<Pet> update(@RequestBody Pet pet) {
        Optional<Pet> optionalPet = petDao.update(pet);
        if (optionalPet.isPresent()) {
            return ResponseEntity.ok(optionalPet.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @Operation(summary = "Finds Pets by status", description = "Multiple status values can be provided with comma separated strings")
    @GetMapping("/findByStatus")
    public ResponseEntity<List<Pet>> findByStatus(String status) {
        Optional<List<Pet>> optionalPetList = petDao.findByStatus(status);
        return ResponseEntity.ok(optionalPetList.get());
    }

    @Operation(summary = "Find pet by ID", description = "Returns a single pet")
    @GetMapping("/{petId}")
    public ResponseEntity<Pet> findById(@PathVariable int petId) {
        Optional<Pet> optionalPet = petDao.findById(petId);
        if (optionalPet.isPresent()) {
            return ResponseEntity.ok(optionalPet.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @Operation(summary = "Updates a pet in the store with form data")
    @PostMapping("/{petId}")
    public ResponseEntity<Pet> updatePetById(@PathVariable int petId, String name, String status) {
        Optional<Pet> optionalPet = petDao.updatePetById(petId, name, status);
        if (optionalPet.isPresent()) {
            return ResponseEntity.ok(optionalPet.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @Operation(summary = "Deletes a pet")
    @DeleteMapping("/{petId}")
    public ResponseEntity<Pet> deleteAPet(@PathVariable int petId) {
        Optional<Pet> optionalPet = petDao.deleteAPet(petId);
        if (optionalPet.isPresent()) {
            return ResponseEntity.ok(optionalPet.get());
        }
        return ResponseEntity.badRequest().build();
    }
}
