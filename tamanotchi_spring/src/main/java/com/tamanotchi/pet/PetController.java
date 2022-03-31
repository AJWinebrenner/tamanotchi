package com.tamanotchi.pet;

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
    public void addNewPet(@RequestBody Pet pet){
        service.addNewPet(pet);
    }

    @PutMapping(path = "pets/{id}")
    public void updatePetById(@PathVariable("id") Integer id, @RequestBody Pet pet){
        service.updatePetById(id, pet);
    }

    @DeleteMapping(path = "pets/{id}")
    public void deletePetById(@PathVariable("id") Integer id){
        service.deletePetById(id);
    }

    @PatchMapping(path = "pets/{id}/house/{nextUpgrade}")
    public void upgradeHouse(@PathVariable("id") Integer petId,@PathVariable("nextUpgrade")Integer nextUpgrade, @RequestBody Integer price){
        service.upgradeHouse(petId, nextUpgrade, price);
    }
}
