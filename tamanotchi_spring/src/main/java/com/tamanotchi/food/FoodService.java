package com.tamanotchi.food;

import java.util.List;

import org.springframework.stereotype.Service;

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
