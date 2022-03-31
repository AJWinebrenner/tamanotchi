package com.tamanotchi.pet;

import com.tamanotchi.food.Food;
import com.tamanotchi.house.House;
import com.tamanotchi.variant.Variant;

import java.util.List;

public interface PetDAO {

    public List<Pet> getAll();
    public Pet getById(Integer id);
    public int add(Pet pet);
    public int updateById(Integer id, Pet update);
    public int deleteById(Integer id);
    House selectHouseById(Integer houseId);
    Variant selectVariantById(Integer variantId);
    public Food selectFoodById(Integer foodId);
}
