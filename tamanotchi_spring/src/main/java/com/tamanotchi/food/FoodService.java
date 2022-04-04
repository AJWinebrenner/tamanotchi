package com.tamanotchi.food;

import com.tamanotchi.food.Food;
import com.tamanotchi.food.FoodDAO;
import com.tamanotchi.house.HouseNotFoundException;
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
        Food selected = foodDAO.selectFoodById(foodId);
        if (selected == null){
            throw new FoodNotFoundException("Food with id number "+ foodId + " does not exist");
        }else{
            return selected;
        }
    }
}
