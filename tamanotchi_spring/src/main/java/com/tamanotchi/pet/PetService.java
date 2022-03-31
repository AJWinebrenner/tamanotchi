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
        } else {
            return selected;
        }
    }

    public void addNewPet(Pet pet) {
        int added = DAO.add(pet);

        if (added != 1) {
            throw new IllegalStateException("Pet could not be created");
        }
    }

    public void updatePetById(Integer id, Pet pet) {
        Pet original = DAO.getById(id);
        if (original == null) {
            throw new PetNotFoundException("Pet with id " + id + " could not be found");
        }
        if (pet.getHappiness() > original.getMax_happiness()) {
            throw new IllegalArgumentException("happiness cannot be larger than " + original.getMax_happiness());
        }
        if (pet.getEnergy() > original.getMax_energy()) {
            throw new IllegalArgumentException("energy cannot be larger than " + original.getMax_energy());
        }

        int result = DAO.updateById(id, pet);

        if (result != 1) {
            throw new IllegalStateException("Pet with id " + id + " could not be updated");
        }
    }

    public void deletePetById(Integer id) {
        if (DAO.getById(id) == null) {
            throw new PetNotFoundException("Pet with id " + id + " could not be found");
        }

        int result = DAO.deleteById(id);

        if (result != 1) {
            throw new IllegalStateException("Pet with id " + id + " could not be deleted");
        }
    }

    public void upgradeHouse(Integer petId, Integer nextUpgrade, Integer price) {
        if (DAO.getById(petId) == null) {
            throw new PetNotFoundException("Pet with id " + petId + " could not be found");
        }

        int result = DAO.upgradeHouse(petId, nextUpgrade, price);

        if (result != 1) {
            throw new IllegalStateException("House was not upgraded");
        }
    }

}
