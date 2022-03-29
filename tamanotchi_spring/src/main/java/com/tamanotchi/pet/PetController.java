package com.tamanotchi.pet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
