package com.tamanotchi.food;

import java.util.List;

public interface FoodDAO {

    List<Food> getAll();
    Food getById(Integer id);
}