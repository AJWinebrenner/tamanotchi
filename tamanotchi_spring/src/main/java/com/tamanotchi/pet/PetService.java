package com.tamanotchi.pet;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private PetDAO DAO;

    public PetService(@Qualifier("postgres") PetDAO DAO) {
        this.DAO = DAO;
    }

    public List<Pet> getAllPets() {
        return DAO.getAll();
    }

    public Pet getPetById(Integer id) {
        Pet selected = DAO.getById(id);
        if (selected == null){
            throw new PetNotFoundException("Pet with id " + id + " could not be found");
        } else return selected;
    }
}
