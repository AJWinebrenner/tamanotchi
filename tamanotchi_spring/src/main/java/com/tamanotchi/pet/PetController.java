package com.tamanotchi.pet;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {

    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }
    
}
