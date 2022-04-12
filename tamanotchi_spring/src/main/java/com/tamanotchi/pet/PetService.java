package com.tamanotchi.pet;

import java.util.List;

import com.tamanotchi.food.Food;
import com.tamanotchi.food.FoodNotFoundException;
import com.tamanotchi.house.House;
import com.tamanotchi.house.HouseNotFoundException;
import com.tamanotchi.variant.Variant;
import com.tamanotchi.variant.VariantNotFoundException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    private PetDAO DAO;

    public PetService(@Qualifier("petSQL") PetDAO DAO) {
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

    public Pet addNewPet(Pet pet) {
        int added = DAO.add(pet);

        if (added == 0) {
            throw new IllegalStateException("Pet could not be created");
        }

        pet.setId(added);
        return pet;
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
        if (pet.getMood() == Mood.DEAD) return;

        House upgrade = DAO.getHouseById((DAO.getHouseById(pet.getHouse()).getUpgrade()));
        if (upgrade == null) {
            throw new HouseNotFoundException("Upgrade house could not be found");
        }

        Integer money = pet.getMoney();
        Integer price = upgrade.getPrice();

        if (price > money) {
            throw new IllegalStateException("You're broke; no house for you");
        }

        pet.setMoney(money - price);
        pet.setHouse(upgrade.getId());
        giveExp(pet, 3);

        int result = DAO.updateById(id, pet);

        if (result != 1) {
            throw new IllegalStateException("House was not upgraded");
        }
    }

    public void feedPet(Integer id, Integer foodId) {

        Pet pet = DAO.getById(id);
        if (pet == null) {
            throw new PetNotFoundException("Pet with id " + id + " could not be found");
        }
        if (pet.getMood() == Mood.DEAD) return;

        Food food = DAO.getFoodById(foodId);
        if (food == null) {
            throw new FoodNotFoundException("Food with id " + foodId + " could not be found");
        }
        Variant variant = DAO.getVariantById(pet.getVariant());
        if (variant == null) {
            throw new VariantNotFoundException("Variant with id " + pet.getVariant() + " could not be found");
        }
        
        //check if you can afford food
        Integer money = pet.getMoney();
        Integer price = food.getPrice();
        if (price > money) {
            throw new IllegalStateException("You're broke; no food for you");
        }

        //check if the food is your pet's favourite
        int extraHappiness = 0;
        if (variant.getFave_food() == foodId){
            extraHappiness = 1;
        }

        //resolve health effects
        int mood = pet.getMood();
        if (food.isUnhealthy()) {
            if (!Pet.hasEatenUnhealthy) {
                Pet.hasEatenUnhealthy = true;
            } else {
                if (mood == Mood.SICK) {
                    pet.setMood(Mood.DEAD);
                } else {
                    pet.setMood(Mood.SICK);
                }
                Pet.hasEatenUnhealthy = false;
            }
        } else {
            Pet.hasEatenUnhealthy = false;
        }
        if (pet.getMood() == Mood.SICK && food.isHeals()) {
            pet.setMood(Mood.IDLE);
        }

        //general effects of food
        int petEnergy = pet.getEnergy();
        int petHappiness= pet.getHappiness();

        int foodEnergy= food.getEnergy();
        int foodHappiness= food.getHappiness();

        pet.setEnergy(Math.min(petEnergy + foodEnergy, pet.getMax_energy()));
        pet.setHappiness(Math.min(petHappiness + foodHappiness + extraHappiness, pet.getMax_happiness()));

        //clean up and update
        pet.setMoney(money - price);
        updateMood(pet);
        int result = DAO.updateById(id, pet);
        if (result != 1) {
            throw new IllegalStateException("Pet was not fed");
        }
    }

    public boolean isDead(Integer id) {
        Pet pet = DAO.getById(id);
        if (pet == null) {
            throw new PetNotFoundException("Pet with id " + id + " could not be found");
        }
        //if no exception, assume pet was found and has the fields required
        Integer mood = pet.getMood();
        if (mood == Mood.DEAD) {
            return true;
        } else {
            return false;
        }
    }


    public void gameWon(Integer id) {

        Pet pet = DAO.getById(id);
        if (pet == null) {
            throw new PetNotFoundException("Pet with id " + id + " could not be found");
        }
        if (pet.getMood() == Mood.DEAD) return;

        Integer money = pet.getMoney();
        pet.setMoney(money + 10);

        giveExp(pet, 2);
        int result = DAO.updateById(id, pet);

        if (result != 1) {
            throw new IllegalStateException("Funds were not added");
        }
    }


    public void updateMood(Pet pet) {

        int originalMood = pet.getMood();
        if (originalMood == Mood.DEAD) return;

        int energy = pet.getEnergy();
        int happiness = pet.getHappiness();

        if (energy == 0 && happiness == 0) {
            pet.setMood(Mood.DEAD);
            return;
        }
        if (originalMood == Mood.SICK) return;

        int max_energy = pet.getMax_energy();
        int max_happiness = pet.getMax_happiness();

        double tiredPoint = 0.4;
        double tiredRecover = 0.6;
        double happyPoint = 0.75;
        double happyCalmDown = 0.5;

        if (energy <= max_energy*tiredPoint) {
            pet.setMood(Mood.TIRED);
        } else if (energy <= max_energy*tiredRecover && originalMood == Mood.TIRED) {
            return;
        } else if (happiness >= max_happiness*happyPoint) {
            pet.setMood(Mood.HAPPY);
            giveExp(pet, 1);
        } else if (happiness >= max_happiness*happyCalmDown && originalMood == Mood.HAPPY) {
            giveExp(pet, 1);
        } else {
            pet.setMood(Mood.IDLE);
        }
    }

    public void giveExp(Pet pet, int exp) {

        Variant variant = DAO.getVariantById(pet.getVariant());
        if (variant == null) {
            throw new VariantNotFoundException("Variant with id " + pet.getVariant() + " could not be found");
        }
        
        Integer maxExp = variant.getMax_exp();
        pet.setExp(Math.min(pet.getExp() + exp, maxExp));

        if (pet.getExp() == maxExp) {
            //check if there is an upgrade
            Integer upgradeId = variant.getUpgrade();
            if (upgradeId > 0 ) {
                Variant upgrade = DAO.getVariantById(upgradeId);
                House house = DAO.getHouseById(pet.getHouse());
                // is pet ready to grow
                if (house.getSize() >= upgrade.getStage() && pet.getMood() == Mood.HAPPY){
                    pet.setVariant(upgrade.getId());
                    pet.setExp(0);
                }
            }
        }
    }

    public void timeStep(Integer id) {

        Pet pet = DAO.getById(id);
        if (pet == null) {
            throw new PetNotFoundException("Pet with id " + id + " could not be found");
        }

        Integer mood = pet.getMood();
        if (mood == Mood.DEAD) return;

        Integer energy = pet.getEnergy();
        Integer happiness= pet.getHappiness();

        if (mood == Mood.TIRED){
            pet.setHappiness(Math.max(happiness - 1, 0));
        } else if (mood == Mood.SICK){
            pet.setHappiness(Math.max(happiness - 2, 0));
        }

        if (happiness == 0){
            pet.setEnergy(Math.max(energy - 2, 0));
        } else {
            pet.setEnergy(Math.max(energy - 1, 0));
        }

        updateMood(pet);
        int result = DAO.updateById(id, pet);

        if (result != 1) {
            throw new IllegalStateException("Step was not completed");
        }
    }
}
