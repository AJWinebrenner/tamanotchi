package com.tamanotchi.food;

import com.tamanotchi.food.Food;
import com.tamanotchi.food.FoodDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    private FoodDAO foodDAO;

    public FoodService(FoodDAO foodDAO) {
        this.foodDAO = foodDAO;
    }

    public List<Food> selectAllFood() {
        List<Food> foods = foodDAO.selectAllFood();
        return foods;
    }

    public Food selectFoodById(Integer foodId) {
        return foodDAO.selectFoodById(foodId);
    }
}
