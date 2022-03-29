package com.tamanotchi.food;

import com.tamanotchi.food.FoodService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {

    private FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;}

    @GetMapping(path="foods")
    public List<Food> getAllFoods (){
        return foodService.selectAllFood();
    }

    @GetMapping(path ="foods/{id}")
    public Food getFoodById(@PathVariable("id") Integer foodId){
        return foodService.selectFoodById(foodId);
    }
}

