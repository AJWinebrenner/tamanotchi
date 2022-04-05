package com.tamanotchi.pet;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {

    private PetService service;

    public PetController(PetService service) {
        this.service = service;
    }

    @GetMapping(path = "pets")
    public List<Pet> getAllPets() {
        return service.getAllPets();
    }

    @GetMapping(path = "pets/{id}")
    public Pet getPetById(@PathVariable("id") Integer id) {
        return service.getPetById(id);
    }

    @PostMapping(path = "pets")
    public ResponseEntity<Pet> addNewPet(@RequestBody Pet pet){
        int newId = service.addNewPet(pet);
        return new ResponseEntity<>( new Pet(newId), HttpStatus.CREATED);
    }

    @PutMapping(path = "pets/{id}")
    public void updatePetById(@PathVariable("id") Integer id, @RequestBody Pet pet){
        service.updatePetById(id, pet);
    }

    @DeleteMapping(path = "pets/{id}")
    public void deletePetById(@PathVariable("id") Integer id){
        service.deletePetById(id);
    }

    @PatchMapping(path = "pets/{id}/upgrade")
    public void upgradeHouse(@PathVariable("id") Integer id){
        service.upgradeHouse(id);
    }

    @PatchMapping(path = "pets/{id}/feed/{foodId}")
    public void feedPet(@PathVariable("id") Integer id, @PathVariable("foodId") Integer foodId){
        service.feedPet(id,foodId);
    }
    @PatchMapping(path = "pets/{id}/game-won")
    public void gameWon(@PathVariable("id") Integer id){
        service.gameWon(id);
    }

    @PatchMapping(path = "pets/{id}/step")
    public void timeStep(@PathVariable("id") Integer id){
        service.timeStep(id);
    }

}
