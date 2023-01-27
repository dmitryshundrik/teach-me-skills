package by.tms.lesson48homework.controller;

import by.tms.lesson48homework.dao.PetRepository;
import by.tms.lesson48homework.entity.Pet;
import by.tms.lesson48homework.status.PetStatus;
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
    private PetRepository petRepository;

    @Operation(summary = "Add a new pet to the store")
    @PostMapping
    public ResponseEntity<Pet> save(@Valid @RequestBody Pet pet) {
        Pet save = petRepository.save(pet);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @Operation(summary = "Update an existing pet")
    @PutMapping
    public ResponseEntity<Pet> update(@Valid @RequestBody Pet pet) {
        Pet save = petRepository.save(pet);
        return ResponseEntity.ok(save);

    }

    @Operation(summary = "Finds Pets by status", description = "Multiple status values can be provided with comma separated strings")
    @GetMapping("/findAllByStatus")
    public ResponseEntity<List<Pet>> findAllByStatus(String status) {
        List<Pet> petList = petRepository.findAllByStatus(PetStatus.valueOf(status));
        if (petList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(petList);
    }

    @Operation(summary = "Find pet by ID", description = "Returns a single pet")
    @GetMapping("/{petId}")
    public ResponseEntity<Pet> findById(@PathVariable int petId) {
        Optional<Pet> optionalPet = petRepository.findById(petId);
        if (optionalPet.isPresent()) {
            return ResponseEntity.ok(optionalPet.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Updates a pet in the store with form data")
    @PostMapping("/{petId}")
    public ResponseEntity<Pet> updatePetById(@PathVariable int petId, String name, String status) {
        if(petRepository.findById(petId).isPresent()) {
            Pet pet = petRepository.findById(petId).get();
            pet.setName(name);
            pet.setStatus(PetStatus.valueOf(status));
            return ResponseEntity.ok(petRepository.save(pet));
        }
        return ResponseEntity.badRequest().build();
    }

    @Operation(summary = "Deletes a pet")
    @DeleteMapping("/{petId}")
    public ResponseEntity<?> deleteById(@PathVariable int petId) {
        petRepository.deleteById(petId);
        return ResponseEntity.ok().build();
    }
}
