package com.tamanotchi.food;

import java.util.List;

public interface FoodDAO {

    List<Food> selectAllFood();

    Food selectFoodById(Integer foodId);
}