package com.tamanotchi.pet;

import com.tamanotchi.food.Food;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.tamanotchi.house.House;
import com.tamanotchi.variant.Variant;


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

    public void upgradeHouse(Integer id) {
        Pet pet = DAO.getById(id);
        if (pet == null) {
            throw new PetNotFoundException("Pet with id " + id + " could not be found");
        }

//        House upgrade = DAO.selectHouseById((DAO.selectHouseById(id).getUpgrade())-1);
        House upgrade = DAO.selectHouseById(pet.getHouse()-1);
        System.out.println(upgrade);

        Integer money = pet.getMoney();
        Integer price = upgrade.getPrice();

        if (money>= price) {
            pet.setMoney(money - price);
            pet.setHouse(upgrade.getId());

            int result = DAO.updateById(id, pet);

            if (result != 1) {
                throw new IllegalStateException("House was not upgraded");
            }
        } else {
            throw new IllegalStateException("You're broke; no house for you");
        }

    }

    public void feedPet(Integer id, Integer foodId) {
        Pet pet = DAO.getById(id);
        Food food = DAO.selectFoodById(foodId);
        if (pet == null) {
            throw new PetNotFoundException("Pet with id " + id + " could not be found");
        }
        Integer money = pet.getMoney();
        Integer petEnergy = pet.getEnergy();
        Integer petHappiness= pet.getHappiness();
        Integer foodEnergy= food.getEnergy();
        Integer foodHappiness= food.getHappiness();
        Integer price = food.getPrice();
        Integer maxEnergy = pet.getMax_energy();
        Integer maxHappiness= pet.getMax_happiness();

        Integer updatedEnergy = petEnergy+foodEnergy;
        Integer updatedHappiness = petHappiness+foodHappiness;
        if (money>= price) {
            if(updatedEnergy>=maxEnergy){
                pet.setEnergy(maxEnergy);
            }else{
                pet.setEnergy(updatedEnergy);
            }
            if(updatedHappiness>=maxHappiness){
                pet.setHappiness(maxHappiness);
            }else{
                pet.setHappiness(updatedHappiness);
            }
            pet.setMoney(money - price);
            int result = DAO.updateById(id, pet);
            if (result != 1) {
                throw new IllegalStateException("Pet was not fed");
            }
        } else {
            throw new IllegalStateException("You're broke; no food for you");
        }
    }
}
