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
        if(isDead(id)) return;
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
        if(food.isUnhealthy()){
            if(!Pet.hasEatenUnhealthy){
                Pet.hasEatenUnhealthy= true;
            }else{
                pet.setMood(4);
            }
        }else {
            Pet.hasEatenUnhealthy=false;
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
            updateMood(pet);
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


    public void gameWon(Integer id) {

        Pet pet = DAO.getById(id);
        if (pet == null) {
            throw new PetNotFoundException("Pet with id " + id + " could not be found");
        }

        Integer money = pet.getMoney();
        pet.setMoney(money + 10);

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
        } else if (happiness >= max_happiness*happyCalmDown && originalMood == Mood.HAPPY) {
            return;
        } else {
            pet.setMood(Mood.IDLE);
        }
        // to ask - why not have to return the pet here?
    }

    // do we need to pass in a variable of how much exp? Assuming here it will always change by 1 unit

    public void giveExp(Integer id, Integer exp) {
        Pet pet = DAO.getById(id);

        if (pet == null) {
            throw new PetNotFoundException("Pet with id " + id + " could not be found");
        }

        pet.setExp(pet.getExp() + exp);
        Variant variant = DAO.selectVariantById(pet.getVariant());
        Integer maxExp = variant.getMax_exp();


        if (pet.getExp() >= maxExp) {
            pet.setExp(maxExp);
            Integer upgradeId = variant.getUpgrade();
            // check if upgrade id null
            if(upgradeId==null){
                System.out.println("can't upgrade");
            }else{
                //  else
                // check if house
                // check if happy
                // check if not sick
                // if all above, then // evolve (poss separate function)
                if(pet.getHouse()-1==pet.getId()&&pet.getMood()!=4&&pet.getMood()!=3&&pet.getMood()!=5){
                    pet.setVariant(pet.getVariant()-1);
                }
            }

        }


    }

    public void timeStep(Integer id) {

        Pet pet = DAO.getById(id);
        if (pet == null) {
            throw new PetNotFoundException("Pet with id " + id + " could not be found");
        }

        Integer energy = pet.getEnergy();
        Integer happiness= pet.getHappiness();
        Integer mood = pet.getMood();

        if (mood == Mood.TIRED){
            pet.setHappiness(happiness - 1);
        } else if (mood == Mood.SICK){
            pet.setHappiness(happiness - 2);
        }

        if (happiness == 0){
            pet.setEnergy(energy - 2);
        } else {
            pet.setEnergy(energy - 1);
        }

        if (pet.getEnergy() < 0) {
            pet.setEnergy(0);
        }
        if (pet.getHappiness() < 0) {
            pet.setHappiness(0);
        }

        updateMood(pet);
        int result = DAO.updateById(id, pet);

        if (result != 1) {
            throw new IllegalStateException("Step was not completed");
        }
    }
}
