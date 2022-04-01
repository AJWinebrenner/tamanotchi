package com.tamanotchi.pet;

import com.tamanotchi.food.Food;
import com.tamanotchi.house.HouseNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.tamanotchi.house.House;
import com.tamanotchi.pet.Mood;

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

        House upgrade = DAO.selectHouseById((DAO.selectHouseById(pet.getHouse()).getUpgrade()));
        if (upgrade == null) {
            throw new HouseNotFoundException("Upgrade house could not be found");
        }

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
        Variant variant = DAO.selectVariantById(pet.getVariant());
        if (pet == null) {
            throw new PetNotFoundException("Pet with id " + id + " could not be found");
        }
        Integer extraHappiness= 0;
        if(variant.getFave_food()==foodId){
            //This needs to be changed
            extraHappiness=2;
        }
        if(food.isUnhealthy()&&!Pet.hasEatenUnhealthy){
            Pet.hasEatenUnhealthy= true;
        }else if(Pet.hasEatenUnhealthy&&food.isUnhealthy()){
            pet.setMood(4);
        }
        if(pet.getMood()==4&&food.isHeals()){
            pet.setMood(1);
            Pet.hasEatenUnhealthy=false;
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
        Integer updatedHappiness = petHappiness+foodHappiness + extraHappiness;
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

    public boolean isDead(Integer id) {
        Pet pet = DAO.getById(id);
        if (pet == null) {
            throw new PetNotFoundException("Pet with id " + id + " could not be found");
        }
        //if no exception, assume pet was found and has the fields required
        Integer mood = pet.getMood(); // get pet's mood
        if (mood == Mood.DEAD) {
            // 5 is dead, but don't need the numbers here
            return true;
            
        } else {
        return false;
        }
    }
}
