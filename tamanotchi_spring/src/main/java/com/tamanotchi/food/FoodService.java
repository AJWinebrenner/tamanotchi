package com.tamanotchi.food;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    private FoodDAO foodDAO;

    public FoodService(@Qualifier("foodSQL") FoodDAO foodDAO) {
        this.foodDAO = foodDAO;
    }

    public List<Food> getAllFood() {
        return foodDAO.getAll();
    }

    public Food getFoodById(Integer id) {
        Food selected = foodDAO.getById(id);
        if (selected == null){
            throw new FoodNotFoundException("Food with id number " + id + " could not be found");
        }else{
            return selected;
        }
    }
}
