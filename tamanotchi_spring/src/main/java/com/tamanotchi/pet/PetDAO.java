package com.tamanotchi.pet;

import java.util.List;

import com.tamanotchi.food.Food;
import com.tamanotchi.house.House;
import com.tamanotchi.variant.Variant;

public interface PetDAO {

    public List<Pet> getAll();
    public Pet getById(Integer id);
    public int add(Pet pet);
    public int updateById(Integer id, Pet update);
    public int deleteById(Integer id);
    House getHouseById(Integer id);
    Variant getVariantById(Integer id);
    Food getFoodById(Integer id);
}
