package com.tamanotchi.pet;

import java.util.List;

public interface PetDAO {

    public List<Pet> getAll();
    public Pet getById(Integer id);
    public int add(Pet pet);
    public int updateById(Integer id, Pet update);
    public int deleteById(Integer id);
}
